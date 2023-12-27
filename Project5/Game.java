package assignment5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Game
{
	int guesses;
	boolean result,testing;
	ArrayList<String> history;
	public Game(boolean testingMode)
	{
		this.guesses=GameConfiguration.guessNumber;
		this.result=false;
		this.testing=testingMode;
		this.history=new ArrayList<>();
	}

	public boolean isValid(String user_guess)
	{
		int length=user_guess.length();
		String upper=user_guess.toUpperCase();

		if(length!=GameConfiguration.pegNumber)
		{
			return false;
		}
		else if(!user_guess.equals(upper))
		{
			return false;
		}
		else
		{
			for(int i=0;i<length;i++)
			{
				char ch=user_guess.charAt(i);
				if(ch!='B' && ch!='G' && ch!='O' && ch!='P' && ch!='R' && ch!='Y')
				{
					return false;
				}
			}
		}
		return true;
	}
	boolean invalid=false;

	public boolean guesscheck(String line, String secretcode)
	{
		boolean result=false;
		Peg peg=new Peg(0,0);
		String s=peg.implement(line, secretcode);
		history.add(s);

		if(peg.black==4 && peg.white==0)
		{
			result=true;
//			win_str=s;
//			break;
		}
		return result;

	}

	public void runGame(Scanner sc)
	{
		System.out.print("You have "+ GameConfiguration.guessNumber+" guesses to figure out the secret code or you lose the "
				+ "game. Are you ready to play? (Y/N): ");
		sc=new Scanner(System.in);
		String input = sc.nextLine();

		if(input.equals("N"))
		{
			return;
		}
		else if(!input.equals("Y"))
		{
			System.out.println("Wrong choice\n Type Y or N");
			runGame(sc);
		}

		System.out.print("Generating secret code ...");


		String code=SecretCodeGenerator.getInstance().getNewSecretCode();
		if(testing==true)
		{
			System.out.print("...(for this example the secret code is "+code+")");
		}

		System.out.println("\n");

		String win_str="";



		while(guesses>0)
		{
			if(invalid==false)
			{
				System.out.println("You have " + guesses+ " guesses left.");
			}
			System.out.println("What is your next guess?\nType in the characters for your guess and press enter." );
			System.out.print("Enter guess: ");
			String user_guess=sc.nextLine();
			System.out.println();
			//System.out.println(user_guess);
			if(user_guess.equals("HISTORY"))
			{
				for(int i=0;i<history.size();i++)
				{
					System.out.println(history.get(i));
				}
				System.out.println();
			}
			else if(!isValid(user_guess))
			{
				System.out.println(user_guess + " -> INVALID GUESS\n");
				invalid=true;
				continue;
			}

			else
			{
				invalid=false;
				Peg peg=new Peg(0,0);
				String s=peg.implement(user_guess, code);
				history.add(s);

				if(peg.black==4 && peg.white==0)
				{
					result=true;
					win_str=s;
					break;
				}

				guesses--;
				if(guesses>0)
				{
					System.out.println("\n");
				}
			}

		//code for pegs


		}
		if(result)
		{
			System.out.println("- You win !!\n");
		}
		else
		{
			System.out.println("- Sorry, you are out of guesses. You lose, boo-hoo.\n");
		}
		System.out.print("Are you ready for another game (Y/N): ");

		Game h=new Game(false);
		input = sc.nextLine();
		System.out.println();
		if(input.equals("N"))
		{
			return;
		}
		else if(input.equals("Y"))
		{
			h.runGame(sc);

		}











	}

}
