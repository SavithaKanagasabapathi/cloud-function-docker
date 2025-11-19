pipeline {
    agent any 
    
    tools {
        // Use the name you configured in Tools Configuration
        maven 'M3.9.9' 
        jdk 'JDK21'
    }
    
    environment {
		DOCKER_CREDS = credentials('docker-creds')
	}

    parameters {
		// Define the parameter to select which stage to run
        choice(
            name: 'TARGET_STAGE',
            choices: ['ALL', 'BUILD', 'TEST', 'DEPLOY'],
            description: 'Select the stage to run, or ALL for the entire pipeline.'
        )
    }

    stages {
        // Stage 1: BUILD - The core action you want to control
        stage('BUILD') {
            when { 
                expression { 
                    // This runs if ALL is selected OR if 'BUILD' is selected
                    return params.TARGET_STAGE == 'ALL' || params.TARGET_STAGE == 'BUILD'
                }
            }
            steps {
                echo 'Running build stage: mvn clean install -DskipTests'
                // Replace with your actual Maven command for building
                sh 'mvn clean install -DskipTests' 
            }
        }

        // Stage 2: TEST - Conditional stage
        stage('TEST') {
            when { 
                expression { 
                    // This runs only if ALL is selected OR if 'TEST' is selected
                    return params.TARGET_STAGE == 'ALL' || params.TARGET_STAGE == 'TEST'
                }
            }
            steps {
                echo 'Running test stage: mvn test'
                // sh 'mvn test'
            }
        }
        
        // Stage 3: DEPLOY - Conditional stage
        stage('DEPLOY') {
            when { 
                expression { 
                    // This runs only if ALL is selected OR if 'DEPLOY' is selected
                    return params.TARGET_STAGE == 'ALL' || params.TARGET_STAGE == 'DEPLOY'
                }
            }
            steps {
                echo 'Running deploy stage...'
                // sh 'deployment commands'
            }
        }
    }
}