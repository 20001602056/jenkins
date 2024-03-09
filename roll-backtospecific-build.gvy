pipeline {
	agent any
	stages {
		stage('Copy Artifact') {
			steps { 
				copyArtifacts filter: '**' , fingerprintArtifacts: true, projectName: 'testing', selector: specific('$build_number') 
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
