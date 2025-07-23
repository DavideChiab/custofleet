package com.it.ibm.stellantis

import org.gradle.api.Plugin
import org.gradle.api.Project

class OssConventionsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        // Applica plugin Java
        project.pluginManager.apply 'java-library'

        // Repositories
        project.repositories {
            mavenCentral()
        }

        // Dipendenze
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

            add("implementation", "org.postgresql:postgresql:42.6.0")
            add("implementation", "com.oracle.database.jdbc:ojdbc8:23.2.0.0")

            add("implementation", "javax.persistence:javax.persistence-api:2.2")
            add("implementation", "org.hibernate:hibernate-core:5.6.15.Final")

            add("implementation", "org.glassfish.jersey.core:jersey-client:3.0.10")

            add("implementation", platform("org.springframework.boot:spring-boot-dependencies:2.7.18"))
            add("implementation", "org.springframework.boot:spring-boot-starter")
            add("implementation", "org.springframework.boot:spring-boot-starter-data-jpa")
            add("implementation", "org.springframework.boot:spring-boot-starter-webflux")
        }
    }
}
