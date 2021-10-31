pipeline {
    agent any 
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
         stage("Sonar"){
            steps{
                bat """mvn sonar:sonar"""
            }
        }
    }
}