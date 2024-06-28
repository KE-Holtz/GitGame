import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println(isBehind());
    }

    public static boolean isBehind() {
        ProcessBuilder fetch = new ProcessBuilder("echo", "behind");
        byte[] bytes;
        try {
            InputStream inputStream = fetch.start().getInputStream();
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String result = new String(bytes);
            System.out.println(result);
            return result.contains("behind");
        } catch (IOException e) {
            return false;
        }
    }
}