package mypack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentDAOFileImpl implements StudentDAO {
   private static int rollno=1;
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fis=new FileOutputStream("E:\\abcd.txt");
			
			ObjectOutputStream oos=new ObjectOutputStream(fis);
			oos.write(rollno++);
			oos.writeObject(student);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
