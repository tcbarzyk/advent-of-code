package day3;
import java.util.*;
import java.io.*;
public class Day3Part1 {
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
            ArrayList<Integer> numberStartIndexes = findNumberStartIndexes(lines.get(i));
            for (int index : numberStartIndexes) {
                //System.out.println(index);
                if (isValid(lines, i, index)) {
                    int num = Integer.parseInt(lines.get(i).substring(index, getEndIndex(lines.get(i), index)));
                    //System.out.println(num);
                    sum += num;
                }
                //System.out.println(isValid(lines, i, index));
            }
        }

        System.out.println(sum);
    }

    public static int getEndIndex (String str, int startIndex) {
        int endIndex = startIndex;
        for (int i = startIndex; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                endIndex++;
            }
            else {
                return endIndex;
            }
        }

        return endIndex;
    }

    public static ArrayList<Integer> findNumberStartIndexes(String line) {
        ArrayList<Integer> numberStartIndexes = new ArrayList<Integer>();
        boolean isNumber = true;

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i)) && !isNumber) {
                numberStartIndexes.add(i);
                isNumber=true;
            }
            else if (!Character.isDigit(line.charAt(i))) {
                isNumber=false;
            }
        }

        return numberStartIndexes;
    }

    public static boolean isSymbol(char c) {
        return Character.toString(c).matches("[^\\w.]");
    }

    public static boolean isValid(ArrayList<String> lines, int x, int y) {
        if (
            (isSymbol(lines.get(x-1).charAt(y))) || //above
            (isSymbol(lines.get(x-1).charAt(y+1))) || //top right
            (isSymbol(lines.get(x).charAt(y+1))) || //right
            (isSymbol(lines.get(x+1).charAt(y+1))) || //bottom right
            (isSymbol(lines.get(x+1).charAt(y))) || //bottom
            (isSymbol(lines.get(x+1).charAt(y-1))) || //bottom left
            (isSymbol(lines.get(x).charAt(y-1))) || //left
            (isSymbol(lines.get(x-1).charAt(y-1))) //top left
        ) {
            return true;
        }

        else if (Character.isDigit(lines.get(x).charAt(y+1))) {
            return isValid(lines, x, y+1);
        }

        else {
            return false;
        }
    }
}
