// vars/dockerCompose.groovy

def call() {
    // Bring down any running containers
    sh 'docker-compose down'
    
    // Build the Docker images defined in docker-compose.yml
    sh 'docker-compose build'
    
    // Start the containers in detached mode
    sh 'docker-compose up -d'
}
