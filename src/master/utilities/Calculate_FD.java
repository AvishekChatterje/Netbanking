package master.utilities;

public class Calculate_FD 
{
	public double getFdAmount(int amt,int time)
	{
		double bal=(5/100.0)+1;
		bal=Math.pow(bal,time);
		bal=bal*amt;
		return bal;
	}
}