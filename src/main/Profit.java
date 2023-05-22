/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class Profit {

    public Profit() {
    }

    public Profit(String year, String profitDetails) {
        this.year = year;
        this.profitDetails = profitDetails;
    }

    public void profitAnalysis() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Profit.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
     public String getYear() {
        return year;
    }

    public String getProfitDetails() {
        return profitDetails;
    }
    
    @Override
    public String toString() {
        return "Profit{" + "year=" + year + ", profitDetails=" + profitDetails + '}';
    }
    private String year, profitDetails;

   
}
