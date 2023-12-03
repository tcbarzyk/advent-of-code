package day3;
import java.util.*;
import java.io.*;
public class Day3Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day3/day3-input2.txt"));
        /*
        ..........
        467..114.. true, false
        ...*...... 
        ..35..633. true, true
        ......#...
        617*...... true
        .....+.58. false
        ..592..... true
        ......755. true
        ...$.*....
        .664.598.. true true
        ..........
         */
        ArrayList<String> lines = new ArrayList<String>();
        int sum = 0;

        while (input.hasNextLine()) {
            lines.add("." + input.nextLine() + ".");
        }

        input.close();
        
        for (int i = 1; i < lines.size()-1; i++) {
            for (int j = 1; j < lines.get(i).length()-1; j++) {
                char c = lines.get(i).charAt(j);
                if (c == '*') {
                    ArrayList<Integer> parts = findParts(lines, i, j);
                    sum += findRatios(parts);
                }
            }
        }

        System.out.println(sum);
    }

    public static int findRatios (ArrayList<Integer> parts) {
        if (parts.size() == 2) {
            return parts.get(0) * parts.get(1);
        }
        else {
            return 0;
        }
    }

    public static int findWholeNumber(String str, int someIndex) {
        int startIndex = 0, endIndex = 0;
        for (int i = someIndex; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                startIndex = i+1;
                break;
            }
        }
        for (int i = someIndex; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                endIndex = i;
                break;
            }
        }

        return Integer.parseInt(str.substring(startIndex, endIndex));
    }
    
    public static ArrayList<Integer> findParts(ArrayList<String> lines, int x, int y) {
        ArrayList<Integer> parts = new ArrayList<Integer>();

        if ((Character.isDigit(lines.get(x-1).charAt(y)))) {  //above
            parts.add(findWholeNumber(lines.get(x-1), y));
        }
        else {
            if ((Character.isDigit(lines.get(x-1).charAt(y-1))) ) { //top left
                parts.add(findWholeNumber(lines.get(x-1), y-1)); 
            }
            if ((Character.isDigit(lines.get(x-1).charAt(y+1))) ) { //top right
                parts.add(findWholeNumber(lines.get(x-1), y+1)); 
            }
        }

        if (Character.isDigit(lines.get(x).charAt(y+1))) { //right
            parts.add(findWholeNumber(lines.get(x), y+1));
        }

        if (Character.isDigit(lines.get(x).charAt(y-1))) { //left
            parts.add(findWholeNumber(lines.get(x), y-1));
        }

        if ((Character.isDigit(lines.get(x+1).charAt(y)))) {  //below
            parts.add(findWholeNumber(lines.get(x+1), y));
        }
        else {
            if ((Character.isDigit(lines.get(x+1).charAt(y-1))) ) { //bottom left
                parts.add(findWholeNumber(lines.get(x+1), y-1)); 
            }
            if ((Character.isDigit(lines.get(x+1).charAt(y+1))) ) { //bottom right
                parts.add(findWholeNumber(lines.get(x+1), y+1)); 
            }
        }

        return parts;
    }
}
