package sightCrawler;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KeelungSightsCrawler {
	public Sight[] getItems(String area) {
		String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";	
		Sight[] sight = null;
		int number=0;
		
		try {
			Document doc = Jsoup.connect(url).timeout(150000).get();
			Elements areaList = doc.select("div.box ul");
			//System.out.print(areaList.get(1));
			//doc.select("div.box ul a").forEach(System.out::println);
			
			if (area.indexOf("七堵") != -1)
				number = 1; 
			else if(area.indexOf("中山") != -1)
				number = 2;
			else if(area.indexOf("中正") != -1)
				number = 3;
			else if(area.indexOf("仁愛") != -1)
				number = 4;
			else if(area.indexOf("安樂") != -1)
				number = 5;
			else if(area.indexOf("信義") != -1)
				number = 6;
			else if(area.indexOf("暖暖") != -1)
				number = 7;
			
			
			areaList = areaList.get(number).select("a"); //select area			
			List<String> viewArr = areaList.eachAttr("href"); //view list
			//System.out.println(viewArr.get(2));
			// click it to redirect
			sight = new Sight[viewArr.size()];
			for(int i=0; i < viewArr.size(); i++) {
				
				sight[i] = new Sight();
				//System.out.println(viewArr.get(i));
				//System.out.print("https://www.travelking.com.tw"+viewArr.get(i));
				Document view =  Jsoup.connect("https://www.travelking.com.tw"+viewArr.get(i)).get();
				
				//sightName, zone, category,photoURL, description, address
				String name = view.select("h1 span").text();
				//System.out.println(name);
				String category = view.select("span strong").text();
				Element photoImg = view.select("div.gpic img").first();
				String photoURL;
				if(photoImg == null) {
					photoURL = "null";						
				}
				else {
					photoURL = photoImg.absUrl("data-src");	
				}
								
				
				view.select("div.author").remove(); //.removeClass("div.author")
				String description = view.select("div.text").first().text();			
				
				String address = view.select("div.address span").text();
				//content = content.select("[itempop=name]");
				//System.out.println(name+category+photoURL+description+address);
				//System.out.println(zone);
									
				sight[i].setSightName(name);										
				sight[i].setZone(area+"區");
				sight[i].setCategory(category);
				sight[i].setPhotoURL(photoURL);
				sight[i].setDescription(description);
				sight[i].setaddress(address);
									
			}
			
			//System.out.print(viewUrl.attr("href"));//areaList.get(1).attr("href");//.forEach(System.out::println);
			
			/*Elements areaList = doc.select("div.box");
			areaList = areaList.select("h4");//.forEach(System.out::println);
			areaList.select("a[href]").forEach(System.out::println);*/
			} catch (IOException ex) {
				ex.printStackTrace();
				//System.out.print("error~~~");
			}
		/*for (Sight s: sight) {
			
			System.out.println(s);
			
		}*/
		return sight;
	}
}
