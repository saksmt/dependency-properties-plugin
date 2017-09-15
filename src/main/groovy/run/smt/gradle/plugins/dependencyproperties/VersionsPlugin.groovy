package run.smt.gradle.plugins.dependencyproperties

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersionsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def versionsFile = project.rootDir.toPath().resolve('dependencies.properties').toFile()
        if (project.properties.containsKey('versionsFile')) {
            versionsFile = project.properties['versionsFile']
        }

        def versions = new Properties()
        project.file(versionsFile).withInputStream {
            versions.load(it)
        }

        project.extensions.extraProperties.setProperty('versions', versions)
    }
}
