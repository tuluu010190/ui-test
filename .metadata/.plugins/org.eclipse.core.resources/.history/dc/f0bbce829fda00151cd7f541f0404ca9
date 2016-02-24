package org.exoplatform.selenium.platform.objectdatabase.common;
import static org.exoplatform.selenium.TestLogger.info;
import java.util.ArrayList;
import java.util.Random;

public class LinksDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> link;

	/**
	 * AttachmentFileDatabase
	 * @param type
	 * @param attachName
	 */
	public LinksDatabase(ArrayList<Integer> type, ArrayList<String> link){
		this.type = type;
		this.link = link;
	}

	/**
	 * AttachmentFileDatabase
	 */
	public LinksDatabase(){
		type  = new ArrayList<Integer>();
		link  = new ArrayList<String>();
	}

	/**
	 * setLinkDatabase
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setLinkData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			link.add(testData[i][1]);
		}
	}

	/**
	 * Get link by index
	 * @param index
	 * @return
	 */
	public String getLinkByIndex(int index){
		return link.get(index);
	}
	
	/**
	 * get Link random
	 * @return
	 */
	public String getLinkRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.link.size());
		String attachFile = this.link.get(index);
		return attachFile;
	}

	/**
	 * getArrayLinkByType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayLinkByType(int type){
		ArrayList<String> arrayLink = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				arrayLink.add(this.link.get(i));
			}
		}
		return arrayLink;
	}

	/**
	 * getArrayLinkByArrayType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayLinkByArrayType(int...type){
		ArrayList<String> arrayLink = new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayLink.add(this.link.get(i));
				}
			}
		}
		return arrayLink;
	}

	/**
	 * Get link by array type random
	 * @param type
	 * @return link
	 */
	public String getLinkByArrayTypeRandom(int...type){
		ArrayList<String> arrayLink = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayLink.add(this.link.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayLink.size());
		String link = arrayLink.get(index);
		info("link is: "+link);
		return link;
	}
}
