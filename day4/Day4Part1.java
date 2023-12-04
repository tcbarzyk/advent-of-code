package day4;
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day4/day4-input2.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        while (input.hasNextLine()) {
            lines.add(input.nextLine());
        }
        input.close();

        int sum = 0;

        for (String line : lines) {
            String str = line.substring(line.indexOf(":")+1);
            String sections[] = str.trim().split("\\|");

            int matches = 0;

            int[] winningNumbers = Stream.of(sections[0].trim().split("\\s+")).mapToInt(s -> Integer.parseInt(s)).toArray();
            int[] haveNumbers = Stream.of(sections[1].trim().split("\\s+")).mapToInt(s  -> Integer.parseInt(s)).toArray();

            for (int winningNum : winningNumbers) {
                for (int num : haveNumbers) {
                    if (winningNum == num) {
                        matches++;
                    }
                }
            }

            int points = 0;

            for (int i = 1; i <= matches; i++) {
                if (i == 1) {
                    points++;
                }
                else {
                    points *= 2;
                }
            }

            sum += points;
        }

        System.out.println(sum);
    }
}
