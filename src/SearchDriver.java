import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SearchDriver {
    public SearchDriver() {
        JTable table = new JTable();
        Object[] columns = {"Race", "Position"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("Search Driver"); //edits the frame
        frame.getContentPane().setBackground(new Color(78, 218, 236, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 700, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when window is closed
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

        Object[] col = new Object[2]; //making 2 colums


        JTextField textField = new JTextField();
        textField.setBounds(150,510,120,35);
        frame.getContentPane().add(textField);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(15,510,120,35);
        btnSearch.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText(); //getting input

                model.setRowCount(0); //setting privous recorded deleted

                for (Race driver: Formula1ChampionshipManager.races) { //looping all races
                    for (int i = 0; i < driver.getPositions().length; i++) { //looping all position in a race
                        if(driver.getPositions()[i].getDriver_name().equals(text)){  //check driver's name equal to input
                            col[0] = driver.getDate();//name
                            col[1] = i+1; //position
                            model.addRow(col);//add a row to model
                        }
                    }
                }
            }
        });
        frame.setVisible(true);
    }
}