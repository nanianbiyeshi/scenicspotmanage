package DataStructure;

import java.util.NoSuchElementException;

public class queue<Type> {
	private static final int Dec=10;
	private Type[] elements;
	private int fornt;
	private int  rear;
	@SuppressWarnings("unchecked")
	public queue(){
		fornt=rear=0;
		elements=(Type[]) new Object[Dec];
	}
	@SuppressWarnings("unchecked")
	public queue(int nom){
		fornt=rear=0;
		elements=(Type[]) new Object[nom];
	}
	public boolean isempty(){
		return fornt==rear;
	}
	public boolean isfull(){
		return (rear+1)%elements.length==fornt;
	}
	public void push(Type item){
		if(isfull())
			throw new ArrayIndexOutOfBoundsException();
		rear=(rear+1)%elements.length;
		elements[rear]=item;
	}
    public Type pop(){
    	if(isempty())
    		throw new NoSuchElementException();
    	fornt=(fornt+1)%elements.length;
    	Type p=elements[fornt];
    	return p;
    }
	
	
	
	
	
	
	
	
}
 