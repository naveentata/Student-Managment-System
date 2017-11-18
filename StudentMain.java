
	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class StudentMain{
		
		public void getProfile(Student sto){
			System.out.println();
			System.out.println("Name   : "+sto.getName());
			System.out.println("RollNo : "+sto.getRoll());
			System.out.println("Branch : "+sto.getBranch());
			System.out.println("Parent : "+sto.parent.getName());
			System.out.println();


		}
		public void goMenu(Student sto){
			System.out.println("================================ Hello ! "+sto.getName()+" =====================================");
			System.out.println();
			do{
			

				int n;
				System.out.println("(1)  Show Name");
				System.out.println("(2)  Show Branch");
				System.out.println("(3)  Display GradeBook");
				System.out.println("(4)  Show All Students");
				System.out.println("(5)  Register a Subject");
				System.out.println("(6)  Show Registered Subjects");
				System.out.println("(7)  Show All Subjects");
				System.out.println("(8)  Show Profile");
				System.out.println("(9)  Add Achievements");
				System.out.println("(10) Show All Achievements");
				System.out.println("(11) Show All Remarks");
				System.out.println("(12) Show All Fines");
				System.out.println("(13) Go Back");
				Scanner s = new Scanner(System.in);
				n = s.nextInt();
				switch(n){
					case 1:
							System.out.println("Hello, " +sto.getName());
							System.out.println();
							break;
					case 2:
							System.out.println("Your are "+ sto.getBranch()+" Branch");
							System.out.println();
							break;
					case 3:
							System.out.println("=======================Grade Book==========================");
							System.out.println();
							System.out.println("Name"+"\t"+"Internals"+"\t"+"External"+"\t"+"Grade");
							for(Mark g: sto.grade.totalMarksList){

								System.out.println(g.subject.name +"\t"+ g.internal +"\t\t"+ g.external +"\t\t"+ g.grade);
							}
							System.out.println();
							System.out.println("===========================================================");
							break;
					case 4:
							for(Student stud : Student.totalStudentsList){
	            				System.out.println(stud.getName());
	        					}
	        				System.out.println();
	        				break;	
					case 5:
							System.out.println();
							System.out.println("======================= Register a Subject ==================");
							while(true){
								System.out.println("Enter Subject Name:");
								String name = s.next();
								System.out.println("Enter the Course Code");
								String course = s.next();
								Subject su = SubjectMain.returnSub(course);
								if( su != null){
										if(!sto.checkRegSub(course)){
												sto.addSub(su);
												sto.save();
												// StudentMain.saveStud();
												System.out.println("Saved.. ");
												break;
										}
								}
							}
							System.out.println();
							break;
					case 6:
							System.out.println();
							System.out.println("================Registered Subjects==============");
							System.out.println();
							System.out.println(sto.registeredSub);
							for(Subject sub : sto.registeredSub){
								System.out.println(sub.getsubName()+"  "+sub.getsubCourseCode());
							}
							System.out.println();
							System.out.println("=================================================");
							System.out.println();
							
							break;
					case 7:
							System.out.println();
							System.out.println("================Subjects==============");
							System.out.println();
							for(Subject sub : Subject.totalSubjectslist){
								System.out.println(sub.getsubName()+"  "+sub.getsubCourseCode());
							}
							System.out.println();
							System.out.println("=======================================");
							System.out.println();
							break;
					case 8:
							getProfile(sto);
							break;
					case 9:
							System.out.println();
							System.out.println("================== Add Achievements ===================");
							System.out.println();
							while(true){
								System.out.println("Enter the type of Achievement :");
								String achName = s.next();
								System.out.println("Give any Description of Achievement");
								String achDes = s.nextLine();
								Achievement ac = new Achievement(achName,achDes);
								if(achName!= null){
									sto.addAch(ac);
									sto.save();
									System.out.println("Saved..");
									System.out.println("==================================================");
									break;
								}
							}
							break;
					case 10:		
							System.out.println();
							System.out.println("=================== All Achievements =======================");
							System.out.println();
							System.out.println("Type of Acheivement\tDescripption");
							for(Achievement ac : sto.achievement){
								System.out.println(ac.getName()+"\t\t\t"+ac.getMsg());
							}
							System.out.println();
							System.out.println("============================================================");
							System.out.println();
							break;
					case 11:
							System.out.println();
							System.out.println("======================== All Remarks =========================");
							System.out.println();
							System.out.println("From "+"\t\t"+"Description");
							for(Memo m : sto.memos){
								System.out.println(m.from.getName()+"\t\t"+m.getMsg());
							}
							System.out.println();
							System.out.println("==============================================================");
							System.out.println();
							break;
					case 12:
							System.out.println();
							System.out.println("======================== All Fines =========================");
							System.out.println();
							System.out.println("From "+"\t\t"+"Description"+"\t\t"+"Date");
							for(Fine m : sto.fines){
								System.out.println(m.from.getName()+"\t\t"+m.getMsg()+"\t\t\t"+m.date);
							}
							System.out.println();
							System.out.println("==============================================================");
							System.out.println();
							break;		
					case 13:
							return;
					default :
							// System.out.println("Enter Valid number");
							Scanner input = new Scanner(System.in);
							System.out.println("Enter roll no:");
							sto.setRoll(input.next());
							sto.save();


				}
			}
			while(true);
		}

		public static void saveStud(){

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try{
				fos = new FileOutputStream("Data/Students.ser");
				oos = new ObjectOutputStream(fos);

				oos.writeObject(Student.totalStudentsList);
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

		public static ArrayList<Student> getStud(){
			FileInputStream fis = null;
	        ObjectInputStream ois = null;
	 
	        ArrayList<Student> listOfStudents = null;
	 
	        try {
	            // reading binary data
	            fis = new FileInputStream("Data/Students.ser");
	 
	            // converting binary-data to java-object
	            ois = new ObjectInputStream(fis);
	 
	            // reading object's value and casting ArrayList<Customer>
	            listOfStudents = (ArrayList<Student>) ois.readObject();

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
	        return listOfStudents;
		}

		public static Student checkRoll(String a){
			
			
			Student pres = null;
			for(Student st :Student.totalStudentsList){
				if(st.getRoll().equals(a)){
					 return st;

				}
				else{
					try{
					throw new MyException("not found");
						}
						catch(MyException ex){System.out.println(ex);}
				}

			}
			return null;
		}	
			

		public boolean isStudent(String a){
			
			ArrayList<Student> objstud = StudentMain.getStud();
			Student pres = null;
			for(Student st : objstud){
				if(st.getRoll().equals(a)){
					return true;
				}
			}
			return false;
			
		}
		
		//////// Add Marks

		

}