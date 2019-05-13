package org.opt4j.satdecoding;


/**
 * @brief Stores a clause of literals
 * @author keszocze
 * 
 * This class serves as the base class for more specific constraints such as OR or IMPLIES.
 * 
 * This class is compatible with the more general {@see Constraint} class as it simply fixes the
 * RHS to 1 and the operator to >=. 
 *
 */
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
