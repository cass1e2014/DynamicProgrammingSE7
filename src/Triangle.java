import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
   ]
 *
 * @author cassie9082
 * 
 */
public class Triangle {
	// Adjacent number for A[i][j] is A[i+1][j] and A[i+1][j+1], no A[i+1][j-1]
	
	/*
	 * Method 1 -- bottom up traversal (Time O(2^n)   it may have repeated calcultions)
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		return bottomUpTraversal(triangle, 0, 0);
	}

	public int bottomUpTraversal(List<List<Integer>> triangle, int layer,
			int curr) {
		if (layer == triangle.size())
			return 0;
		int currentNextLayerMax = bottomUpTraversal(triangle, layer + 1, curr);
		int rightNextLayerMax = bottomUpTraversal(triangle, layer + 1, curr + 1);
		return Math.min(currentNextLayerMax, rightNextLayerMax)
				+ triangle.get(layer).get(curr);
	}
	
	
	/*
	 * Method 2 -- DP
	 * We need an array with row size to store layer i+1 for calculating later i
	 */
	public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }
        
        int[] dp = new int[triangle.size()];
        
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
