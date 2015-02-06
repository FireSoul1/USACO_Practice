/* 
ID: trunks.1
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

import org.omg.CORBA.SystemException;


public class beads 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int mid  = Integer.parseInt(in.readLine());
		String input =  in.readLine();
		String neck = input+input;
		//System.out.print(input.length());
		int max = Integer.MIN_VALUE;
		if(input.indexOf('b')==-1||input.indexOf('r')==-1)
			max=mid;
		else
		{
			for(int y=0;y<mid;y++)
			{
				boolean stopR=false;
				boolean stopL=false;
				char lef = neck.charAt(mid-1);
				char rig = neck.charAt(mid);
				int range = 0;
				int red=1;
				int blue=1;
				if(lef=='w')
				{
					int i = neck.substring(0,mid).lastIndexOf('r');
					int j = neck.substring(0,mid).lastIndexOf('b');
					if(j<i)
					{
						red+=(mid-i);
						stopL=true;
					}
					else
					{
						blue+=(mid-j);
						stopL=true;
					}
		//			System.out.println(red+" "+blue);		
				}
				if(rig=='w')
				{
					int i = neck.substring(mid).indexOf('r');
					int j = neck.substring(mid).indexOf('b');
					if(j>i)
					{
						red+=i;
						stopR=true;
					}
					else
					{
						blue+=j;
						stopR=true;
					}
					//System.out.println(red+" "+blue);
				}
				
				if(rig=='r')
				{
					while(!stopR || !stopL)
					{
						//if(y==0)
							//System.out.println(red+" "+blue);
						range++;
						if((neck.charAt(mid+range)!='r') && (neck.charAt(mid+range)!='w') )
						{
							stopR=true;
						}
						if(!stopR)
						{
							red++;
						}
					
						if((neck.charAt(mid-range-1)!='b') && (neck.charAt(mid-range-1)!='w'))	
						{
							stopL=true;
						}
						if(!stopL)
						{
							blue++;
						}
						
					}
					//if(y==0)
						//System.out.println(neck+" ");
				}
				else if(rig=='b')
				{
					while(!stopR || !stopL)
					{
						//if(y==0)
							//System.out.println("LOOP 2");
						range++;
						if((neck.charAt(mid+range)!='b') && (neck.charAt(mid+range)!='w') )
						{
							stopR=true;
						}
						if(!stopR)
						{	
							blue++;
						}
						if((neck.charAt(mid-range-1)!='r') && (neck.charAt(mid-range-1)!='w'))	
						{
							stopL=true;
						}
						if(!stopL)
						{
							red++;
						}
						
					}
				}
				//if(red<0 || blue<0)
				//out.println("Count:"+range+"   "+red+"   "+blue);
				if((red+blue)<=mid)
					max = Math.max(max,(red+blue));
				//System.out.println();
				//if(y==1)
				//System.out.println(neck+" ");
				neck = neck.charAt(neck.length()-1)+ neck.substring(0,neck.length()-1);
			}
			
		}
		out.println(max);
		
		in.close();
		out.close();
		System.exit(0);
	}

}
