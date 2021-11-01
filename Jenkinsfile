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
    post{
        succes{
            emailext body: 'build success' , subject: 'Jenkins' , to: 'rouambarki19@gmail.com'
        }
        failure{
             emailext body: 'build failure' , subject: 'Jenkins' , to: 'rouambarki19@gmail.com'
        }
    }
}
