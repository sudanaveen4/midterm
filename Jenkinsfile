pipeline {
    agent any

    environment {
        // Define environment variables if needed
        MAVEN_HOME = '/path/to/maven' // Example Maven path
        JAVA_HOME = '/path/to/java'   // Example Java path
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    try {
                        // Set up environment variables
                        env.PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
                        
                        // Maven build with clean and install phases
                        sh 'mvn clean install'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        echo "Build failed: ${e.message}"
                    }
                }
            }
        }

        stage('Unit Tests') {
            steps {
                script {
                    try {
                        sh 'mvn test' // Run unit tests
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        echo "Unit tests failed: ${e.message}"
                    }
                }
            }
        }

        stage('Integration Tests') {
            steps {
                script {
                    try {
                        sh 'mvn integration-test' // Run integration tests
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        echo "Integration tests failed: ${e.message}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    try {
                        // Deployment steps (e.g., deploying to a server)
                        sh 'ssh user@server "deploy_script.sh"'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        echo "Deployment failed: ${e.message}"
                    }
                }
            }
        }
    }

    post {
        failure {
            // Notification in case of failure (e.g., sending an email)
            mail to: 'admin@example.com',
                 subject: "Pipeline failed: ${currentBuild.fullDisplayName}",
                 body: "The Jenkins pipeline ${currentBuild.fullDisplayName} has failed. Please check the logs."
        }
    }
}
