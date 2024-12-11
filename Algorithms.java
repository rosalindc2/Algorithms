import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Algorithms {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        s = new Scanner(f);

        int twoLetterCount = 0;
        int maxLength = 0;
        ArrayList<String> longestWords = new ArrayList<>();
        int palindromeCount = 0;

        while (s.hasNextLine()) {
            String word = s.nextLine().trim();

            if (word.length() == 2) {
                twoLetterCount++;
            }

            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }

            if (isPalindrome(word)) {
                palindromeCount++;
            }
        }

        s.close();

        System.out.println("Number of two-letter words: " + twoLetterCount);
        System.out.println("Number of longest words: " + longestWords.size());
        System.out.println("Number of palindromes: " + palindromeCount);
    }

    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
