import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(canPull());
    }

    public static boolean canPull() {
        ProcessBuilder fetch = new ProcessBuilder("git", "fetch");
        byte[] bytes;
        try {
            InputStream inputStream = fetch.start().getInputStream();
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String result = new String(bytes);
            result += 'c';
            Logger.log(result);
            return result.isBlank();
        } catch (IOException e) {
            return false;
        }
    }
}