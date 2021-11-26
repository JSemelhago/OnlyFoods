# OnlyFoods

Project for MIE350 which incorporates software development methodologies to create a social media food experience using Java SDK and Access for the backend and HTML & CSS with Bootstrap enabled and Jakarta Server Pages for a dynamic frontend. 

## **Installation & Deployment**

### **Prerequisites**

1. Eclipse IDE for Java EE Developers (*skip if running Eclipse from the MIE350 folder on ECF*)
   - **Windows & macOS**: the x84_64 version of Eclipse for Java EE Developers [here](https://www.eclipse.org/downloads/packages/release/luna/r/eclipse-ide-java-ee-developers)
2. Apache Tomcat v7.0 (*skip if running Eclipse from the MIE350 folder on ECF*)
   - Unzip Apache Tomcat 7.0.96 [here](https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.96/bin/apache-tomcat-7.0.96.zip) and make note of its downloaded directory
3. JRE 6 or JDK 1.6 (*skip if running Eclipse from the MIE350 folder on ECF*)
   - **Windows**: Install the Java SE Runtime Environment version 6u38 for Windows x86 Offline [here](https://www.oracle.com/java/technologies/javase-java-archive-javase6-downloads.html)
   - **macOS**: Install the legacy Java SE Runtime Environment version 6 [here](https://updates.cdn-apple.com/2019/cert/041-88384-20191011-3d8da658-dca4-4a5b-b67c-26e686876403/JavaForOSX.dmg)
4. Microsoft Access (*skip if running Eclipse from the MIE350 folder on ECF*)
5. Update `src/db.properties` to be the PATH_TO_DIR of the database in `src/db/OnlyFoods.accdb`

### **Installation**

1. Use `git clone` to clone this repository locally
2. Open Eclipse IDE for Java EE Developers and set a workspace. Make note of this workspace for future use
3. Go to File->New->Java Project
   1. Set the Project name to OnlyFoods
   2. Uncheck Use Default Location
   3. Browse and set the location to where the repository was cloned
   4. Click Next->Finish. The project will now be open under the Package Explorer on the left
4. Set the compiler compliance level (*skip if running Eclipse from the MIE350 folder on ECF*)
   1. Go to Project->Properties->Java Compiler and Enable project specific settings and disable Use compliance from execution environment on the 'Java Build Path'
   2. Set the compiler compliance level to 1.6
   3. At the bottom in the warning, click on the Installed JREs link
   4. Click Add->Next and select the folder that contains the installed JRE from the prerequisites
   5. Click Finish and tick it in the Installed JREs window and click OK->OK
5. Right click on the project->Properties->Project Facets and enable the following (*skip if running Eclipse from the MIE350 folder on ECF*): 
   1. Ensure that Dynamic Web Module (v2.5), Java (v1.6), and JavaScript (v1.0)
   2. In the Runtimes tab select New->Apache->Apache Tomcat v7.0->Next->Browse for the directory containing the downloaded folder in the prerequisites
   3. Set the JRE to jre1.6 and click Finish and tick it
   4. Click OK
6. Right click on the project->Run As->Run on Server
7. Click on Manually define a new server
8. Click on Tomcat v7.0 Server and click Next
9. Click on OnlyFoods and click Add to ensure it is on the right hand side and click Finish
10. Open up a browser and type in `localhost:8080/OnlyFoods` or `localhost:8080/mie350webapp`

### **Rerunning After Installation**

1. Select the workspace
2. Ensure that Tomcat is loaded and the JRE compliance level is set to 1.6 with a JAR 6 selected
3. Make modifications as needed after using `git pull`
4. Right click on the project->Run As->Run on Server
5. Click on Choose an existing server and click Next
6. Ensure that OnlyFoods is on the right hand side (otherwise click on it and click Add) and click finish
7. Open up a browser and type in `localhost:8080/OnlyFoods` or `localhost:8080/mie350webapp`