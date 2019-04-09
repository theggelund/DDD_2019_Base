import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.2"

project {

    vcsRoot(Git)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(Git)
    }

    steps {
        exec {
            path = "build.sh"
            arguments = "--coverage"
        }
    }

    triggers {
        vcs {
        }
    }
})

object Git : GitVcsRoot({
    name = "Git"
    pollInterval = 15
    url = "https://github.com/theggelund/DDD_2019_TC.git"
    branchSpec = "+:*"
    authMethod = password {
        userName = "theggelund"
        password = "zxx17792d66e875161d50fa42b10888d3cd"
    }
})
