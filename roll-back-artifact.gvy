pipeline {
	agent any
	stages {
		stage('Git Checkout') {
			steps {
				git branch: 'master', credentialsId: 'Bitbucket', url: 'https://AnkitSiwach@bitbucket.org/devops-pankaj/fastenft_web.git'
			}
		}
		stage('Creating Artifact') {
			steps {
				archiveArtifacts artifacts: '**' , followSymlinks: false
			}
		}
		stage('Upload On AWS') {
			steps {
				sh 'echo "Uploading content with AWS"'
				sh 'aws s3 cp . s3://testing-rollback --recursive'
			}
		}
	}
}