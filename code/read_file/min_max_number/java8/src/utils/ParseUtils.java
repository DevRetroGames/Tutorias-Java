package utils;

import java.util.Arrays;

public class ParseUtils {

    /**
     * Parses a comma-separated string into an array of integers.
     *
     * @param input the input string, e.g., "1, 2, 3"
     * @return an array of integers parsed from the string
     */
    public int[] parseStringToIntArray(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}