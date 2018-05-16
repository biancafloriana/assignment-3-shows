package model.BLL;

import DAO.UserDAO;
import model.User;

public class UserServices {
    public void execute(Request r) {

        String type = r.getType();
        switch (type){

            case "findByUsername":
                    this.findByUsername((User) r.getData());

        }
    }

    private void findByUsername(User data) {

        data = new UserDAO().findByUsername(data.getUsername());
        new ServicesHandler().response(data);
    }
}
