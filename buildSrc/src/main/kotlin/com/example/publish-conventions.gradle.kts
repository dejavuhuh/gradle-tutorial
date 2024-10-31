import com.moandjiezana.toml.Toml

plugins {
    `maven-publish`
}

version = run {
    val file = rootProject.file("cz.toml")
    val toml = Toml().read(file)
    toml.getString("tool.commitizen.version")
}

publishing {
    repositories {
        mavenLocal()
    }
}

