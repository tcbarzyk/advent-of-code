package day4;
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Day4Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day4/day4-input2.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        while (input.hasNextLine()) {
            lines.add(input.nextLine());
        }
        input.close();

        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            String sections[] = splitIntoSections(lines.get(i));

            int[] winningNumbers = getNumbers(sections[0]);
            int[] haveNumbers = getNumbers(sections[1]);

            int matches = getMatches(winningNumbers, haveNumbers);

            sum++;
            sum += getCopies(lines, matches, i);
        }

        System.out.println("Total: " + sum);
    }

    public static int getCopies(ArrayList<String> lines, int matches, int index) {
        int copies = 0;

        for (int i = 1; i <= matches; i++) {
            int copyIndex = index+i;
            String sections[] = splitIntoSections(lines.get(copyIndex));

            int[] winningNumbers = getNumbers(sections[0]);
            int[] haveNumbers = getNumbers(sections[1]);

            int copyMatches = getMatches(winningNumbers, haveNumbers);

            //System.out.println("Card: " + (copyIndex+1));
            //System.out.println("Matches: " + copyMatches);
            
            copies++;
            copies += getCopies(lines, copyMatches, copyIndex);
        }

        return copies;
    }

    public static String[] splitIntoSections(String str) {
        return str.substring(str.indexOf(":")+1).trim().split("\\|");
    }

    public static int[] getNumbers(String str) {
        return Stream.of(str.trim().split("\\s+")).mapToInt(s -> Integer.parseInt(s)).toArray();
    }

    public static int getMatches(int[] winningNumbers, int[] haveNumbers) {
        int matches = 0;
        for (int winningNum : winningNumbers) {
            for (int num : haveNumbers) {
                if (winningNum == num) {
                    matches++;
                }
            }
        }
        return matches;
    }
}
