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
import java.util.Stack;
/**
 *
 * @author mian
 */
public class Parser1 {
    BufferedReader reader;
    ArrayList <String> words= new ArrayList<String>();
    int token_number;
    String look;
    int tabs;
    File tree;
    String myfile;
    boolean p1;
    boolean p2;
    boolean exitprogram=false;
    
    
    int error;
    String  k;
    ArrayList<String> var;
    FileWriter myWriter2;
    FileWriter myWriter;
    FileWriter myWriter3;
    
    boolean iff;
    //-------------------------------------------------- SDT Variables
    SDT sdt= new SDT(); 
    int vid;
    boolean wh;
    String [] output;
    int i=0;
    Stack stack = new Stack();
    
    
    public Parser1(String filename) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException {
        myfile=new String();
        
        String [] parts = new String [10];
        Filing F = new Filing();
        String [] m=F.FilingRead(filename);
        int fl = F.getFileLines(filename);
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
           output = new String[200];
           i=0;
           iff=false;
        
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
        //System.out.println(token);
            token_number++;
            if(token_number==words.size())
        {
            exitprogram=true;
        }
            
        token=words.get(token_number);
        
        }
        if(token != null &&!token.isEmpty()  )
        {
            if(token.contains("id"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }

                return "id";

            }
            if(token.contains("kw"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }

                return token.substring(1, token.indexOf(','));
            }
            if(token.contains("error"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }

                return "";
            }
            if(token.contains("Single Comment"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "";

            }
            if(token.contains("double Cpmment"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "";
            }
            if(token.contains("String"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "String";
            }
            if(token.contains("Assign Op"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "Assign Op";
            }
            if(token.contains("RO"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "RO";
            }
            if(token.contains("Integer"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "Integer";
            }
            if(token.contains("LiteralConstant"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }
                return "LiteralConstant";
            }
            if(token.contains("^"))
            {
                token_number++;
                if(token_number==words.size())
        {
            exitprogram=true;
        }

                if(token.substring(1, token.indexOf(',')).equals(" "))
                {
                    return ",";
                }
                return token.substring(1, token.indexOf(','));
                
            }
           
            
            

        }
        
        }
      token_number++;
      if(token_number==words.size())
        {
            exitprogram=true;
        }

        return "";
    }
    void halt() throws IOException{
    int i=1;
    
    String s=words.get(token_number-1);
    myfile=myfile+"\n Bad Token == ";
         WriteFiles();
        System.out.print("Bad Token at token number "+(token_number-1) +"   "+s);
        System.exit(0);
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
    
    
    void FunctionCall() throws IOException{
    if(look.contains("id")){
    sdt.n['t']=myLex();
        match("id");
    
    if(look.contains("Assign Op")){
    match("Assign Op");
    if(look.contains("id")){
    
        sdt.n['s']= myLex();
    }
    
    E();
   // A45();
    }
    
    
    }
    
    }
    void Declaration() throws IOException
    {
        tabs++;
        hamaraBajaj("Declaration()");
       // FunctionCall();
        //sdt.wipeString();
       // Function();
       Statements();
       int pinki=9;
        //if(!words.get(token_number).isEmpty()){
       // Declaration();
        //}
        
       /* try{
            if(!words.get(token_number).isEmpty()){
            Declaration();
            }
        }catch(Exception ex){
        //System.out.print(ex.getLocalizedMessage());
        
        }*/
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
         sdt.ts=sdt.ts+"int ";
         
         hamaraBajaj("DeclareVariable()");
            sdt.addString(myLex());
            match("int");
            
            Varid();
            A103();
            if(look.contains(";"))
            {
                A102();
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
           sdt.ts= sdt.ts+"char ";
          
           hamaraBajaj("DeclareVariable()");
            
            sdt.addString(myLex());
            match("char");
            
            Varid();
            A103();
            if(look.contains(";"))
            {
                  A102();
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
            sdt.addString(myLex());
            
         String token2=words.get(token_number-1);
         String [] s =token2.split(",");
         s[0]=s[0].replace("(","");
         k=k+s[0]+'\n';
          sdt.ts= sdt.ts+s[0]+sdt.bytes + "\n";
         if(p1==true && p2==false){
         sdt.bytes=sdt.bytes+4;
                 
         }else if(p2==true && p1==false){
         sdt.bytes=sdt.bytes+1;
         
         }   
            hamaraBajaj("Varid()");
         
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
    public String getVar(){
    
   return "t"+(vid-1);
    }
    public void A45(){
        
    sdt.emit(sdt.n['x'] + " = " +getVar());
    
    }
    void A100(){
    sdt.n['u']= sdt.getStored();
    }
    void A101(){
    sdt.emit(sdt.n['u']);
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
              
                //System.out.print("sdkaksjdksjdks " +sdt.storage);
                A100();
                
                if(look.contains(";"))
                {
                    
                    A101();
                    
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
    public void A102(){
    sdt.emit(sdt.n['o']);
    }
    public void A103(){
    sdt.n['o']=sdt.getStored();
    }
    void OUT() throws IOException
    { tabs++;
        if(look.contains("out"))
        {
            
            hamaraBajaj("OUT()");
            sdt.addString(myLex());
            match("out");
            outtype();
            A103();
            if(look.contains(";"))
            {
                A102();
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
            sdt.addString("ret");
            hamaraBajaj("RET()");
            match("ret");
            rettype();
            A103();
            if(look.contains(";"))
            {
             A102();
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
            sdt.addString(myLex());
            hamaraBajaj("rettype()");
            match("id");
            
        }
        else if(look.contains("Integer"))
        {
            
            sdt.addString(myLex());
            hamaraBajaj("rettype()");
            match("Integer");
            
        }
        else if(look.contains("LiteralConstant"))
        {
            
            sdt.addString(myLex());
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
        if(look.equals(" in "))
        {
            sdt.addString(myLex());
            hamaraBajaj("in()");
            match("in");
            
            if(look.contains("id"))
            {
                sdt.addString(myLex());
                match("id");
                A103();
                if(look.contains(";"))
                {
                    A102();
                    
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
    void A44(){
    sdt.n['E']=sdt.n['R']; 
    String [] s = sdt.storage.split("= ");
    sdt.storage= s[0];
    sdt.storage=s[0]+"= "+sdt.n['E'];
    }
    void E() throws IOException
    { tabs++;
    hamaraBajaj("E()");
            
        T();
        A10();
        R();
      A44();
      
        
      tabs--;
        
    }
    void A9(){
    sdt.n['T']=sdt.n['F'];
    }
    void T() throws IOException
    {
        tabs++;
        
        hamaraBajaj("T()");
        
        
        f();
        A9();
        R_();

        tabs--;
        
    }
    void A11(String s){
    
    sdt.emit(makeVar() + " = " + sdt.n['R'] +s+ sdt.n['T']);
    sdt.n['R']= "t"+(vid-1);
    }
    void R() throws IOException
    { tabs++;
        if(look.contains("+"))
        {
            
            hamaraBajaj("R()");
            sdt.addString(myLex());
          //  sdt.addaEString(myLex());
            match("+");
            
            T();
           A11(" + ");
           if(stack.isEmpty()){
           stack.push("+");
           }else{
           
           
           }
             
            //System.out.print("---\n "+makeVar()+ ":= "+ sdt.aE +"\n");
            R();
            
        }
        else if(look.contains("-"))
        {
            
            stack.push("-");
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
        //output[i]=myLex();
        i++;
    }
    public void A42(){
    sdt.emit("param " +sdt.n['E'] );
    sdt.count=sdt.count+1;
    }
    public void AL_() throws IOException{
    if(look.contains(",")){
       
        hamaraBajaj("AL");
    match(",");
    
    E();
    A42();
    AL_();
    }
    
    }
    public void A41(){
    sdt.emit("param "+ sdt.n['E'] );
   sdt.count=1;
    }
    public void AL() throws IOException{
    hamaraBajaj("AL");
        E();
        A41();
        AL_();
    
    }
    public void OAL() throws IOException
    {
         hamaraBajaj("OAL()");
           AL();
    
    }
    public void A43(){
        String makeVar = makeVar();
     sdt.emit("call " + sdt.n['i']+" " +sdt.n['s'] + sdt.count+" " +makeVar());
     sdt.emit(sdt.n['t']+" := " +" "+" t" + String.valueOf(vid-1));
   
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
            if(look.contains("(")){
        
            match("(");
            OAL();
            if(look.contains(")")){
            match(")");
             A43();
            }
           
            }
            
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
    void R_() throws IOException
    {
        tabs++;
        if(look.contains("*"))
        {
            A11(" * ");
            sdt.addString(myLex());
            stack.push("*");
            hamaraBajaj("R_()");
            match("*");
            
            
            f();
            A11(" * ");
            
            R();
            
        }
        
        else if(look.contains("/"))
        {
            A11("/");
            sdt.addString(myLex());
            
         stack.push("/");
            
          match("/");
          f();
          A11(" / ");
          R();
            
        }
        else{
        
            A12(" ");
        }
       tabs--;
    }
    
    public void A105(){
        sdt.emit("if" + sdt.getStored() +  " goto ");
        sdt.n['x']=String.valueOf(sdt.getLine());
        
        sdt.emit("goto");
       sdt.n['y']=String.valueOf(sdt.getLine());
        
    }
    public void A301(){
    sdt.emit("if" + sdt.getStored() +  " goto ");
        sdt.saveLine(0);    
        sdt.emit("goto");
    }
    public void A401(){
  sdt.backPath(Integer.valueOf(sdt.n['x'])-1, sdt.line);
    }
    public void A402(){
        sdt.line=sdt.line-1;
        sdt.emit("\ngoto" +" "+String.valueOf(Integer.valueOf(sdt.n['x'])-1));
  sdt.backPath(Integer.valueOf(sdt.n['y'])-1, sdt.line+1);
          sdt.line=sdt.line+1;

  
    }
    public void WHILE() throws IOException
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
            A401();
            match(")");
            }else{
            halt();
            }
            constatment();
            A402();
        }
        tabs--;
    }
    public void A5(){
    
    sdt.emit(sdt.getStored());
    }
    public void A106(){
    sdt.backPath(Integer.valueOf(sdt.n['x'])-1, sdt.line);
    }
    
    
    public void A6(){
        sdt.emit("goto");
  sdt.n['z']= String.valueOf(sdt.getLine());
   
    }

    void IF() throws IOException
    { tabs++;
    
      
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
           
            if(look.contains(")")){
            match(")"); 
            A106();
            
            }
          
            constatment();
            
            
            
            
            
        if(look.contains("else")){
            A6();
            
            A70();
            match("else");
            constatment();
            A71();
            
            
        }
        else
        {
            A7000();
        }
           
        }
    
  
    

        tabs--;
    }
    public void A70(){
    sdt.backPath(Integer.valueOf(sdt.n['y'])-1, sdt.line);
    
    }
    public void A7000(){
    sdt.backPath(Integer.valueOf(sdt.n['y'])-1, sdt.line);
    
    }
    
    public void A71(){
    sdt.backPath(Integer.valueOf(sdt.n['z'])-1, Integer.valueOf(sdt.n['p']));
    
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
        A105();
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
     
           sdt.iff=sdt.iff+" "+ myLex();
           sdt.addString(myLex());
            
            match("id");
            
            
        }
        else if(look.contains("Integer"))
        {
            
           sdt.iff=sdt.iff+" "+ myLex();
           sdt.addString(myLex());
            
            hamaraBajaj("P()");
            match("Integer");
        }
         else if(look.contains("LiteralConstant"))
        {
            
            
           sdt.iff=sdt.iff+" "+ myLex();
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
            System.exit(0);
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
        sdt.n['p']=String.valueOf(sdt.getLine());
       // S();
        
        
         
       
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
             //A2();
            
            
        }
        if(look.contains("ret")){
            error=0;
            RET();
            // A2();
          
           
        }
        if(look.equals(" in ")){
            error=0;
            in();
            
        }
        if(look.contains("id")){
            error=error-1;
            InitializeVariable();
             //A2();
           
        }
        if(look.contains("int") || look.contains("char")){
            error=0;
            DeclareVariable();
            // A2();
           
           
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
                   

       if(look.contains("}")==false)
       {
        hamaraBajaj("Statements()");
        Statement();
        if(exitprogram==true)
        {
            return;
        }
        Statements();
        
        
       }
       
       
       tabs--;
    }
    
      void sdtPrint() throws IOException
    {
        sdt.print();
    }
    
    
}
