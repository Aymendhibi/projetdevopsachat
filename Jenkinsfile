pipeline {
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

    }
}