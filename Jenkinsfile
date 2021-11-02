pipeline {
	environment
		{
		registry = "roua5/Timesheet-Project"
		registryCredential= 'dockerhub_id'
		dockerImage = ''
}
    agent any 
    stages {
	
		stage('Cloning our Git') {
		steps { 
		    git 'https://github.com/elposs10/Timesheet-Project.git';
		    }
		}
		
		stage('Building our image') {
			steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
		}
		stage('Deploy our image') {
		steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
		}
	stage('Cleaning up') {
		steps { bat "docker rmi $registry:$BUILD_NUMBER" }
		}
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'roua', 
                url:'https://github.com/elposs10/Timesheet-Project.git';
            }
        }

        stage("Test, Build"){
            steps{
                bat """mvn clean install"""
            }
        }
         stage("Sonar"){
            steps{
                bat """mvn sonar:sonar"""
            }
        }
    }
    post{
        always{
            emailext body: 'build success' , subject: 'Jenkins' , to: 'rouambarki19@gmail.com'
        }
    }
}
