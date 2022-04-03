import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Formula1ChampionshipManager implements ChampionshipManager { // implemeted by champianship manager

    public static ArrayList<Formula1Driver> driversArrayList = new ArrayList<Formula1Driver>();//use to store objects of drivers
    static ArrayList<Race> races = new ArrayList<Race>(); // use to store objects of races


    public void mainmenu() throws ParseException {
        System.out.println("----------------------------");
        System.out.println("---------Main Menu---------");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.print(" 1 = Add a new driver\n"+
                " 2= Delete the driver from List\n"+
                " 3= Change the driver from the team\n"+
                " 4= Display the Driver's details\n"+
                " 5= Add a new race\n"+
                " 6= Display the points Table\n"+
                " 7= Saving to a file\n"+
                " 8= Go to Graphical User Interface\n"+
                "Enter the option (1/2/3/4/5/6/7/8): "
        );
        String opt = input.nextLine(); //get input from user
        if (opt.equals("1")){
            newDriver();//Add a new driver
        }else if(opt.equals("2")){
            delete_Driver();//Delete the driver from List
        }else if(opt.equals("3")){
            changeTheDriver();//Change the driver from the team
        }else if(opt.equals("4")){
            displayDriverStatics();//Display the Driver's details
        }else if(opt.equals("5")){
            newRace();//Add a new race
        }else if(opt.equals("6")){
            fullInformationTable();//Display the points Table
        }else if(opt.equals("7")){
            save();//Saving to a file
        }else if(opt.equals("8")){
            GUI1 g = new GUI1();//object created and Go to Graphical User Interface

        }else{
            System.out.println("Enter the correct option");//Enter valid option

        }
        }

    public void newDriver(){//add a new driver method
        Formula1Driver d = new Formula1Driver(); //new object by Formula1Diver
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the driver Name: ");
        String name=input.nextLine(); //get user input for driver name
        if(checkDriverList(name)){ // checkDriverList is call
            System.out.print("Enter the driver Team: ");
            String team=input.nextLine(); //get user input for team

            if(checkTeamList(team)){//checkTeamList id call
                System.out.print("Enter the driver Location: ");
                String location=input.nextLine(); //get user input for location

                d.setDriver_name(name) ; //setting driver for object
                d.setDriver_location(location);//setting location for object
                d.setDriver_team(team); //setting team for object
                driversArrayList.add(d); //new object add to array list
            }else{
                System.out.println("Already add this team"); //get the massege for already add team
            }
        }else {
            System.out.println("Already add this driver"); //get the massage for already add driver

        }
        save(); //calling save method
    }


    public  boolean checkDriverList (String name){
        for (Formula1Driver d:driversArrayList) { //every object in array list is checked
            if(d.getDriver_name().equals(name)){ //unique name of driver list checked
                return false; // if name is equal to driver name who is already registered return false
            }

        }return true;//if name is not equal to driver name who is already registered return true

    }

    public  boolean checkTeamList (String team){
        for (Formula1Driver d:driversArrayList) { //every object in array list is checked
            if(d.getDriver_team().equals(team)){ //unique team of driver list checked
                return false; //if name is equal to driver team who is already registered return false
            }

        }return true; //if name is not equal to driver name who is already registered return true
    }



    public  void delete_Driver(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Driver name you want to delete from list:  ");
        String delname = input.nextLine(); //get user input for delete
        boolean delete = false;
        for (Formula1Driver d: driversArrayList) {  //every object in array list is checked
            if(delname.equals(d.getDriver_name())){  //unique team of driver list checked
                driversArrayList.remove(d); //remove from the array list
                System.out.println("Driver delete from list");
                delete= true;
                break;

            }
        }if(!delete){
            System.out.println("Driver is not registered");
        }
        save(); //calling save method
    }

    public  void changeTheDriver(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the driver Name: ");
        String nameChange=input.nextLine(); //get user input for change
        boolean change = false;
        for (Formula1Driver d: driversArrayList) { //every object in array list is checked
            if(nameChange.equals(d.getDriver_name())){ //unique team of driver list checked
                System.out.print("Enter the new driver name: ");
                String newName=input.nextLine(); //get user input as new driver name
                d.setDriver_name(newName); //setting driver for object

                System.out.print("Enter the driver Location: ");
                String newLocation=input.nextLine(); //get user input as new location
                d.setDriver_location(newLocation); //setting location for object
               change=true;
                break;
            }
        }if(!change){
            System.out.println("Driver is not registered");
        }
        save(); //calling save method
    }


    public  void displayDriverStatics(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the driver Name: ");
        String nameDisplay=input.nextLine(); //get user input for display details
        boolean display = false;
        for (Formula1Driver d: driversArrayList) {  //every object in array list is checked
            if(d.getDriver_name().equals(nameDisplay)){
                System.out.println("Location - "+d.getDriver_location()); //getting driver name for required driver
                System.out.println("Team - "+d.getDriver_team()); //getting team name for required driver
                System.out.println("Number of Races - "+d.getNum_of_races()); //getting number of races for required driver
                System.out.println("Number of Points - "+d.getNum_of_points()); //getting number of points for required driver
                System.out.println("1st Places - "+d.getFirst_position()); //getting first position for required driver
                System.out.println("2nd Places - "+d.getSecond_position()); //getting second position for required driver
                System.out.println("3rd Places - "+d.getThird_position()); //getting third position for required driver
                display=true;
                break; // ends the loop
            }
        }if(!display){
            System.out.println("Driver is not registered");
        }

    }

    private boolean checkDate(String dateStr) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // format of the date
        df.setLenient(false);
        try {
            df.parse(dateStr);
        }
        catch (ParseException e) {
            return false; //return false when the date is not valid
        }
        return true; //return true when the date is valid
    }



    public  void newRace(){
        Scanner input = new Scanner(System.in);

        Formula1Driver[] racePlaces = new Formula1Driver[driversArrayList.size()];
        System.out.print("Enter the Date: ");
        String date = input.nextLine(); // get user input for date to race
        int i=1;
        if(checkDate(date)) {
            for (Formula1Driver d : driversArrayList) {  //every object in array list is checked
                System.out.print(i + " place " + "Enter the name of the driver: ");
                String placeName = input.nextLine(); // get user input for place
                racePlaces[i - 1] = driverByName(placeName);
                driverByName(placeName).setNumOfPointsByPlace(i);

                i++;
            }
            try {
                Race race = new Race(date, racePlaces); //creating a race
                races.add(race); // adding race to the races
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Enter the correct date next time");
        }
        save(); //calling save method
        saveRaces(); //calling saveToFileRace method
    }


    private  Formula1Driver driverByName(String name){
        for (Formula1Driver driver_name: driversArrayList) {
            if (driver_name.getDriver_name().equals(name)){
                return driver_name;
            }
        }

        return new Formula1Driver(name,"e","e");

    }

    public  void fullInformationTable(){
        Collections.sort(driversArrayList,new PointCompare().reversed());
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|  Driver  | TeamName |  Location  | Races | Points | First | Second | Third |");
        System.out.println("--------------------------------------------------------------------------------");
        for (Formula1Driver driver:driversArrayList) {
            System.out.printf("| %8s | %8s | %10s | %5d | %6d | %5d | %6d | %5d |",driver.getDriver_name(),driver.getDriver_team(),driver.getDriver_location(),driver.getNum_of_races(),driver.getNum_of_points(),driver.getFirst_position(),
                    driver.getSecond_position(),driver.getThird_position());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");

    }

    public  void save(){ //saving data to save text file
        File f=new File("Driver_Details.txt"); //making object with file class
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(f);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(driversArrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public  void load(){ //loading data to savefrom load text file
        try {
            FileInputStream fileInputStream=new FileInputStream("Driver_Details.txt");//making object with file class
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            driversArrayList = (ArrayList<Formula1Driver>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (EOFException ex1) { //message display on exceptions
            System.out.println("Error");
        } catch (IOException | ClassNotFoundException e) {//message display on exceptions
            System.out.println("Error loading.");
            e.printStackTrace();
        }
    }


    public void saveRaces() { //race data to save text file
        File f1 = new File("saveToFileRaces.txt"); //making object with file class
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(f1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(races);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRace() {//loading race data to save from load text file
        try {
            FileInputStream fileInputStream = new FileInputStream("saveToFileRaces.txt"); //making object with FileInputStream class
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); //making object with ObjectInputStream class
            races = (ArrayList<Race>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (EOFException ex1) {
            System.out.println("Error"); //message display on exceptions

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading..."); //message display on exceptions
            e.printStackTrace();
        }
    }

}
