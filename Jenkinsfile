pipeline {
    agent any
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
