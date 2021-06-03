package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import java.util.ArrayList;
import compute.Compute;
public class ComputeConverter {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        } try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);

            String[] newArgs = new String[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                newArgs[i-1] = args[i];
            }
            Converter task = new Converter(newArgs);
            ArrayList<String> res = comp.executeTask(task);
            System.out.print("Answer: ");
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }

        } catch (Exception e) {
            System.err.println("ComputeConverter exception:");
            e.printStackTrace();
        }
    }
}
