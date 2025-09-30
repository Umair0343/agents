pipeline {
  agent any
  stages {
    stage('Contract Guardian') {
      steps {
        sh 'npm i -g @qodo/command'
        sh 'qodo contract-guardian --agent-file=agents/contract-guardian/agent.toml --service_repo=. --contract_path=openapi.yaml --mode=ci'
      }
    }
  }
}


