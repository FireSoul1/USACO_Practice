/* 
ID: trunks.1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 
{
	static ArrayList<Person> names;
	public static void main(String args[])throws Exception
	{
		names = new ArrayList<Person>();
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		int count = Integer.parseInt(in.readLine());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		for(int c=0;c<count;c++)
		{
			names.add(new Person(in.readLine(),0));
		}
		while(count>0)
		{
			String i = in.readLine();
			//out.print(i+" ");
			StringTokenizer split = new StringTokenizer(in.readLine());
			int val = Integer.parseInt(split.nextToken());
			int con = Integer.parseInt(split.nextToken());
			int don = 0;
			int ex=0;
			if(con!=0)
			{
				if(val%con==0)
					don= val/con;
				else
				{
					ex = val%con;
					don = (val-(val%con))/con;
				}
			}
			names.get(find(i)).add((val*-1)+ex);
			for(int p=0;p<con;p++)
			{
				names.get(find(in.readLine())).add(don);
			}
			count--;
		}
		for(Person i:names)
		{
			out.println(i.name+" "+i.number);
		}
		
		in.close();
		out.close();
		System.exit(0);
		
	}
	public static int find(String nam)
	{
		int i=0;
		for(Person c:names)
		{
			if(c.name.equals(nam))
				return i;
			i++;
		}
		return i;
	}

}
class Person
{
	String name;
	int number;
	public Person(String i, int num)
	{
		number=num;
		name=i;
	}
	public void add(int a)
	{
		number+=a;
	}

}