package Task1;

import java.time.LocalDateTime;
import java.lang.Math;

public class Task1
{
	public static void main (String[] args)
	{
		BankAccount Nolan = new BankAccount("Nolan");
		BankAccount Harper = new BankAccount("Harper");
		BankAccount Nolan2 = Nolan;
		
		System.out.println(Nolan.accountNumber);
		System.out.println(Harper.accountNumber);
		System.out.println(Nolan.Deposit(50000));
		System.out.println(Nolan.Transfer(10000, Harper));
		System.out.println(Nolan.Withdrow(40000));
		System.out.println(Harper.toString());
		System.out.println(Nolan2.equals(Nolan));
		System.out.println(Nolan2.hashCode() == Nolan.hashCode());
		
	}
}
class BankAccount 
{
	Number accountNumber = 00000000;
	String ownerName = "";
	Integer bal = 0;
	LocalDateTime CreateDate = LocalDateTime.now();
	Boolean banned = false;
	
	public BankAccount(String string) 
	{

		ownerName = string;
		String temp = "";
		for (int i = 1; i < 9; i++) 
		{
			temp += Integer.toString(0 + (int) (Math.random() * 9));
		}
		accountNumber = Integer.valueOf(temp);
	}
	
	Boolean Deposit(Integer amount) 
	{
		if(this.banned)
		{
			return false;
		}
		bal += amount;
		return(true);
	}
	
	Boolean Withdrow(Integer amount) 
	{
		if(this.banned)
		{
			return false;
		}
		if (bal < amount) 
		{
			return(false);
		}else
		{
			bal -= amount;
		return(true);
		}
	}
	
	Boolean Transfer (Integer amount, BankAccount otherAccount) 
	{
		if(this.banned)
		{
			return false;
		}
		if(this.Withdrow(amount))
		{
			otherAccount.Deposit(amount);
			return(true);
		}else
		{
			return(false);
		}
		
	}
	@Override
	public boolean equals(Object object)
	{
		if(this == object)
		{
            return true;
		}
		if(object == null || object.getClass()!= this.getClass())
		{
            return false;
		}
		BankAccount otherAccount = (BankAccount) object;
		return (otherAccount.accountNumber == this.accountNumber);
	}
    @Override
    public int hashCode()
    {
        return (int) this.accountNumber;
    }
	
	@Override
	public String toString()
	{
		return("Owner name - " + ownerName + "\n" + "balance - " + bal + "\n" + "Create date - " + CreateDate + "\n"+ "Is banned? - " + banned);
	}
}