pipeline {
  agent any
  stages {
    stage('Print Maven Vers') {
      parallel {
        stage('Print Maven Vers') {
          steps {
            echo 'Build'
            sh 'mvn --version'
          }
        }

        stage('Run Maven project') {
          steps {
            sh 'mvn clean install '
          }
        }

      }
    }

  }
}