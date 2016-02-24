package org.exoplatform.selenium.platform.objectdatabase.chat;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

/**
 * @date Apr 13, 2015
 * @author anhpp
 */

public class ChatStatusDatabase {
    
	public ArrayList<String> icon;
	public ArrayList<String> status;
	public ArrayList<String> tooltip;
	public ArrayList<String> newIcon;
	public ArrayList<String> newStatus;
	public ArrayList<String> newTooltip;

	public ChatStatusDatabase(ArrayList<String> icon,
			ArrayList<String> status,ArrayList<String> tooltip){
		this.icon = icon;
		this.status = status;
		this.tooltip = tooltip;
	}

	public ChatStatusDatabase() {
		icon  = new ArrayList<String>();
		status  = new ArrayList<String>();
		tooltip = new ArrayList<String>();
		newIcon = new ArrayList<String>();
		newStatus = new ArrayList<String>();
		newTooltip = new ArrayList<String>();
	}

	public void setChatStatusData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			icon.add(testData[i][0]);
			status.add(testData[i][1]);
			tooltip.add(testData[i][1]);
		}
	}
	public String getIcon(int index){
		return icon.get(index);
	}
	public String getStatus(int index){
		return status.get(index);
	}
	public String getTooltip(int index){
		return tooltip.get(index);
	}
	

}



