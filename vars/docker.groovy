// Docker Build & Push 

// vars/docker.groovy  
def buildImage(String imageName, String tag = 'latest') {  
    sh "docker build -t ${imageName}:${tag} ."  
}  

def pushImage(String imageName, String tag = 'latest') {  
    withCredentials([usernamePassword(  
        credentialsId: 'dockerhub',  
        usernameVariable: 'DOCKER_USER',  
        passwordVariable: 'DOCKER_PASS'  
    )]) {  
        sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"  
        sh "docker push ${imageName}:${tag}"  
    }  
}  


// use case in pipeline
// @Library('my-shared-lib') _  
// pipeline {  
//     stages {  
//         stage('Docker Build') {  
//             steps { docker.buildImage('my-app') }  
//         }  
//         stage('Docker Push') {  
//             steps { docker.pushImage('my-app') }  
//         }  
//     }  
// }  
