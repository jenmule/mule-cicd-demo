pipeline {
    agent any
    options {
        office365ConnectorWebhooks([
            [name: "Office 365", url: "https://outlook.office.com/webhook/22f09f83-ab33-46f0-8ffa-3d000704ebf3@2bb82c64-2eb1-43f7-8862-fdc1d2333b50/JenkinsCI/bc5d776e5a2c4f77a4b2f94c14362bec/f8e05ff9-7932-45b2-ac3a-99b7a779e94e", notifyFailure: true]
        ])
    }
    stages { 
        stage('Example') {
            steps {
                echo 'Hello - mule cicd Master'
            }
        }
        stage('Unit Test') { 
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
