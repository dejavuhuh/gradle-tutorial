import kotlin.io.path.createTempFile

plugins {
    `version-catalog`
    `publish-conventions`
}

catalog {
    versionCatalog {
        val files = files("../gradle/libs.versions.toml")

        // 替换 toml 文件中的 $libVersion 为当前项目的版本号，并写入临时文件
        val tomlFileContent = files.singleFile.readText()
        val replacedTomlFileContent = tomlFileContent.replace("\$libVersion", version.toString())
        val tempTomlFile = createTempFile("libs.versions", ".toml").toFile()
        tempTomlFile.deleteOnExit()
        tempTomlFile.writeText(replacedTomlFileContent)

        from(files(tempTomlFile.absolutePath))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
