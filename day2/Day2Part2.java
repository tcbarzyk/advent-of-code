package day2;
import java.util.*;
import java.io.*;
public class Day2Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day2/day2-input2.txt"));
        
        int sum = 0;
        
        while (input.hasNextLine()) {
            String line = input.nextLine();

            String str = line.substring(line.indexOf(":")+1);
            String[] sets = str.split(";");

            int minRed = 0;
            int minGreen = 0;
            int minBlue = 0;

            for (String set : sets) {
                String[] subsets = set.split(",");

                for (String subset : subsets) {
                    if (subset.contains("red")) {
                        int num = Integer.parseInt(subset.replaceAll("[\\D]", ""));
                        if (num > minRed) {
                            minRed = num;
                        }
                    }
                    else if (subset.contains("green")) {
                        int num = Integer.parseInt(subset.replaceAll("[\\D]", ""));
                        if (num > minGreen) {
                            minGreen = num;
                        }
                    }
                    else if (subset.contains("blue")) {
                        int num = Integer.parseInt(subset.replaceAll("[\\D]", ""));
                        if (num > minBlue) {
                            minBlue = num;
                        }
                    }
                }
            }

            sum += (minRed * minGreen * minBlue);
        }

        input.close();

        System.out.println(sum);
    }
}
