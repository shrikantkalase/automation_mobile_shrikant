# Amazon mobile automation (Appium) 

IDE - IntelliJ 
Appium - 1.17 version 
Language - JAVA 14 
Automation build - Maven project
Automation framework - TestNG using page object model design pattern.
Device parameter - pixel 2 (android -9.0)


# Project structure - 
maven project 
Src/main/Java/ 
1) App_config class - All appium driver initialization and setup 
2) Loadproperty class - Testdata.properties file (external file for data)
3) Applocators class - app element locators 

Resources - 
A) Propertyfile > Testdata.properties - (External file for data fetching) 

src/test/java/ 
1) App_Testcases class - All test cases written in this class

# Execution process - 
1) import project 
2) configure and Run testng.xml for running the testsuite through IDE
3) command line - install maven & command line - mavn test {location of POM.xml} 

# Automation Report - 
1) install allure https://docs.qameta.io/allure/ 
2) Aftr execution testc tescases - allure report folder will gererate under the project (copy local path)
3) go to command line go to the allure installed location - allure serve (path of generated folder) 


