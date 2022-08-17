#Project Name:
Hospital Management System

#Project Description:
The application is designed for Managing different purpose of hospital such as- book appointment, cancel appointment etc. and hence patient can register to the system and able to book an appointment to a particular doctor.

Admin/Receptionist can login to the system and can view patient details, appointment details, schedule the appointment, confirm it, and cancel it.

After Admin/Receptionist confirm an appointment, it will be appeared in Doctor’s Dashboard. Doctor can view all the appointments to a particular day and also can make an event on any day from calendar.

#Installation and Run:
1. Download the zip file from git lab from download option. After downloading unzip the file.
or clone the project using git command and URL-
git clone https://cognizant-git.tekstac.com/root/hospital-management-system_adm21jf025_pod2.git

2. Select an IDE (Eclipse/VS Code).

3. To run the project on Eclipse-


4. To run the project on VS Code-
4.1. Download extestion Spring Boot Extestion Pack
4.2. Open the unzip file in VS Code.
4.3. After all the Jar files and dependencies get loaded, run the project from "Spring Boot Dashboard" option.

5. Login into MySQL Workbench and create a database (Refer to HMS.sql file)

6. Go to Google Chrome and run the project on Localhost with assigned port number.

#Usage:
1. To login as "USER"
1.1. Select the option - Sign up now
1.2. After that fill all the necessery credentials for Registration.
1.3. After getting "Successfully Register" message, click on Log in option to login.
1.4. From the Nav bar of User Dashboard, user can "Make An appointment".
1.5. After Submitting an appointment, User/patient can view their appointment from nav bar option "view App".
1.6. After that user can log out from the application.

2. To login as ":ADMIN"
2.1. For the first time refer the HMS.sql file and run the Insert query of Admin in MySQL Workbench.
2.2. Go to the login page and using username and password Log in to the Admin Dashboard.
2.3. From the nav bar of Admin Dashboard, Admin can view Patient Details, Appointment Details, Doctor Details and Admin Details.
2.4. From the nav bar of Admin Dashboard, Admin can add Patient, Doctor, Admin.
2.5. From Patient Details Nav bar, Admin Can Update or Delete Patient's credentials.
2.6. From Appointment Nav ar, Admin can cancel An appointment.
2.7. After that admin can log out from the application.

3. To login as "DOCTOR"
3.1. For the first time refer the HMS.sql file and run the Insert query of Doctor in MySQL Workbench OR Admin can also add Doctor from Admin Dashboard.
3.2. Go to the login page and using username and password Log in to the Doctor Dashboard.
3.3 After login doctor can view all the appointments.
3.4. After that doctor can log out from the application.

#Contributing:

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request 

#Include Credits:
Ananya Chattopadhyay
Ankita Datta
Ayan Goswami
Rajeev Kumar
Shreya Saha
Vishal Kumar
