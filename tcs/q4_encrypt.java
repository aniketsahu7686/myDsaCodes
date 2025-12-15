import java.util.HashMap;
import java.util.Scanner;

public class q4_encrypt{
    public static void encryptHP(String str){
         // Define the actual to cipher mapping
         HashMap<Character, Character> cipherMap = new HashMap<>();
         String actual = "abcdefghijklmnopqrstuvwxyz";
         String cipher = "fghijklmnopqrstuvwxyzabcde";
 
         // Fill the map with the cipher key
         for (int i = 0; i < actual.length(); i++) {
             cipherMap.put(actual.charAt(i), cipher.charAt(i));
         }
 
         // Input the string from the user
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the string to be encrypted: ");
         String input = sc.nextLine();
         
         // Initialize the encrypted string
         StringBuilder encryptedString = new StringBuilder();
 
         // Encrypt the input string
         for (char ch : input.toCharArray()) {
             if (Character.isLowerCase(ch)) {
                 encryptedString.append(cipherMap.get(ch));
             }
         }
 
         // Output the encrypted string
         System.out.println("Encrypted String: " + encryptedString.toString());
         sc.close();
    }
    public static String Opt(String str){
        String res = "";
        int n = str.length();

        for(int i=0;i<n;i++){
            if(str.charAt(i)<='u'){
                res +=  (char) (str.charAt(i) + 5);
            }else{
                res += (char) (str.charAt(i) - 'v' + 'a');
            }
        }
        return res;
    }

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
       System.out.println(Opt(str));
    }

}






// This question asks you to encrypt a given string using a substitution cipher. A substitution cipher is a method of encryption where 
// each letter in the original text (called plaintext) is replaced with a corresponding letter from a predefined set (cipher alphabet).

// actual = "abcdefghijklmnopqrstuvwxyz";
// cipher = "fghijklmnopqrstuvwxyzabcde";

// Key Points of the Program:
// The cipher mapping is predefined. For example:
// 'a' is replaced by 'f',
// 'b' by 'g', and so on until 'z', which is replaced by 'e'.
// The user inputs a string they want to encrypt, and the program then replaces each lowercase letter from the input string with its corresponding letter from the cipher map.

// What You Need to Do:
// The input is the string from the user.
// The output will be the encrypted version of that string based on the substitution cipher provided.

// Example:
// If the input string is:
// hello

// The output will be the encrypted version, for example:
// mjqqt







// **********why we use this  res += (char) str.charAt(i) - 'v' + 'a' rather than this res += (char) str.charAt(i) - 'u';**************




// Example Input
// Let’s use an example string: "xyz"

// Execution Breakdown
// Step 1: Iterate Over Each Character
// Character 'x':

// ASCII value of 'x' = 120
// Check: x <= u (120 <= 117) → False
// Line B executes:
// java
// Copy code
// res += (char) (str.charAt(i) - 'v' + 'a')
// Calculation:
// ASCII of 'v' = 118
// Result:
// java
// Copy code
// (char) (120 - 118 + 97) = (char) (2 + 97) = (char) 99 = 'c'
// res now is "c".
// Character 'y':

// ASCII value of 'y' = 121
// Check: y <= u (121 <= 117) → False
// Line B executes:
// java
// Copy code
// res += (char) (str.charAt(i) - 'v' + 'a')
// Calculation:
// Result:
// java
// Copy code
// (char) (121 - 118 + 97) = (char) (3 + 97) = (char) 100 = 'd'
// res now is "cd".
// Character 'z':

// ASCII value of 'z' = 122
// Check: z <= u (122 <= 117) → False
// Line B executes:
// java
// Copy code
// res += (char) (str.charAt(i) - 'v' + 'a')
// Calculation:
// Result:
// java
// Copy code
// (char) (122 - 118 + 97) = (char) (4 + 97) = (char) 101 = 'e'
// res now is "cde".
// Final Result
// The final result of the encryption for the input "xyz" would be "cde".

// Direct Usage of Character Arithmetic
// You asked whether you could directly write str.charAt(i) - 'u'. Here's how it would work:

// For 'x':
// You could write:
// java
// Copy code
// int diff = str.charAt(i) - 'u'; // ASCII of 'x' (120) - ASCII of 'u' (117) = 3
// This would give you the numeric difference (3), which you could use in further calculations if needed.