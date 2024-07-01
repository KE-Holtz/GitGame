import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    static BufferedWriter writer;

    public static void log(String data) {
        if (writer == null) {
            try {
                writer = new BufferedWriter(new FileWriter("log.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
