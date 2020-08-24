pipeline {
    agent any
	
    stages {

        stage("Environment Setup") {
			
		    steps {
			
				def os = System.properties['os.name'].toLowerCase()
				echo "OS: ${os}"
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
