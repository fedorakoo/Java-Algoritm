package substring_search.task_5_3_39;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessing {
    private FileProcessing() {

    }
    public static String getFileText(String path) {
        String text = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            text = sb.toString();
        } catch (IOException e) {
            text = "Error";
        }
        return text;
    }
}
