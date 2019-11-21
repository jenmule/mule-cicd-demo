pipeline {
    
    environment {
      ANYPOINT = credentials("ANYPOINT")
    }
    
    agent any
    options {
        // Keep the 10 most recent builds
    buildDiscarder(logRotator(numToKeepStr:'10'))
  office365ConnectorWebhooks([[name: 'mule-jenkins-connect', notifyBackToNormal: true, notifyFailure: true, notifyUnstable: true, url: 'https://outlook.office.com/webhook/64805a1d-9de2-48ae-b900-0adbb9f22248@22ddce65-9770-4012-94f0-da65409d3999/JenkinsCI/c2513a42b1b848e3a8f26522e8b3e8df/82ed54e0-8f97-4b40-96f8-94a9a532f7d0']])
}
    stages { 
        stage('Example') {
            steps {
                echo 'Hello - mule cicd Master'
                sh 'echo "ANYPOINT is $ANYPOINT"'
                sh 'echo "ANYPOINT_USR is $ANYPOINT_USR"'
                sh 'echo "ANYPOINT_PSW is $ANYPOINT_PSW"'
                
                //Write to file
                dir("combined") {
                    sh 'echo $ANYPOINT > foo.txt'
                }
                sh 'echo $ANYPOINT_PSW > foo_psw.txt'
                sh 'echo $ANYPOINT_USR > foo_usr.txt'
            }
        }
        /*stage('Decide tag on Docker Hub') {
          steps {
            script {
              env.TAG_ON_DOCKER_HUB = input message: 'User input required',
                  parameters: [choice(name: 'Tag on Docker Hub', choices: 'no\nyes', description: 'Choose "yes" if you want to deploy this build')]
            }
          }
        }*/
        /*stage('Unit Test') { 
            input {
                  message 'Proceed?'
                  ok 'Yes!'
                  submitter 'sa'
                }
            steps {
                sh 'mvn clean test'
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'target\\munit-reports\\coverage', reportFiles: 'summary.html', reportName: 'Code Coverage', reportTitles: ''])
            }
            post {
                success {
                    junit 'target/surefire-reports/**-/*.xml' 
                }
            }
        }*/
        stage('Deploy CloudHub') { 
            steps {
                sh 'mvn deploy -P cloudhub -DANYPOINT_USERNAME=$ANYPOINT_USR -DANYPOINT_USERNAME=$ANYPOINT_PSW'
            }
        }
        /*stage('Deploy Standalone') { 
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
        }*/
    }
}
