import ilog.cp.*;
import ilog.concert.*;

public class Main {
    public static void main(String[] args) {
        try {

            // params
            int j = 10;
            double DISTANCE_IJ = 4.5;

            // init model
            IloCP cp = new IloCP();

            // set vars
            IloIntVar next_i = cp.intVar(0, 10); //next node to be visited after node i
            IloNumVar distance_at_i = cp.numVar(0, 10); // incurred distance at node i
            IloNumVar distance_at_j = cp.numVar(0, 10);// incurred distance at node j

            // set constraints

            // if next node of i is j then update distance at j
            cp.add(
                    cp.ifThen(
                        cp.eq(next_i, j), 
                        cp.eq(cp.diff(distance_at_i, distance_at_j), - DISTANCE_IJ)
                        )
                  );

            // edge case, since CPO requires the floating variables to have fixed value when 
            // all the discrete variables are setted, we say that if arc ij does not exist
            // simply set the distance_at_j to 0
            cp.add(
                    cp.ifThen(
                        cp.neq(next_i, j), 
                        cp.eq(distance_at_j, 0)
                        )
                  );

            // forces the distance at i to be 0 (as it was supposed to be a depot)
            cp.add(
                    cp.eq(
                        distance_at_i, 
                        0
                        )
                  );

            if (cp.solve()) {
                System.out.println("Solved");

                System.out.println(cp.getValue(next_i));
                System.out.println(cp.getValue(distance_at_i));
                System.out.println(cp.getValue(distance_at_j));

            } else
                System.out.println("Not solved");

        } catch (IloException e) {
            System.err.println("Error: " + e);
        }
    }
}

