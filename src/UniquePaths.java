/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 机器人走格子题
 * 
 * @author cassie9082
 * 
 */
public class UniquePaths {
	/*
	 * The crux of the Java solution is to define a transit equation. 
	 * We definedp[i][j] means the total number of unique paths from dp[0][0] to dp[i][j]. 
	 * So dp[i][j] = dp[i - 1][j] + dp[i][j - 1]. 
	 * So we can only need to check about the last element, which is dp[m-1][n-1].
	 */
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dp = new int[m][n];
		// fill 1 in top row and left row
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
