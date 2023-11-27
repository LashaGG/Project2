pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            bat 'mvn clean install'
          }
        }

        stage('') {
          steps {
            bat 'mvn --version'
          }
        }

      }
    }

  }
}