pluginManagement {
    repositories {
        maven {
            url = uri("https://nexus.kuku.me/repository/maven-public/")
        }
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://nexus.kuku.me/repository/maven-public/")
        }
    }
}

rootProject.name = "buildSrc"
