import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSentences' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY. The function accepts
     * following parameters: 1. STRING_ARRAY wordSet 2. STRING_ARRAY sentences
     */

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        Map<String, Integer> anagramsortedCnt = new HashMap<String, Integer>();
        for (String word : wordSet) {
            char[] sorted = word.toCharArray();
            Arrays.sort(sorted);

            String sortedStr = new String(sorted);
            if (anagramsortedCnt.get(sortedStr) == null)
                anagramsortedCnt.put(sortedStr, 1);
            else
                anagramsortedCnt.replace(sortedStr, anagramsortedCnt.get(sortedStr) + 1);
        }

        List<Long> answers = new ArrayList<Long>();
        for (String sentence : sentences) {
            Long answer = 1l;

            String[] words = sentence.split(" ");
            for (String word : words) {
                char[] sorted = word.toCharArray();
                Arrays.sort(sorted);
                String sortedStr = new String(sorted);

                answer *= anagramsortedCnt.get(sortedStr);
            }
            answers.add(answer);
        }
        return answers;
    }

}

public class prog {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int wordSetCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> wordSet = IntStream.range(0, wordSetCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        int sentencesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> sentences = IntStream.range(0, sentencesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<Long> result = Result.countSentences(wordSet, sentences);

        System.out.println(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
    }
}
