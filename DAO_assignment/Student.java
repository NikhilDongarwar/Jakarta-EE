package mypack;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student implements Serializable  {
	
	       int rollno ;
			String name;
			String address;
			
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
             public int getRollno() {
				return rollno;
			}
			
			@Override
			public String toString() {
				return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
			}

			public void setRollno(int rollno) {
				this.rollno = rollno;
			}
		
			public String getName() {
				return name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
			
			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}
			
			

}
