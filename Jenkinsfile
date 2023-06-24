pipeline {
    agent any
    
    tools {
        //Que herramientas queremos utilizar 
        maven "Maven"
        jdk "Java 11"
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }
    
    stages {
        stage('Hello') {
            steps {
                echo "Database engine is ${DB_ENGINE}"
                echo "DISABLE_AUTH is ${DISABLE_AUTH}"
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "Job Name: ${env.JOB_NAME}"
                echo "Job Name: ${env.JAVA_HOME}"
            }
            
        }
        
        stage('Git Polling'){
            steps{
                //git branch: 'main', url: 'https://github.com/gabrielr291/PruebaTeorica'
                git branch: 'main', credentialsId: 'GitHubKey', url: 'git@github.com:gabrielr291/PruebaTeorica.git'
                
            }
        }
        
        stage('BUILD CON MAVEN'){
            steps{
               bat "mvn clean package -DskipTests" //windows
               
               // sh "mvn -Dmaven.test.failure.ignore=true clean package " //Unix
            }
            
            post{
                success{
                    echo 'Archivar Artefactos'
                    archiveArtifacts "target/*.jar"
                }
            }
        }
        
        stage('test maven'){
            steps{
                bat "mvn test"
                //sh "mvn test"
            }
        }
		
		stage('Coverage Report') {
			steps {
			// Paso para generar el informe de cobertura
				 bat 'mvn jacoco:prepare-agent test jacoco:report' // Comando para generar el informe de jacoco con Maven
			}
		}
	}
	post {
       	always {
			// Archivar los informes de cobertura
			jacoco(execPattern: '**/target/jacoco.exec')
           	jacoco(classPattern: '**/target/classes', sourcePattern: 'src/main/java')
        }
    }
	
}