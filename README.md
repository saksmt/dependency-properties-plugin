# Dependency version management gradle plugin

## Motivation

In maven you can store your versions separate from your dependencies.
This plugins allows you to store your versions in separate `.properties` file

## Usage

```groovy
buildscript {
    repositories {
        mavenCentral()
    }
    
    dependencies {
        classpath 'run.smt.gradle.plugins:dependency-properties-plugin:1.0.0'
    }
}

// optionaly you can change your path to versions.properties:
ext.versionsFile = rootDir + '/my/custom/path/to/versions.properties'

apply plugin: 'run.smt.dependency-properties'

// now you can use them!

dependencies {
    compile "commons-lang:commons-lang:${versions['commons-lang']}"
    compile "org.springframework:spring-context:${versions.spring}"
    
    // more of them...
}
```