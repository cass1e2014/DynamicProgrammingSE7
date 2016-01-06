/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 * 
 * @author cassie9082
 * 
 */
public class PaintFence {
	/*
	 * diff[n] -- the number of ways for the fence i which has different color with fence i-1 
	 * same[n] -- the number of ways if fence i has the same color with fence i-1 
	 * Initialization 
	 * same[0] = 0; diff[0] = k; 
	 * same[i] = diff[i-1] -- 当前杆和前一个杆颜色相同的个数等于前一个杆和再前一个杆颜色不相同的个数 
	 * diff[i] = (k-1)*(same[i-1] + diff[i-1]) --
	 * 即前一个杆和再前一个杆所有可能的颜色组合，乘以当前杆与前一个杆颜色不相同的个数，即（k - 1）
	 */
	public int numWays(int n, int k) {
		if (n <= 0 || k <= 0) {
			return 0;
		}

		if (n == 1) {
			return k;
		}

		int[] same = new int[n];
		int[] diff = new int[n];

		same[0] = 0;
		diff[0] = k;

		for (int i = 1; i < n; i++) {
			same[i] = diff[i - 1];
			diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);
		}

		return same[n - 1] + diff[n - 1];
	}
}
