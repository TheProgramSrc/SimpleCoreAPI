## v0.1.7 - Snapshot
* Fixes to the module download
* Migrated to new module download system (repository based)
* Added required repository-id field to module properties
* Removed CloudModule.kt due to migration to new module download system

## v0.1.6 - Snapshot
* Added update system like update folder in bukkit servers
* Fixed modules not being loaded (Class Not Found Exception)
* Fixed Null Pointer Exception when abruptly disabling the api
* Improvements to the module load order
* Fixes to issue templates

## v0.1.4 - Snapshot / v0.1.5 - Snapshot
* Fixed build script not working
* Implemented custom actions

## v0.1.3 - Snapshot
* Added ability to re-deploy a version by specifying it in the environment variable `VERSION`
* Add a way to let know the user the current commit hash of the running release.
* Added Dokka
* Added Gradle Wrapper Validator
* Improve deploy script to update edited releases.
* Fixed shadowJar not saving the file without version
* Cleanup some code

## v0.1.2 - Snapshot
* Fixed fat jar not recognized by kotlin plugin [KTIJ-20430](http://youtrack.jetbrains.com/issue/KTIJ-20430)
* Added dokka
* Fixed `minimize()` removing dependencies
* Updated maven publish config
* Removed code-ql analysis because kotlin is not supported :/

## v0.1.1 - Snapshot
* Fixed empty dependency being loaded (Currently being fixed)
* Cleanup of the code
* Migration to Kotlin

## v0.1.0 - Snapshot
Hello, World!