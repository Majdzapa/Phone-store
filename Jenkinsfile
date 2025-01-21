pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java 17'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token') // ID Jenkins pour le token SonarQube
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Majdzapa/Phone-store.git'
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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=phoneStore -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t phoneStore:latest .'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
