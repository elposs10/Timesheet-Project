pipeline {
    agent any 
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'arij', 
                url:'https://github.com/elposs10/Timesheet-Project.git';
            
            }
        }
    
        stage("Test, Build"){
            steps{
                bat """mvn clean install"""
            }
        }
        
    }
}


    