package pageObject;

import org.springframework.stereotype.Component;

@Component
public class ResultCountEvaluator {

	private int range;

	public ResultCountEvaluator(final int range) {
		this.range = range;
	}

	public boolean areEqual(int expected, int actual) {
		return expected <= actual - range || actual + range <= expected;
	}
}
