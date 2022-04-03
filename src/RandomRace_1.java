import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class RandomRace_1 {
    public RandomRace_1() throws ParseException {
        JTable table = new JTable();
        Object[] columns = {"Player", "Start", "End"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("Random Race 1");  //edits the frame
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


        Object[] col = new Object[3]; //making 3 colums
        PointCompare pointCompare = new PointCompare(); //make point compare object

        ArrayList<Integer> wonPositions =new ArrayList(); //winning position arraylist
        Formula1ChampionshipManager f=new Formula1ChampionshipManager(); //created object with Formula1ChampionshipManager
        int x=1;
        for (Formula1Driver d:f.driversArrayList) { //places added to wonPosition
            wonPositions.add(x);
            x++;
        }
        Collections.shuffle(wonPositions); //wonPosition shuffled

        int i=1;
        Formula1Driver [] sorted=new Formula1Driver[f.driversArrayList.size()]; //driversArrayList sorted
        Collections.shuffle(Formula1ChampionshipManager.driversArrayList); //shuffle driverArrayList
        for (Formula1Driver driver: Formula1ChampionshipManager.driversArrayList) {
            col[0] = driver.getDriver_name();
            col[1] = i;
            col[2] = wonPositions.get(i-1);


            sorted[i-1]=driver;//adding driver to driverArrayList

            driver.setNumOfPointsByPlace(i-1);//setNumOfPointsByPlace of driver
            model.addRow(col);//row add to model
            i++;
        }
        String date =new SimpleDateFormat("dd/MM/yyyy").format(new Date());//get a date
        Race r=new Race(date,sorted); //create race object
        f.races.add(r);
        f.save(); //save data to a text file up to that point
        f.saveRaces(); //save race data to a text file up to that point

        frame.setVisible(true);
    }
}