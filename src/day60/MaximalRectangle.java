package day60;
import java.util.*;

public class MaximalRectangle {
	
	public static void main(String[] args) {
		char[][] arr = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'},
						{'1','0','0','1','0'}};
		System.out.println("Output :: " + maximalRectangle(arr));
		System.out.println("Output :: " + maximalRectangle1(arr));
		System.out.println("Output :: " + maximalRectangle2(arr));
	}

	private static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) 
			return 0;
		int maxarea = 0;
		int[] dp = new int[matrix[0].length];

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++)
				dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
			maxarea = Math.max(maxarea, height(dp));
		} return maxarea;
	}
	private static int height(int[] heights) {
		Stack < Integer > stack = new Stack < > ();
		stack.push(-1);
		int maxarea = 0;
		for (int i = 0; i < heights.length; ++i) {
			while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
				maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
			stack.push(i);
		}
		while (stack.peek() != -1)
			maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
		return maxarea;
	}
	

    private static int maximalRectangle1(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int ans = 0;
    int[] hist = new int[matrix[0].length];

    for (char[] row : matrix) {
      for (int i = 0; i < row.length; ++i)
        hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
      ans = Math.max(ans, largestRectangleArea(hist));
    }

    return ans;
  }

  private static int largestRectangleArea(int[] heights) {
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= heights.length; ++i) {
      while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
        final int h = heights[stack.pop()];
        final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, h * w);
      }
      stack.push(i);
    }

    return ans;
  }
  
  private static int maximalRectangle2(char[][] matrix) {
      if (matrix.length == 0)
          return 0;
      int m = matrix.length;
      int n = matrix[0].length;

      int[] left = new int[n]; 
      int[] right = new int[n];
      int[] height = new int[n];

      Arrays.fill(right, n); 
      int maxarea = 0;
      for (int i = 0; i < m; i++) {
          int cur_left = 0, cur_right = n;
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == '1')
                  height[j]++;
              else
                  height[j] = 0;
          }
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == '1')
                  left[j] = Math.max(left[j], cur_left);
              else {
                  left[j] = 0;
                  cur_left = j + 1;
              }
          }
          for (int j = n - 1; j >= 0; j--) {
              if (matrix[i][j] == '1')
                  right[j] = Math.min(right[j], cur_right);
              else {
                  right[j] = n;
                  cur_right = j;
              }
          }
          for (int j = 0; j < n; j++) {
              maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
          }
      }
      return maxarea;
  }
	

}
