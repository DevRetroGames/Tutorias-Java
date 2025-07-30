package utils;

import java.util.regex.Pattern;

public class ParseUtils {

    // Precompiled pattern to split input by comma
    private static final Pattern COMMA = Pattern.compile(",");
    
    /**
     * Parses a comma-separated string into an array of integers.
     *
     * This method trims each element using {@code String.strip()} to remove
     * leading and trailing Unicode whitespace, filters out empty strings,
     * and converts the remaining tokens to integers.
     *
     * @param input the comma-separated string, e.g., "1, 2, 3"
     * @return an array of integers parsed from the input
     */
    public int[] parseStringToIntArray(String input) {
        return COMMA.splitAsStream(input)
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}