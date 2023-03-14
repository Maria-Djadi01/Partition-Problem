package partitionProblem;

import java.util.ArrayList;
import java.util.Random;

public class Rand {

    public static void main(String args[]) {
        
    }
    
    public static ArrayList<Integer> Generaterandom(int n){
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            int nb = random.nextInt(10000-1 +1)+1;
            list.add(nb);
        }
        
        return list;
    }
    
}
