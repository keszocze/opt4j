package org.opt4j.tutorial.waerden;

import org.opt4j.core.config.annotations.Parent;
import org.opt4j.core.problem.ProblemModule;
import org.opt4j.core.start.Constant;
import org.opt4j.tutorial.TutorialModule;

@Parent(TutorialModule.class)
public class WaerdenModule extends ProblemModule {

    @Constant(value = "j")
    protected int j = 3;

    @Constant(value = "k")
    protected int k = 3;

    @Constant(value = "n")
    protected int n = 9;

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }



	public void config() {
		bindProblem(WaerdenDecoder.class, WaerdenDecoder.class, WaerdenEvaluator.class);
	}

}
