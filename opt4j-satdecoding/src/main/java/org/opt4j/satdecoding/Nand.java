package org.opt4j.satdecoding;

import java.util.Collection;

public class Nand  extends Clause {

    public Nand(Literal a, Literal b) {
        add(a.negate());
        add(b.negate());
        System.out.println("nand rhs: "+rhs);
        System.out.println("nand op: "+operator);
    }

    public Nand(Collection<Literal> vars) {
        for (Literal l: vars ) {
            add(l.negate());
        }
    }
}
