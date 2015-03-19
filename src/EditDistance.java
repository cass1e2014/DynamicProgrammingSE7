/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		
		int[][] dp = new int[n + 1][m + 1]; //*add " " 在both 行和列前，所以会多一个cell 0
		//Initialization
		for(int i = 0; i < m ; i++){
			dp[0][i] = i;
		}
		for(int j = 0; j < n; j++){
			dp[j][0] = j;
		}
		
		//三种情况求最小值：dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + 1.
		//且第三种情况dp[i-1][j-1] + 1有2种可能。一种是之前斜对格的数字和当前的相等，则不用动。另一种是不等，则要replace，即还要＋1
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		return dp[n][m];
	}
}
