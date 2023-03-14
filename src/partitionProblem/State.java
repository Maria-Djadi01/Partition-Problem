package partitionProblem;

import java.util.ArrayList;

public class State {
	ArrayList<Integer> s1;
	ArrayList<Integer> s2;
	int index;
	
	
	public State() {
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
        this.index = 0;
    }
	
	public State(ArrayList<Integer> s1, ArrayList<Integer> s2, int index) {
        this.s1 = s1;
        this.s2 = s2;
        this.index = index;
    }
	
	public boolean finalGoal(ArrayList<Integer> S) {
		ArrayList<Integer> S_copy = new ArrayList<>();
		S_copy = (ArrayList<Integer>) S.clone();
		
		for(int e: this.s1) {
			S_copy.remove(S_copy.indexOf(e));
		}
		for(int e: this.s2) {
			S_copy.remove(S_copy.indexOf(e));
		}
		if(S_copy.isEmpty()) return true;
		else return false;
	}
	
	public int eval() {
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i:this.s1) sum1 += i; 
		for(int j:this.s2) sum2 += j; 
		return Math.abs(sum1 - sum2);
	}
	
	public State copy() {
		ArrayList<Integer> s1_copy = new ArrayList<>();
		ArrayList<Integer> s2_copy = new ArrayList<>();
		
		s1_copy.addAll(this.s1);
		s2_copy.addAll(this.s2);
		
		State st_copy = new State(s1_copy, s2_copy, this.index);
		return st_copy;
	}
}


