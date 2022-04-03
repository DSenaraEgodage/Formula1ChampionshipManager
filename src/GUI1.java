import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collections;

public class GUI1 {
    public  GUI1(){
        JTable table = new JTable();
        Object[] columns = {"Name", "Location", "Team", "Number Of Races", "Points", "First", "Second", "Third"}; //colum
        DefaultTableModel model = new DefaultTableModel(); // make a object

        JFrame frame = new JFrame("STATISTICS TABLE Of DRIVERS"); //Table name
        frame.getContentPane().setBackground(new Color(29, 6, 234, 176));
        frame.getContentPane().setForeground(Color.red);
        frame.setBounds(100, 100,700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the program when close
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.WHITE);  //making a table
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.yellow); //back ground  color
        table.setGridColor(Color.black);
        table.setSelectionForeground(Color.red);
        table.setFont(new Font("Arial", Font.PLAIN,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0,0,700,500);
        frame.getContentPane().add(pane);

        Object[] col = new Object[8]; //making 8 colums

        PointCompare pointCompare=new PointCompare();
        Collections.sort(Formula1ChampionshipManager.driversArrayList,pointCompare.reversed());
        for (Formula1Driver driver: Formula1ChampionshipManager.driversArrayList) { //check every in driverArrayList
            col[0] = driver.getDriver_name();
            col[1] = driver.getDriver_team();
            col[2] = driver.getDriver_location();
            col[3] = driver.getNum_of_races();
            col[4] = driver.getNum_of_points();
            col[5] = driver.getFirst_position();
            col[6] = driver.getSecond_position();
            col[7] = driver.getThird_position();

            model.addRow(col);
        }
       JButton btnAscendingOrder = new JButton("Ascending");//make a ascending button
       btnAscendingOrder.setBounds(10,510,100,35); // Button size and location
       btnAscendingOrder.setBackground(new Color(231, 231, 239));
       frame.getContentPane().add(btnAscendingOrder);
       btnAscendingOrder.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               model.setRowCount(0);
              PointCompare pointCompare=new PointCompare();
               Collections.sort(Formula1ChampionshipManager.driversArrayList,pointCompare);
               for (Formula1Driver driver: Formula1ChampionshipManager.driversArrayList) {//check every in driverArrayList
                   col[0] = driver.getDriver_name();
                   col[1] = driver.getDriver_team();
                   col[2] = driver.getDriver_location();
                   col[3] = driver.getNum_of_races();
                   col[4] = driver.getNum_of_points();
                   col[5] = driver.getFirst_position();
                   col[6] = driver.getSecond_position();
                   col[7] = driver.getThird_position();


                   model.addRow(col);
               }
           }

       });

       JButton btnByFirstPositions = new JButton("By First Places");//make a By first places button
       btnByFirstPositions.setBounds(115,510,120,35); // Button size and location
       btnByFirstPositions.setBackground(new Color(231, 231, 239));
       frame.getContentPane().add(btnByFirstPositions);
       btnByFirstPositions.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               model.setRowCount(0);
               ComparePositionByFirst firstPlaceCompare=new ComparePositionByFirst();
               Collections.sort(Formula1ChampionshipManager.driversArrayList,firstPlaceCompare.reversed());
               for (Formula1Driver d: Formula1ChampionshipManager.driversArrayList) { //check every in driverArrayList
                   col[0] = d.getDriver_name();
                   col[1] = d.getDriver_team();
                   col[2] = d.getDriver_location();
                   col[3] = d.getNum_of_races();
                   col[4] = d.getNum_of_points();
                   col[5] = d.getFirst_position();
                   col[6] = d.getSecond_position();
                   col[7] = d.getThird_position();


                   model.addRow(col);
               }
           }
        });
        frame.setVisible(true);

        JButton btnRaces = new JButton("Races"); //make a Races button
        btnRaces.setBounds(240,510,80,35); // Button size and location
        btnRaces.setBackground(new Color(231, 231, 239));
        frame.getContentPane().add(btnRaces);
        btnRaces.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Races race = new Races();

            }
        });
       frame.setVisible(true);


        JButton searchRace = new JButton("Search"); //make a search button
        searchRace.setBounds(325,510,80,35); // Button size and location
        searchRace.setBackground(new Color(231, 231, 239));
        frame.getContentPane().add(searchRace);
        searchRace.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchDriver search=new SearchDriver();

            }
        });
        frame.setVisible(true);


        JButton btnR1 = new JButton("Random Race_1"); //make a Random Race_1 button
        btnR1.setBounds(410,510,125,35); // Button size and location
        btnR1.setBackground(new Color(231, 231, 239));
        frame.getContentPane().add(btnR1);
        btnR1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RandomRace_1 randomRace_1=new RandomRace_1();//making object with RandomRace_1 class (open RandomRace_1 GUI )
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });
        frame.setVisible(true);


        JButton btnR2 = new JButton("Random Race_2"); //make a Random Race_2 button
        btnR2.setBounds(540,510,125,35); // Button size and location
        btnR2.setBackground(new Color(231, 231, 239));
        frame.getContentPane().add(btnR2);
        btnR2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RandomRace_2 randomRace_2=new RandomRace_2(); //making object with RandomRace_2 class (open RandomRace_2 GUI )
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });
        frame.setVisible(true);
    }
}



