pipeline{
    environment
{
registry = "roua5/docker-timesheet"
registryCredential= 'dockerhub_id'
dockerImage = ''
}
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
                bat "mvn clean install"
            }
        }
	stage("package"){
               steps{

                   bat "mvn package"
                    }

                  }
         stage("Sonar"){
            steps{
                bat "mvn sonar:sonar"
            }
        }
         stage("Nexus"){
            steps{
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -Dmaven.test.skip=true -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=0.0.1-SNAPSHOT -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo1 -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1-SNAPSHOT.war"
            }
        }
        
       stage('Building our image') {
    steps {
       script {
          dockerImage= docker.build registry + ":$BUILD_NUMBER" 
       }
    }
  }

  stage('Deploy our image') {
    steps {
       script {
         docker.withRegistry( '', registryCredential) {
            dockerImage.push() 
         }
       } 
    }
  }
	    
	    
	    stage('Deploy our image') {
    steps {
       script {
         docker.withRegistry( '', registryCredential) {
            dockerImage.push() 
         }
       } 

    }
	
	

           
    post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'rouambarki19@gmail.com'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'rouambarki19@gmail.com'
		}

	}
 
}
