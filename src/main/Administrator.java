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
public class Administrator extends User {

    public Administrator() {
    }

    public Administrator(int userId, String name, String password, String group) {
        super(userId, name, password, group);
    }

   
    public static void createUser(int userId, String name, String password, String group){
        if("CEO".equals(group)){
            CEO ceo = new CEO(userId, name, password, group);
            ceo.addUser();
        }
        else if("Manager".equals(group)){
            Manager manager = new Manager(userId, name, password, group);
            manager.addUser();
        }
        else if("Employee".equals(group)){
            Employee emp = new Employee(userId, name, password, group);
            emp.addUser();
        }
        else if("Administrator".equals(group)){
            Administrator admin = new Administrator(userId, name, password, group);
            admin.addUser();
        }
        else if("Distributor".equals(group)){
            Distributor dis = new Distributor(userId, name, password, group);
            dis.addUser();
        }
        
    }
    
    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("User.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
    public void updateStorageDetails(String productName, String weight, int productID){
        File f = null;
        f = new File("Storage.bin");
        if(f.exists()){
            f.delete();
        }
        StorageDetails c = new StorageDetails(productName, weight, productID);
        c.addStorageDetails();
    }
    
     public void updateProduceDetails(String productName, String price, int productID){
        File f = null;
        f = new File("Produce.bin");
        if(f.exists()){
            f.delete();
        }
        ProduceDetails s = new ProduceDetails(productName, price, productID);
        s.addProduceDetails();
    }
    
}
