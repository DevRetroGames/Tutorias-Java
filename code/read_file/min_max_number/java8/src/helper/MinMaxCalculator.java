package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import utils.ParseUtils;
import utils.RangeComparatorUtils;

public class MinMaxCalculator {

    private ParseUtils _parseUtils;
    private RangeComparatorUtils _rangeComparatorUtils;

    private String _fileName;
    private boolean _initialized;

    public MinMaxCalculator(String fileName) {
        this._parseUtils = new ParseUtils();
        this._rangeComparatorUtils = new RangeComparatorUtils();
        this._fileName = fileName;
        this._initialized = false;
    }

    private int[] _readFile() throws IOException {
        int[] resultRange = new int[2];

        try (Stream<String> lines = Files.lines(Paths.get(this._fileName))) {
                lines.forEach(line -> {
                int[] currentRange = _processLine(line);
                int[] updatedRange = _compareRanges(resultRange, currentRange);
                resultRange[0] = updatedRange[0];
                resultRange[1] = updatedRange[1];
            });
        }

        return resultRange;
    }

    private int[] _processLine(String line) {
        int[] values = this._parseUtils.parseStringToIntArray(line);

        int min = java.util.Arrays.stream(values).min().getAsInt();
        int max = java.util.Arrays.stream(values).max().getAsInt();

        return new int[] { min, max };
    }

    private int[] _compareRanges(int[] rangeA, int[] rangeB) {
        if (!this._initialized) {
            this._initialized = true;
            return rangeB;
        }
        return this._rangeComparatorUtils.combineRanges(rangeA, rangeB);
    }

    private int[] _execute() {
        try {
            return this._readFile();
        } catch (IOException e) {
            return new int[] { Integer.MIN_VALUE };
        }
    }

    public void print() {
        int[] result = this._execute();

        if(result.length == 1) {
            System.err.println("Error reading file.");
        }
        else { 
            System.out.printf("Minimum value: %d%nMaximum value: %d%n", result[0], result[1]); 
        }
    }
    
}