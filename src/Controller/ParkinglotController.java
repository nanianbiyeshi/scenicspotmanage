package Controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import com.ibm.icu.text.SimpleDateFormat;
import entity.Car;
import 	DataStructure.Stack;
import DataStructure.queue;

public  class ParkinglotController {
	private  Stack<Car> parkinglot;
	private  queue<Car> shortcut;
	private  queue<Car>  temporystr;
	private     int size;
	ArrayList<String>  massag1=new ArrayList<String>();
	public   ParkinglotController() {
		super();
		parkinglot=new Stack<>(5);
		shortcut=new queue<>(100);
		temporystr=new queue<Car>(20);
		size=0;
	}
	public Stack<Car> getParkinglot() {
		return parkinglot;
	}
	public void setParkinglot(Stack<Car> parkinglot) {
		this.parkinglot = parkinglot;
	}
	public queue<Car> getShortcut() {
		return shortcut;
	}
	public void setShortcut(queue<Car> shortcut) {
		this.shortcut = shortcut;
	}
	public ArrayList<String> into(Car c) {
		  massag1.clear();
		if(!Find(c.getCnumber())) 
		{
		    if(!parkinglot.isfull()) {
			Date date=new Date();
		      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd  hh:mm:ss ");
		      c.setStartime(ft.format(date));
			parkinglot.push(c);
			size++;
			massag1.add(c.getCnumber());
			massag1.add(c.getStartime());
			massag1.add(String.valueOf(size));
			}
		   else {
			shortcut.push(c);
			String s="停车场已满车辆在进入便道等待";
			massag1.add(s);
		     }
		}
		else {
			String s="该车已在停车场中";
		    massag1.add(s);}
		     return massag1;
	}
	public void report() {
		
	}
	public boolean Find(String s) {
		Boolean flag=false;
		 while(!parkinglot.isempty()) {
			  Car ss=parkinglot.pop();
			  temporystr.push(ss);
			 if(ss.getCnumber().equals(s)) {
				flag=true;
				break;
			 }		
		   }
		 while(!temporystr.isempty()) {
			parkinglot.push(temporystr.pop());
		 }
		return flag;
	}
	public ArrayList<String> Leave(String  cnumber) throws ParseException {
		ArrayList<String>  massag=new ArrayList<String>();
		 massag1.clear();
		 massag.clear();
		 int flag=0;
		 while(!parkinglot.isempty()) {
			Car s=parkinglot.pop();
			if(s.getCnumber().equals(cnumber)) {
				Date date=new Date();
			    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd  hh:mm:ss");
				s.setEndtime(ft.format(date));
				massag.add(s.getCnumber());
				String f=claculate(s.getStartime(),s.getEndtime());
				massag.add(s.getEndtime());
				massag.add(f);
				size--;
				flag=1;
				break;
			 }
			temporystr.push(s);		
		   }
		  while(!temporystr.isempty()) {
			parkinglot.push(temporystr.pop());
		   }
		   if(flag!=1) {
			String  sr="该车不在停车场中";
			massag.add(sr);}
		  if(!shortcut.isempty()) {
			into(shortcut.pop());
		  }
		  return massag;
	}
	public String claculate(String  start,String end ) throws ParseException {
		 SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd  hh:mm:ss");  
		 long from = ft.parse(start).getTime();
		 long to = ft.parse(end).getTime();
		 float hours = (float) ((to - from)/(1000*60));
		 float money=0;
		 if(hours>1)
		  money =(hours-1)*5+10;
		 else
			 money=10;
		 return hours+"," +money;
	  }
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ArrayList<String> getMassag1() {
		return massag1;
	}
	public void setMassag1(ArrayList<String> massag1) {
		this.massag1 = massag1;
	}
	
}
