package pageObject;

public class ResultCountEvaluator {

    public ResultCountEvaluator(int value, int range) {
        this.evaluatedValue = value;
        this.minValue = value - range;
        this.maxValue = value + range;
    }

    private int evaluatedValue;
    private int minValue;
    private int maxValue;

    public boolean areEqual(int value) {
        return minValue <= evaluatedValue && evaluatedValue <= maxValue;
    }
}
