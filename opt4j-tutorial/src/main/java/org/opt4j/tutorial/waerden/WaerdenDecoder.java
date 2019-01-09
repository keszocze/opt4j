package org.opt4j.tutorial.waerden;

import com.google.inject.Inject;
import org.opt4j.core.Genotype;
import org.opt4j.core.common.random.Rand;
import org.opt4j.core.start.Constant;
import org.opt4j.satdecoding.*;


import java.util.*;

public class WaerdenDecoder extends AbstractSATDecoder<Genotype, WaerdenResult> {




    int j = 0;
    int k = 0;
    int n = 0;

    @Inject
    public WaerdenDecoder(SATManager satManager, Rand random, @Constant(value = "j") int j, @Constant(value = "k") int k, @Constant(value = "n") int n) {
        super(satManager, random);
        this.j=j;
        this.k=k;
        this.n=n;
    }


    int W(int j, int k) {


        HashMap<Integer, HashMap<Integer, Integer>> ws = new HashMap<Integer, HashMap<Integer, Integer>>(4);

        //HashMap<Integer, Integer> threes =

        switch (j) {
            case 1:
                return k;
            case 2:
                return (k & 0x1) == 0 ? 2 * k - 1 : 2 * k;
        }

        return 0;
    }

    void helper(boolean phase, Collection<Constraint> cons) {
        int d = 1;

        int choice = phase ? j : k;



        // stupid worst case considerations
        if (choice == 1) {
            for (int i = 1; i <= n; i++) {
                Clause clause = new Clause();
                clause.add(new Literal(i,phase));
                cons.add(clause);
            }
            return;
        }

        int bound = (choice -1) *d;

        while (n > bound) {
            for (int i = 1; i <= n - bound; i++) {

                Constraint clause = new Clause();
                List<Integer> vars = new LinkedList<>();
                int index = i;
                for (int iter = 0; iter < choice; iter++) {
                    vars.add(index);
                    index += d;
                }
                for (int v : vars) {
                    clause.add(new Literal(v, phase));
                }
                cons.add(clause);
            }

            d++;
            bound =  (choice -1) *d;
        }

    }

    @Override
    public Set<Constraint> createConstraints() {


        Set<Constraint> constraints = new HashSet<>();


        helper(true,constraints);
        helper(false, constraints);

//        for (Constraint c:  constraints) {
//            System.out.println(c);
//        }

//        HashSet<Constraint> cons = new HashSet<>();
//        cons.addAll(constraints);

        return constraints;
    }

    @Override
    public WaerdenResult convertModel(Model model) {

        WaerdenResult waerdenResult = new WaerdenResult();

        for (int i = 1; i < n; i++) {
            waerdenResult.add(model.get(i));
        }

        return waerdenResult;
    }

}
