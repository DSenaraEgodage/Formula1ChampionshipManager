import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Races {
    public Races() {
        JTable table = new JTable();
        Object[] columns = {"Race Number", "Race Date"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("Races"); //edits the frame
        frame.getContentPane().setBackground(new Color(40, 87, 224, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 700, 600);

        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);  //edits everything on the table
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.black); //bg color
        table.setGridColor(Color.black);
        table.setSelectionForeground(Color.red);
        table.setFont(new Font("Arial", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0, 0, 700, 500);
        frame.getContentPane().add(pane);

        Object[] col = new Object[2];

        int x = 1;
        Formula1ChampionshipManager f1_Manager = new Formula1ChampionshipManager();
        for (Race d: f1_Manager.races) {
            col[0] = x;
            col[1] = d.getDate();
            x++;
            model.addRow(col);
        }

        frame.setVisible(true);
    }
}