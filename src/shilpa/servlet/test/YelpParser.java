package shilpa.servlet.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.net.*;
import java.io.*;

public class YelpParser {

	ArrayList<NameLinkPair> result;
	public YelpParser()
	{
		result = new ArrayList<NameLinkPair>();
	}
	
	public ArrayList<NameLinkPair> parse(String url) 
	{
		try
		{
			URL webPage = new URL(url);
			BufferedReader bf = new BufferedReader(new InputStreamReader(webPage.openStream()));
			
			
			String line;
			String marker = "\"indexed-biz-name\">";
			String linkMarker = "href=\"";
			int lenLinkMark = linkMarker.length();
			
			while ((line = bf.readLine()) != null)
			{
				//System.out.println(line);
				int index = line.indexOf(marker);
				
				if (index != -1)
				{
					int indexLink = line.indexOf(linkMarker);
					indexLink+=lenLinkMark;
					int linkEnd = line.indexOf("?");
					String linkResult = line.substring(indexLink, linkEnd);
					
					int nameLink = line.lastIndexOf('"') + 2;
					int nameEnd = line.lastIndexOf('<');
					String nameResult = line.substring(nameLink, nameEnd);
					NameLinkPair res = new NameLinkPair(nameResult, linkResult);
					result.add(res);
				}
			}
			
			bf.close();
			return result;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
