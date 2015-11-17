/**
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author cassie9082
 * 
 */
public class HouseRobberII {
	// Time O(2N), Space O(N)
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1)
			return nums[0];
		// 第一个房子没有被偷，则可以从第二个房子偷到最后一个房子,这之间用线性的动态规划求解
		// dp[i]表示到第i个房子，小偷没有惊动警察时获取的最大钱数
		int[] dp1 = new int[nums.length];
		dp1[0] = 0;
		dp1[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
		}

		// 第一个房子被偷
		int[] dp2 = new int[nums.length];
		dp2[0] = nums[0];
		dp2[1] = nums[0];// 第二个房子不能被偷
		for (int i = 2; i < nums.length; i++) {
			dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
		}
		dp2[nums.length - 1] = dp2[nums.length - 2];// 最后一个房子不能被偷

		return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
	}
}
