package jarednametocolor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  This is a very simple project based off of jared cross' video
//  Detials: This formula takes in your first name, middle name and last name
//  using the alphabetic numeral system (a = 1, z = 26) we sum up all the characters
//  on each name, and then multiply the sums by 4. If the sum is greater than 255
//  we subtract by 256 until it eventually reaches below 255
//  and now you have a color based on your name

public class Main {
    public static void main(String[] args){

        Map<Character, Integer> characterValueMap = new HashMap<>();

        // Create the mapping for all lowercase letters from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            characterValueMap.put(c, c - 'a' + 1);
        }

        // Create the mapping for all lowercase letters from 'a' to 'z'
        for (char c = 'A'; c <= 'Z'; c++) {
            characterValueMap.put(c, c - 'A' + 1);
        }
        
        int firstnameNum = 0;
        int middlenameNum = 0;
        int lastnameNum = 0;

        Scanner scannerObj = new Scanner(System.in);
        System.out.print("First Name: ");
        String firstnameString = scannerObj.nextLine();
        System.out.print("Middle Name: ");
        String middlenameString = scannerObj.nextLine();
        System.out.print("Last Name: ");
        String lastnameString = scannerObj.nextLine();


        for (int i = 0; i < firstnameString.length(); i++) {
            char currentChar = firstnameString.charAt(i);
            if (characterValueMap.containsKey(currentChar)) {
                firstnameNum += characterValueMap.get(currentChar) * 4;
                while (firstnameNum > 255) {
                    firstnameNum -= 256;
                }
            } else {
                System.out.println("Invalid Character!");
                scannerObj.close();
                return;
            }
        }

        for (int i = 0; i < middlenameString.length(); i++) {
            char currentChar = middlenameString.charAt(i);
            if(characterValueMap.containsKey(currentChar)){
                middlenameNum += characterValueMap.get(currentChar) * 4;
                while (middlenameNum > 255) {
                    middlenameNum -= 256;
                }
            } else {
                System.out.println("Invalid Character!");
                scannerObj.close();
                return;
            }
        }

        for (int i = 0; i < lastnameString.length(); i++) {
            char currentChar = lastnameString.charAt(i);
            if(characterValueMap.containsKey(currentChar)){
                lastnameNum += characterValueMap.get(currentChar) * 4;
                while (lastnameNum > 255) {
                    lastnameNum -= 256;
                }        
            } else {
                System.out.println("Invalid Character!");
                scannerObj.close();
                return;
            }
        }

        String hex = String.format("#%02x%02x%02x", firstnameNum, middlenameNum, lastnameNum);
        System.out.println("---------------------------------");
        System.out.println("RGB: " + firstnameNum + ", " + middlenameNum + ", " + lastnameNum); 
        System.out.println("HEX: " + hex); 
        System.out.println("---------------------------------");
        scannerObj.close();

    }
}
