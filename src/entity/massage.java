package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class massage implements  Serializable {
private String time ;
private String  mas;
public massage(String time, String mas) {
super();
this.time = time;
this.mas = mas;
}
public String getTime() {
return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getMas() {
	return mas;
}
public void setMas(String mas) {
	this.mas = mas;
}
public  static void writeObject( ArrayList<massage> ms ) {  
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
	public static ArrayList<massage> readObject( ArrayList<massage> ms){  
	    FileInputStream freader;  
	    try {  
	        freader = new FileInputStream("massage");  
	        ObjectInputStream objectInputStream = new ObjectInputStream(freader);    
	         ms = (ArrayList<massage>) objectInputStream.readObject();  
	     } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	     } catch (IOException e) {    
	        e.printStackTrace();  
	     } catch (ClassNotFoundException e) {  
	        e.printStackTrace();  
	     }
		return ms;  
	 }
}
