/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncl;
import java.util.Date;
/**
 *
 * @author HafizAhmad
 */
public class Flight_Details_Info {

    public int Flight_Id;

    public int FPrice;
    public String FFeatures;
    public int EPrice;
    public String EFeatures;
    public int BPrice;
    public String BFeatures;
    public String From;
    public String To;
    public int Seats;
    public String DTime;
    public String RTime;
    public String DDATE;
    public String RDATE;

    public Flight_Details_Info(int Flight_Id,
            int FPrice,
            String FFeatures,
            int EPrice,
            String EFeatures,
            int BPrice,
            String BFeatures,
            String From,
            String To,
            int Seats,
            String DTime,
            String RTime,
            String DDATE,
            String RDATE) {

        this.BFeatures = BFeatures;
        this.BPrice = BPrice;
        this.DTime = DTime;
        this.EFeatures = EFeatures;
        this.EPrice = EPrice;
        this.FFeatures = FFeatures;
        this.FPrice = FPrice;
        this.Flight_Id = Flight_Id;
        this.From = From;
        this.RTime = RTime;
        this.Seats = Seats;
        this.To = To;
        this.RDATE=RDATE;
        this.DDATE=DDATE;

    }

}
