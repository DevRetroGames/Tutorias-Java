package utils;

import java.lang.Math;

public class RangeComparatorUtils {

    /**
     * Returns a combined range that includes both input ranges.
     * Each range is represented as an int array: [min, max].
     *
     * @param rangeA first range [min, max]
     * @param rangeB second range [min, max]
     * @return new range [min of both, max of both]
     */
    public int[] combineRanges(int[] rangeA, int[] rangeB) {
        int min = Math.min(rangeA[0], rangeB[0]);
        int max = Math.max(rangeA[1], rangeB[1]);
        return new int[]{min, max};
    }

}