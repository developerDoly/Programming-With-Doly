package FirstNonRepeatingChar;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The purpose of this program is to find the first non-repeating char in a String.
 * @author developerDoly
 *
 * Info on input file:
 * Strings will be separated by new-line, don't process blank lines.
 */
public class FirstNonRepeatingChar {

    public static final String FILE_NAME = "input.txt"; //this is a class constant, notice the convention of all-caps and underscores rather than camelcase

    //I looked up "how many chars are there" and I could have used 128 but an extra 128 isn't too bad in this case
    private static int[] tracker = new int[256];

    private static String currentString;

    public static void main(String[] args) throws IOException {//I will show you guys try/catch blocks later

        Scanner fileScanner = new Scanner(new File(FILE_NAME));

        while (fileScanner.hasNextLine()) {

            currentString = fileScanner.nextLine();
            if(!currentString.equals("")) { //allows us to throw away blank lines
                //first count letters in the word
                countLetters(currentString);

                //second go through word and see if letter is repeated
                int result = findFirstNonRepeat(currentString);
                giveResult(result);

                resetTracker();
            }
        }

        fileScanner.close();//this closes the file so that other programs can read/write it
    }

    /**
     * This method resets the array so that other strings in the file are not biased by previous strings.
     */
    public static void resetTracker(){
        Arrays.fill(tracker, 0);

        // could also be done using:
        /*
        for(int i = 0; i < tracker.length; i ++){
            tracker[i] = 0;
        }
         */
    }

    /**
     * This method tells interprets results of the program for the user.
     * @param result int the integer representation of the first non-repeated char
     */
    public static void giveResult(int result){
        if( result > 0 && result < 256) {
            System.out.println("The first non-repeated letter in " + currentString + " is: " + (char) (result));//https://www.javatpoint.com/java-int-to-char
        }
        else {
            System.out.println("Every letter in \"" + currentString + "\" is repeated.");
        }
    }

    /**
     * This method goes through the word and checks if a letter is unique in that word by going through the array of
     * letter counts.
     * @param content String the inputed string
     * @return int representation of the first non-repeated char
     */
    public static int findFirstNonRepeat(String content){
        for(int i = 0; i < content.length(); i++) {
            if (tracker[content.charAt(i)] == 1) {//this does not store the char, this is more efficient than in countLetters()
                return content.charAt(i);
            }
        }
        return -1;
    }

    /**
     *This method counts the number of each letter in the word and puts that count in the array.
     * @param content String the inputed string
     */
    public static void countLetters(String content){
        char letter;
        for(int i = 0; i < content.length(); i++){
            letter = content.charAt(i);//storing the result of charAt into a char is not necessary, I just wanted to show that it is a char
            tracker[letter]++;//notice how letter is being used as an int to access and modify an element in the array
        }
    }
}
