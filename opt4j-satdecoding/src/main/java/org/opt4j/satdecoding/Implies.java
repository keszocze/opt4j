package org.opt4j.satdecoding;

public class Implies extends Clause {
    public Implies(Literal a, Literal b) {
        add(a.negate());
        add(b);
    }

    public Implies(Literal a1, Literal a2, Literal b) {
        add(a1.negate());
        add(a2.negate());
        add(b);
    }
}
