package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import persistence.HighScores;

public class HighScoreWindow extends JDialog {
    private final JTable table;

    public HighScoreWindow(List<HighScores> highscores, JFrame parent) {
        super(parent, true);
        table = new JTable(new HighScoreTableModel(highscores));
        table.setFillsViewportHeight(true);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        table.setRowSorter(sorter);

        add(new JScrollPane(table));
        setSize(400,400);
        setTitle("High Score Table");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
