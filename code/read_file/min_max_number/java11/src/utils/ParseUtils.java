package utils;

import java.util.Arrays;

public class ParseUtils {

    public int[] parseStringToIntArray(String input) {
        return Arrays.stream(input.split(","))
            .map(String::strip)
            .filter(s -> !s.isEmpty())
            .filter(s -> s.matches("-?\\d+"))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

}