package Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import entity.ScenicSpot;
import DataStructure.Graph;
public class GreatTourSortGraph {
	private  ArrayList<LinkedList<String>> paths=new ArrayList<>();
	private LinkedList<String>  path=new LinkedList<>();
	private  ArrayList<ScenicSpot> Slist;
	private int size=0;
	public GreatTourSortGraph(Graph g) {
		super();
		Slist = new ArrayList<ScenicSpot>(g.getSlist());
		this.size = g.getSize();
	}
	
	public ArrayList<LinkedList<String>> getPaths() {
		return paths;
	}
	
	
	public void setPaths(ArrayList<LinkedList<String>> paths) {
		this.paths = paths;
	}
	
	public LinkedList<String> getPath() {
		return path;
	}
	
	public void setPath(LinkedList<String> path) {
		this.path = path;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public  void TourSortGraph(String start ,String end) {
	       ScenicSpot sd=Finds(start);
	       if(path.size()==0)
	    	  path.addLast(start);
	       sd.setVicture(true);
	       for(int i=0;i<sd.getEhead().size();i++) {
		    ScenicSpot sd1=Finds(sd.getEhead().get(i).getSfont());
		    if(sd1.getFlag()) {
		     
		    	if(!sd1.getVicture()||sd1.getName().equals(end)) {
			  
		    	 path.addLast(sd1.getName());
			   if(sd1.getName().equals(end))
			   { 
				   paths.add(path);
			   
				   LinkedList<String> sn=path;
				   path=new LinkedList<String>();
				   path.addAll(sn);
			   }
			   else {
				   TourSortGraph(sd1.getName(), end);
				   sd1.setVicture(false);
			   }
			   path.removeLast(); }}
	   }
	  }
	public String GreatTourtSortGraph1(String start,String end) {
		  rset();
		  paths.clear();
		  path.clear();
		  if(Finds(start)==null) return "起点输入有误";
		  if(Finds(end)==null) return "终点输入有误";
		   TourSortGraph(start,end);
		   int min;
		   int flag=0;
		   if(start.equals(end))
			   flag=size+1;
		   else
			   flag=size;
		   for(int i=0;i<paths.size();i++) {
			     min=0;
			     if(paths.get(i).size()>=size) {
			      for(int h=0;h<paths.get(i).size()-1;h++) {
				  min=min+Calcualate(paths.get(i).get(h),paths.get(i).get(h+1));
			      }
			      paths.get(i).addLast(String.valueOf(min));}
		          }
		   
		  for(int i=0;i<getPaths().size();i++) {
			   System.out.println(getPaths().get(i).toString());
		         }
		     path=min(flag);
		     System.out.println(path.toString());
		  if(path.size()>=size)
		    return "success";
		   else
		    return "从"+start+"到"+end+"不存在导游路线图";
	}
	public int Calcualate(String s,String e) {
		ScenicSpot ss=Finds(s);
		for(int i=0;i<ss.getEhead().size();i++) {
			if(ss.getEhead().get(i).getSfont().equals(e))
				return ss.getEhead().get(i).getWeight();
		}
		return 0;
	}
	public LinkedList<String> min(int h){
		LinkedList<String> m=new LinkedList<>();
		int min=Integer.MAX_VALUE;
		for(int i=0;i<paths.size();i++) {
			if(paths.get(i).size()>h) {
			if(Integer.parseInt(paths.get(i).getLast())<min) 
				    {
					min=Integer.parseInt(paths.get(i).getLast());
					m=paths.get(i);}	
	      }
		}
		return m;	
	}
	public void rset(){
		for(int i=0;i<Slist.size();i++){
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
	
	
	
	
	
	
	
	

}
