pipeline {
    agent any
        environment {
            OPENAI_API_KEY = credentials('OPENAI_API_KEY')
        }
    stages {

        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Docker-Compose-Up') {
            steps {
                echo "$OPENAI_API_KEY"
                sh "docker-compose up --detach --build"
            }
        }
    }
}