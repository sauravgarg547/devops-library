// vars/deploy.groovy  
def applyK8sManifest(String manifestPath) {  
    sh "kubectl apply -f ${manifestPath}"  
}  

def rollbackDeployment(String deploymentName) {  
    sh "kubectl rollout undo deployment/${deploymentName}"  
}  


// Pipeline mein Use:

// @Library('my-shared-lib') _  
// pipeline {  
//     stages {  
//         stage('Deploy to K8s') {  
//             steps { deploy.applyK8sManifest('k8s/deployment.yaml') }  
//         }  
//     }  
//     post {  
//         failure { deploy.rollbackDeployment('my-app') }  
//     }  
// }  
