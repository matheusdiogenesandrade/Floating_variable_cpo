import ilog.cp.*;
import ilog.concert.*;

public class Main {
    public static void main(String[] args) {
        try {
            IloCP cp = new IloCP();

            IloIntVar x = cp.intVar(0, 10);
            IloIntVar p = cp.intVar(0, 10);
            IloNumVar q = cp.numVar(0, 10);
           
            IloConstraint eq = cp.eq(x, 10);

            IloConstraint eq1 = cp.eq(cp.diff(p, q), -5);
            IloConstraint ifThen = cp.ifThen(eq, eq1);
            
            cp.add(ifThen);

            if (cp.solve()) {
                System.out.println("Solved");
            } else
                System.out.println("Not solved");

        } catch (IloException e) {
            System.err.println("Error: " + e);
        }
    }
}

