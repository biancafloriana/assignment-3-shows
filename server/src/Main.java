import DAO.UserDAO;
import model.User;


public class Main {
    public  static void main(String[] arg){
       User u = new User(1,"admin","nunu", "admin");
       //User u2 =
               new UserDAO().delete(u);
       //System.out.println(u2.getPassword());
    }
}