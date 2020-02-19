package com.xyz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    static String line;
    public static void getCountOfSymbols(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int count = 0;
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            count+=line.length();
        }
        System.out.println("Number of characters in a sentence "+count);
    }
    public static void getCountOfWords(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int count = 0;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            count += new StringTokenizer(line," ").countTokens();
        }
        System.out.println("Number of words in a sentence "+count);
    }
    public static void getListOfTopOccurrences(File file) throws IOException {
        System.out.println("Number of entries \n");
                Files.lines(file.toPath(), StandardCharsets.UTF_8)
                .flatMap(s -> Arrays.stream(s.split("\\PL+")))
                .filter(w -> w.length() > 0)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

    }
}
