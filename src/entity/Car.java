package entity;

public class Car {
	private String name;
	private  String Startime;
	private  String  Endtime;
	private  String  cnumber;
	private  int  way=0;
	
	public Car(String name, String cnumber) {
		super();
		this.name = name;
		this.cnumber = cnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartime() {
		return Startime;
	}
	public void setStartime(String startime) {
		Startime = startime;
	}
	public String getEndtime() {
		return Endtime;
	}
	public void setEndtime(String endtime) {
		Endtime = endtime;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	
	public int getWay() {
		return way;
	}
	public void setWay(int way) {
		this.way = way;
	}
	
	

}
