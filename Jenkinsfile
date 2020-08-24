pipeline {
    agent any
	
	tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }
	
    stages {
        stage("Environment Setup") {
		    steps {
			    echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
            }
        }
        
        stage("deploy") {
        
            steps {
                echo 'Build the deployment package'

            }
        }
        
    }
}
