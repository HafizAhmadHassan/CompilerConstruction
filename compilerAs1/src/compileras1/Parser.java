/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/**
 *
 * @author mian
 */
public class Parser {
    BufferedReader reader;
    ArrayList <String> words= new ArrayList<String>();
    int token_number;
    String look;
    int tabs;
    File tree;
    String myfile;
    boolean p1;
    boolean p2;
    
    
    int error;
    String  k;
    ArrayList<String> var;
    FileWriter myWriter2;
    FileWriter myWriter;
    
    //-------------------------------------------------- SDT Variables
    SDT sdt= new SDT(); 
    int vid;
    boolean wh;
    
    public Parser() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException {
        myfile=new String();
        
        String [] parts = new String [10];
        Filing F = new Filing();
        String [] m=F.FilingRead("test.cmm");
        int fl = F.getFileLines("test.cmm");
        sdt.initString(fl);
        vid=0;
        tabs=0;
        var = new ArrayList();
        k = new String();
        Tokenizer T=new Tokenizer();
        p1=false;
        p2= false;
        T.storeFileContents(m);
        T.id();
        error=1;
        myWriter2 = new FileWriter("parse_tree.txt");
        myWriter = new FileWriter("parse_symbol_table.txt");
        token_number=0;
  
       read_words_dot_txt();
        look=nextToken();
        Declaration(); 
        
           WriteFiles(); 
           wh=false;
           
        
    }
 String makeVar(){
    
    return "t"+(vid++);
    }
    void WriteFiles() throws IOException{
            myWriter2.write(myfile);
           myWriter.write(k);
            myWriter.close();
            myWriter2.close();
    
    }
    void hamaraBajaj(String str) throws IOException
    {   
	for (int i = 0; i < tabs; i++)
	{
		//cout << "	";
         myfile=myfile+"	";
        }

	if (( str.contains("id")))
	{
            
         myfile=myfile+str + " "  +"\n\n";
      
	}
	else if ((str.contains("+")) || (str.contains("-")) || (str.contains("*")) || (str.contains("/")))
	{
	       
              myfile=myfile+str + " "+ "A0"  +"\n\n";
       
        
        }
	else if ((str.contains("<")) || (str.contains("<=")) || (str.contains(">")) || (str.contains(">=")) || (str.contains("==")) )
	{
              myfile=myfile+str + " "+ "R0"  +"\n\n";
      
        
        }
	else if ((str.contains(":=")))
	{
	
                    myfile=myfile+str + " "+ "A0"  +"\n\n";
      
	}
	else if ((str.contains("LiteralConstant")))
	{
	 
                    myfile=myfile+str + " "+ "LC"  +"\n\n";
      
            
        
        }
	else
	{
           
        myfile=myfile+str + " "+"\n\n";
      
     //   System.out.println(str);
            
	}

        //System.out.println('\n'+str+'\n');

    }

