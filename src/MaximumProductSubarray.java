/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author cassie9082
 * 
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int maxProd = 1;
		int minProd = 1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int tmp = maxProd;// ****
			maxProd = Math.max(Math.max(maxProd * nums[i], nums[i]), minProd
					* nums[i]);
			minProd = Math.min(Math.min(minProd * nums[i], nums[i]), tmp
					* nums[i]);
			max = Math.max(maxProd, max);
			// min = Math.min(minProd, min);
		}
		return max;
	}
}
