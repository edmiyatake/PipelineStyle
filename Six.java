import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Six {
    public static void main (String[] args) {
        String path_to_file = args[1];
        List<Map.Entry<String, Integer>> sorted = sort(frequencies(remove_stop_words(scan(filter_chars_and_normalize(read_file(path_to_file))))));
        print_all(sorted.subList(0, Math.min(25, sorted.size())));
    }

    private static String read_file(String path_to_file) {
        try {
            return new String(Files.readAllBytes(Paths.get(path_to_file)));
        }
        catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String filter_chars_and_normalize(String data){
        StringBuilder result = new StringBuilder();

        for (char c : data.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(' ');
            }
        }

        return result.toString();
    }

    private static List<String> scan(String data){
        String[] wordsArray = data.split("\\s+");  // split on one or more whitespace characters
        return new ArrayList<>(Arrays.asList(wordsArray));
    }

    private static List<String> remove_stop_words(List<String> wordList) {
        Set<String> stopWords = new HashSet<>();

        // Read stop words from file
        try (BufferedReader reader = new BufferedReader(new FileReader("stopwords.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                stopWords.addAll(Arrays.asList(parts));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add single-letter words a–z
        for (char c = 'a'; c <= 'z'; c++) {
            stopWords.add(String.valueOf(c));
        }

        // Filter out stop words
        List<String> filtered = new ArrayList<>();
        for (String word : wordList) {
            if (!stopWords.contains(word)) {
                filtered.add(word);
            }
        }

        return filtered;
    }

    private static Map<String, Integer> frequencies (List<String> wordList){
        Map<String, Integer> wordFreqs = new HashMap<>();

        for (String w : wordList) {
            if (wordFreqs.containsKey(w)) {
                wordFreqs.put(w, wordFreqs.get(w) + 1);
            } else {
                wordFreqs.put(w, 1);
            }
        }

        return wordFreqs;
    }

    private static List<Map.Entry<String,Integer>> sort (Map<String, Integer> wordFreq) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFreq.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));  // sort by frequency, descending

        return sortedList;
    }

    private static void print_all(List<Map.Entry<String, Integer>> wordFreqs) {
        printAllRecursive(wordFreqs, 0);
    }

    private static void printAllRecursive(List<Map.Entry<String, Integer>> wordFreqs, int index) {
        if (index < wordFreqs.size()) {
            Map.Entry<String, Integer> entry = wordFreqs.get(index);
            System.out.println(entry.getKey() + " - " + entry.getValue());
            printAllRecursive(wordFreqs, index + 1);
        }
    }
}
