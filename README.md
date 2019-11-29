# Homalco

Homalco is the project name for an Inventory Management System (IMS) submitted for the SOEN343 project class.



## Running The Project

### Dependencies
* Maven
* Java 11
* Java IDE (Preferably IntelliJ IDEA)

### Steps
1. Clone the project from the GitHub repository through the terminal or the method of your choice:
   * Terminal: run `git clone https://github.com/Pwnagebird/Homalco.git` to clone using HTTPS.
   * Terminal: run `git clone git@github.com:Pwnagebird/Homalco.git` to clone using SSH.
2. Open the cloned project and make sure your IDE recognizes the project as a Maven Spring project.
3. In Maven, Run Maven Build with `clean` & `package`, so that maven can resolve dependencies and package the project:
   * Through your IDE interface, run the `clean` and `package` lifecycle phase
   * Alternatively, you can run the lifecycle phase through the terminal. Run `mvn clean package`.
4. Run the main method of the spring project in the file `ImsApplication.java` through your IDE. This file is located in `src/main/java/com/homalco/ims/ImsApplication.java`
5. The Application should now be running. The login page is accessible at http://localhost:8080/