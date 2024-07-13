package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length -1] ;
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return  array[array.length -2] ;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
    int length = array.length;

    for(int i = 0; i < length / 2; i++){
        String temp = array[i];
        array[i] = array[length -1 - i];
        array[length - 1 - i] = temp;
    }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        for( int  i = 0 ; i < array.length; i++){
            if(!array[i].equals(array[array.length -1 -i])) {
             return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] alphalist = new boolean[26];

        for (String str : array){
            for (int i = 0; i < str.length(); i++){
                char ch = Character.toLowerCase((str.charAt(i)));
                if('a' <= ch && ch <= 'z'){
                    alphalist[ch - 'a'] = true;
                }
            }
        }
        for (boolean value : alphalist){
            if (!value){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurence =  0;

        for(int i = 0; i < array.length; i++){
            if (array[i].contains(value)){
                occurence++;
            }
        }
        return occurence;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArray = new ArrayList<>();
        for (String str : array){
            if (!str.equals(valueToRemove)){
                newArray.add(str);
            }
        }
            String[] reformed = new String[newArray.size()];

        return newArray.toArray(reformed);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>();

        newArray.add(array[0]);//taking first element of the string array

        for(int i = 1; i < array.length; i++){
            if(!array[i-1].equals(array[i])){//if previous index and current index are the same
                newArray.add(array[i]);//adding indexes that arent the same
            }
        }
        return newArray.toArray(new String[0]);

    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> test = new ArrayList<>();
        StringBuilder chars = new StringBuilder(array[0]);//Initiates a StringBuilder that holds the first element in the array.

        for(int i =1; i < array.length; i++){
            if (array[i].equals(array[i-1])){//check if previous index equals current index
                chars.append(array[i]);//adds duplicate element to string builder
            }
            else {
                test.add(chars.toString());//add the string we made to the ArrayList
                chars = new StringBuilder(array[i]);//resets the stringBuilder for next sequence
            }
        }
        test.add(chars.toString());//Add the last sequence after loop ends

        return test.toArray(test.toArray(new String[0]));//Convert ArrayList to String array
    }


}
