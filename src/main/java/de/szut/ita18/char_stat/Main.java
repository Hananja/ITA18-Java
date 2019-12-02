package de.szut.ita18.char_stat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        CharStat charStat;
        try (InputStream inputStream = new FileInputStream("input.txt")) {
                charStat = new CharStat();
                charStat.add(inputStream);
            for (Map.Entry<Character,Integer> item: charStat.entrySet()) {
                System.out.printf("%c: %d%n", item.getKey(), item.getValue());
            }
        } catch (IOException e) {
            System.err.println("Fehler: " + e.getLocalizedMessage());
        }
    }
}
