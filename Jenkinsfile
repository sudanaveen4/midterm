pipeline {
    agent any

    environment {
        MAVEN_HOME = '"C:\\Users\\sudan\\OneDrive\\Desktop\\Y\\CSI3025 - Application Development and Deployment Architecture-LAB\\login-proj\\login"'
        JAVA_HOME = '"C:\\Program Files\\Java\\jdk-17.0.2"'
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
