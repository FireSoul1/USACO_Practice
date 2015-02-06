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

public class transform 
{
	
	public static void main(String[] args) throws Exception 
	{
		gotten = new boolean[7];
		//combin = new String[6];
		BufferedReader in = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int y = Integer.parseInt(in.readLine());
		char[][] inut = new char[y][y];
		char[][] com = new char[y][y];
		String first = "";
		for(int t=0;t<y;t++)
		{
			String gr = in.readLine();
			first+=gr+" ";
			int ii=0;
			for(char g:gr.toCharArray())
			{
				inut[t][ii] = g;
				ii++;
			}
		}
		String second = "";
		for(int t=0;t<y;t++)
		{
			String gr = in.readLine();
			second+=gr+" ";
			int ii=0;
			for(char g:gr.toCharArray())
			{
				com[t][ii] = g;
				ii++;
			}
		}
		
		if(second.equals(first))
			System.out.println("6");
		else
		{
			char[][] trans1 = rotate(inut,com);
			
			char[][] trans2 = rotate180(inut,com);
			char[][] trans3 = rotateNeg(inut,com);
			System.out.println(makeString(trans3));
			char[][] trans4 = reflect(inut,com);
			print(trans3);
			if(gotten[1])
				System.out.println("1");
			if(gotten[2])
				System.out.println("2");
			if(gotten[3])
				System.out.println("3");
			if(gotten[4])
				System.out.println("4");
			if(gotten[5])
				System.out.println("5");
			else
				System.out.println("7");
		}
		in.close();
		out.close();
		System.exit(0);
	}
	static boolean[] gotten;
	public static void print(char[][] free)
	{
		for(char[] r:free)
		{
			for(char rp:r)
				System.out.print(rp);
			System.out.println();
		}
	}
	public static String makeString(char[][] free)
	{
		String out = "";
		for(char[] r:free)
		{
			for(char rp:r)
				out+=rp+"";
			out+="\n";
		}
		return out;
	}
	public static char[][] rotate180(char[][] m,char[][] n)
	{
		boolean trying =true;
		char[][] c = rotate(m,n);
		char[][] temp = new char[m.length][m.length];
		for(int f=0;f<m.length/2;f++)
		{
			for(int u=f;u<m[f].length;u++)
			{
				char tem = c[0][u];	
				temp[0][u] =  c[c.length-u-1][0];
				temp[c.length-u-1][0] =  c[c.length-1][c.length-u-1];
				temp[c.length-1][c.length-u-1] =  c[u][c.length-1];
				temp[u][c.length-1]= tem;
				
			}
		}
		if(m.length%2==1)
		{
			temp[m.length/2][m.length/2] = c[m.length/2][m.length/2];
		}
		
		gotten[2]=trying;
		return temp;
	}
	public static char[][] rotate90Ref(char[][] m,char[][] n)
	{
		boolean trying =true;
		char[][] c = reflect(m,n);
		char[][] temp = new char[c.length][c.length];
		for(int f=0;f<m.length/2;f++)
		{
			for(int u=f;u<m[f].length;u++)
			{
				char tem = c[0][u];
				
				temp[0][u] =  c[m.length-u-1][0];
				temp[c.length-u-1][0] =  c[m.length-1][m.length-u-1];
				temp[c.length-1][c.length-u-1] =  c[u][m.length-1];
				temp[u][m.length-1]= tem;
				
				
			}
		}
		if(m.length%2==1)
		{
			temp[m.length/2][m.length/2] = c[m.length/2][m.length/2];
		}
		
		
		gotten[5] =trying;
		return temp;
	}
	public static char[][] rotateNeg(char[][] m,char[][] n)
	{
		boolean trying =true;
		char[][] c = rotate(m,n);
		char[][] temp =new char[m.length][m.length]; 
		c=rotate(c,n);
		for(int f=0;f<m.length/2;f++)
		{
			for(int u=f;u<m[f].length;u++)
			{
				char tem = c[0][u];
				
				temp[0][u] =  c[m.length-u-1][0];
				temp[m.length-u-1][0] =  c[m.length-1][m.length-u-1];
				temp[m.length-1][m.length-u-1] =  c[u][m.length-1];
				temp[u][m.length-1]= tem;
					
			}
		}
		if(m.length%2==1)
		{
			temp[m.length/2][m.length/2] = c[m.length/2][m.length/2];
		}
		

		
		gotten[5]=trying;
		return temp;
	}
	public static char[][] rotate(char[][] m,char[][] n)
	{
		
		boolean trying =true;
		char[][] temp = new char[m.length][m.length];
		for(int f=0;f<m.length/2;f++)
		{
			for(int u=f;u<m[f].length;u++)
			{
				char tem = m[0][u];
				
				temp[0][u] =  m[m.length-u-1][0];
				temp[m.length-u-1][0] =  m[m.length-1][m.length-u-1];
				temp[m.length-1][m.length-u-1] =  m[u][m.length-1];
				temp[u][m.length-1]= tem;
				
			}
		}
		if(m.length%2==1)
		{
			temp[m.length/2][m.length/2] = m[m.length/2][m.length/2];
		}

		
		gotten[1] = trying;
		return temp;
	}
	public static char[][] rotate270Ref(char[][] m,char[][] n)
	{
		boolean trying =true;
		char[][] temp = new char[m.length][m.length];
		for(int f=0;f<m.length;f++)
		{
			for(int u=0;u<m[f].length;u++)
			{
				temp[f][u] =  m[m.length-f-1][u];
				if(m[f][u]!=temp[f][u])
					trying =false;
			}
		}
		temp= reflect(temp,n);
		if(m.length%2==1)
		{
			temp[m.length/2][m.length/2] = m[m.length/2][m.length/2];
		}
		System.out.println(makeString(temp));
		System.out.println(makeString(m));

		
		gotten[3] = trying;
		return temp;
	}
	public static char[][] reflect(char[][] m,char[][] n)
	{
		boolean trying =true;
		char[][] temp = new char[m.length][m.length];
		for(int f=0;f<m.length;f++)
		{
			for(int u=0;u<m[f].length;u++)
			{
				temp[f][u] =  m[m.length-f-1][m.length-u-1];
				if(temp[f][u]!=m[f][u])
					trying=false;
			}
		}
		
		gotten[4] = trying; 
		return temp;
	}

}
