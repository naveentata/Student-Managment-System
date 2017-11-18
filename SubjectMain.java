import java.io.*;
import java.util.*;
import java.lang.*;
class SubjectMain {
	public void getProfile(Subject sub){
		System.out.println();
		System.out.println("Name   : "+sub.getsubName());
		System.out.println("Course Code : "+sub.getsubCourseCode());
		System.out.println();


	}
	// public void goMenu(Student sto){
		
	// 	do{
		

	// 		int n;
	// 		System.out.println("(1) Show Name");
	// 		System.out.println("(2) Show Branch");
	// 		System.out.println("(3) Add Student");
	// 		System.out.println("(4) Show All Students");
	// 		System.out.println("(5) Go Back");
	// 		Scanner s = new Scanner(System.in);
	// 		n = s.nextInt();
	// 		switch(n){
	// 			case 1:
	// 					System.out.println("Hello, " +sto.getName());
	// 					System.out.println();
	// 					break;
	// 			case 2:
	// 					System.out.println("Your are "+ sto.getBranch()+" Branch");
	// 					System.out.println();
	// 					break;
	// 			case 3:
	// 					System.out.println("Enter the Name : ");
	// 					String name = s.next();
	// 					System.out.println("Enter the RollNo");
	// 					String rol= s.next();
	// 					System.out.println("Enter the Branch");
	// 					String bra = s.next();
	// 					new Student(name,rol,bra);
	// 					System.out.println();
	// 					break;
	// 			case 4:
	// 					for(Student stud : Student.totalStudentsList){
 //            				System.out.println(stud.getName());
 //        					}
 //        				System.out.println();
 //        				break;	
	// 			case 5:
	// 					return;
	// 			default :
	// 					System.out.println("Enter Valid number");				
	// 		}
	// 	}
	// 	while(true);
	// }

	public static void saveSub(){

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try{
			fos = new FileOutputStream("Data/Subjects.ser");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(Subject.totalSubjectslist);
			oos.flush();
			oos.close();

		}
		catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
	}

	public static ArrayList<Subject> getSub(){
		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Subject> listOfSubjects = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Subjects.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfSubjects = (ArrayList<Subject>) ois.readObject();

        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        // for(Student stud : listOfStudents){
        //     System.out.println(stud.getRoll());
        // }
        return listOfSubjects;
	}

	public static Subject returnSub(String a){
			
			for(Subject st : Subject.totalSubjectslist){
				if(st.getsubCourseCode().equals(a)){
					return st;

				}
			}
			return null;
			
	}
	public static Subject returnRegSub(String a,Student s){
			for(Subject st : s.registeredSub){
				if(st.getsubCourseCode().equals(a)){
					return st;

				}
			}
			return null;
	}
	

}