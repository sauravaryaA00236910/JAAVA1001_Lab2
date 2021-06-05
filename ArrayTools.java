/*
Name: Saurav Arya
Student ID: A00236910
Program Description: ArrayTools is a command line application that consists of several methods in order to provide helpful java tools to java developers. This program aims to reduce efforts while doing some common repetitive functions such as simple Caeser Cipher Encryptions, reveresing an array, etc. The methods below are some of the initial ones and I will try to add more useful methods here throughout the course. As of now, the following methods are listed below to choose from:
1. Caesar Cipher Encryption
2. Array average method
3. Array contains method
4. Array reverse method
*/

import java.util.Scanner;

public class ArrayTools{
    public static void main(String[] args){
 // handling all input from the user and output to the user in the main method of this program in order to test the methods successfully

      // Setting up Scanner for inputs
      Scanner keyb = new Scanner(System.in);

// taking users input as a String to encrypt
      System.out.println("Enter a string to encrypt: ");
      String stringToEncrypt = keyb.nextLine();

      // taking users input as an integer in order to shift the string by that value
      System.out.println("Enter a value to encrypt with: ");
      int valueToEncrypt = keyb.nextInt();

      // calling the encryption method that takes the string value along with the integer value to encrypt with as its parameters
      String encryptedString = caesarCipherEncrypt(stringToEncrypt, valueToEncrypt);
      // showcasing the encrypted string to the user
      System.out.println("The encrypted string is: " + encryptedString);

// taking users input as an integer for the length of the array to get the average of the array
      System.out.println("Enter the length of the array to get average: ");
      int arrayLength = keyb.nextInt();

      // creating an array as per the length of the user's input value
      int[] arrayForAverage = new int[arrayLength];

      // this is a simple array with integer values upto the length of the array in an increasing order
      //  we can also do it with random value function or the hardcoded array values
      System.out.println("Your array is: ");
      for (int i = 0; i<arrayLength; i++){
        arrayForAverage[i] += i+1;
      System.out.print(arrayForAverage[i] + ", ");
    }

      // calling the arrAvg method that takes an array as its parameter and provides the average of all the values in the array
      System.out.println("\nThe average value of your array is: " + arrayAvg(arrayForAverage));

// taking user's input as a string value to search for in the array of hardcoded strings
      System.out.println("Enter a string value to search in the array: ");
      // converting the value entered by the user to upper case
      String searchValue = keyb.next().toUpperCase();
      String[] searchArray = {"Goku", "Kakarot", "Vageta", "Whis", "Berus"};

      // calling the arrayContains method that takes an array along with a search value as parameters in order to get the desired result
      System.out.println("Does the array contain the entered string value: " + arrayContains(searchArray, searchValue));

// taking users input to get the desired length of an random array to reverse
      System.out.println("Enter the length of a random array to get a new reverse array: ");
      int arrayLen = keyb.nextInt();

      // taking users input to get the upperlimit for the random values to include in the array
      System.out.println("Enter the value below which you would like the values of your random array: ");
      int range = keyb.nextInt();

      // generating a random array for the reverse function
      // we can also use an array with hardcoded values for this function
      int[] arrayToReverse = new int[arrayLen];
      System.out.println("Your array is: ");
      for (int i = 0; i<arrayLen; i++){
        arrayToReverse[i] += (int)(Math.random()*range);
        // showcasing the generated array in the console
      System.out.print(arrayToReverse[i]+", ");
    }
    // calling the reverse method that takes an array as a parameter in order to reverse it and print the result in the console
      reverse(arrayToReverse);

  }

/*
below is a simple caesar cipher method that takes a string and a integer value to encrypt with as parameters.
*/
    public static String caesarCipherEncrypt(String s, int t){
      // initializing a string, an integer and a character
      String duringEncryption = "";
      int a;
      char c;
      // iterating over the user's entered string
      for(int i = 0; i < s.length(); i++){
        // assigning characters to the char c value from the user's string one by one
        c = s.charAt(i);
        // checking if the character is a letter or a blank space from the character class's function as blank space will not be encrypted
          if(Character.isLetter(c)){
            // assigning the encrypted ASCII value to the integer a
            a = (int)c + t;
            // checking if the ASCII value of the encrypeted characted is greated than "Z" and "z" or less than "A" and "a" in both uppercase and lowercase. As for capital Z = 90, for capital A = 65, for small z = 122 and for small a = 97
            // Reference: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
            if((Character.isUpperCase(c)&& a>90)||(Character.isLowerCase(c)&& a >122)){
            // if true, then the 'a' will subtract 26 from its ASCII value to get the shifted encryption
              a = a - 26;
            }else if ((Character.isUpperCase(c)&&a<65)||(Character.isLowerCase(c)&& a <97)){
            // if true, then the 'a' will add 26 to its ASCII value to get the shifted encryption
              a = a + 26;
            }
            // assigning the ASCII value's characted to char c
            c = (char)a;
          }
          // adding the encrypted characters to the duringEncryption string
          duringEncryption += c;
      }
      // returning the resultant encrypted string through the method
      return duringEncryption;
    }


/*
the below method takes an array as its parameter and returns an average by adding the values from the array and dividing them by the no. of values in the array
*/
    public static double arrayAvg(int[] arr){
      // initialinzing variables
      int sum = 0;
      double avg;
      // iterating over the array
      for(int i=0; i < arr.length; i++){
      // adding the value to the sum variable one by one
        sum += arr[i];
      }
      // calculating the average by adding the values from the array and dividing them by the no. of values in the array
      avg = (double)sum/arr.length;

      // returning the result through the method
      return avg;
    }

/*
the method below is to check if the given array of string contains a particular string value entered by the user. This method can also be modified to exactly equate a string from the array with the entered string by the user.
*/
    public static boolean arrayContains(String[] arr, String value){
      boolean ifContains = false;
      // iterating over the array of strings
      for(int i = 0; i < arr.length; i++){
        // codition to check of the array contains the string or not
        // can also add equals in the below condition to get the exact value match
        if(arr[i].toUpperCase().contains(value)){
          ifContains = true;
        }
      }
      // returning the boolean expression through the method
      return ifContains;
    }

/*
the below method takes an array as its parameter in order to reverse it along with making a new array of reverse values for the user
*/
    public static void reverse(int[] arr){
      // creating a new array of same length as the input array
      int[] newReverseArray = new int[arr.length];
      System.out.println("\nYour reverse array is: ");
      // iterating over the given array and reversing the values
      for(int i = 0; i < arr.length; i++){
        newReverseArray[i] = arr[(arr.length-1) - i];
        // printing the new resultant array with reversed values
        System.out.print(newReverseArray[i]+", ");
      }
    }
}
