import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        while (isUpToDate()) {
            System.out.println("Still up to date");
        }
        System.out.println("new changes");
    }

    public static boolean isUpToDate() {
        ProcessBuilder fetch = new ProcessBuilder("git", "fetch");
        byte[] bytes;
        try {
            InputStream inputStream = fetch.start().getInputStream();
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String result = new String(bytes);
            Logger.log(result);
            return result.isBlank();
        } catch (IOException e) {
            return false;
        }
    }
}