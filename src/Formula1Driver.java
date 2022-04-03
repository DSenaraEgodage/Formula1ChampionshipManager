import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {
    private static final long serialVersionUID=1001L;
    private int first_position; //make variable for first position
    private int second_position; //make variable for second position
    private int third_position; //make variable for third position
    private int num_of_points; //make variable for number of positions position
    private int num_of_races; //make variable for number od races position


    public Formula1Driver(){ //make constructor

    }
    public Formula1Driver(String driver_name, String driver_location, String driver_team) {
        super(driver_name, driver_location, driver_team);
    }

    public void setNumOfPointsByPlace(int place){
        num_of_races++;

        if(place==1){
            num_of_points+=25;
            first_position+=1;
        }else if(place==2){
            num_of_points+=18;
            second_position+=1;
        }else if(place==3){
            num_of_points+=15;
            third_position+=1;
        }else if(place==4){
            num_of_points+=12;
        }else if(place==5){
            num_of_points+=10;
        }else  if(place==6){
            num_of_points+=8;
        }else if(place==7){
            num_of_points+=6;
        }else if(place==8){
            num_of_points+=4;
        }else if(place==9){
            num_of_points+=2;
        }else if(place==10){
            num_of_points+=1;
        }
    }


    public int getFirst_position() { //making number of first position getter
        return first_position;
    }

    public int getSecond_position() { //making number of second position getter

        return second_position;
    }

    public int getThird_position() { //making number of third position getter

        return third_position;
    }

    public int getNum_of_points() { //making number of points getter

        return num_of_points;
    }

    public int getNum_of_races() { //making number of races  getter

        return num_of_races;
    }

    public void setFirst_position(int first_position) { //making number of first position setter

        this.first_position = first_position;
    }

    public void setSecond_position(int second_position) { //making number of second position setter

        this.second_position = second_position;
    }

    public void setThird_position(int third_position) { //making number of third position setter

        this.third_position = third_position;
    }

    public void setNum_of_points(int num_of_points) { //making number of points setter

        this.num_of_points = num_of_points;
    }

    public void setNum_of_races(int num_of_races) { //making number of races setter

        this.num_of_races = num_of_races;
    }
}
