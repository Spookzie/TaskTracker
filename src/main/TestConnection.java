package main;

import java.sql.Connection;


public class TestConnection
{
    public static void main(String[] args)
    {
        Connection con = DatabaseHelper.Connect();
        DatabaseHelper.Close(con);
    }
}