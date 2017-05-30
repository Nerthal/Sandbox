package pageObject;

public class ResultCountEvaluator {

    private int evaluatedValue;
    private int minValue;
    private int maxValue;

    public ResultCountEvaluator(int value, int range) {
        this.evaluatedValue = value;
        this.minValue = value - range;
        this.maxValue = value + range;
    }

    public boolean areEqual(int value) {
        return minValue <= evaluatedValue && evaluatedValue <= maxValue;
    }
}
