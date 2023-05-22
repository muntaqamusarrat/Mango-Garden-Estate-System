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
public class Meeting {

    public Meeting(String date, String time, String topic) {
        this.date = date;
        this.time = time;
        this.topic = topic;
    }

    public String date, time, topic;
    
    public Meeting() {
    
    }
    
    public void addNewMeeting(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Meetings.bin");
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
            Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Meeting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }  
    
    public static ArrayList<Meeting> meetingList() {
        ArrayList<Meeting> meetingList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Meetings.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Meeting m;
            try {
                while (true) {
                    m = (Meeting) ois.readObject();
                    meetingList.add(m);
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
        return meetingList;
    }
   
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTopic() {
        return topic;
    }
    
    @Override
    public String toString() {
        return "Meeting{" + "date=" + date + ", time=" + time + ", topic=" + topic + '}';
    }
}
