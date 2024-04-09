package day56;

public class TimeReqToBuy {
	
	public static void main(String[] args) {
		int[] tickets = {5,1,1,1};
		int k = 0;
		System.out.println("Time taken to buy tickets :: " + timeRequiredToBuy(tickets, k));
	}
	
	private static int timeRequiredToBuy(int[] tickets, int k) {
	       
	       int res = 0, n = tickets.length;
	       for (int i = 0; i < n; i++) {
	        if (tickets[k] >= tickets[i])
	            res += tickets[i];
	        else
	            res += tickets[k];
	       }
	       int after = k + 1;
	       while (after < n) {
	        if (tickets[after] >= tickets[k])
	            res--;
	        after++;
	       }
	       return res;
	    }

}
