pipeline {
    agent any

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
