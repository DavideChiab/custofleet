package com.it.ibm.stellantis

import org.gradle.api.Plugin
import org.gradle.api.Project

class JavaConventionsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.pluginManager.apply 'java-library'
        project.pluginManager.apply 'maven-publish'

        project.repositories {
            mavenCentral()
        }
    }
}
