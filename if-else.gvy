pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                script {
                    // Define a variable (you can replace this with your condition)
                    def condition = true

                    // If-Else condition
                    if (condition) {
                        echo "Condition is true. This block will be executed."
                        // Add your steps for the true condition here
                    } else {
                        echo "Condition is false. This block will be executed."
                        // Add your steps for the false condition here
                    }
                }
            }
        }
    }
}