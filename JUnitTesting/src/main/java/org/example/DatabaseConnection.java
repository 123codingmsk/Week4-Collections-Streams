package org.example;

public class DatabaseConnection  {

    boolean connected = false;
    public void connect(){
        connected = true;
        System.out.println("Connecting to system...");
    }
    public void disconnect(){
        connected = false;
        System.out.println("Disconnecting from system...");
    }
    boolean isconnected(){
        return connected;
    }
}
