/* 
ID: trunks.1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class ride 
{
	public static void main(String[] args) throws Exception 
	{
		BufferedReader in = new BufferedReader(new FileReader("ride.in"));
		char[] sign =  in.readLine().toCharArray();
		char[] check = in.readLine().toCharArray();
		int prod1=1;
		int prod2=1;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		for(int c=0;c<sign.length;c++)
		{
			prod1*=((int)sign[c]-64);
			//System.out.println(prod1);
		}
		for(int y=0;y<check.length;y++)
		{
			prod2*=((int)check[y]-64);
			//System.out.println(prod2);
		}
		if((prod1%47)==(prod2%47))
			out.println("GO");
		else
			out.println("STAY");
		in.close();
		out.close();
		System.exit(0);

	}

}
