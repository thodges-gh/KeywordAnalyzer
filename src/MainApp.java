import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Thomas Hodges on 7/24/15.
 * This program accepts a text document, sorts each word by its
 * frequency, and displays the number of occurrences of each word.
 */

public class MainApp {


    public void filler(String[] args) {

        try {
            String content = new Scanner(new File(args[0]))
                    .useDelimiter("\\Z") // To the end of the file
                    .next();
            content = content.toLowerCase()
                             .replaceAll("[(!-+•&.^:,)]", "");
            String[] line = content.split("\\s+");

            Analyzer keywords = new Analyzer(line);

            keywords.wordCount();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    public static void main(String[] args) {

        MainApp runner = new MainApp();
        runner.filler(args);

    }
}
