Lawrence, Ming-Hua Sean
Mendoza, Ellis Marie
Le, Dillon
Castaneda, Victor
4/15/2022
CSULB Spring 2022
CECS 543, Prof. Fahim
README file

1. If you are reading this, you have downloaded our submission folder zip file and unzipped it into a directory in your computer (let’s call it DirA).
2. Open command prompt.
3. In the command prompt, navigate to DirA on your computer, where you have put our submission folder.
4. Navigate into our submission folder in command prompt.
5. Copy, paste, and press “Enter” to execute this command in the command prompt, to compile all our Java files with the right dependencies.

javac -p .\lib\commons-csv-1.9.0.jar;.\lib\opencsv-3.8.jar -classpath .\plugins\org.junit.jupiter.api_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.engine_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.migrationsupport_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.params_5.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.commons_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.engine_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.launcher_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.runner_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.suite.api_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.suite.engine_1.8.1.v20211028-1957.jar;.\plugins\org.junit.platform.suite.commons_1.8.1.v20211018-1956.jar;.\plugins\org.junit.vintage.engine_5.8.1.v20211018-1956.jar;.\plugins\org.opentest4j_1.2.0.v20211018-1956.jar;.\plugins\org.apiguardian_1.1.2.v20211018-1956.jar;.\plugins\org.junit_4.13.2.v20211018-1956.jar;.\plugins\org.hamcrest.core_1.3.0.v20180420-1519.jar; *.java

1. 
2. 
3. 
4. 
5. 
6. Copy, paste and execute this command in command prompt to run all our tests:

java -p .\lib\commons-csv-1.9.0.jar;.\lib\opencsv-3.8.jar -classpath .;.\plugins\org.junit.jupiter.api_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.engine_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.migrationsupport_5.8.1.v20211018-1956.jar;.\plugins\org.junit.jupiter.params_5.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.commons_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.engine_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.launcher_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.runner_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.suite.api_1.8.1.v20211018-1956.jar;.\plugins\org.junit.platform.suite.engine_1.8.1.v20211028-1957.jar;.\plugins\org.junit.platform.suite.commons_1.8.1.v20211018-1956.jar;.\plugins\org.junit.vintage.engine_5.8.1.v20211018-1956.jar;.\plugins\org.opentest4j_1.2.0.v20211018-1956.jar;.\plugins\org.apiguardian_1.1.2.v20211018-1956.jar;.\plugins\org.junit_4.13.2.v20211018-1956.jar;.\plugins\org.hamcrest.core_1.3.0.v20180420-1519.jar; org.junit.runner.JUnitCore InventoryLookupTest createInvoiceTest

7. You will see that all our tests will pass.
