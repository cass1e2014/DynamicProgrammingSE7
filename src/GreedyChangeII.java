/**
 * 自定义的零钱类型，10，7，1, 给出total amount，如何使零钱数目最少
 * 
 * 
 * DP的优势是如果碰到如果零钱的选项里面没有1，而导致有的total不能按greedy的算法破解开的时候，如果用DP就有可能破开钱。比如total =
 * 11, 而零钱是5， 4， 3的情况。用greedy换了一张5和一张4就换不下去了，DP可以解出一张5和两张3。
 * 
 * @author cassie9082
 * 
 */
public class GreedyChangeII {
	// DP
	public int minNum(int n) {
		int[] result = new int[n + 1];
		result[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i < 7) {
				result[i] = i;
			} else if (i >= 7 && i < 10) {
				result[i] = i % 7 + 1;
			} else {
				result[i] = Math.min(result[i - 1],
						Math.min(result[i - 7], result[i - 10])) + 1;
			}
		}
		return result[n];
	}
}
