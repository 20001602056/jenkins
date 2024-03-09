pipeline {
     agent any
     stages {
        stage('Git Checkout'){
            steps{
                git branch: 'master', credentialsId: 'Bitbucket', url: 'https://AnkitSiwach@bitbucket.org/devops-pankaj/fastenft_web.git'
            }
        }
        stage('Upload On AWS') {
            steps {
                sh 'echo "Uploading content with AWS"'
                sh 'aws s3 cp . s3://testing-rollback --recursive' 
                }
            }
        stage('Creating validation in Cloudfront') {
            steps {
                sh 'echo "Clear caching in AWS Cloudfront"'
                sh 'aws cloudfront create-invalidation --distribution-id E4U616VTH66AM --paths "/*"' 
                }
            } 
         }
     }
