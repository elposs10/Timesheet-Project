pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'oussema',
                url: 'https://github.com/elposs10/Timesheet-Project.git';
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
        stage ("Checking Test Coverage with JaCoCo"){
			steps{
				bat """mvn verify"""
			}
		}
        stage ("Analysing project with Sonar for better code quality"){
			steps{
				bat """mvn sonar:sonar"""
			}
		}
		stage ("Deploying in Maven Releases repositoy with Nexus"){
			steps{
				bat """mvn clean package -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=0.0.1-SNAPSHOT -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1-SNAPSHOT.war"""
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