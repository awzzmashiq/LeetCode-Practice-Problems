
public class CoinChange {
	int[] coins;
	Integer[] cache;
	
	public int coinChanges(int amount, int []coins)
	{
		this.coins=coins;
		this.cache= new Integer[amount+1];
		return helper(amount);
	}

	private int helper(int amount) {
		// TODO Auto-generated method stub
		if(amount==0)return 0;
		if(amount<0)return -1;
		
		if(cache[amount]!=null) return cache[amount];
		
		int mincoinschange=Integer.MAX_VALUE;
		
		for(int num:coins)
		{
			int curmincoinschange=helper(amount-num);
			if(curmincoinschange!=-1)
			{
				mincoinschange=Math.min(curmincoinschange,mincoinschange);
			}
		}
		if(mincoinschange==Integer.MAX_VALUE)
			mincoinschange=-1;
		else
			mincoinschange+=1;
		
		cache[amount]=mincoinschange;
		
		return cache[amount];
	}

	public static void main(String[] args) {
		
		int[] coins=new int[]{1,2,3};
		int amount=6;
		CoinChange c= new CoinChange();
		int result=c.coinChanges(amount,coins);
		System.out.println(result);

	}

}
