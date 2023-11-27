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
            sh '''export MAVEN_HOME=/opt/maven
export PATH=$PATH:$MAVEN_HOME/bin
mvn --version
mvn clean package'''
          }
        }

      }
    }

  }
}