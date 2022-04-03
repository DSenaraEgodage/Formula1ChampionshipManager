import java.io.Serializable;

public abstract class Driver implements Serializable {

    private String driver_name; //make a private variable for driver name
    private String driver_location; //make a private variable for driver location
    private String driver_team; //make a private variable for driver team

    public Driver(){ // make constructor

    }

     public Driver(String driver_name, String driver_location, String driver_team) {
         this.driver_name = driver_name;
         this.driver_location = driver_location;
         this.driver_team = driver_team;
     }

     public String getDriver_name() { //making driver getter
        return driver_name; }

     public void setDriver_name(String driver_name) { //making driver name setter

        this.driver_name = driver_name;
     }

     public void setDriver_location(String driver_location) { //making driver location setter

        this.driver_location = driver_location;
     }

     public void setDriver_team(String driver_team) { //making driver team setter

        this.driver_team = driver_team;
     }

     public String getDriver_location() { //making driver location getter

        return driver_location;
     }

     public String getDriver_team() { //making driver team getter

        return driver_team;
     }


}
