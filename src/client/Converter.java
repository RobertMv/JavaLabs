package client;
import compute.Task;
import java.io.Serializable;
import java.util.ArrayList;
public class Converter implements Task<ArrayList<String>>, Serializable {
    private String[] args;

    public Converter(String[] args){
        this.args = args;
    }
    public static ArrayList<String> convert(String[] args){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> one = new ArrayList<>();
        for (String x : args) {
            if (Integer.parseInt(x) == 0) {
                res.add(x);
            } else {
                one.add(x);
            }
        }
        res.addAll(one);
        return res;
    }
    @Override
    public ArrayList<String> execute() {
        return convert(args);
    }
}

