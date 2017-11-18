import java.util.*;
import java.lang.*;
import java.io.*;


class ParentMain {
	
	public void getProfile(Student sto){
			System.out.println();
			System.out.println("Name   : "+sto.getName());
			System.out.println("RollNo : "+sto.getRoll());
			System.out.println("Branch : "+sto.getBranch());
			System.out.println("Parent : "+sto.parent.getName());
			System.out.println();


	}

	public void goMenu(Student sto){
		System.out.println("================================ Hello ! "+sto.parent.getName()+" =====================================");
			System.out.println();
			do{
			

				int n;
				System.out.println("(1)  Show Name");
				System.out.println("(2)  Show Branch");
				System.out.println("(3)  Display GradeBook");
				System.out.println("(4)  Show Registered Subjects");
				System.out.println("(5)  Show Profile");
				System.out.println("(6)  Show All Achievements");
				System.out.println("(7)  Show All Remarks");
				System.out.println("(8)  Show All Fines");
				System.out.println("(9)  Go Back");
				Scanner s = new Scanner(System.in);
				n = s.nextInt();
				switch(n){
					case 1:
							System.out.println("Your Child, " +sto.getName());
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
					case 5:
							getProfile(sto);
							break;
					case 6:		
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
					case 7:
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
					case 8:
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
					case 9 :
							return;
					default :
							System.out.println("Enter Valid number");
							// Scanner input = new Scanner(System.in);
							// System.out.println("Enter roll no:");
							// sto.setRoll(input.next());
							// sto.save();


				}
			}
			while(true);
	}

	
}