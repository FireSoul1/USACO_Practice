import java.io.*;
import java.util.*;
/*ID: trunks.1
 * PROG: greedy gift givers
 * LANG: JAVA
 * */

public class present 
{
	static ArrayList<Person> names;
	public static void main(String args[])throws Exception
	{
		names = new ArrayList<Person>();
		Scanner in = new Scanner(new File("names.dat"));
		int count = in.nextInt();
		for(int c=0;c<=count;c++)
		{
			names.add(new Person(in.nextLine(),0));
		}
		while(in.hasNext())
		{
			String i = in.nextLine();
			System.out.print(i+" ");
			String[] split = in.nextLine().split(" ");
			int val = Integer.parseInt(split[0]);
			int con = Integer.parseInt(split[1]);
			int don = 0;
			if(con!=0)
				don= val/con;
			names.get(find(i)).add(val*-1);
			for(int p=0;p<con;p++)
			{
				names.get(find(in.nextLine())).add(don);
			}
			
		}
		for(Person i:names)
		{
			System.out.println(i.name+" "+i.number);
		}
		in.close();
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