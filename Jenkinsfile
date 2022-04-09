pipeline{
 
    agent any

    stages {
      
        stage ('redirect') {
          
          steps{
            sh 'cd /api/' 
          }
          
        }
        stage ('compile stage') {

            steps{
                withMaven(maven : 'maven_3_8_5') {
                    sh 'mvn clean compile'
                }
            }

        }

        stage ('Testing stage'){
            steps{
                withMaven(maven : 'maven_3_8_5') {
                    sh 'mvn test'
                }
            }

        }

        stage ('Deployment stage'){
            steps{
                withMaven(maven : 'maven_3_8_5') {
                    sh 'mvn deploy'
                }
            }

        }
    }
}
