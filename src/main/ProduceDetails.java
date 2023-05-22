/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class ProduceDetails {
    
    private String productName, price;
    int productID;
    
    public ProduceDetails() {
    }

    public ProduceDetails(String productName, String price, int productID) {
        this.productName = productName;
        this.price = price;
        this.productID = productID;
    }
    
    public void addProduceDetails(){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Produce.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(ProduceDetails.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ProduceDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<ProduceDetails> produceList() {
        ArrayList<ProduceDetails> pList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Produce.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ProduceDetails produce;
            try {
                while (true) {
                    produce = (ProduceDetails) ois.readObject();
                    pList.add(produce);
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch                 
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return pList;
    }
    
    @Override
    public String toString() {
        return "ProduceDetails{" + "productName=" + productName + ", price=" + price + ", productID=" + productID + '}';
    }
    
    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }
}
