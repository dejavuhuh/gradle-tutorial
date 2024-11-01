import com.moandjiezana.toml.Toml

plugins {
    id("publish-conventions")
}

version = run {
    val file = rootProject.file("cz.toml")
    val toml = Toml().read(file)
    toml.getString("tool.commitizen.version")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            plugins.withType<JavaPlugin> {
                from(components["java"])
            }
        }
    }
}

