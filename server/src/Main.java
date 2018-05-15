import DAO.ShowDAO;
import model.Movie;


public class Main {
    public  static void main(String[] arg){
        Movie m = new Movie(2,"Titanic","action","Jonny Nu",4);
       // new ShowDAO().delete(m);
        Movie m1 = new Movie();
        m1.setName("Titanic");
        m1 = (Movie)new ShowDAO().findByTitle(m1);
        System.out.println(m1.getDescription());
    }
}