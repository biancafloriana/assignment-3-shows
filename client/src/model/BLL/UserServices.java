package model.BLL;

import model.User;

public class UserServices {

        private User user;

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
}
