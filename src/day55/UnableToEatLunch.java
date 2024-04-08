package day55;

public class UnableToEatLunch {
	
	public static void main(String[] args) {
		int[] students = {1,1,1,0,0,1}, sandwiches = {1,0,0,0,1,1};
		System.out.println("Output ::  " + countStudents(students, sandwiches));
	}
	
	private static int countStudents(int[] students, int[] sandwiches) {
        int[] total = new int[2];
        for (int std : students)
            total[std]++;
        for (int snd : sandwiches) {
            if (total[snd] == 0)
                break;
            total[snd]--;
        }
        return Math.abs(total[0] - total[1]);

    }

}
