pipeline {
  agent any

  environment {
    AWS_ACCESS_KEY_ID     = credentials('AKIA5UMDMQGBPB63UF4M')        // Your Jenkins credential ID
    AWS_SECRET_ACCESS_KEY = credentials('WEPDWhAkRKm46UjX4P/yLKgm1AGakMzFna/QtPdt')    // Your Jenkins credential ID
    AWS_DEFAULT_REGION     = 'us-east-1'                             // Set your region
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/Prashant-man/cf-deploy-pipeline.git'
      }
    }

    stage('Deploy CloudFormation Stack') {
      steps {
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
