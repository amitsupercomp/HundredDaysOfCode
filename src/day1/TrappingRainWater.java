package day1;

public class TrappingRainWater {

public static void main(String[] args) {
		
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Maximum water store :: " + trap(arr));

	}

//Method start to calculate rain water trapping.
	 private static int trap(int[] height) {
	    
		 //initialize variables with default value 0.
	        int result = 0;
	        int check = height[0];
	        //initialize two array for left and right
	        //fill left array with higher value till index and same process apply for right also
			int[] left = new int[height.length];
			int[] right = new int[height.length];
			
			//fill left array
			for(int i = 0; i < height.length; i++)
			{
				if(check < height[i])
				{
					check = height[i];
					left[i] = check;
				}
				else
				{
					left[i] = check;
				}
			}
			check = height[height.length - 1];
			//fill right array
			for(int i = height.length - 1; i >= 0 ; i--)
			{
				if(check < height[i])
				{
					check = height[i];
					right[i] = check;
				}
				else
				{
					right[i] = check;
				}
			}
			//Calculate total water. To get result we have formula 
			//minimum of left and right of index and subtract by main array element
			for(int i = 0; i < height.length; i++)
			{
				result = result + ( TrappingRainWater.min(left[i], right[i]) - height[i] );
			}
	        return result;
	    }

	    private static int min (int a, int b) {
	        if (a < b)
	            return a;
	        else
	            return b;
	    }
}
