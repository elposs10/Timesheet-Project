pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'oussema',
                url: 'https://github.com/elposs10/DevOps-TimesheetProject.git';
            }
        }
        stage ("Checking Maven Version"){
			steps{
				bat """mvn -version"""
			}
		}
        stage("Removing the Target directory & Copying the artifact in the local repository") {
            steps {
                bat """mvn clean install"""
            }
        }
        stage ("Launching Unit Tests"){
			steps{
				bat """mvn test"""
			}
		}
        stage("Generating artifact in the Target directory") {
            steps {
                bat """mvn package -Dmaven.test.skip=true"""
            }
        }
    }
    post {
        success {
            emailext body:'Build Success', subject:'Jenkins', to: 'oussema.mihoubi@esprit.tn'
        }
        failure {
            emailext body:'Build Failure', subject:'Jenkins', to: 'oussema.mihoubi@esprit.tn'
        }
    }
}