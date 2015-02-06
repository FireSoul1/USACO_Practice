/* 
ID: trunks.1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;
public class friday 
{
	
	public static void main(String[] args) throws Exception
	{
		leap=false;
		ArrayList<Day> week = new ArrayList<Day>();
		week.add(new Day("Monday"));
		week.add(new Day("Tuesday"));
		week.add(new Day("Wednsday"));
		week.add(new Day("Thursday"));
		week.add(new Day("Friday"));
		week.add(new Day("Saturday"));
		week.add(new Day("Sunday"));
		
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int DOW = 0;
		int leaped=0;
		int change = Integer.parseInt(in.readLine());
		for(int i=1900;i<1900+change;i++)
		{
			if(i%100==0)
				leap = (i%400==0);
			else
				leap = (i%4==0);
			if(leap)
				leaped++;
			//int ex=0;
			//	System.out.println(i+" is Leap.");
			//if((1900+change-1)==i)
				//ex =1;
			for(int p=0;p<12;p++)
			{
				DOW = DOW+(13%7);
				if(DOW>6)
					DOW=DOW-(7*(DOW/7));
				
				//System.out.print(" Month "+p+" "+DOW);
				if(DOW>6)
					DOW=DOW-(7*(DOW/7));
				if(DOW==0)
					week.get(6).increment();
				else
					week.get(DOW-1).increment();
				DOW = DOW+(monthDays(p)%7);
				if(DOW>6)
					DOW=DOW-(7*(DOW/7));
			}
			//System.out.println("leaped "+leaped+" "+i);
		}
		//int sum=0;
		week.add(0,week.remove(6));
		week.add(0,week.remove(6));
		for(int i=0;i<week.size();i++)
		{
			if(i==week.size()-1)
				out.print(week.get(i)+"\n");
			else
				out.print(week.get(i)+" ");
			//sum+=c.times;
		}
		///out.print(sum);
		///out.println();
		in.close();
		out.close();
		System.exit(0);
	}
	static boolean leap;
	public static int monthDays(int mon)
	{
		switch(mon)
		{
		case 0:return 31-13;
		case 1: if(leap) {return 29-13;} else {return 28-13;}
		case 2: return 31-13;
		case 3: return 30-13;
		case 4: return 31-13;
		case 5: return 30-13;
		case 6: return 31-13;
		case 7: return 31-13;
		case 8: return 30-13;
		case 9: return 31-13;
		case 10: return 30-13;
		case 11: return 31-13;
		
		}
		return 30;
	}

}
class Day 
{
	String d;
	int times;
	public Day(String name)
	{
		times=0;
		d=name;
	}
	public void increment(){times++;}
	public String toString(){return ""+times;}
}