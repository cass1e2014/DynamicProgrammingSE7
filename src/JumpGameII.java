/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * 
 * Time O(n), Space O(1)
 * @author cassie9082
 * 
 */
public class JumpGameII {
	//Greedy
	public static int jump(int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int jumps = 0;//最少的jump的次數
        int next = 0;//下一個會起跳的index，從0開始
        int max = 0;//能reach到的最遠的index
		for(int i = 0; i < nums.length - 1 && next < nums.length - 1; i++){
			max = Math.max(max, i + nums[i]);
			
			if(next == i){ // ready to jump
				if(next == max) return -1;
				next = max;
				jumps++;
			}
		}
		return jumps;
	}
	
	public static void main(String[] args){
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}
}
