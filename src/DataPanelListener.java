import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DataPanelListener implements ActionListener {
    private DataPanel dataPanel;
    private Blackboard blackboard;
    private File file;

    public DataPanelListener(DataPanel panel, Blackboard board, File file) {
        this.dataPanel = panel;
        this.blackboard = board;
        this.file = file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Parse file, compute stats, update UI
    }
}
