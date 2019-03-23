package Controller;

import java.util.ArrayList;
import java.util.Random;
import entity.ScenicSpot;

public final class Sort {
	 public static ArrayList<ScenicSpot> sort( String key,DataStructure.Graph g){
		   ArrayList<ScenicSpot> Slist1=new ArrayList<>(g.getSlist());
	    	if(key.equals("»¶Ó­¶È")) {
	    		for(int i=0;i<Slist1.size();i++) {
	    			Random rand =new Random();
	    			Slist1.get(i).setPopularity(rand.nextInt(1000));
	    		}
	    		for (int i = 1; i <Slist1.size(); i++) {
	                int j = i;
	                while (j > 0 &&Slist1.get(j).getPopularity()  < Slist1.get(j-1).getPopularity()&&Slist1.get(j-1).getFlag()&&Slist1.get(j).getFlag()) {
	                    swap(Slist1,j,j-1);
	                    j--;
	                }
	            }	
	    	}
	    	else {
	    		for (int i = 1; i <Slist1.size(); i++) {
	                int j = i;
	                while (j > 0 &&Slist1.get(j).getEhead().size()< Slist1.get(j-1).getEhead().size()&&Slist1.get(j-1).getFlag()&&Slist1.get(j).getFlag()) {
	                    swap(Slist1,j,j-1);
	                    j--;
	                }
	            }
	    		
	    	}
	    	return Slist1;
	    	
	    }
	public static void swap( ArrayList<ScenicSpot> slist1,int j,int i) {
		   ScenicSpot minddle=slist1.get(j);
		   slist1.remove(j);
		   slist1.add(j, slist1.get(i));
		   slist1.add(i,minddle);
		   slist1.remove(i+1);  
	   }

}
