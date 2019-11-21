def getEnvFromBranch(branch) {
  if (branch == 'release') {
    return 'ALL'
  } else if (branch == 'develop') {
    return 'DEV'
  }
}

pipeline {
    
    environment {
      ANYPOINT = credentials("ANYPOINT")
      //DEPLOY_TO = getEnvFromBranch(env.BRANCH_NAME)
      // CloudHub (CH) | Mule China Onprem (ARM_C) | Mule EU Onprem (ARM_EU) 
      DEPLOY_TARGET = 'CH'
      //CloudHub Enviroments
      CH_ENV_DEV = 'DEV'
      CH_ENV_QA = 'QA'
      CH_ENV_PROD = 'PRODUCTION'
      //China Onprem Enviroments
      ARM_C_ENV_DEV = 'DEV'
      ARM_C_ENV_QA = 'QA'
      ARM_C_ENV_PROD = 'PRODUCTION'
    }
    
    agent any
    options {
        office365ConnectorWebhooks([[name: 'mule-jenkins-connect', notifyBackToNormal: true, notifyFailure: true, notifyUnstable: true, url: 'https://outlook.office.com/webhook/64805a1d-9de2-48ae-b900-0adbb9f22248@22ddce65-9770-4012-94f0-da65409d3999/JenkinsCI/c2513a42b1b848e3a8f26522e8b3e8df/82ed54e0-8f97-4b40-96f8-94a9a532f7d0']])
    }
    stages { 
        /*stage('Initialize Master Branch Variables') {
            when {
                branch 'master'
            }
            steps {
                environment { 
                    DEPLOY_TO = 'DEV'
                }
            }
        }*/
        stage('Example') {
            steps {
                echo 'Hello - mule cicd Master'
            }
        }
        /*stage('Unit Test') { 
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
        /*stage('Deploy CloudHub - DEV') { 
              when {
                    environment name: 'DEPLOY_TARGET', value: 'CH'
              }
              environment {
                DEPLOY_TO = "${env.CH_ENV_DEV}"
                }
              steps {
                sh 'mvn deploy -P cloudhub -DANYPOINT_USERNAME=$ANYPOINT_USR -DANYPOINT_PASSWORD=$ANYPOINT_PSW -DCH_ENV=${env.DEPLOY_TO} -DCH_RGN=eu-west-1 -DCH_WORKERTYPE=Micro -DCH_WORKERS=1'
              }
        }
       stage('Deploy CloudHub - QA') { 
               when { 
                 environment name: 'DEPLOY_TARGET', value: 'CH'
                 anyOf { branch 'develop'; branch 'release' } 
               }
               environment {
                 DEPLOY_TO = "${env.CH_ENV_QA}"
                      }
               steps {
                      sh 'mvn deploy -P cloudhub -DANYPOINT_USERNAME=$ANYPOINT_USR -DANYPOINT_PASSWORD=$ANYPOINT_PSW -DCH_ENV=${env.DEPLOY_TO} -DCH_RGN=eu-west-1 -DCH_WORKERTYPE=Micro -DCH_WORKERS=1'
                    }
        }*/
       stage('Deploy CloudHub - PRODUCTION') { 
              when {
                allOf { branch 'develop'; environment name: 'DEPLOY_TARGET', value: 'CH' }            
              }             
              environment {
                DEPLOY_TO = "${env.CH_ENV_PROD}"
                }
              steps {
                echo "Hello1 - ${env.DEPLOY_TO}"
                /*script {
                    def proceed = true
                    try {
                        timeout(time: 15, unit: 'SECONDS') {
                            input(message: 'Deploy to production?')
                        }
                    } catch (err) {
                        echo 'Skipped production deployment'
                        proceed = false
                    }
                    if(proceed) {
                        echo 'Deploying to production'
                    }
                }*/            
                //sh 'mvn deploy -P cloudhub -DANYPOINT_USERNAME=$ANYPOINT_USR -DANYPOINT_PASSWORD=$ANYPOINT_PSW -DCH_ENV=${env.DEPLOY_TO} -DCH_RGN=eu-west-1 -DCH_WORKERTYPE=Micro -DCH_WORKERS=1'
              }
        }
        /*stage('Deploy ARM') { 
            steps {
                sh 'mvn deploy -P arm -DANYPOINT_USERNAME=$ANYPOINT_USR -DANYPOINT_PASSWORD=$ANYPOINT_PSW -DARM_ENV=$DEPLOY_TO -DARM_TARGET=vm-mule -DARM_TARGET_TYPE=server'
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
        }*/
    }
}
