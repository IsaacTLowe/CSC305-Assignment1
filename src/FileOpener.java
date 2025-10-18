import javax.swing.*;
import java.io.File;

public class FileOpener extends JFileChooser {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    } else {
        System.out.println("No file selected.");
    }

}
