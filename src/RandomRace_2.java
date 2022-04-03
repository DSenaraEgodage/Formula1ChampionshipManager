import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class RandomRace_2 {
    public RandomRace_2() throws ParseException {
        JTable table = new JTable();
        Object[] columns = {"Player", "Start", "End"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame(" Random Race_1");  //edits the frame
        frame.getContentPane().setBackground(new Color(78, 218, 236, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 700, 600);

        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);  //edits everything on the table
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.black); //bg color
        table.setGridColor(Color.magenta);
        table.setSelectionForeground(Color.red);
        table.setFont(new Font("Arial", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0, 0, 700, 500);
        frame.getContentPane().add(pane);


        Object[] col = new Object[3];//making 3 colums
        PointCompare pointCompare = new PointCompare();

        ArrayList<Integer> wonPositions =Places();
        Formula1ChampionshipManager f=new Formula1ChampionshipManager();
        int x=1;
        for (Formula1Driver d:f.driversArrayList) {
            wonPositions.add(x);
            x++;
        }

        int i=1;
        Formula1Driver [] sorted=new Formula1Driver[f.driversArrayList.size()];
        Collections.shuffle(Formula1ChampionshipManager.driversArrayList);
        for (Formula1Driver driver: Formula1ChampionshipManager.driversArrayList) {
            col[0] = driver.getDriver_name();
            col[1] = i;
            col[2] = wonPositions.get(i-1);


            sorted[i-1]=driver;

            driver.setNumOfPointsByPlace(i-1);
            model.addRow(col);
            i++;
        }
        String date =new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        Race r=new Race(date,sorted); //making object with Race class
        f.races.add(r);//adding race to the races
        f.save(); //save data to a text file up to that point
        f.saveRaces(); //save race data to a text file up to that point

        frame.setVisible(true);
    }
    Boolean checkIn(int i){ //checking percentage
        Boolean In=true;
        Random random=new Random(); //making random numbers
        int randomGot = random.nextInt(100) + 1;//range 1-100
        if(i>=randomGot){//check number with percentage
            return In;//return true
        }
        In =false;//return false
        return In;

    }
    ArrayList<Integer> Places(){
        Formula1ChampionshipManager f=new Formula1ChampionshipManager();//making object with  Formula1ChampionshipManager class
        int size=f.driversArrayList.size();//

        int whoFirst;
        whoFirst=0;
        if(checkIn(2)){
            whoFirst=9;
        }else if(checkIn(2)){
            whoFirst=5;
        }else if(checkIn(10)){
            whoFirst=4;
        }else if(checkIn(10)){
            whoFirst=3;
        }else if(checkIn(30)){
            whoFirst=2;
        }else if(checkIn(2)){
            whoFirst=8;
        }else if(checkIn(2)){
            whoFirst=7;
        }else if(checkIn(2)){
            whoFirst=6;
        }else{
            whoFirst=1;
        }

        ArrayList<Integer> place = new ArrayList<Integer>(); //making object with ArrayList<Integer> class
        for (int j=2; j<size+1; j++) {
            place.add(j);
        }
        Collections.shuffle(place);//shuffle places
        place.add(whoFirst-1,1); //
        return place;


    }

}