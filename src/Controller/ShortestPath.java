package Controller;

import java.util.ArrayList;
import java.util.Stack;
import entity.ScenicSpot;
import DataStructure.Graph;
public  class ShortestPath {
	private int ShortestDistance=0;
	private  ArrayList<ScenicSpot> Slist;
	private Stack<String> route=new Stack<>();
	
	public ShortestPath(Graph g) {
		super();
		Slist = new ArrayList<ScenicSpot>(g.getSlist());
	}

	public void rset(){
		for(int i=0;i<Slist.size();i++){
			Slist.get(i).setLouteamoute(Integer.MAX_VALUE);
			Slist.get(i).setVicture(false);
			Slist.get(i).setFontSpot(null);
		}
		
	}
	
	public ScenicSpot Finds(String Sname) {
		for (ScenicSpot sd:Slist) {
			if(sd.getName().equals(Sname)&&sd.getFlag())
			return sd;
		}
		return null;
	}
	public String  Shottes(String h1,String h2) {
		rset();
		route.clear();
		ScenicSpot s1;
		ScenicSpot s2;
		int j=0;
		int size=Slist.size();
		int min ;
		int lable=-1;
		String ru=h2;
		if((s1=Finds(h1))==null){System.out.println("您的输入有误");return "您的输入有误" ;}
		if((s2=Finds(h2))==null){System.out.println("您的输入有误");return "您的输入有误";}
		for(int m=0;m<s1.getEhead().size();m++) {
			String str=s1.getEhead().get(m).getSfont();
			if(Finds(str)!=null) {
			Finds(str).setLouteamoute(s1.getEhead().get(m).getWeight());
			Finds(str).setFontSpot(h1);	}
		}
        s1.setVicture(true);
		s1.setLouteamoute(0);
		while(j<size-1) {
			int h=0;
			min=Integer.MAX_VALUE;
			for(int i=0;i<size;i++) {
				if(Slist.get(i).getFlag()&&!Slist.get(i).getVicture()&&Slist.get(i).getLouteamoute()<min) {
					h++;
					min=Slist.get(i).getLouteamoute();
					lable=i;
				}
			}
			if(h==0) break;
			Slist.get(lable).setVicture(true);
			ScenicSpot ssf=Slist.get(lable);
			for(int i=0;i<ssf.getEhead().size();i++) {
				String str =ssf.getEhead().get(i).getSfont();
				ScenicSpot ss=Finds(str);
				if(ss!=null) {
				if(ss!=null&&!Finds(str).getVicture()) {
					if(ss.getLouteamoute()>ssf.getEhead().get(i).getWeight()+ssf.getLouteamoute()) {
						ss.setLouteamoute(ssf.getEhead().get(i).getWeight()+ssf.getLouteamoute());
						ss.setFontSpot(ssf.getName());
					}
				}
			}}
			j++;
		}
		route.push(h2);
		while(!((ru=Finds(ru).getFontSpot())==null)){
			route.push(ru);
		}
		ShortestDistance=Finds(h2).getLouteamoute();
	  return "success";		
	}
	public String recover_route(String h){
		String stri="";
		String mid=null;
		while(!route.isEmpty())
		{
			mid=route.pop();
			if(mid.equals(h)){
			 stri= stri+mid;
			}
			else
		    stri= stri+mid+"——";
		}
		return stri;	
	}

	public int getShortestDistance() {
		return ShortestDistance;
	}

	public void setShortestDistance(int shortestDistance) {
		ShortestDistance = shortestDistance;
	}

	public ArrayList<ScenicSpot> getSlist() {
		return Slist;
	}

	public void setSlist(ArrayList<ScenicSpot> slist) {
		Slist = slist;
	}

	public Stack<String> getRoute() {
		return route;
	}

	public void setRoute(Stack<String> route) {
		this.route = route;
	}	
	
}
