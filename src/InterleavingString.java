/**
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


 * @author cassie9082
 *
 */
public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "db";
		String s2 = "b";
		String s3 = "cbb";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= s2.length(); i++){
            if(s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]){
                dp[0][i] = true;
            }
        }
        
        for(int i = 1; i <= s1.length() ; i++){
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0]){
                dp[i][0] = true;
            }
        }
        
        for(int i = 1; i <= s1.length(); i ++){
            for(int j = 1; j <= s2.length(); j ++){
                char c = s3.charAt(i + j - 1);
                if(c == s1.charAt(i - 1) && dp[i - 1][j]){
                    dp[i][j] = true;
                }
                
                if(c == s2.charAt(j - 1) && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
        
    }

}
