def call() {
    sh 'docker-compose down'
    sh 'docker-compose build && docker-compose up -d'
}
