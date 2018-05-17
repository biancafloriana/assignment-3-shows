package model.BLL;

import DAO.ShowDAO;
import model.Show;

import java.util.List;

public class ShowServices {
    public void execute(Request r) {
        String type = r.getType();
        switch (type){

            case "read":
                this.read();
                break;
            case "findById":
                this.findById(r.getData());
                break;
            case "findByTitle":
                this.findByTitle(r.getData());

        }
    }

    private void findByTitle(Object data) {

        Show s = new ShowDAO().findByTitle((Show)data);
        new ServicesHandler().response(s);

    }

    private void findById(Object data) {

        Show s = new ShowDAO().findByID((Show)data);
        new ServicesHandler().response(s);
    }

    private void read(){

        List list = new ShowDAO().read();
        new ServicesHandler().response(list);

    }
}
