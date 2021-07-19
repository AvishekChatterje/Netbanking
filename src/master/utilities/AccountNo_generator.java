package master.utilities;

public class AccountNo_generator 
{
	public String generateCID()
	{
		int len=12;
		String str="1234567890"+"023456789";
		int n=str.length();
		String OTP="";
		for(int i=1;i<=len;i++)
		{
			OTP+=(str.charAt((int)(Math.random()*10)%n));
		}
		return ("XYZ"+OTP);
	}
	public String generateAcc_no()
	{
		int len=12;
		String str="1234567890"+"023456789";
		int n=str.length();
		String OTP="";
		for(int i=1;i<=len;i++)
		{
			OTP+=(str.charAt((int)(Math.random()*10)%n));
		}
		return (OTP);
	}

}
