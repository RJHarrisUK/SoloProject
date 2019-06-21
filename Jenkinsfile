pipeline{
        agent any
        stages{
		stage('---setup---'){
                        steps{
                                sh "sudo rm -rf /var/lib/wildfly-10.1.0.Final/standalone/deployments/*"
                        }
                }
                stage('--package--'){
                        steps{
                                sh "mvn package"
                        }
                }
		stage('--deploy--'){
                        steps{
                                sh "cd /"
				sh "pwd"
				sh "sudo cp target/SoloProject.war /var/lib/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }
        }
}
