Online-Blog

HOW TO SETUP PROJECT:
  
#1 
   open cmd and do 'git clone' https://github.com/matejjj27/Online-Blog.git - in the directory where you want the project to be
#2
   Start 'MySQL' in 'XAMPP Control Panel' - link for 'XAMPP' download: https://www.apachefriends.org/download.html
#3
   Open 'HeidiSQL' and create a database with name 'javablog' - link for 'HeidiSQL' download: https://www.heidisql.com/download.php
#4
   Open The Project with 'Intellij IDEA' wait for all the dependencies to load and run it 
   - link for Intellij IDEA download: https://www.jetbrains.com/idea/download/?fromIDE=#section=windows
#5
   Check 'HeidiSQL' to see if the tables have created
#6
   In the table roles click on the '+' button and Create a role with name 'ROLE_USER' and another with name 'ROLE_ADMIN'
#7
   Run the Application again and open this link on your browser 'localhost:8080'
#8
   Go to 'users_roles' in HeidiSQL and here you can change the 'roles_id' for a user that you want to have admin rights to 2
#9
   Now you can enjoy all the functionalitites of the Blog Application
