pipeline {
/*environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerid')


    }*/
    agent any

    stages {
         stage('Display pom.xml') {
            steps {
                script {
                    def pomContent = readFile('pom.xml')
                    echo "Content of pom.xml:\n${pomContent}"
                }
            }
        }

         stage('Maven Clean ') {
            steps {

                sh 'mvn clean'
            }
        }
        stage('Maven Compile') {
            steps {

                sh 'mvn compile'
            }
        }
        stage('Maven sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=taher -Dmaven.test.skip=true'
            }
        }
        stage('JUNIT / Mockito' ) {
            steps {
                sh 'mvn test'
            }
        }
        stage('Nexus') {
            steps {
                sh 'mvn clean deploy -DskipTests=true'
            }
        }
        stage('Build docker image') {
                    steps {

                        sh 'docker build -t taharelarbi/devopsachat:$BUILD_NUMBER .'
                    }
                }
        	 /*stage('login to dockerhub') {
                    steps{
                        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    }
                }

             stage('push image') {
                    steps{
                        sh 'sudo docker push taherelarbi/DevopsAchat:$BUILD_NUMBER'
                    }
                }*/

    }
}