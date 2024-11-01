import com.example.dependencyManagement

/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.10.2/userguide/multi_project_builds.html in the Gradle documentation.
 */
pluginManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://nexus.kuku.me/repository/maven-public/")
        }
    }
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("com.example.lib-bom-plugin") version "0.2.1"
    id("com.mooltiverse.oss.nyx") version "3.0.0"
}

rootProject.name = "gradle-tutorial"
include("lib-a", "lib-b", "lib-bom", "lib-bom-plugin")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyManagement {
    version = "0.0.2"
}

nyx {
    preset = "simple"
    changelog {
        path = "CHANGELOG.md"
    }
    releaseTypes {
        publicationServices = listOf("github")
        items {
            create("mainline") {
                gitCommit = "true"
                description = "{{#fileContent}}CHANGELOG.md{{/fileContent}}"
                gitTag = "true"
                gitTagForce = "true"
            }
        }
    }
    services {
        create("github") {
            type = "GITHUB"
            options {
                put("AUTHENTICATION_TOKEN", "{{#environmentVariable}}GH_TOKEN{{/environmentVariable}}")
                put("REPOSITORY_NAME", "gradle-tutorial")
                put("REPOSITORY_OWNER", "dejavuhuh")
            }
        }
    }
}



