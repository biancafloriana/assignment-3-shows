package model.BLL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    
    private static Connection connection;
    private static ServerSocket myService;
    private  Socket clientSocket = null;
    private  static ObjectInputStream serverInputStream;
    private  static ObjectOutputStream serverOutputStream;
    private  Connection(){}

    public static Connection getConnection() {

        if(myService == null){
            try {
                connection = new Connection();
                connection.myService  = new ServerSocket( 1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }else {

            return connection;
        }
    }

    public void waitForRequest(){

        try {
            connection.clientSocket = myService.accept();
            serverInputStream =  new
                    ObjectInputStream(clientSocket.getInputStream());

            Request r = (Request) serverInputStream.readObject();
            System.out.println(r.getType());
            new ServicesHandler().execute(r);
           // serverInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    
    public void response(Object o){

        try {
            serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            serverOutputStream.writeObject(o);
            //serverOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}
