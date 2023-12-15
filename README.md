### For ProductBill Application

create a table "Product" with
pid,pname,price,qty
enter 5/6 records.
	
write a FirstServ which will retrieve all the records.
while retrieving records it will create ArrayList and store only productnames inside it.
This ArrayList should be now stored inside "request" attribute.

FirstServ will now forward to Shop.jsp which will display all the product names using checkbox. [ use jstl here ]

after selecting products when user will enter submit button ("add to cart"), control will go to SecondServ.

SecondServ will get all the selected products, store them in ArrayList. Store this ArrayList inside session attribute.

write a Bill.jsp will 
retrieve session and ArrayList from it.
display all the selected products using EL and Jstl.




### For Studets Application


now create "Student.jsp"
	accept
		rollno
		name
		age
		address

	on submit control should go to "StudentServ".

		"StudentServ" will get the request parameters and add a record in database.

		this servlet also will query to the database
"select rollno from student" 
rollno retrieved from database will be added inside ArrayList.
ArrayList will be stored inside "request" attribute and finally servlet will forward the request to "Report.jsp"

"Report.jsp" will retrieve ArrayList from request attribute and display rollnos. here you have to use "forEach" tag of JSTL.


### For Groupmembers Application

create a servlet "MyServlet"
	inside "doGet()" create ArrayList<String>

	store your group member's names in this list.

	add that list inside "session"
	display a message "session has been created"

now write a JSP "MyJsp.jsp"
	inside this JSP, retrieve ArrayList from session and display.

Instruction :- first run "MyServlet" and then "MyJsp.jsp"


### For RegisterLogin Application

welcome page - Home.html will have 2 links
	
	new user

	login


when user clicks on "new user" link , "Register.html" will be displayed. It will accept following information:
name,address,email,login and password.
on submit , request should go to "RegisterServ" (init and doPost) which will add this information inside "register" table of database.

when user clicks on "login" link, "Login.html" will be displayed. it will accept "login name" and "password".
on submit request should go to "LoginServ" (init and doGet()) which will search entered login and password inside "register" table and if found, forward the control to "success.html".  if not found then forward to "fail.html" which will have following link:


	Retry - Home.html

create html page "Admin.html" which will have a link "View All Users". when user clicks on a link control should go to "ViewServ" servlet (init and doGet) which will retrieve all the users who have registered and display them.


###DAO_assignment

DAO ( Data Access Object) design pattern
A DAO class provides access to a particular data resource in the data tier (e.g. relational database, XML, mainframe etc. ) without coupling the resource’s API to the business logic in the business tier.
For example :- you may have a EmployeeBO business object class access all of its employees in the database using a DAO interface EmployeeDAO. If your data resource change from a database to a Mainframe system, then reimplementing EmployeeDAO for a different data access mechanism would have little or no impact on any classes like EmployeeBO that uses EmployeeDAO with method “store(EmployeeBO)” because only the implementation (e.g. EmployeeDAODatabaseImpl or EmployeeDAOFileImpl ) would change but the interface remains the same. All the classes that use the DAO should  code to interface not implementation. 
Business objects represents the data client. They are the objects that require access to the datasource to obtain and store data. Data Access Objects abstract the underlying data access implementation for the business objects to enable transparent access to the datasource. The business objects also delegate data load and store operations to the Data Access Objects. A Datasource represents a database such as a relational database, XML repository, flat file , mainframe system etc. 

Question==>>
    create an entity "Student" with
	int rollno   [ id ]
	String name
	String address

create an interface

		StudentDAO with method
	void addStudent(Student)
	

create two implementations

	StudentDAOFileImpl.java
		which will persist given student inside file using serialization.

	StudentDAODataImpl.java
		which will persist given student inside database using hibernate.


Add.jsp

	Enter student name:
	Enter student address
		
		Select persistence store: dropdown
			with values

				file 
				database

		submit

on submit control should go to "AddServlet"

AddServlet will have a reference to 

	StudentDAO sdao;
the idea here is that "sdao" can point to any implementation of "StudentDAO" and invoke "addStudent()" polymorphically.

inside doPost() method 
a) instantiate "Student" with the values provided by user.
b) u will check the persistence store selected by user.
if this is "file"
	set the rollno.
	servlet will instantiate "StudentDAOFileImpl" and invoke "addStudent()" method.

if this is "data"
	servlet will instantiate "StudentDAODataImpl" and invoke "addStudent()" method.


 ###First_Spring_Application


 Person class with
name,address and age
toString() method.

create a form in jsp "person.html" (thymeleaf) which will accept name,address and age and on submit control will go to "View.html" (thymeleaf) which will display person class object with name,address and age entered by user.

 "PersonController" with "@GetMapping" and "@PostMapping" methods.









