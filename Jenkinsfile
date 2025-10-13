pipeline {
  agent any

  environment {
    AWS_ACCESS_KEY_ID     = 'AKIA5UMDMQGBPB63UF4M'
    AWS_SECRET_ACCESS_KEY = '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'
    AWS_DEFAULT_REGION    = 'us-east-1'
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/Prashant-man/cf-deploy-pipeline.git'
      }
    }

   stage('List files') {
      steps {
        sh 'ls -R'
      }
    }


    stage('Deploy CloudFormation Stack') {
      steps {
        sh '''
          aws cloudformation deploy \
            --template-file templates/ec2.yaml \
            --stack-name MyEC2Stack \
            --capabilities CAPABILITY_NAMED_IAM
        '''
      }
    }
  }
}
