package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class SievePrime
{
	private int upperBound;
	private boolean[] isComposite;
	
	public SievePrime(int val)
	{
		if (val > Integer.MAX_VALUE)
		{
			this.upperBound = Integer.MAX_VALUE;
		}else {
			this.upperBound = val;
		}
		this.isComposite = new boolean[val];
	}
	
	public void sieve()
	{
		isComposite[0] = true;
		isComposite[1] = true;
		isComposite[2] = false;
		for (int i = 4; i <  upperBound; i+=2)
		{
			isComposite[i] = true;
		}
		int upperBoundSqrtRoot = (int)Math.sqrt(upperBound * 1.0);		
		for (int i = 3; i < upperBoundSqrtRoot; i++)
		{
			if (!isComposite[i])
			{
				for (int j = i * i; j < upperBound; j += 2 * i)
				{
					isComposite[j] = true;
				}
			}
		}
		
	}
	
	public void displayPrimes()
	{
		
		try
		{
			File file = new File("primes.txt");
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
			for (int i = 0; i <  isComposite.length; i++)
			{
				if (!isComposite[i])
				{
					System.out.println(i);
					pw.println(i);
				}
			}
			pw.flush();
			pw.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SievePrime sp = new SievePrime(2000000);
		sp.sieve();
		sp.displayPrimes();
	}

}
