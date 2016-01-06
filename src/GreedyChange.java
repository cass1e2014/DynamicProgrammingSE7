
public class GreedyChange {
	public static void main(String[] args){
		int amount = 56;
		int coin[] = {20, 5, 1};
		int num;
		
		for(int i = 0; i < coin.length; i++){
			if(coin[i] <= amount){
				num = amount / coin[i];
				System.out.println(num + " " + "$" + coin[i]);
				amount -= num * coin[i];
			}			
		}
	}
}
