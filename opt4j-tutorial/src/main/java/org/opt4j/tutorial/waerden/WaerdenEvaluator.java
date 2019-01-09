package org.opt4j.tutorial.waerden;

import org.opt4j.core.Objective;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

public class WaerdenEvaluator implements Evaluator<WaerdenResult> {

	protected Objective ones = new Objective("ones", Sign.MIN);

	@Override
	public Objectives evaluate(WaerdenResult waerdenResult) {

		int value = 0;
		for (Boolean v : waerdenResult) {
			if (v != null && v) {
				value++;
			}
		}

		Objectives objectives = new Objectives();
		objectives.add(ones, value);
		return objectives;
	}
}
