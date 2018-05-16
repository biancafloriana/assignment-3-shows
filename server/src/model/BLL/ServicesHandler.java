package model.BLL;



public class ServicesHandler {
    public void execute(Request r) {

        String serviceName = r.getServiceName();

        switch (serviceName){

            case "user":
                new UserServices().execute(r);

        }

    }

    public void response(Object o){
        Connection.getConnection().response(o);
    }
}
