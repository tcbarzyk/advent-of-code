package day2;
import java.util.*;
import java.io.*;
public class Day2Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day2/day2-input2.txt"));

        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        int sum = 0;
        int id = 0;
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            id++;

            System.out.println("ID:" + id);

            String str = line.substring(line.indexOf(":")+1);
            String[] sets = str.split(";");

            boolean possible = true;

            for (String set : sets) {
                String[] subsets = set.split(",");

                for (String subset : subsets) {
                    if (subset.contains("red")) {
                        if (Integer.parseInt(subset.replaceAll("[\\D]", "")) > maxRed) {
                            possible = false;
                        }
                    }
                    else if (subset.contains("green")) {
                        if (Integer.parseInt(subset.replaceAll("[\\D]", "")) > maxGreen) {
                            possible = false;
                        }
                    }
                    else if (subset.contains("blue")) {
                        if (Integer.parseInt(subset.replaceAll("[\\D]", "")) > maxBlue) {
                            possible = false;
                        }
                    }
                }
            }

            if (possible) sum += id;
            else System.out.println("Game " + id + " is possible");
        }

        input.close();

        System.out.println(sum);
    }
}
