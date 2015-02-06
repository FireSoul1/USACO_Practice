/* 
ID: trunks.1
LANG: JAVA
TASK: namenum
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.*;

public class namenum
{
	static TreeMap<Integer,Set<String>> replce;
	static Set<String> diction;
	public static void main(String[] args) throws Exception
	{
		diction = new TreeSet<String>();
		Scanner file = new Scanner(new File("dict.txt"));
		BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		while(file.hasNext())
		{
			String v =file.nextLine();
			diction.add(v);
			//System.out.println(v);
		}
		int index =0;
		String vals =in.readLine();
		TreeSet<String> value = new TreeSet<String>();
		TreeSet<String> temp = new TreeSet<String>();
		value.addAll(diction);
		///System.out.println(vals);
		for(char f:vals.toCharArray())
		{
			
			String poss = "";
			switch(f)
			{
			case'2':poss="A B C";break;
			case'3':poss="D E F";break;
			case'4':poss="G H I";break;
			case'5':poss="L K J";break;
			case'6':poss="M N O";break;
			case'7':poss="R S P";break;
			case'8':poss="T U V";break;
			case'9':poss="X W Y";break;
			}
			for(String t:value)
			{
				if(index<t.length())
					if(poss.contains(t.charAt(index)+""))
						temp.add(t);
			}
			value = new TreeSet<String>();
			value.addAll(temp);
			temp = new TreeSet<String>();
			index++;
		}
		if(value.size()==0)
			out.println("NONE");
		else
		{
			for(String h:value)
				if(h.length()==vals.length())
				  out.println(h);
			
		}
		
		out.close();
		in.close();
		System.exit(0);
	}
	
}
