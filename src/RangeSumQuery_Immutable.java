/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 
 * sumRange(2, 5) -> -1 
 * sumRange(0, 5) -> -3
 * 
 * You may assume that the array does not change. There are many calls to
 * sumRange function.
 * 
 * @author cassie9082
 * 
 */
public class RangeSumQuery_Immutable {
	/*
	 * 考虑到要多次调用sumRange()函数，因此需要把结果先存起来，调用时就可以直接返回了。最开始考虑的是用dp[i][j]来直接存储i到j之间元素的和
	 * ，但是内存超出限制。于是考虑用dp[i]来存储0到i之间元素的和，0到j的和减去0到i-1的和即为所求
	 */
	int[] dp;

	public RangeSumQuery_Immutable(int[] nums) {
		dp = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			dp[i] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? dp[j] : dp[j] - dp[i - 1];
	}
}

//Your RangeSumQuery_Immutable object will be instantiated and called as such:
//RangeSumQuery_Immutable rangeSumQuery_Immutable = new RangeSumQuery_Immutable(nums);
//rangeSumQuery_Immutable.sumRange(0, 1);
//rangeSumQuery_Immutable.sumRange(1, 2);
