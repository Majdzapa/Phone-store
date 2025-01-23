pipeline {
    agent any

    tools {
        maven 'Maven' // Nom de Maven configuré dans Jenkins
        jdk 'Java 17' // Nom de Java 17 configuré dans Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Analysis with SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') { // Remplacez "SonarQube" par le nom configuré dans Jenkins
                    sh 'mvn sonar:sonar -Dsonar.token=sqa_cc1c5ce0eeacb6d87b991434dec1de83805d8e5f'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}