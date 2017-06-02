package pageObject;

public class ResultCountEvaluator {

    private int range;

    public ResultCountEvaluator( int range) {
        this.range = range;
    }

    public boolean areEqual(int expectedValue, int actualValue) {
        return expectedValue - range <= actualValue && actualValue <= expectedValue + range;
    }
}
