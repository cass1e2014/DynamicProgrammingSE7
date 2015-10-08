/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * 动态规划。 o(n)
 * 到达第k个元素前的最远距离为max
 * 若max < k, 则无法跳到k位置，返回false
 * 
 * max_dis_at_k = max > k + num[k] ? max : k + num[k]
 * 
 * （k+nums[k] ：： 表达为从k位置起跳的最远距离
 * 
 * @author cassie9082
 * 
 */
public class JumpGameI {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0){
			return false;
		}
		
		int max = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(i > max){
				return false;
			}else if(nums[i] + i >= nums.length - 1){
				return true;
			}else if(nums[i] + i > max){
				max = nums[i] + i;
			}
		}
		return true;
	}
}
