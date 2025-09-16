pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1'
        STACK_NAME = 'SimpleEC2Stack'
    }

    stages {
        stage('Deploy EC2') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'aws-credentials', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
                    sh '''
                    aws cloudformation deploy \
                        --stack-name $STACK_NAME \
                        --template-file templates/ec2.yaml \
                        --region $AWS_REGION \
                        --capabilities CAPABILITY_IAM
                    '''
                }
            }
        }
    }
}
