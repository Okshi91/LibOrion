/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orion.string;

import java.util.Arrays;

/**
 *
 * @author Orion
 */
public class String2D {
    /*
    What this is:
    This is a collection of all commands I may need when working with 2D strings, so that I don't need to
    make copies of it whenever I want to use them
    */
    /**
     * A function that returns a 2D array from a string when provided strings to split along
     * @param target A string to split into a 2D array
     * @param split1 The string to break the input string along
     * @param split2 The string to break the subsequent arrays along
     * @return a 2D string array
     */
    public static String[][] Split2D(String target, String split1, String split2) {
        String[] s = target.split(split1);
        String[][] out = new String[s.length][];
        for (int i = 0; i < out.length; i++) {
            out[i] = s[i].split(split2);
            System.out.println(Arrays.toString(out[i]));
        }
        return out;
    }
    /**
     * A function that returns a 2D array from a string array when provided a string to split along
     * @param target A string array
     * @param split What to split each array by to make sub-arrays
     * @return a 2D String array
     */
    public static String[][] Split2D(String[] target, String split) {
        String[][] out = new String[target.length][];
        for (int i = 0; i < out.length; i++) {
            out[i] = target[i].split(split);
        }
        return out;
    }
}
