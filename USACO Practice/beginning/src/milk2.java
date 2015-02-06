/* 
ID: trunks.1
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class milk2 
{
	
	public static void main(String args[])throws Exception
	{
		ArrayList<Integer> st = new ArrayList<Integer>();
		ArrayList<Integer> sop = new ArrayList<Integer>();

		ArrayList<Integer> stDub = new ArrayList<Integer>();
		ArrayList<Integer> sopDub = new ArrayList<Integer>();

		
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		int count = Integer.parseInt(in.readLine());
		boolean[] farmers = new boolean[1000000];
		
		int min =Integer.MAX_VALUE;
		int max =Integer.MIN_VALUE;
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		for(int co=0;co<count;co++)
		{
			StringTokenizer split = new StringTokenizer(in.readLine());
			int ii =Integer.parseInt(split.nextToken());
			min = Math.min(min, ii);
			int cc = Integer.parseInt(split.nextToken());
			max = Math.max(cc,max);

			for (int c =ii; c<cc; c++)
	        {
	            farmers[c]=true;
	        }
		}
	
		int idle=0;
		int work=0;
		int temp=0;
		int tempI=0;
		 for (int i = min; i<max;i++)
	        {
	            if (farmers[i])
	            {
	                tempI=0;
	                temp++;
	                if (temp>work)
	                    work=temp;
	            }
	            else
	            {
	                temp=0;
	                tempI++;
	                if (tempI>idle)
	                    idle=tempI;
	            }
	            
	        }	
	    out.println((work)+" "+idle);
	    out.close();
	    in.close();
		System.exit(0);
	}
}