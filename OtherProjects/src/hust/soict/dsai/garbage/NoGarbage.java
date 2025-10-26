package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
    String filename = "rand.txt";
    byte[] inputBytes = {0};
    long startTime, endTime;

    inputBytes = Files.readAllBytes(Paths.get(filename));
    startTime = System.currentTimeMillis();
    StringBuilder outputString = new StringBuilder();
    for (byte b : inputBytes) {
        outputString.append((char)b);
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    }
}
