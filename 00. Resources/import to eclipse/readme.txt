To be able to import project into eclipse we need to run a command which will create two files

.classpath
.project

for this we need to go inside the built project's main directory (contains POM and src directory) and enter command 'mvn eclipse:eclipse'

I have created a batch file that can be used.  Just copy the import.bat file into the main directory folder and double click.  You're welcome