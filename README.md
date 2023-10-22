# This is Saucedemo test based of data-driven-test, using cucumber.

This is Saucedemo test based of data-driven-test, using cucumber. This is intended for educational perpose only. Thanks to Rakamin and Digitalent Kominfo.

Software to help me run this:
1. Intellij Idea Community Edition [https://www.jetbrains.com/idea/]
2. JAVA SDK SE (im running on jdk21) [https://www.oracle.com/java/technologies/downloads/]
3. Cucumber for java plugin in intellij idea [https://plugins.jetbrains.com/plugin/7212-cucumber-for-java]
4. Maven for build tools (im using 3.9.5 version) [https://maven.apache.org/download.cgi]

Also some library that make this project work:
1. Selenium Java [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java]
2. Selenium Firefox Driver [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-firefox-driver]
3. JUnit Vintage Engine [https://mvnrepository.com/artifact/org.junit.vintage/junit-vintage-engine]
4. Webdrivermanager [https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager]
5. Cucumber Java [https://mvnrepository.com/artifact/io.cucumber/cucumber-java]
6. Cucumber JUnit [https://mvnrepository.com/artifact/io.cucumber/cucumber-junit]
7. Reporting Plugin [https://mvnrepository.com/artifact/me.jvt.cucumber/reporting-plugin]

Setup every apps and dont forget to add it in PATH if you are running on Windows.

This is brief how to use and how to check it:
1. After download this repo, you shuld reload maven to make sure all library is loaded in system.
2. For running all test you can simply open runEveryhing.java in runner. After finish test, there is "target" folder in root folder. The report test is "HTML_report.html".
3. For running spesific task, you can go to features and run task you desire.