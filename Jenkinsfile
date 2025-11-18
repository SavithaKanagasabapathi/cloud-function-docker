pipeline {
    agent any 
    
    tools {
        // Use the name you configured in Tools Configuration
        maven 'M3.9.9' 
        jdk 'JDK21' // Use the name you configured for the JDK
    }

    stages {
        
        stage('Build') {
            steps {
                // This command cleans the target directory, compiles the code, 
                // runs unit tests, and packages the Spring Boot application into a JAR file.
                sh 'mvn clean install -DskipTests' 
            }
        }
        
        stage('Test') {
            steps {
                // Separate test stage to run unit tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Creates the final Spring Boot executable JAR using the spring-boot-maven-plugin
                sh 'mvn package'
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                // Archives the resulting JAR file so you can download it from the Jenkins build page
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}