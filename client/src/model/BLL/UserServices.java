package model.BLL;

import model.Activity;
import model.BasicUser;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServices {

        private User user;

    public static boolean addActivity(int idUser, int id) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Activity a= new Activity(idUser,id);
       // System.out.println(a.getShowId() + " "+ a.getUserId());
        Request r = new Request("create","activity",a);
        serverConnection.makeReguest(r);
        //Boolean ok  = (Boolean) serverConnection.getResponse();
        // System.out.println(u.getType());

        return true;
    }

    public User findByUsername(User user) {

                ServerConnection serverConnection = ServerConnection.getConnection();
               // User u = new User("admin","nunu");
                Request r = new Request("findByUsername","user",user);
                serverConnection.makeReguest(r);
                user = (User)serverConnection.getResponse();
               // System.out.println(u.getType());

                return user;
        }

        public boolean logIn(User user) {

                User dbUser = findByUsername(user);

                if(dbUser != null){

                     this.user = dbUser;
                        System.out.println(dbUser.getPassword());
                    return dbUser.getPassword().equals(user.getPassword());

                }


                return false;
        }

        public User getUser() {
                return user;
        }
        public User getSpecializedUser(User u) {

                String type = u.getType();

                switch (type) {

                        case "basic":
                                return (BasicUser) user;
                }
                return null;
        }

    public static List<Activity> findAll(int idUser) {

        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r = new Request("read","activity",idUser);
        serverConnection.makeReguest(r);
        List<Activity> list= (ArrayList)serverConnection.getResponseList();
        return list;

    }
}
