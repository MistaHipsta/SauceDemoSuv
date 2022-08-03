pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
    //parameters {
        //choice choices: ['smoke.xml', 'regression.xml'], name: 'TEST_SET'
      //}

            gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select branch to run tests', name: 'BRANCH', type: 'PT_BRANCH'
            credentials credentialType: 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl', defaultValue: 'standard_user', name: 'CREDS', required: false
        }

    stages {
        stage('Build') {
            steps {
                 // Get some code from a GitHub repository
                 git branch: "${params.BRANCH}", url: 'https://github.com/MistaHipsta/SauceDemoSuv.git'

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn clean test -DsuiteXmlFile=src/main/resources/smoke.xml"
            }
        }
        stage('Allure') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}