package models;

import java.sql.Timestamp;


public class Task
{
    private int id;
    private String title;
    private String description;
    private STATUS status;
    private Timestamp createdAt;


    // Constructor
    public Task(int id, String title, String desc, STATUS status, Timestamp created_at)
    {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.status = status;
        this.createdAt = created_at;
    }

    
    // Accessors (Getters)
    public int GetId()  {   return this.id; }
    public String GetTitle()    {   return this.title;  }
    public String GetDescription()  {   return this.description;  }
    public STATUS GetStatus()   {   return this.status; }
    public Timestamp GetTimestamp() {   return this.createdAt;  }


    // Modifiers (Setters)
    public void SetId(int id)   {   this.id = id;   }
    public void SetTitle(String title)  {   this.title = title; }
    public void SetDescription(String desc) {this.description = desc;   }
    public void SetStatus(STATUS status)    {   this.status = status;   }
    public void SetTimestamp(Timestamp created_at)  {   this.createdAt = created_at;    }
}