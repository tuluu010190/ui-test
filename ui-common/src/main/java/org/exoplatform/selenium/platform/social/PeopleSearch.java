package org.exoplatform.selenium.platform.social;

import org.openqa.selenium.By;
import static org.exoplatform.selenium.TestLogger.info;

/*--@Author: VuNA  
 *--@date: 08/11/2012   
 *--Common functions for SOCIAL 
 *--Part: Search people
 *--*/
public class PeopleSearch extends SocialBase{

	//Go to username link -> Find Connections

	//Search people by name
	public final By ELEMENT_NAME_OF_PEOPLE = By.id("Search");

	//Search people by position
	public final By ELEMENT_ROLE_OF_PEOPLE = By.id("position");
	//By ELEMENT_ROLE_OF_PEOPLE = By.xpath("//*[@id='position']");

	//Search people by skill
	public final By ELEMENT_SKILL_OF_PEOPLE = By.id("skills");
	//By ELEMENT_SKILL_OF_PEOPLE = By.xpath("//*[@id='skills']");   

	//Search people by directory
	public final String ELEMENT_DIRECTORY_OF_PEOPLE = "//*[@id='DirectorySpaces']/li/a[text()='${directoryPeople}']";

	//public final By ELEMENT_SEARCH_BUTTON = By.id("SearchButton");
	
	/**
	 * 
	 * @param type: Search by Name/Role/Skill or Directory
	 * @param inputSearch:
	 * by name: inputSearch -> name of People;
	 * by role/position: inputSearch -> role of People;
	 * by skill: inputSearch -> skill of People;
	 * by directory: inputSearch -> input an alphabet: A,B,C ...
	 * 
	 */
	public void searchPeople(searchType type, String inputSearch){
		info("-- Searching people ... --");
		switch (type) {
		case NAME:
			type(ELEMENT_NAME_OF_PEOPLE, inputSearch, true);
			click(ELEMENT_SEARCH_BUTTON);
			break;
		case ROLE:
			type(ELEMENT_ROLE_OF_PEOPLE, inputSearch, true);
			click(ELEMENT_SEARCH_BUTTON);
			break;	
		case SKILL:
			type(ELEMENT_SKILL_OF_PEOPLE, inputSearch, true);
			click(ELEMENT_SEARCH_BUTTON);
			break;
		case DIRECTORY:
			click(ELEMENT_DIRECTORY_OF_PEOPLE.replace("${directoryPeople}", inputSearch));
			break;
		default:
			break;
		}
	}

	public void searchPeopleAdvance(boolean searchName, String inputName,
			                               boolean searchRole, String inputRole,
			                               boolean searchSkill,String inputSkill){
		info("-- Searching people ... --");
		if (searchName && searchRole){
			type(ELEMENT_NAME_OF_PEOPLE, inputName, true);
			type(ELEMENT_ROLE_OF_PEOPLE, inputRole, true);
		}else if (searchName && searchSkill){
			type(ELEMENT_NAME_OF_PEOPLE, inputName, true);
			type(ELEMENT_SKILL_OF_PEOPLE, inputSkill, true);
		}else if (searchRole && searchSkill){
			type(ELEMENT_ROLE_OF_PEOPLE, inputRole, true);
			type(ELEMENT_SKILL_OF_PEOPLE, inputSkill, true);
		}
		/*else {
			type(ELEMENT_NAME_OF_PEOPLE, inputName, true);
			type(ELEMENT_ROLE_OF_PEOPLE, inputRole, true);
			type(ELEMENT_SKILL_OF_PEOPLE, inputSkill, true);
		}*/
		click(ELEMENT_SEARCH_BUTTON);
	}
	
	//Define a type of search 
	public enum searchType {
		NAME, ROLE, SKILL, DIRECTORY;
	}

}
