import java.util.*;
import java.io.*;
class Parent implements Serializable{
	String name;
	String id;
	Parent(String name, String id){
		this.name= name;
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	public Parent getParent(){
		return this;
	}
	

}