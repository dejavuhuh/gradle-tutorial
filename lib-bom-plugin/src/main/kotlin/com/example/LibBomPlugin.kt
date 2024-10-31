package com.example

import dev.aga.gradle.versioncatalogs.Generator.generate
import java.net.URI
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

data class DependencyManagementConfiguration(var version: String? = null)

fun Settings.dependencyManagement(configure: DependencyManagementConfiguration.() -> Unit) {
    val (version) = DependencyManagementConfiguration().apply(configure)
    if (version == null) {
        error("version property must be set within dependencyManagement {} block")
    }

    dependencyResolutionManagement {
        repositories {
            mavenLocal()
            maven {
                url = URI("https://nexus.kuku.me/repository/maven-public/")
            }
        }
        versionCatalogs {
            create("commonLibs") {
                from("com.example:lib-bom:$version")
            }
            generate("springLibs") {
                from(toml("springBootDependencies"))
            }
        }
    }
}

class LibBomPlugin: Plugin<Settings> {
    override fun apply(settings: Settings): Unit = with(settings) {
        plugins.apply("dev.aga.gradle.version-catalog-generator")
    }
}
