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
public class Task {

    public Task(int taskId, int userId, String dueBy, String taskDescription) {
        this.taskId = taskId;
        this.userId = userId;
        this.dueBy = dueBy;
        this.taskDescription = taskDescription;
    }

  
    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", userId=" + userId + ", dueBy=" + dueBy + ", taskDescription=" + taskDescription + '}';
    }

    private final int taskId;
    private final int userId;
    private String dueBy, taskDescription;
    
    public void addNewTask(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Tasks.bin");
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
            Logger.getLogger(ManagerAssignTaskSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerAssignTaskSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }    
    
     public static ArrayList<Task> taskList() {
        ArrayList<Task> tList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Tasks.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Task t;
            try {
                while (true) {
                    t = (Task) ois.readObject();
                    tList.add(t);
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
        return tList;
    }
    
     public int getTaskId() {
        return taskId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDueBy() {
        return dueBy;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}
   
