package org.opt4j.satdecoding;

import java.util.Collection;

public class Or extends Clause {

    public Or(Collection<Literal> lits) {
        for (Literal l: lits) {
            add(l);
        }
    }

    public Or(Literal a, Literal b) {
        add(a);
        add(b);
    }
}
