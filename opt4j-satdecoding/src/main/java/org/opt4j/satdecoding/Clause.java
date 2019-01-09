package org.opt4j.satdecoding;



public class Clause extends Constraint {
    public Clause() {
        this.operator = Operator.GE;
        this.rhs = 1;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < size(); i++) {
            s += get(i).getLiteral();
            if (i < size() - 1) {
                s += " ";
            }
        }

        return s;
    }
}
