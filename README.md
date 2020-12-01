# GoCD CMake Task Plugin

This is a plugin for [GoCD](https://gocd.org) providing a task for building CMake based projects (mainly C/C++ projects).

## Building
Build with:
```shell script
./gradlew clean test assemble
```

## Installation
See the [official GoCD documentation](https://docs.gocd.org/current/extension_points/plugin_user_guide.html#installing-and-uninstalling-of-plugins).

TL;DR: Place the plugin JAR under `<gocd_installation_directory>/plugins/external` and restart the server. The plugin
should show up in the plugins list of the administration site.

## Usage
In a pipeline job supposed to use this plugin, add a new `Plugin Task`. Select this plugin from the dropdown.
