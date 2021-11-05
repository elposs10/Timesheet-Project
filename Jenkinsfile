pipeline { 

    environment { 

        registry = "roua5/Timesheet-Project" 

        registryCredential = 'dockerhub_id' 

        dockerImage = '' 

    }

    agent any 

    stages { 

        stage('Cloning our Git') { 

            steps { 
                git 'https://github.com/elposs10/Timesheet-Project.git' 

            }

        } 

        stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 

                }

            } 

        }

        stage('Deploy our image') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 

                    }

                } 

            }

        } 
        

       

    }

}
