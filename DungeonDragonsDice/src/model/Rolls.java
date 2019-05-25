package model;

public class Rolls {
	private int num;
	private String allresults = "";
	
	public Rolls(int num) {
		this.num = num;
	}
	
	public int regularRoll(int sides) {
		int res = 0;
		for(int i = 1; i <= num; i++) {
			int rand = (int) (Math.random()*sides)+1;
			res += rand;
			allresults += "  " + rand;
		}
//		result.setText(Integer.toString(res));
//		results.setText(allresults)
		return res;
	}
	
	public int advantageRoll(int sides) {
		int res = 0;
		for(int i = 1; i <= num; i++) {
			int rand = (int) (Math.random()*sides)+1;
			if(rand > res)
				res = rand;
			allresults += "  " + rand;
		}
//		result.setText(Integer.toString(res));
//		results.setText(allresults);
		return res;
	}
	
	public int disadvantageRoll(int sides) {
		int res = 100;
		for(int i = 1; i <= num; i++) {
			int rand = (int) (Math.random()*sides)+1;
			if(rand<res)
				res = rand;
			allresults += "  " + rand;
		}
//		result.setText(Integer.toString(res));
//		results.setText(allresults);
		return res;
	}
	
	public String getAllResults() {
		return allresults;
	}
	
}
