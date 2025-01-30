// vars/notify.groovy  
def sendSlack(String message, String channel = '#devops') {  
    slackSend(  
        channel: channel,  
        color: 'good',  
        message: message  
    )  
}  

def sendBuildStatus() {  
    def status = currentBuild.currentResult  
    sendSlack("Build ${status}: ${env.JOB_NAME} #${env.BUILD_NUMBER}")  
}  


//Pipeline mein Use:
// @Library('my-shared-lib') _  
// pipeline {  
//     post {  
//         success { notify.sendBuildStatus() }  
//         failure { notify.sendBuildStatus() }  
//     }  
// }  

