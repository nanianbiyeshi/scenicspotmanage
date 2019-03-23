package DataStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import DataStructure.Edge;
import entity.ScenicSpot;
public class Graph {
	private  ArrayList<ScenicSpot> Slist;
	private Object[][] matrix ;
	private int size=0;
	public Graph() {
		super();
		Slist=new ArrayList<ScenicSpot>();
	} 
	public void GreatGraph( String name ) {
		this.Slist=utils.Utils.getdata(name);
			int am=1;
			for(int i=0;i<Slist.size();i++) {
				Iterator<Edge> s=Slist.get(i).getEhead().iterator();
				while(s.hasNext()) {
					Edge sd=s.next();
					System.out.println( Slist.get(i).getName()+ "！！" +sd.getSfont()+"！！"+sd.getWeight() );
					System.out.println(am);
					am++;
				}
			}
			size=Slist.size();
		}
	public Object[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(Object[][] matrix) {
		this.matrix = matrix;
	}
	public void  OutputtGraph( ) {
		matrix=new Object[Slist.size()+1][Slist.size()+1];
		for(int i=0;i<Slist.size();i++) {
			for(int h=0;h<Slist.size();h++) {
				if(Slist.get(i).getFlag()==false) {
					matrix[i+1][h+1]=32767;
					if(i==h)
						matrix[i+1][h+1]=0;
				}
				else
				{
					if(i+1==h+1) 
						matrix[i+1][h+1]=0;
					else
						matrix[i+1][h+1]=find(Slist.get(h).getName(),Slist.get(i));
				}
			}
		 }	
		for(int i=1;i<Slist.size()+1;i++) {
			matrix[0][i]=Slist.get(i-1).getName();
		}
		for(int i=1;i<Slist.size()+1;i++) {
			matrix[i][0]=Slist.get(i-1).getName();
		}
	}
	public int find(String snme,ScenicSpot sct) {
		Iterator<Edge> s=sct.getEhead().iterator();
		while(s.hasNext()) {
			Edge e=s.next();
			if(e.getSfont().equals(snme)&&Finds(e.getSfont()).getFlag())
				return e.getWeight();
		}
		return 32767;	
	}
	public ArrayList<ScenicSpot> getSlist() {
		return Slist;
	}
	public void setSlist(ArrayList<ScenicSpot> slist) {
		Slist = slist;
	}
	public ScenicSpot Finds(String Sname) {
		for (ScenicSpot sd:Slist) {
			if(sd.getName().equals(Sname)&&sd.getFlag())
			return sd;
		}
		return null;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void InsertEdge1(String sname1,String sname,int weight) {
		if(Finds(sname1)!=null)
		{ 
			ScenicSpot sd=Finds(sname1);
		   if(Finds(sname)==null) {
			 Slist.add(  new ScenicSpot(sname,true));
			 insertinto(sd,sname,weight);
			 size++;
			 }
		     insertinto(sd,sname,weight);
		}
		else {
			ScenicSpot sd=new ScenicSpot(sname1,true);
			Slist.add(sd);
			if(Finds(sname)==null) {
				 insertinto(sd,sname,weight);
				 Slist.add(  new ScenicSpot(sname,true));
				 size++;
				 }
		   insertinto(sd,sname,weight);
		}	
	}
   private  void insertinto( ScenicSpot sd,String sname,int weight)	{
	   int h=0;
		 for(int i=0;i<sd.getEhead().size();i++) {
			 if(sd.getEhead().get(i).getSfont().equals(sname)) {
				 h=-1;
				 break;
			 }
		 }
		 if(h!=-1) {
			 sd.getEhead().add(new Edge(sname,weight)) ;
		 }	 
	}
    public  void  remove(String sname) {
    	Finds(sname).setFlag(false);
    	size--;
    }
}
