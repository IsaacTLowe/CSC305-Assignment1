import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Displays a list of Java files from a selected folder.
 * Allows the user to select a file to be analyzed.
 *
 * @author Emily Harris
 * @author Isaac Lowe
 * @version 1.0
 */

public class FileListPanel extends JPanel {
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JList<String> fileList = new JList<>(model);

    public FileListPanel() {
        setLayout(new BorderLayout());
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(fileList), BorderLayout.CENTER);
        setPreferredSize(new Dimension(200, 0));
    }

    public void loadJavaFiles(File folder) {
        model.clear();
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".java"));
        if (files != null) {
            for (File f : files) model.addElement(f.getName());
        }
    }

    public String getSelectedFileName() {
        return fileList.getSelectedValue();
    }
}