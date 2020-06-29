# fami-BDD-Framework
Fami Behavior Driven Development (BDD) Framework. This framework incorporate the use of selenium and cucumber framework 


# Where to start
- First you need to have install git client in your local machine. I'm highly recommended to use this git client: https://git-scm.com/downloads.
- Then you need to have java jdk 1.8, maven 3.6.3 install in your local machine. 
- After all of that is done, you can start cloning this repository by executing this command from you console:
```
git clone https://github.com/gravitydevelopment/Fami-BDD-Framework.git
```

# How to Start
- Once you successfully clone this repository to you local, there's two (2) ways to start executing the testing:
1. Execute in your local machine
    - Access the main package folder "~/Fami-BDD-Framework/" where the pom.xml file located through console.
    - Execute below command to clean and build the package:
    ```
    mvn clean install
    ```
    - Execute below execute main class of the framework to start the test execution:
    ```
    mvn exec:java
    ```    
    - Once test execution completed, execute below command to generate the cluecumber test report:
    ```
    mvn cluecumber-report:reporting
    ```    
    - Once report successfully generated, access cluecumber test report folder in a generated target folder "~/Fami-BDD-Framework/targetcluecumber-report"
    - Open the html file "index.html" to view the test report.
    - Apart from that, the framework also generate a log file. The log file can be access at "~/Fami-BDD-Framework/logs".
    
    
2. Execute through virtual container instance by using docker
    - First you need to setup the docker and your windows. You can follow this guideline: https://docs.docker.com/docker-for-windows/install/ 
    - Once the environment setup is done, access the main package folder "~/Fami-BDD-Framework/" from the console where the "Dockerfile" file located. 
    - Execute below command to start create the image and container instance: 
    ```
    docker build -t famibddframework .
    ```
    - Docker will start building the image and deploy the container instance. Once that's done, automation testing will be executed in the container instance.
    - Once the automated testing execution completed, execute below command:
    ```
    docker run -p 70:8080 famibddframework
    ```    
    - Once the process is done, now the test report is ready for view. Open your browser and access url:
    ```
    http://localhost:70/
    ```
    - The cluecumber test report will be display. 
  
