pipeline {
    agent any

    tools {
        maven 'maven' // Use the name configured in Jenkins Global Tool Configuration
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        // Add other stages as needed
    }

    // Add post actions and other pipeline configuration
}
