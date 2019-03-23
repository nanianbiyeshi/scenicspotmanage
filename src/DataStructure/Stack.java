package DataStructure;

import java.util.NoSuchElementException;

public class Stack  <Type>{
	private Type[] elements;
	private int top;
	@SuppressWarnings("unchecked")
	public Stack( int size){
		elements=    (Type[])new Object[size];
		top=-1;
	}
	public void clear(){
		top=-1;
	}
	public boolean isempty(){
		return top==-1;
	}
	public boolean isfull(){
		return top==elements.length-1;
		
	}
	public void push(Type item){
		if(isfull())
			throw new ArrayIndexOutOfBoundsException();
		elements[++top]=item;
	}
	public Type pop(){
		if(isempty())
			throw new NoSuchElementException();
		return    elements[top--];
	}
	public Type gettop(){
		if(isempty())
			throw new NoSuchElementException();
		return elements[top];
	}
	
	
}
