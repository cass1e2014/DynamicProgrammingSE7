/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * 
 * @author cassie9082
 * 
 */
public class LongestIncreasingSubsequence {
	// DP
	// LIS(i)::Length of longest increasing subsequence which includes element
	// A[i] as its last element
	// for each j, where 0 <= j < i, if (A[i] >= A[j]), dp[i] = Math.max(dp[i],
	// dp[j] + 1);
	// Example:
	// A[] = {3, 4, 1, 5}
	// i=1 , LIS(1) = 1
	// i=2 , LIS(2) = 1+ Max(LIS(1)) = 1 +1 =2 (4>3)
	// i=3 , LIS(3) = 1 (1>3, 1>4)
	// i=4 , LIS(4) = 1+ Max(LIS(1),LIS(2), LIS(3)) = 1 + Max(1,2,1) = 3
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int result = 1;
		for (int i = 0; i < nums.length; i++) {
			result = Math.max(dp[i], result);
		}

		return result;
	}
}
