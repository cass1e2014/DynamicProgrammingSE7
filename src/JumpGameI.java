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
 * Time O(n), Space O(1)
 * 
 * @author cassie9082
 * 
 */
public class JumpGameI {
	//Greedy
	public static boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0){
			return false;
		}
		
		int reach = 0;//the rightmost that can jump to
        for(int i = 0; i <= reach && reach < nums.length; i++){
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
	}
	
	public static void main(String[] args){
		int[] nums = {3, 2, 1, 0, 4};
		System.out.println(canJump(nums));
	}
}
