pipeline {
  agent any
  environment {
    PATH = "C:\\Program Files\\Apache\\maven\\apache-maven-4.0.0-alpha-8"
  }
  stages {
    stage('Build') {
      steps {
        sh ' mvn clean install'
      }
    }

  }
}
