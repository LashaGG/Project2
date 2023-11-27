pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh 'mvn clean install'
          }
        }

        stage('Print Maven Version') {
          steps {
            sh 'mvn --version'
          }
        }

      }
    }

  }
}