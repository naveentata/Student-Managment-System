import java.io.*;
import java.util.*;

class Subject implements Serializable{
	String name;
	String courseCode;
	static ArrayList<Subject>totalSubjectslist = new ArrayList<Subject>();
	public Subject(){

	}
	public Subject(String name, String courseCode){
		this.name = name;
		this.courseCode= courseCode;
		System.out.println(this);
		totalSubjectslist.add(this);
		SubjectMain.saveSub();

	}
	public String getsubName(){
		// System.out.println(this.name);
		return this.name;
	}
	public String  getsubCourseCode(){
		return this.courseCode;
	}
	public void setName(String name){
		this.name= name;
	}
	public void setCourse(String cou){
		this.courseCode=cou;
	}
}