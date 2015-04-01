package org.exoplatform.selenium.platform.objectdatabase.ecms;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SiteExplorerContentTypesDatabase {
	public ArrayList<String> contentType;

	public SiteExplorerContentTypesDatabase(ArrayList<String> contentType){
		this.contentType = contentType;
	}

	public SiteExplorerContentTypesDatabase() {
		contentType  = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			contentType.add(testData[i][0]);
		}
	}
	
	public String getContentByIndex(int index){
		info("path of site explorer is: "+contentType.get(index));
		return contentType.get(index);
	}

	public String getContentRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.contentType.size());
		info("path of site explorer is: "+contentType.get(index));
		return this.contentType.get(index);
	}
}