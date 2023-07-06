def call(command) {
    try {
        docker.image("releaseworks/awscli:latest").inside("--entrypoint \"\" -e AWS_ACCESS_KEY_ID -e AWS_SECRET_ACCESS_KEY -e AWS_DEFAULT_REGION --mount type=bind,source=/home/angela/work/template/work/,target=/work") {
            sh "aws ${command}"
        }
    } catch( ClassNotFoundException e ) {
        throw new Exception("Docker Pipeline plugin required")
    }
}
