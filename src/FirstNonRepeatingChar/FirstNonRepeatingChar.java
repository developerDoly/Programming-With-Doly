package FirstNonRepeatingChar;

/**
 * The purpose of this program is to find the first non-repeating char in a String.
 */
public class FirstNonRepeatingChar {

    //I looked up "how many chars are there" and I could have used 128 but an extra 128 isn't too bad in this case
    private static int[] tracker = new int[256];

    private static String noRepeats = "subdermatoglyphic";
    private static String longestWord = "pneumonoultramicroscopicsilicovolcanoconiosis";

    public static void main(String[] args){
        //first count letters in the word
        countLetters(noRepeats);

        //second go through word and see if letter is repeated
        int result = findFirstNonRepeat(noRepeats);
        giveResult(result);
    }

    /**
     * This method tells interprets results of the program for the user.
     * @param result
     */
    public static void giveResult(int result){
        if( result > 0 && result < 256) {
            System.out.println("The first non-repeated letter in " + noRepeats + " is: " + (char) (result + '0'));//https://www.javatpoint.com/java-int-to-char
        }
        System.out.println("Every letter in \"" + noRepeats + "\" is repeated.");
    }

    /**
     * This method goes through the word and checks if a letter is unique in that word by going through the array of
     * letter counts.
     * @param content
     * @return
     */
    public static int findFirstNonRepeat(String content){
        for(int i = 0; i < content.length(); i++) {
            if (tracker[content.charAt(i)] == 1) {//this does not store the char, this is more efficient than in countLetters()
                return i;
            }
        }
        return -1;
    }

    /**
     *This method counts the number of each letter in the word and puts that count in the array.
     * @param content
     */
    public static void countLetters(String content){
        char letter;
        for(int i = 0; i < content.length(); i++){
            letter = content.charAt(i);//storing the result of charAt into a char is not necessary, I just wanted to show that it is a char
            tracker[letter]++;//notice how letter is being used as an int to access and modify an element in the array
        }
    }
}