    public void read_words_dot_txt()
    {
	BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("words.txt"));
			String line = reader.readLine();
			while (line != null) {
				// read next line
                                words.add(line);

				line = reader.readLine();
                                
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public String nextToken()
    {
        if(token_number<words.size())
        {
        String token=words.get(token_number);
        if(token.contains("Comment")){
        System.out.println(token);
            token_number++;
        token=words.get(token_number);
        
        }
        if(token != null &&!token.isEmpty()  )
        {
            if(token.contains("id"))
            {
                token_number++;

                return "id";

            }
            if(token.contains("kw"))
            {
                token_number++;

                return token.substring(1, token.indexOf(','));
            }
            if(token.contains("error"))
            {
                token_number++;

                return "";
            }
            if(token.contains("Single Comment"))
            {
                token_number++;
                
                return "";

            }
            if(token.contains("double Cpmment"))
            {
                token_number++;
                return "";
            }
            if(token.contains("String"))
            {
                token_number++;
                return "String";
            }
            if(token.contains("Assign Op"))
            {
                token_number++;
                return "Assign Op";
            }
            if(token.contains("RO"))
            {
                token_number++;
                return "RO";
            }
            if(token.contains("Integer"))
            {
                token_number++;
                return "Integer";
            }
            if(token.contains("LiteralConstant"))
            {
                token_number++;
                return "LiteralConstant";
            }
            if(token.contains("^"))
            {
                token_number++;

                if(token.substring(1, token.indexOf(',')).equals(" "))
                {
                    return ",";
                }
                return token.substring(1, token.indexOf(','));
                
            }
           
            
            

        }
        }
      token_number++;

        return "";
    }
    void halt() throws IOException{
    int i=1;
    
    String s=words.get(token_number-1);
    myfile=myfile+"\n Bad Token == ";
         WriteFiles();
        System.out.print("Bad Token at token number "+(token_number-1) +"   "+s);
        while(i==1);
    }
    String getmyfile(){
    
    return myfile;
    }
    void match(String tok) throws IOException
    {
        int i=0;
        if(look.contains(tok))
        {hamaraBajaj(tok);
      
            look=nextToken();
            if(look.equals(""))
            {
                look=nextToken();
            }
        }
        else {
            halt();
        }
    }
    void Declaration() throws IOException
    {
        tabs++;
        hamaraBajaj("Declaration()");
        
        Function();
        //if(!words.get(token_number).isEmpty()){
       // Declaration();
        //}
        try{
            if(!words.get(token_number).isEmpty()){
            Declaration();
            }
        }catch(Exception ex){
        System.out.print(ex.getLocalizedMessage());
        
        }
        tabs--;
    }
    
    void DeclareVariable() throws IOException
    { tabs++;
    // single out aur return comment type cheezein ho skti hain

    if(look.contains("int"))
        {
         p2=false;
         p1=true;          
         k=k+"int ";
       
         hamaraBajaj("DeclareVariable()");
         sdt.addString(myLex());
            match("int");
            
            Varid();
            if(look.contains(";"))
            {
                match(";");
                
            }else{
            halt();
            }
        }
        else if (look.contains("char"))
        {
            p1=false;
            p2=true;
            String token2=words.get(token_number);
            String [] s =token2.split(",");
            k=k+"char";
           hamaraBajaj("DeclareVariable()");
            
            sdt.addString(myLex());
            match("char");
            
            Varid();
            if(look.contains(";"))
            {
                match(";");
                
            }
            else{
            halt();
            }
        }
        
        tabs--;
        
    }
    void Varid() throws IOException
    {
       tabs++;
        if(look.contains("id"))
        {
            
         String token2=words.get(token_number-1);
         String [] s =token2.split(",");
         s[0]=s[0].replace("(","");
         k=k+s[0]+'\n';
         
            
            hamaraBajaj("Varid()");
         
            sdt.addString(myLex());
            match("id");
           
            
        }
        
        if(look.contains(",") ){
        MoreVar();
        }
        else if(!look.contains(";")){
        halt();
        }
        tabs--;
        
    }
    String getk(){
    return k;
    }
    void MoreVar() throws IOException
    {
        tabs++;
        if(look.contains(","))
        {
            
            
            hamaraBajaj("MoreVar()");
            match(",");
            
            if(look.contains("id"))
            {
                if(p1==true && p2==false){
                String token2=words.get(token_number-1);
                String [] s =token2.split(",");
                s[0]=s[0].replace("(","");
         
                k=k+"int"+" "+ s[0]+'\n';
            
            }else{
            if(p1==false && p2==true)    
            {
                String token2=words.get(token_number-1);
                String [] s =token2.split(",");
                s[0]=s[0].replace("(","");
         
                k=k+"char"+" "+s[0]+'\n';
            
            
            }
                
                }
                match("id");
                
            }
            if(!look.contains(";")){
                MoreVar();
            }else if(look.contains(";")){
                
            return;
            }
        }
       tabs--;
    }
    void Function() throws IOException
    {
        tabs++;
        hamaraBajaj("Function()");
        FunctionType();
        if(look.contains("id"))
        {
            match("id");
            
        }else{
        
        halt();
        }
        if(look.contains("("))
        {
            match("(");
            
        }else{
        halt();
        }
        
        Parameter();
        if(look.contains(")"))
        {
            match(")");
            
        }else{
        
        halt();
        }
        if(look.contains("{"))
        {
            match("{");
            
        }else{
        
        halt();
        }
        
        Statements();
        
        if(look.contains("}"))
        {
            match("}");
            
        }else{
        halt();
        
        }
        
        tabs--;
    }
    void FunctionType() throws IOException
    {
        tabs++;
        hamaraBajaj("FunctionType()");
        Type();
        tabs--;
    }
    void Type() throws IOException
    {
        tabs++;

            hamaraBajaj("Type()");
            
        if(look.contains("int"))
        {
            match("int");
            
        }
        else if (look.contains("char"))
        {
            match("char");
            
        }else{
        halt();
        }
        tabs--;
    }
    void Parameter() throws IOException
    { tabs++;
    
        hamaraBajaj("Parameter()");
            
        One();
        
        More();
        
       tabs--;
    }
    void One() throws IOException
    {
        tabs++;
        
        hamaraBajaj("One()");
            
        Type();
        if(look.contains("id"))
        {
            match("id");
            
        }else{
        
        halt();
        }
        tabs--;
    }
    void More() throws IOException
    {
        tabs++;
        if(look.contains(","))
        {
            
            hamaraBajaj("More()");
            
            match(",");
            
            
            Type();
            if(look.contains("id"))
            {
                match("id");
                
            }else{
            
            halt();
            }
            
            //---------------nice tackle Ahmad Hassan :P
            if(!look.contains(")")){
            More();
            }else if(look.contains(")")){
            return;
            
            }
        }else{
        halt();
        }
       tabs--;
    }
    public void A2(){
    sdt.emit(sdt.getStored());
    }
    void InitializeVariable() throws IOException
    {
        tabs++;
        if(look.contains("id"))
        {
        
            
            hamaraBajaj("InitializeVariable()");
//            try {
//  Thread.sleep(5000L);
//} catch(InterruptedException ie) {
//   // Exception handling code here, it is a bad practice to leave this scope empty
//}
            sdt.addString(myLex());
            match("id");
            
            
            
            if(look.contains("Assign Op"))
            {
                
                sdt.addString(myLex());
                match("Assign Op");
                
            
                IniVar();
                if(look.contains(";"))
                {
                    
                    match(";");
                    
                }else{
                halt();
                }
            }else{
            halt();
            }
            
            
        }
        
        
        tabs--;
    }
    void IniVar() throws IOException
    { tabs++;
      int i=0;
          hamaraBajaj("IniVar()");
      
       E();
        if(look.contains("id"))
        {
            i=1;
            sdt.addString(myLex());
            
            match("id");
            
        }
        else if(look.contains("Integer"))
        {
            i=1;
            
            sdt.addString(myLex());
            match("Integer");
            
        }
        else if(look.contains("LiteralConstant"))
        {
            i=1;
            
            sdt.addString(myLex());
            match("LiteralConstant");
            
        }
        
        
         
           tabs--;
        
    }
    void OUT() throws IOException
    { tabs++;
        if(look.contains("out"))
        {
            
            hamaraBajaj("OUT()");
            sdt.addString(myLex());
            match("out");
            outtype();
            if(look.contains(";"))
            {
                match(";");
            
            }else{
            halt();
            }
        }
        tabs--;
    }
    void outtype() throws IOException
    { tabs++;
        if(look.contains("id"))
        {
        
            hamaraBajaj("outtype()");
            sdt.addString(myLex());
            match("id");
        }
        else if(look.contains("Integer"))
        {
            
            hamaraBajaj("outtype()");
            sdt.addString(myLex());
            match("Integer");
        }
        else if(look.contains("LiteralConstant"))
        {
            
            hamaraBajaj("outtype()");
            sdt.addString(myLex());
            match("LiteralConstant");
            
        }
        else if(look.contains("String"))
        {
            
            hamaraBajaj("outtype()");
            sdt.addString(myLex());
            match("String");
            
        }else{
    
           halt();
      
        }
        tabs--;
    }
    void RET() throws IOException
    { tabs++;
         if(look.contains("ret"))
        {
            
            hamaraBajaj("RET()");
            match("ret");
            rettype();
            if(look.contains(";"))
            {
                match(";");
            
            }
            
        }
        tabs--;
    }
    void rettype() throws IOException
    {
        tabs++;
        if(look.contains("id"))
        {
            
            hamaraBajaj("rettype()");
            match("id");
            
        }
        else if(look.contains("Integer"))
        {
            
            hamaraBajaj("rettype()");
            match("Integer");
            
        }
        else if(look.contains("LiteralConstant"))
        {
            
            hamaraBajaj("rettype()");
            match("LiteralConstant");
            
        }else{
        halt();
        }
        tabs--;
    }
    void in() throws IOException
    {
       tabs++;
        if(look.equals("in"))
        {
            
            hamaraBajaj("in()");
            match("in");
            
            if(look.contains("id"))
            {
                match("id");
                
                if(look.contains(";"))
                {
                    match(";");
                  
                }else{
                halt();
                }
            }else{
            halt();
            }
        }
        tabs--;
    }
    void A7(){
    //sdt.emit(makeVar()+" :=" + sdt.aE);
    //sdt.aE=new String();
    }
    void A10(){
    
    sdt.n['R']=sdt.n['T'];
    }
    void E() throws IOException
    { tabs++;
    hamaraBajaj("E()");
            
        T();
        
        A31(sdt.n['o']);
//A10();
        R();
      
        
      tabs--;
        
    }
    void A9(){
    sdt.n['T']=sdt.n['F'];
    }
    void A31(String s){
     sdt.emit(makeVar() + " = " + sdt.n['T'] +s+ sdt.n['r']);
    
    sdt.n['R']= "t"+(vid-1);
    }
    
    void A32(){
    sdt.n['R']=sdt.n['F'];
    System.out.print("A32  "+ sdt.n['R']);
    }
    
    
    void T() throws IOException
    {
        tabs++;
        
        hamaraBajaj("T()");
        
        
        f();
        A32();
        R_();
        

        tabs--;
        
    }
    
    void A11(String s){
    
    sdt.emit(makeVar() + " = " + sdt.n['R'] +s+ sdt.n['F']);
    sdt.n['R']= "t"+(vid-1);
    }
    void R() throws IOException
    { tabs++;
        if(look.contains("+"))
        {
            
            hamaraBajaj("R()");
            sdt.addString(myLex());
      
          match("+");
            
            T();
           A11(" + ");
             
            //System.out.print("---\n "+makeVar()+ ":= "+ sdt.aE +"\n");
            R();
            
        }
        else if(look.contains("-"))
        {
            
            hamaraBajaj("R()");
            
            sdt.addString(myLex());
            //sdt.addaEString(myLex());
            match("-");
            
            T();
            A11(" - ");
            R();
            
        }
        tabs--;
    }
    public void A8(){
        sdt.n['F']=myLex();
        System.out.print("A8" + sdt.n['F']);
        
    }
    void f() throws IOException
    {tabs++;
        if(look.contains("id"))
        {
            
            hamaraBajaj("f()");
            
            //sdt.addaEString(myLex());
            
            
            sdt.addString(myLex());
            
            A8();
            match("id");
            return;
            
        }
        else if(look.contains("Integer"))
        {
            
            hamaraBajaj("f()");
            sdt.addString(myLex());
            A8();
            //sdt.addaEString(myLex());
            match("Integer");
        return;    
        }
//        else if(look.contains("LiteralConstant")){
//        
//            hamaraBajaj("f()");
//            match("LiteralConstant");
//        
//        }
        else if (look.contains("("))
        {
         
            hamaraBajaj("f()");
            if(look.contains("(")){
            match("(");   
            }else{
            halt();
            }
            
            E();
           
            if(look.contains(")")){
            match(")");   
            }
            
        }
        
           tabs--;
        
    }
    void A12(String s){
    sdt.n['F']=sdt.n['F']+s;
    }
    void A33(){
    sdt.n['r']=sdt.n['F'];
    
    }
    void A34(String s){
    sdt.n['o']=s;
    
    }
    void R_() throws IOException
    {
        tabs++;
        if(look.contains("*"))
        {
            sdt.addString(myLex());
            
            hamaraBajaj("R_()");
            match("*");
            
            
            f();
          A11("*");
            R();
            
        }
        
        else if(look.contains("/"))
        {
            
            sdt.addString(myLex());
        
            match("/");
          
            f();
            A11(sdt.n['/']);
            R();
            
        }
        else{
        
            A12(" ");
        }
       tabs--;
    }
    
    public void A1(){
        sdt.emit("if" + sdt.getStored() +  " goto ");
        sdt.saveLine(0);    
        sdt.emit("goto");
    
    }
    void WHILE() throws IOException
    {
        tabs++;
         if(look.contains("while"))
        {
            wh=true;
            hamaraBajaj("WHILE()");
            
            match("while"); 
            if(look.contains("(")){
            match("(");
            }else{
            halt();
            }
            con();
            if(look.contains(")")){
            A1();
            match(")");
            }else{
            halt();
            }
            constatment();
            A3();
        }
        tabs--;
    }
    public void A5(){
    
    sdt.emit(sdt.getStored());
    }
    public void A4(){
    sdt.backPath(sdt.v[0], sdt.line);
    }
    
    public void A6(){
    sdt.backPath(sdt.v[0]+1, sdt.line);
   
    }
    void SimpleIf() throws IOException{
    tabs++;
    
    
      
         if(look.contains("if"))
        {
                hamaraBajaj("IF()");
        
            match("if");
            if(look.contains("(")){
            match("(");
            }else{
            halt();
            }
            con(); 
            A1();
            if(look.contains(")")){
            match(")"); 
            A4();
            }
          
            constatment();
            
            
            A6();
            
            
        if(look.contains("else")){
            
            match("else");
            constatment();
            A6();
            
            
        }
           
        }
    
           tabs--;
   
    }
    void IF() throws IOException
    { tabs++;
    SimpleIf(); 
    

        tabs--;
    }
    public String myLex(){
    return this.getLex(words.get(token_number-1));
    }
    void con() throws IOException
    {
        tabs++;
        
        hamaraBajaj("con()");
           
        P(); 
        if(look.contains("RO")){
            
        
        sdt.addString(myLex());
        match("RO"); 
        }
        else{
        halt();
        
        }
        
        P();
        tabs--;
        
    }
    
    String getLex(String text){
    
       text=text.substring(text.indexOf('(') + 1, text.indexOf(','));
                   
    return text;
    }
    void P() throws IOException
    { tabs++;
        if(look.contains("id"))
        {
            
            hamaraBajaj("P()");
     
           
           sdt.addString(myLex());
            
            match("id");
            
            
        }
        else if(look.contains("Integer"))
        {
           sdt.addString(myLex());
            
            hamaraBajaj("P()");
            match("Integer");
        }
         else if(look.contains("LiteralConstant"))
        {
            
            
           sdt.addString(myLex());
            
           hamaraBajaj("P()");
            match("LiteralConstant");
        
        }
        else if (look.contains("("))
        {
            
            hamaraBajaj("P()");
            
            match("(");
            con();
            
            if(look.contains(")")){
            match(")");
            }else{
            
            halt();
            }
           
        }
        else{
            System.out.print("Bad Token");
        }
            tabs--;
    }
    public void A3(){
        
      sdt.emit("goto " + String.valueOf(sdt.v[0]));
      sdt.backPath(sdt.v[0], sdt.v[0]+2);
      sdt.backPath(sdt.v[0]+1, sdt.line);
      
    }
    void constatment() throws IOException
    {
        tabs++;
        hamaraBajaj("constatements()");
     
        
        manystatements();
       
        S();
        
        
        
         
       
        tabs--;
    }
    void manystatements() throws IOException
    {
        tabs++;
        if(look.contains("{"))
        {
            
       hamaraBajaj("manystatements()");
     
            match("{"); 
            Statements();
            
            if(look.contains("}")){
               
            match("}") ; 
            }else{
            
            halt();
            }
        }
        tabs--;
    
    }
    void S() throws IOException
    {
        tabs++;
        if(!look.equals(""))
        {
       hamaraBajaj("S()");
     
        OUT();
        RET();
        in(); 
        
        InitializeVariable(); 
        
        DeclareVariable();
        A5();
       
        }
        
        tabs--;
    }
    void Statement() throws IOException
    { tabs++;
    
     hamaraBajaj("Statement()");
        if(look.contains("out")){
            error=0;
            OUT();
             A2();
            
            
        }
        if(look.contains("ret")){
            error=0;
            RET();
             A2();
          
           
        }
        if(look.contains("in")){
            error=0;
            in();
            
        }
        if(look.contains("id")){
            error=error-1;
            InitializeVariable();
             A2();
           
        }
        if(look.contains("int") || look.contains("char")){
            error=0;
            DeclareVariable();
             A2();
           
           
        }
        if(look.contains("if")){
            error=0;
            IF();
            
        }
        if(look.contains("while")) {
            error=0;
            WHILE();
        }
        if(error==1 ){
        halt();
        }
        
        
        
        tabs--;
    }
    void Statements() throws IOException
    {
        tabs++;
       
       if(look.contains("}")==false )
       {
        hamaraBajaj("Statements()");
        Statement();
        
        Statements();
       }
       
       
       tabs--;
    }
    
      void sdtPrint() throws IOException
    {
        sdt.print();
    }
    
    
}
