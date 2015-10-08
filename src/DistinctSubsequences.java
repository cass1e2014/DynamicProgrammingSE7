/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * @author cassie9082
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if(s == null || t == null){
            return 0;
        }
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;//initial
        
        for(int i = 1; i <= s.length(); i++){
            dp[i][0] = 1;//t is empty
        }
        
        for(int j = 1; j <= t.length(); j++){
            dp[0][j] = 0;//s is empty
        }
        
        //dp[i][j]至少等于dp[i - 1][j]
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                dp[i][j] = dp[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
	}
}
