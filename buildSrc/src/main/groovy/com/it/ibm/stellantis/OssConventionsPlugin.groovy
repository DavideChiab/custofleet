package com.it.ibm.stellantis

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.it.ibm.stellantis.OssConventionsExtension

/**
 * Plugin Gradle che definisce le dipendenze di base del progetto OSS. Alcune
 * dipendenze opzionali possono essere abilitate tramite l'estensione
 * {@link OssConventionsExtension} o le proprietà Gradle «oss.webflux»,
 * «oss.postgresql» e «oss.jerseyClient».
 */

class OssConventionsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        // Applica plugin Java
        project.pluginManager.apply 'java-library'

        // Repositories
        project.repositories {
            mavenCentral()
        }

        // Estensione per abilitare le dipendenze opzionali
        def extension = project.extensions.create('ossConventions', OssConventionsExtension)

        // Dipendenze di base
        project.dependencies {
            add("implementation", "com.fasterxml.jackson.core:jackson-databind:2.14.2")
            add("implementation", "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.14.2")
            add("implementation", "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
            add("implementation", "com.fasterxml.jackson.module:jackson-module-parameter-names:2.14.2")
            add("implementation", "com.fasterxml.jackson.core:jackson-core:2.14.2")
            add("implementation", "com.fasterxml.jackson.core:jackson-annotations:2.14.2")

            add("implementation", "org.openapitools:jackson-databind-nullable:0.2.6")


            add("implementation", "org.apache.logging.log4j:log4j-core:2.20.0")
            add("implementation", "org.apache.logging.log4j:log4j-api:2.20.0")

            add("implementation", "com.oracle.database.jdbc:ojdbc8:23.2.0.0")

            add("implementation", "javax.persistence:javax.persistence-api:2.2")
            add("implementation", "org.hibernate:hibernate-core:5.6.15.Final")

            add("implementation", platform("org.springframework.boot:spring-boot-dependencies:2.7.18"))
            add("implementation", "org.springframework.boot:spring-boot-starter")
            add("implementation", "org.springframework.boot:spring-boot-starter-data-jpa")
        }

        // Dipendenze opzionali abilitate tramite estensione o proprietà Gradle
        project.afterEvaluate {
            def enableWebflux = extension.webflux || project.findProperty('oss.webflux')?.toString()?.toBoolean()
            def enablePostgresql = extension.postgresql || project.findProperty('oss.postgresql')?.toString()?.toBoolean()
            def enableJerseyClient = extension.jerseyClient || project.findProperty('oss.jerseyClient')?.toString()?.toBoolean()

            project.dependencies {
                if (enablePostgresql) {
                    add('implementation', 'org.postgresql:postgresql:42.6.0')
                }
                if (enableJerseyClient) {
                    add('implementation', 'org.glassfish.jersey.core:jersey-client:3.0.10')
                }
                if (enableWebflux) {
                    add('implementation', 'org.springframework.boot:spring-boot-starter-webflux')
                }
            }
        }
    }
}
