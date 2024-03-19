package day35;
import java.util.*;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] s = {'A','C','A','B','D','B'};
		int n = 1;
		System.out.println("Output :: " + leastInterval(s, n));
	}
	
	private static int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for(char c : tasks){
            taskFreq[c - 'A']++;
        }
        Arrays.sort(taskFreq);
        int batchCnt = taskFreq[25];
        int vacantSlots = --batchCnt * n;
        for(int indx = 0; indx < 25; indx++){
            vacantSlots -= Math.min(taskFreq[indx], batchCnt); 
        }
        return vacantSlots > 0 ? tasks.length + vacantSlots : tasks.length;
    }
	
}
