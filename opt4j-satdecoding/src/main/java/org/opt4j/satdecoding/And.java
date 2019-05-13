package org.opt4j.satdecoding;

import java.util.Collection;

public class And extends Constraint {
    public And(Collection<Literal> lits) {
        for (Literal l: lits) {
            add(l);
        }
        rhs=lits.size();
    }

    public And(Literal a, Literal b) {
        add(a);
        add(b);
        rhs=2;
        System.out.println(rhs);
    }
}
