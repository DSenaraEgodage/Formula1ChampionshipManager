import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;

public class GUI2 {
    public  GUI2(){
        Formula1ChampionshipManager d = new Formula1ChampionshipManager();
        PointCompare p = new PointCompare();
        Collections.sort(d.driversArrayList, p);
        JTable table = new JTable();
        Object[] columns = {"Name", "Location", "Team", "No.Of Races", "Points", "1st Positions", "2nd Positions", "3rd Positions"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("STATISTICS");
        frame.getContentPane().setBackground(new Color(134, 236, 78, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when window is closed
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.red); //bg color
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Arial", Font.PLAIN,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0,0,700,500);
        frame.getContentPane().add(pane);

        Object[] col = new Object[8];//making 8 colums

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
        frame.setVisible(true);
    }
}

