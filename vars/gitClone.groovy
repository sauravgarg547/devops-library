// vars/gitClone.groovy
def call(String repoUrl, String branch = 'main') {
    checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]],
              userRemoteConfigs: [[url: repoUrl]]])
    echo "Successfully cloned ${repoUrl} on branch ${branch}"
}
