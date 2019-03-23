package DataStructure;

import java.util.Arrays;

public class seqlist <Type>{
	private static final int mon=10;
	private Object[] elements;
	private int size;
	public seqlist() {
		elements= new Object[mon];
		size=0;
	}
	public void clear(){
		size=0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public Type get	(int m){
		if(m<0||m>=size){
			throw new ArrayIndexOutOfBoundsException();
		}
		return  (Type)elements[m];		
	 }
	public Type set(int m,Type newm){
		if(m<0||m>=size){
			throw new ArrayIndexOutOfBoundsException();
		}
		@SuppressWarnings("unchecked")
		Type old =(Type)elements[m];
		elements[m]=newm;
		return old;
		
	}
	public void ensureCapacity(int newsize){
		if(newsize<size)return;
		Object[] old=elements;
		elements=new Object[newsize];
		for(int i=0;i<size;i++){
			elements[i]= old[i];
		}
		return;
	}
	public void trimTosize(){
		ensureCapacity(size);
	}
	public void add(int x ,Type m){
		if(x<0||x>size){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(elements.length==size){
			ensureCapacity(size*2+1);
		}
		for(int i=size;i>size;i--)
		elements[i]=elements[i-1];
		elements[x]=m;
		size++;
	}
	public void add(Type m){
		add(size,m);
	}
	public void remove(int x){
		if(x<0||x>size){
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i=x;i<size;i++){
			elements[i]=elements[i+1];
		}
		
	}
	public void remove(Type m){
		remove(find( m));
	}
	
	public int find(Type m){
		if(m==null){
			for(int i=0;i<size;i++){
				if(elements[i]==null)
					return i;
			}

}
		else{
		for(int i=0;i<size;i++){
			if(m.equals(elements[i])){
				return i;	
			}
		}}
	 return -2;
	}
	@Override
	public String toString() {
		return "seqlist [elements=" + Arrays.toString(elements) + ", size=" + size + "]";
	}
	
	}
	


