package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import   DataStructure.Edge;
public class ScenicSpot {
	private String name;
	private String Introduction;
	private  Boolean flag;
	private String fontSpot;
	private Boolean Victure;
	private  LinkedList<Edge>  Ehead;
	private  int louteamoute =0;
	private  int popularity =0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getFontSpot() {
		return fontSpot;
	}
	public void setFontSpot(String fontSpot) {
		this.fontSpot = fontSpot;
	}
	public Boolean getVicture() {
		return Victure;
	}
	public void setVicture(Boolean victure) {
		Victure = victure;
	}
	
	public LinkedList<Edge> getEhead() {
		return Ehead;
	}
	public void setEhead(LinkedList<Edge> ehead) {
		Ehead=ehead;
	}
	
	public ScenicSpot(String name, Boolean flag) {
		super();
		this.name = name;
		this.flag = flag;
		this.fontSpot = null;
		Victure = false;
		Ehead = new  LinkedList<Edge>();
	}
	public int getLouteamoute() {
		return louteamoute;
	}
	public void setLouteamoute(int louteamoute) {
		this.louteamoute = louteamoute;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}
