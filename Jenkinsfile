pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh ' mvn clean install'
      }
    }

  }
  environment {
    Maven = 'C:\\Program Files\\Apache\\maven\\apache-maven-4.0.0-alpha-8'
  }
}