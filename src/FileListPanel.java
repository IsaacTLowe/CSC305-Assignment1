import javax.swing.*;
import java.awt.*;
import java.io.File;

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
