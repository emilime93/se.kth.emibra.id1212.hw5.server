package se.kth.emibra.id1212.hw1.server.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * A class that is used to read words from a text file.
 */
public class LineReader {

    /**
     * Reads a random word (one word per line) from a text file placed
     * in the res/word.txt
     * @return A random word in the form of a String.
     */
    public static String getRandomLineFromFile() {
        int length = 0;
        List<String> words = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("words.txt")));
            words = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null ) {
                words.add(line);
            }
            length = words.size();
        } catch (IOException e) {
            System.out.println("Could not read read word from file.");
            e.printStackTrace();
        }
        return words.get(new Random().nextInt(length));
    }
}
