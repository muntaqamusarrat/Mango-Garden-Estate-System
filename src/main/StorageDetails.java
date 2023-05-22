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
public class StorageDetails {

    private String productName, weight;
    int productID;
    
    public StorageDetails() {
    }
    
    public StorageDetails(String productName, String weight, int productID) {
        this.productName = productName;
        this.weight = weight;
        this.productID = productID;
    }
    
    public void addStorageDetails(){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Storage.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(StorageDetails.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(StorageDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<StorageDetails> storageList() {
        ArrayList<StorageDetails> sList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Storage.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            StorageDetails store;
            try {
                while (true) {
                    store = (StorageDetails) ois.readObject();
                    sList.add(store);
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
        return sList;
    }
    
    @Override
    public String toString() {
        return "StorageDetails{" + "productName=" + productName + ", weight=" + weight + ", productID=" + productID + '}';
    }

     public String getProductName() {
        return productName;
    }

    public String getWeight() {
        return weight;
    }

    public int getProductID() {
        return productID;
    }
}
