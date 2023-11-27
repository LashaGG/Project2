pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            bat 'mvn clean test'
          }
        }

        stage('error') {
          steps {
            bat 'mvn --version'
          }
        }

      }
    }

  }
}