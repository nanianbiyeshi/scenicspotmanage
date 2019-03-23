package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import DataStructure.Edge;
import entity.ScenicSpot;
import entity.massage;

public class Utils {
	public  static void writeObject( ArrayList<Object> ms ) {  
		  try {  
		        FileOutputStream outStream = new FileOutputStream("massage");  
		        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);   
		        objectOutputStream.writeObject(ms);  
		        outStream.close();  
		    } catch (FileNotFoundException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		}  
		public static ArrayList<Object> readObject( ){  
		    FileInputStream freader;  
		    ArrayList<Object> ms=new ArrayList<Object>();
		    try {  
		        freader = new FileInputStream("massage");  
		        ObjectInputStream objectInputStream = new ObjectInputStream(freader);    
		         ms = (ArrayList<Object>) objectInputStream.readObject();  
		     } catch (FileNotFoundException e) {  
		        e.printStackTrace();  
		     } catch (IOException e) {    
		        e.printStackTrace();  
		     } catch (ClassNotFoundException e) {  
		        e.printStackTrace();  
		     }
			return ms;  
		 }
		public  static  ArrayList<ScenicSpot>  getdata(String filename) {
			 ArrayList<ScenicSpot> Slist=new  ArrayList<ScenicSpot>();
			Stack<String> mon=new Stack<String>();
			LinkedList<Edge> head=new LinkedList<Edge>();
			File file = new File(filename);
			BufferedReader reader=null;
			try{
				reader=new BufferedReader(new FileReader(file));
				String st=null;
				int i=1;
				while((st=reader.readLine())!=null){
					System.out.println(i++);
					String [] str=st.split("¡ª¡ª");
					if( mon.isEmpty()){
						mon.push(str[0]);
					}
					if(mon.peek().equals(str[0])){
						head.addLast(new Edge(str[1],Integer.parseInt(str[2])));
					}
					else{ 
						ScenicSpot sc=new ScenicSpot(mon.pop(),true);
						sc.setEhead(head);
					    Slist.add(sc);
						head=new LinkedList<Edge>();
						mon.push(str[0]);
						System.out.println(str[0]);
						head.addLast(new Edge(str[1],Integer.parseInt(str[2])));
					}
				}	
				ScenicSpot sc=new ScenicSpot(mon.pop(),true);
				sc.setEhead(head);
			    Slist.add(sc);
			}catch(Exception e){
				e.printStackTrace();
			}
			return Slist;
			
		}
}
