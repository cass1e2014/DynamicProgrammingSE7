/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author cassie9082
 * 
 */
public class MaximumSubarray {
	// Time: O(N) Space: O(N)
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(sum, max);
			sum = Math.max(sum, 0);
		}
		return max;
	}
}
