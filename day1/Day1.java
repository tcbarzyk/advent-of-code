import java.util.*;
import java.io.*;
public class Day1 {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("day1/day1-input.txt");
        Scanner input = new Scanner(file);

        int sum = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String numbers = line.replaceAll("[a-zA-Z]", "");

            int num = Character.getNumericValue(numbers.charAt(0))*10 + Character.getNumericValue(numbers.charAt(numbers.length()-1));
            
            System.out.println("num: " + num);
            sum += num;
            System.out.println(sum);
        }

        input.close();

        System.out.println(sum);
    }
}