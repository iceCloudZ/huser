pipeline {
  agent any
  stages {
    stage('检出') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: env.GIT_BUILD_REF]], 
                                                                                                                                                                    userRemoteConfigs: [[url: env.GIT_REPO_URL, credentialsId: env.CREDENTIALS_ID]]])
      }
    }
    stage('编译') {
      steps {
        sh 'mvn clean install -U -Dmaven.test.skip'
      }
    }
    stage('打包镜像') {
      steps {
        sh "docker build -t ${TKE_REPO}:${env.GIT_BUILD_REF} ."
        sh "docker tag ${TKE_REPO}:${env.GIT_BUILD_REF} ${ARTIFACT_IMAGE}:latest"
        sh "docker tag ${TKE_REPO}:${env.GIT_BUILD_REF} ${TKE_REPO}:latest"
      }
    }
    stage('推送到ccr制品库') {
      steps {
        sh 'docker login -u 100000778480 -p Zzh320281 ccr.ccs.tencentyun.com'
        sh "docker push ${TKE_REPO}:latest"
      }
    }
    stage('推送到code.net制品库') {
      steps {
        sh "docker login -u LJUUQddXzI -p PPNN13%y jiujiuhouse-docker.pkg.coding.net"
        sh "docker push ${ARTIFACT_IMAGE}:latest"
      }
    }
  }
  environment {
    ENTERPRISE = 'jiujiuhouse'
    PROJECT = 'huser'
    ARTIFACT = 'huser'
    CODE_DEPOT = 'huser'
    ARTIFACT_BASE = "${ENTERPRISE}-docker.pkg.coding.net"
    ARTIFACT_IMAGE = "${ARTIFACT_BASE}/${PROJECT}/${ARTIFACT}/${CODE_DEPOT}"
    TKE_REPO = 'ccr.ccs.tencentyun.com/tsf_100000778480/huser'
  }
}