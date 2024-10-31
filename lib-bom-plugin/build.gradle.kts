plugins {
    `java-gradle-plugin`
    `publish-conventions`
    `kotlin-dsl`
}

dependencies {
    implementation(libs.dagp)
}

gradlePlugin {
    plugins {
        create("lib-bom-plugin") {
            id = "com.example.lib-bom-plugin"
            implementationClass = "com.example.LibBomPlugin"
        }
    }
}
