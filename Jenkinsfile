pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'chmod +x ./jenkins/scripts/build.sh'
        sh './jenkins/scripts/build.sh'
      }
    }
    stage('Test') {
      steps {
        sh 'chmod +x ./jenkins/scripts/test.sh'
        sh './jenkins/scripts/test.sh'
      }
    }
    stage('Deploy') {
      steps {
        sh 'chmod +x ./jenkins/scripts/deliver.sh'
        sh './jenkins/scripts/deliver.sh'
      }
    }
  }
  tools {
    maven 'M3'
  }
}