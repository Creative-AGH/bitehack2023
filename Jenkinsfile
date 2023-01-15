pipeline {
    agent any

    stages {
        environment {
            $OPENAI_API_KEY    = 'xDDDDDDDDDDDDDDD'
        }
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
                sh "echo $OPENAI_API_KEY"
                sh "docker-compose up --detach --build"
            }
        }
    }
}