import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileAnalyzer {

    public static void analyze(File file, Blackboard board) {
        int complexity = 0;
        int size = 0;
        boolean hasAuthor = false, hasVersion = false;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            size = lines.size();

            for (String line : lines) {
                String trimmed = line.trim();
                if (trimmed.contains("if") || trimmed.contains("for") ||
                        trimmed.contains("while") || trimmed.contains("switch")) {
                    complexity++;
                }
                if (trimmed.contains("@Author")) hasAuthor = true;
                if (trimmed.contains("@Version")) hasVersion = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        board.setSize(size);
        board.setComplexity(complexity);
        board.setHappy(hasAuthor && hasVersion);
    }
}
