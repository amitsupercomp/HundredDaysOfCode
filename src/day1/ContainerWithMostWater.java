package day1;

public class ContainerWithMostWater {

public static void main(String[] args) {
		
		int[] arr = {1,8,6,2,5,4,8,3,7};		
		System.out.println("Maximum water contain :: " + maxArea(arr));
	}
	
//Method start to calculate Container with most water.
	 private static int maxArea(int[] height) {
		 
		 //Initialize variable of left which is pointing to left
		 //and right which is pointing to right side element
		 //maxArea and currentArea is initialize with 0
	        int left = 0;
	        int right = height.length - 1;
	        int maxArea = 0, currentArea = 0;
	        
	        //Container contains water between two height. So we take left element
	        //one height and right element second height. To get water left and right
	        //should not be equal and left should be less than right.
	        while (left < right) {
	        	
	        	//To calculate currentArea we have formula
	        	//minimum of left and right element mul by difference of left and right
	            currentArea = Math.min(height[left], height[right]) * (right - left);
	            
	            //To calculate maxArea always take max value from current area 
	            //and hold this value until get another max value.
	            maxArea = Math.max(maxArea, currentArea);
	            
	            //Last inc and dec of left and right
	            if (height[left] > height[right])
	                right--;
	            else
	                left++;
	        }
	        return maxArea;       
	    }  
}
