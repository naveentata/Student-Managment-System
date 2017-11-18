import java.util.*;
import java.io.*;
class Date implements Serializable{
	int date;
	int month;
	int year;
	Date(int date,int month,int year){
		this.date= date;
		this.month=month;
		this.year=year;
	}
	public String toString(){
		return(this.date+"/"+this.month+"/"+this.year);
	}
}