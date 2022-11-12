pipeline {
    agent any
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Maven3.8.6') {
                    bat 'mvn clean'
                }
            }
        }
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Maven3.8.6') {
                    bat 'mvn verify'
                }
            }
        }
        
    }
}
