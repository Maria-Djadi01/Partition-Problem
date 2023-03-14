package partitionProblem;
import java.util.Stack;
import java.util.ArrayList;
 
class main
{
	public static State dfs(ArrayList<Integer> S) {
		State initial_state = new State();
		State bestSol = new State(S, new ArrayList<>(), 0);
		
		Stack<State> stack = new Stack<State>();
		ArrayList<State> closed = new ArrayList<State>();
		
		stack.push(initial_state);
		
		while(!stack.empty()) {
			State current_state = stack.pop();
			closed.add(current_state);
			
			if(!current_state.finalGoal(S)) {
				State n1 = current_state.copy();
				State n2 = current_state.copy();
				n1.s1.add(S.get(n1.index));
				n2.s2.add(S.get(n2.index));
				n1.index++;
				n2.index++;
				stack.push(n2);
				stack.push(n1);
			}
			else {
				if(current_state.eval() == 0) {
					System.out.println("Number of covered nodes : " + closed.size());
					return current_state;
				}
			else {
				if(current_state.eval() < bestSol.eval()) bestSol = current_state;
				
			}
			}
		}
		System.out.println("Number of covered nodes : " + closed.size());
		return bestSol;
		
	}
	
    public static ArrayList<Integer> fillList(int[] arr) {
    	ArrayList<Integer> S = new ArrayList<>(); 
    	for(int i: arr) S.add(i);
    	return S;
    }
    
    public static void main(String[] args)
    {
    	int[] arr = {382745, 799601, 909247, 729069, 467902,  44328,  34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161,  31385, 496951, 264724, 224916, 169684};
    	ArrayList<Integer> S = fillList(arr);
    	
    	
    	State state = dfs(S);
    	System.out.println("S : " + S);
    	System.out.println("s1 : " + state.s1);
    	System.out.println("s2 : " + state.s2);
    	System.out.println("Evaluation : " + state.eval());
    	
    }
}

