package model.BLL;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ShowServices {

    public static List<Show> findAll() {

        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Request r = new Request("read","show",null);
        serverConnection.makeReguest(r);
        List shows=  serverConnection.getResponseList();

        return  shows;
    }

    public static List<Comment> getComments(int id) {
        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r = new Request("read","comment",id);
        serverConnection.makeReguest(r);
        List comments=  serverConnection.getResponseList();
        return comments;

    }

    public static List<Rating> getRatings(int id) {
        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r = new Request("read","rating",id);
        serverConnection.makeReguest(r);
        List ratings=  serverConnection.getResponseList();
        return ratings;
    }

    public static Boolean addComment(Comment comment) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        Request r = new Request("create","comment",comment);
        serverConnection.makeReguest(r);
        //Boolean ok = (Boolean)serverConnection.getResponse();
        return true;
    }

    public static Boolean addRating(Rating rating) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        Request r = new Request("create","rating",rating);
        serverConnection.makeReguest(r);
       // Boolean ok = (Boolean)serverConnection.getResponse();
        return true;
    }

    public static Show findById(int id,String type) {

        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r;
        // System.out.println(u.getType());
        switch (type){

            case "movie":
                Movie m = new Movie();
                m.setId(id);
                r = new Request("findById","show",m);
                serverConnection.makeReguest(r);
                m = (Movie)serverConnection.getResponse();
                return m;
                //break;
            case "theatre":
                Theatre t = new Theatre();
                t.setId(id);
                r= new Request("findById","show",t);
                serverConnection.makeReguest(r);
                t = (Theatre) serverConnection.getResponse();
                return t;
                //break;
            case "sport":
                SportEvent s = new SportEvent();
                s.setId(id);
                r = new Request("findById","show",s);
                serverConnection.makeReguest(r);
                s = (SportEvent) serverConnection.getResponse();
                return s;
                //break;
        }
    return null;
    }

    public static Show findByName(String date) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        Show s = new Show();
        s.setName(date);
        Request r = new Request("findByTitle","show",s);
        serverConnection.makeReguest(r);
        s= (Show) serverConnection.getResponse();
        return s;



    }
}
