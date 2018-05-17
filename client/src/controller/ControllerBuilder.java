package controller;

import model.User;

public class ControllerBuilder {
    public void getController(User user) {

        String type = user.getType();

        switch (type){

            case "basic":
                    new BasicUserController(user.getId());
                break;
            case "premium":
                    new PremiumUserController(user.getId());

        }

    }
}
