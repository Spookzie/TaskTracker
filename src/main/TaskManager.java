package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TaskManager
{
    public void AddTask(String title, String desc)
    {
        // Setting up connection
        Connection con = DatabaseHelper.Connect();
        if(con == null)
        {
            System.out.println("Database connection failed");
            return;
        }

        // Inserting new task
        String query = "INSERT INTO tasks(title, description) VALUES(?, ?)";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, title);
            pst.setString(2, desc);

            int rowsInserted = pst.executeUpdate();

            if(rowsInserted > 0)
                System.out.println("Task added Successfully!");
            else
                System.out.println("Insertion Failed");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseHelper.Close(con);
        }
    }


    public List<String> GetAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        
        // Setting up connection
        Connection con = DatabaseHelper.Connect();
        if(con == null)
        {
            System.out.println("Database connection failed");
            return null;
        }

        // Getting all tasks
        String query = "SELECT * FROM tasks";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                String status = rs.getString("status");
                String timestamp = rs.getString("created_at");
                
                String task = String.format("ID: %d | Title: %s | Description: %s | Status: %s | Timestamp: %s", id, title, desc, status, timestamp);

                tasks.add(task);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseHelper.Close(con);
        }

        return tasks;
    }


    public void UpdateTask(int id, String new_status)
    {
        // Setting up connection
        Connection con = DatabaseHelper.Connect();
        if(con == null)
        {
            System.out.println("Database connection failed");
            return;
        }

        // Updating the task
        String query = "UPDATE tasks SET status = ? WHERE id = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, new_status);
            pst.setInt(2, id);

            int rowsUpdated = pst.executeUpdate();

            if(rowsUpdated > 0)
                System.out.println("Task " + id + "updated to " + new_status);
            else
                System.out.println("No task found with ID " + id);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseHelper.Close(con);
        }
    }


    public void DeleteTask(int id)
    {
        // Setting up connection
        Connection con = DatabaseHelper.Connect();
        if(con == null)
        {
            System.out.println("Database connection failed");
            return;
        }

        // Deleting the task
        String query = "DELETE FROM tasks WHERE id = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);

            int rowsDeleted = pst.executeUpdate();

            if(rowsDeleted > 0)
                System.out.println("Task " + id + " has been deleted");
            else
                System.out.println("No task found with ID " + id);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseHelper.Close(con);
        }
    }
}