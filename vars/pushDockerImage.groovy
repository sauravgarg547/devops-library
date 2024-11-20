// // vars/pushDockerImage.groovy
// def call(String sourceImage, String targetImage) {
//     withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
//         sh """
//             docker login -u ${dockerHubUser} -p ${dockerHubPass}
//             docker tag ${sourceImage} ${dockerHubUser}/${targetImage}
//             docker push ${dockerHubUser}/${targetImage}
//         """
//         echo "Successfully pushed ${targetImage} to DockerHub"
//     }
// }

def call(String sourceImage, String targetImage) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        try {
            sh """
                echo "${dockerHubPass}" | docker login -u "${dockerHubUser}" --password-stdin
                docker tag ${sourceImage} ${dockerHubUser}/${targetImage}
                docker push ${dockerHubUser}/${targetImage}
            """
            echo "✅ Successfully pushed ${targetImage} to DockerHub"
        } catch (Exception e) {
            echo "❌ Error occurred: ${e.message}"
            currentBuild.result = 'FAILURE'
            throw e
        } finally {
            sh "docker logout"
        }
    }
}
