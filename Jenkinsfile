pipeline {
    agent any
    options {
  office365ConnectorWebhooks([[name: 'mule-jenkins-connect', notifyBackToNormal: true, notifyFailure: true, notifyUnstable: true, url: 'https://outlook.office.com/webhook/64805a1d-9de2-48ae-b900-0adbb9f22248@22ddce65-9770-4012-94f0-da65409d3999/JenkinsCI/c2513a42b1b848e3a8f26522e8b3e8df/82ed54e0-8f97-4b40-96f8-94a9a532f7d0']])
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
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'target\\munit-reports\\coverage', reportFiles: 'summary.html', reportName: 'Code Coverage', reportTitles: ''])
            }
        }
        stage('Deploy Standalone') { 
            steps {
                sh 'mvn deploy -P standalone -Dmule.home=/home/sab/Downloads/opt/mule3'
            }
        }
        stage('Artifact') {  
            when {
                branch 'master'
            }
            steps {
                    echo 'Push to Artifactory'
            }
        }
    }
}
