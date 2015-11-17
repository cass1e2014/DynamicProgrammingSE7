/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank 
 * and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 * 
 */
public class GasStation {
	/**
	 * 用两个变量存+= gas[i] - cost[i]。一个帮助判断当前这个点作为gas
	 * station的起点合不合适，一个帮助判断总的需求是不是大于供给
	 * 如果总的需求大于供给那么肯定是无解的，如果需求小于等于供给，就可以返回刚才找到的起始点。
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//Greedy
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0
				|| gas.length != cost.length) {
			return -1;
		}

		int sum = 0;
		int total = 0;
		int index = 0;// 哪个加油站？
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i]; // 一个帮助判断当前这个点作为gas station的起点合不合适
			total += gas[i] - cost[i]; // 一个帮助判断总的需求够不够
			if (sum < 0) {
				index = i + 1;
			}
		}

		if (total < 0) {
			return -1;
		}
		return index;
	}

}
