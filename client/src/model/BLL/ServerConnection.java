package model.BLL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection {

    private static ServerConnection serverConnection;
    private static Socket myClient;

    private ServerConnection(){

    }

    public static ServerConnection getConnection() {

        if(myClient == null){
            try {
                serverConnection = new ServerConnection();
                serverConnection.myClient  = new Socket("127.0.0.1", 1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return serverConnection;
        }else {

            return serverConnection;
        }
    }

    public void makeReguest(Request r){
        try {
            ObjectOutputStream clientOutputStream = new
                    ObjectOutputStream(myClient.getOutputStream());
            clientOutputStream.writeObject(r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getResponse(){
        ObjectInputStream clientInputStream = null;
        Object o = null;
        try {
            clientInputStream = new
                    ObjectInputStream(myClient.getInputStream());
           o = clientInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return o;
    }

}
