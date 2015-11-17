/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */

/**
 * [Thoughts] DP. The transition function should be: f(n) = f(n-1) + f(n-2) n>2;
 * or = 1 n=1 or = 2 n=2
 * 
 * 假设梯子有n层，那么如何爬到第n层呢，因为每次只能怕1或2步，那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
 * 所以递推公式非常容易的就得出了：
 * 
 * dp[n] = dp[n-1] + dp[n-2]
 * 
 * @author cassie9082
 * 
 */
public class ClimbingStairs {
	//Time O(N) Space O(N)
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
