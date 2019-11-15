pipeline {
    agent any
    options {
        office365ConnectorWebhooks([
            [name: "mule-jenkins-con", url: "https://outlook.office.com/webhook/64805a1d-9de2-48ae-b900-0adbb9f22248@22ddce65-9770-4012-94f0-da65409d3999/JenkinsCI/f6bd047ff6764b7bb375953d70a76382/82ed54e0-8f97-4b40-96f8-94a9a532f7d0", notifyFailure: true]
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
