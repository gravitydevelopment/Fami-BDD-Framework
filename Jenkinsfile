pipeline {
    agent any
	
    stages {

        stage("Environment Setup") {
			
		    steps {
			    echo 'INFO:: Verify the Maven environment'
				bat 'mvn dependecies:analyze'
            }
        }
        
        stage("deploy") {
        
            steps {
                echo 'Build the deployment package'

            }
        }
        
    }
}
