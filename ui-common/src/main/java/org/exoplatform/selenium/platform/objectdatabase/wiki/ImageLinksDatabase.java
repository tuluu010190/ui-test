package org.exoplatform.selenium.platform.objectdatabase.wiki;
import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ImageLinksDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> links;

	/**
	 * ImageLinkDatabase
	 * @param type
	 * @param links
	 */
	public ImageLinksDatabase(ArrayList<Integer> type, ArrayList<String> links){
		this.type = type;
		this.links = links;
	}

	/**
	 * Create array
	 */
	public ImageLinksDatabase(){
		type  = new ArrayList<Integer>();
		links  = new ArrayList<String>();
	}

	/**
	 * Set data
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			links.add(testData[i][1]);
		}
	}

	
	
	/**
	 * Get link by random
	 * @return linkFile
	 */
	public String getLinksRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.links.size());
		String linkFile = this.links.get(index);
		return linkFile;
	}

	/**
	 * Get links by type
	 * @param type
	 * @return array
	 */
	public ArrayList<String> getLinksByType(int type){
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				array.add(this.links.get(i));
			}
		}
		return array;
	}

	/**
	 * Get link by array type
	 * @param type
	 * @return
	 */
	public ArrayList<String> getLinksByArrayType(int...type){
		ArrayList<String> array = new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.links.get(i));
				}
			}
		}
		return array;
	}

	public String getLinksByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.links.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String links = array.get(index);
		info("links is: "+links);
		return links;
	}
}
