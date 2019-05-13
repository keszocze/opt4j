package org.opt4j.satdecoding;

import java.util.Collection;

import org.opt4j.satdecoding.Constraint.Operator;

public class And extends Constraint {
    public And(Collection<Literal> lits) {
    	this.operator = Operator.GE;
        for (Literal l: lits) {
            add(l);
        }
        rhs=lits.size();
    }

    public And(Literal a, Literal b) {
    	this.operator = Operator.GE;
        add(a);
        add(b);
        rhs=2;
    }
}
