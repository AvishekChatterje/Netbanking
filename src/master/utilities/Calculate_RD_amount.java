package master.utilities;

public class Calculate_RD_amount 
{
		public double getFdAmount(int amt,int time)
		{
			double bal=(5/100.0)+1;
			bal=Math.pow(bal,time);
			bal=bal*amt;
			return bal;
	}
		public int getAmount(int amount,String choice)
		{
			if(choice.equals("Monthly"))
			{
				return amount/12;
			}
		return amount/4;	
		}
}
