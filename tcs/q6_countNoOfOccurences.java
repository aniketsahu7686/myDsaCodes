import java.util.*;
public class q6_countNoOfOccurences {
    public static void noOfOccurences(String input){
        String[] strArr = input.split(" ");

        Map<String,Integer> mp = new HashMap<>();

        for(String word:strArr){
            // allMatch(Character::isLetter): This is a terminal operation on the stream that checks if every element (character) in the stream satisfies a given condition.
            //  In this case, the condition is Character::isLetter, which is a method reference that checks whether a character is a letter (i.e., A-Z, a-z, or any other
            //   letter in Unicode).
            if(word.chars().allMatch(Character::isLetter)){
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                mp.put(word, mp.getOrDefault(word ,0) + 1);
            }
        }

        for(Map.Entry<String,Integer> count : mp.entrySet()){
            System.out.println(count.getKey() + " " +  count.getValue());
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        noOfOccurences(input);
    }
}

// Given a space-separated string of words, write a function to count the frequency of each word in the string. The output should display each unique word followed by its 
// frequency, with the words in the order of their first appearance. The output should capitalize the first letter of each word.

// Example:
// Input: apple banana apple banana apple orange banana
// Output: Apple 3 Banana 2 Orange 1
