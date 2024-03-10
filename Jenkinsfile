pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Starting sonar analysis...'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Publish Artifact') {
            steps {
                echo 'Archiving artifact...'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging environment'
            }
        }

        stage('Staging Tests') {
            steps {
                echo 'Running staging environment tests'
            }
        }

        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying to production environment'
            }
        }
    }

    post {
        failure {
            echo 'The pipeline failed!'
        }
    }
}