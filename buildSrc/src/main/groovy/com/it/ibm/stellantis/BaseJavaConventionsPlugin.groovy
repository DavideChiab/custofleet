package com.it.ibm.stellantis;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

class BaseJavaConventionsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // Plugin base
        project.pluginManager.apply 'java-library'
        project.pluginManager.apply 'maven-publish'

        // Repository Maven Central
        project.repositories {
            mavenLocal()
            maven {
                url = project.uri('https://repo.maven.apache.org/maven2/')
            }
        }

        // Config Java Toolchain (Java 17 con J9)
        project.extensions.configure(JavaPluginExtension) { java ->
            java.toolchain {
                languageVersion = JavaLanguageVersion.of(17)
            }
        }

        // Encoding UTF-8
        project.tasks.withType(JavaCompile).configureEach {
            options.encoding = 'UTF-8'
        }

        // Pubblicazione Maven solo se il progetto ha plugin java
        project.afterEvaluate {
            if (project.plugins.hasPlugin('java') || project.plugins.hasPlugin('java-library')) {
                project.extensions.configure(org.gradle.api.publish.PublishingExtension) { publishing ->
                    publishing.publications {
                        maven(org.gradle.api.publish.maven.MavenPublication) {
                            from(project.components.getByName("java"))
                        }
                    }
                }
            }
        }
    }
}
