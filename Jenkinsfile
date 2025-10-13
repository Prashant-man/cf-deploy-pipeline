pipeline {
  agent any

  environment {
    AWS_DEFAULT_REGION = 'us-east-1'  // your AWS region
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/Prashant-man/cf-deploy-pipeline.git'
      }
    }

    stage('Deploy CloudFormation Stack') {
      steps {
        withCredentials([[
          $class: 'AmazonWebServicesCredentialsBinding', 
          credentialsId: '245d8a7b-a2f6-4ebe-b09a-ab58c64a1815' // your Jenkins credential ID
        ]]) {
          sh '''
            echo "Deploying CloudFormation stack using templates/ec2.yaml"
            aws cloudformation deploy \
              --template-file templates/ec2.yaml \
              --stack-name MyEC2Stack \
              --capabilities CAPABILITY_NAMED_IAM
          '''
        }
      }
    }
  }
}
