
plugins {
    `maven-publish`
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        create<MavenPublication>("mavenJava") {
            plugins.withType<JavaPlugin> {
                from(components["java"])
            }
        }
    }
}

