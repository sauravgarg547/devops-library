// vars/pushDockerImage.groovy
def call(String sourceImage, String targetImage) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh """
            docker login -u ${dockerHubUser} -p ${dockerHubPass}
            docker tag ${sourceImage} ${dockerHubUser}/${targetImage}
            docker push ${dockerHubUser}/${targetImage}
        """
        echo "Successfully pushed ${targetImage} to DockerHub"
    }
}


