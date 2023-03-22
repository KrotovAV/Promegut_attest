package Lottory_toys;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Write {

    public static void writeFile(String text) {
        Path path = Paths.get("D:/GeekBrains/My Git/Promegut_attest/Lottory_toys/Toys.txt");
        String dT = DateTime.getDateTime();
        String foolText = dT + ": " + text + ";\n";

        try {
            Files.write(path, foolText.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

