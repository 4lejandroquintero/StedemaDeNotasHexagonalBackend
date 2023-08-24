@Library('ceiba-jenkins-library') _

pipeline {
  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
    disableConcurrentBuilds()
  }

  tools {    
    nodejs 'NodeJS16'
  }

  stages {
    stage('Checkout') {
      steps {
        echo "------------>Checkout<------------"
        checkout scm
      }
    }

    stage('NPM Install') {
      steps {
        echo "------------>Instalacion NPM<------------"
        dir('BoletinCine') {
          sh 'npm install'
        }      
      }
    }
  

    stage('Unit Tests') {
      steps {
        echo "------------>Unit Tests<------------"
        dir('BoletinCine') {
          sh 'npm run test'
        }        
      }
    }

    stage('Tests end-to-end') {
      steps {
        echo "------------>End-to-end Tests<------------"
        echo "------Aquí se ejecutarán los test end-to-end------"
        /*dir('BoletinCine') {
          sh 'npm run test'
        }*/       
      }
    }
    
    stage('Codigo Estatico') {
      steps {
        echo "------------>Codigo con TSLint<------------"
        dir('BoletinCine') {
          sh 'npm run lint'
        }        
      }
    }

    stage('Static Code Analysis') {
      steps {
        echo '------------>Análisis de código estático<------------'
        sonarqubeMasQualityGatesP(sonarKey: 'co.com.ceiba.adn:bolestosdecine.jose.diaz',
          sonarName: 'ADN-BoletosDeCine-jose.diaz',
          sonarPathProperties: './sonar-project.properties')
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        dir('BoletinCine') {
          sh 'npm run build'
        }
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }

    success {
      echo 'This will run only if successful'
    }  

    unstable {
      echo 'This will run only if the run was marked as unstable'
    }

    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}