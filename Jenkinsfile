pipeline {
    agent any 
	environment
	{
	registry = "YourDockerhubAccount/YourRepository"
	registryCredential= 'dockerhub_id'
	dockerImage = ''
	}
    stages {
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
	stage('Cloning our Git') {
	steps { git 'https://github.com/YourGithubAccount/YourGithubRepository.git’ }
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
         
    }
    post{
        always{
            emailext body: 'build success' , subject: 'Jenkins' , to: 'rouambarki19@gmail.com'
        }
        
    }
}
