/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Hp
 */
public abstract class User implements Serializable{
    protected int userId;
    protected String name, password, email, gender, dob, phone, address, group;
    public User() {
    }

    public User(int userId, String name, String password, String group) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.group = group;
    }

    public static ArrayList<User> usersGroup() {
        ArrayList<User>uList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            f = new File("Users.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User u;
            try {
                while (true) {
                    u = (User) ois.readObject();
                    uList.add(u);
                }
            }
            catch (IOException | ClassNotFoundException e) {
                
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
        return uList;
    }
    
    public abstract void addUser();
    
    public static User login(int userId, String password, String group){
        ArrayList<User>uList = usersGroup();
        for(User user:uList){
            if(user.getUserId() == userId && user.getPassword().equals(password) && user.getGroup().equals(group)){
                return user;
            }
        }
        return null;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + ", group=" + group + '}';
    }
}

