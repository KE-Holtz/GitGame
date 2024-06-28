import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println(isBehind());
    }

    public static boolean isBehind() {
        ProcessBuilder fetch = new ProcessBuilder("git", "fetch");
        byte[] bytes;
        try {
            InputStream inputStream = fetch.start().getInputStream();
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String result = new String(bytes);

            return result.contains("");
        } catch (IOException e) {
            return false;
        }
    }
}