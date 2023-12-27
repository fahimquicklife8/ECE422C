package assignment5;

import java.util.ArrayList;

public class Peg 
{
	int white, black;
	public Peg(int white, int black)
	{
		this.white=white;
	}
	
	public String implement(String guess, String secretcode)
	{
		//System.out.println(secretcode);
		for(int i=0;i<guess.length();i++)
		{
			char ch=guess.charAt(i);
			if (secretcode.contains(String.valueOf(ch)))
			{
				//System.out.print(ch +" ");
				
				white++;
			}
			
		}
		
		for(int i=0;i<guess.length();i++)
		{
			char ch=guess.charAt(i);
			if(ch==secretcode.charAt(i))
			{
				black++;
			}
			
		}
		white=white-black;
		String guess_result=guess + " -> Result: " + black + "B_" + white + "W";
		String str=guess+"\t\t"+ black + "B_" + white + "W";
		
		System.out.println(guess_result);
		return str;
		
	}

}
