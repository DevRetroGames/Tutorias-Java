package utils;

import java.lang.Math;

public class RangeComparatorUtils {

    public int[] combineRanges(int[] rangeA, int[] rangeB) {
        int min = Math.min(rangeA[0], rangeB[0]);
        int max = Math.max(rangeA[1], rangeB[1]);
        return new int[]{min, max};
    }

}