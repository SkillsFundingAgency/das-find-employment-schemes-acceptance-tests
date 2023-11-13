package sfa.das;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateAllCombinations {

    public static void main(String[] args) {

        // Create an array to store all the possible combinations
        Boolean[] combinations = new Boolean[8];

        // Generate all the possible combinations
        generateAllCombinations(combinations, 0);
    }

    public static void generateAllCombinations(Boolean[] combinations, int index) {
        if (index == combinations.length) {
            // Convert the array of Boolean values to a string
            String combinationString = Arrays.toString(combinations);

            // Print the combination string
            System.out.println(combinationString);
            return;
        }

        combinations[index] = true;
        generateAllCombinations(combinations, index + 1);
        combinations[index] = false;
        generateAllCombinations(combinations, index + 1);
    }


}
