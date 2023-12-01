import java.util.*;
import java.io.*;
public class Day1Part2 {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("day1/day1-input4.txt");
        Scanner input = new Scanner(file);

        int sum = 0;

        while (input.hasNextLine()) {
            String str = input.nextLine();

            String str2 = str
                            .replaceAll("one", "o1e")
                            .replaceAll("two", "t2o")
                            .replaceAll("three", "t3e")
                            .replaceAll("four", "f4r")
                            .replaceAll("five", "f5e")
                            .replaceAll("six", "s6x")
                            .replaceAll("seven", "s7n")
                            .replaceAll("eight", "e8t")
                            .replaceAll("nine", "n9e");

            String str3 = str2.replaceAll("[a-zA-Z]", "");
            System.out.println("string: " + str3);

            int num = Character.getNumericValue(str3.charAt(0))*10 + Character.getNumericValue(str3.charAt(str3.length()-1));
            System.out.println("num: " + num);
            sum += num;
            System.out.println(sum);
        }

        input.close();

        System.out.println(sum);
    }
 }
