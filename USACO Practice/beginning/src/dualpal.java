/* 
ID: trunks.1
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class dualpal
{

	public static void main(String[] args) throws Exception
	{
		
		BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int count = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())+1;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		
		while(count>0)
		{
			int times=0;
			for(int c=2;c<=10;c++)
			{
				if(pal(baseCon(c,start)))
					times++;
			}
			if(times>=2)
			{
				out.println(start);
				count--;
			}
			start++;
		}
		
		out.close();
		in.close();
		System.exit(0);
	}
	public static boolean pal(String p)
	{
		List<Character> ne = new ArrayList<Character>();
		for(char r:p.toCharArray())
		{
			ne.add(new Character(r));
		}
		String u =ne.toString();
		Collections.reverse(ne);
		return u.equals(ne.toString());
	}
	public static String baseCon(int bas, int num)
	{
		if(num==0)
			return "";
		else
			return baseCon(bas,(num/bas)) +""+(num%bas);
	
	}
}
