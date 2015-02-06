/* 
ID: trunks.1
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.Collections;
///import java.util.StringTokenizer;

public class palsquare 
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
		int base = Integer.parseInt(in.readLine());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		if(base==10)
		{
			for(int i=1;i<=300;i++)
			{
				int c = (int)Math.pow(i,2);
				List<Character> ne = new ArrayList<Character>();
				for(char r:(c+"").toCharArray())
				{
					ne.add(new Character(r));
				}
				String u =ne.toString();
				Collections.reverse(ne);
				if(u.equals(ne.toString()))
					out.println(i+" "+c);
			}
		}
		else
		{
			for(int i=1;i<=300;i++)
			{
				int c = (int)Math.pow(i,2);
				String p = baseCon(base,c);
				
				//System.out.println(p);
				List<Character> ne = new ArrayList<Character>();
				for(char r:p.toCharArray())
				{
					ne.add(new Character(r));
				}
				String u =ne.toString();
				Collections.reverse(ne);
				if(u.equals(ne.toString()))
					out.println(baseCon(base,i)+" "+p);
			}
		}
		out.close();
		in.close();
		System.exit(0);
	}
	
	
	public static String baseCon(int bas, int num)
	{
		if(num==0)
			return "";
		else if(bas>10)
			return baseCon(bas,(num/bas)) +""+ numVal(num%bas);
		else
			return baseCon(bas,(num/bas)) +""+(num%bas);
	
	}
	public static String numVal(int i)
	{
		int in = i;
		switch(in)
		{
		
		case 10:return "A";
		case 11:return "B";
		case 12:return "C";
		case 13:return "D";
		case 14:return "E";
		case 15:return "F";
		case 16:return "G";
		case 17:return "H";
		case 18:return "I";
		case 19:return "J";
			default: return i+"";	
		}
		
	}

}
