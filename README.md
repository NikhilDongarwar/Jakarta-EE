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


