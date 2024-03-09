pipeline {
    agent any
    stages 
    {
        stage('Start') {
            steps {
                echo 'Hello'
            }
        }
        stage ('Invoke_test') {
            steps {
                build job: 'test', parameters: [
                string(name: 'STATE', value: "STOP")
                ]
            }
        }
        stage('End') {
            steps {
                echo 'Bye'
            }
        }
    }
}