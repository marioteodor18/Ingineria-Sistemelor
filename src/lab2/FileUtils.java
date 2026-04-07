package lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileUtils {

    public static <T extends Student> void saveToFile(String numeFisier, Collection<T> colectie) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (T item : colectie) {
                writer.write(item.toString());
                writer.newLine();
            }

        } catch (IOException e) {

        }
    }
}