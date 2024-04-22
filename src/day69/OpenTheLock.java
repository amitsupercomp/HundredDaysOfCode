package day69;
import java.util.*;

public class OpenTheLock {
	
	public static void main(String[] args) {
		String[] deadEnds = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		System.out.println("Output :: " + openLock(deadEnds, target));
	}
	
	private static int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
		Map<String,Integer> mp=new HashMap<>();
		Set<String> dead=new HashSet<>();
		for(String s:deadends)
			dead.add(s);
		q.add("0000");
		mp.put("0000", 0);
		 if(dead.contains("0000"))
	            return -1;
		while(!q.isEmpty()) {   
			String p=q.poll();
			if(p.equals(target)) return mp.get(p);
			int turn=mp.get(p);
			String[] comb=new String[8];
			for(int i=0;i<8;i+=2) {
				comb[i]=increaseF(p,i/2);
				comb[i+1]=decreaseF(p,i/2);
			}
			for(String s:comb) {
				if(!dead.contains(s)&&!mp.containsKey(s)) {
					q.add(s);
					mp.put(s, turn+1);
				}
			}
			
		}
		return -1;
    }

    private static String decreaseF(String p,int pos) {
		char[] charword=p.toCharArray();
		charword[pos]=	charword[pos]=='0'?'9':(char)(	charword[pos]-1);
		return new String(charword);
	}
	
	private static String increaseF(String p,int pos) {
		char[] charword=p.toCharArray();
		charword[pos]=	charword[pos]=='9'?'0':(char)(	charword[pos]+1);
		return new String(charword);
	}

}
