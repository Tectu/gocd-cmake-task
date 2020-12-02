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

### Config
The task configuration view looks like this:

![Task Configuration View](docs/screenshots/task_config_01.png)

CMake settings:

| Settings | Key | Sample Value | Description |
| :--- | :--- | :--- | :--- |
| Build directory | `build_directory` | `build` | The build directory relative to the pipeline directory |
| Source directory | `source_directory` | `.` | The source directory relative to the pipeline directory |
| Generator | `generator` | `Unix Makefiles` | The buildsystem generator to use |
| C Compiler | `compiler_c` | `gcc` | The C compiler to use (This value will be assigned to `CMAKE_C_COMPILER`) |
| C++ Compiler | `compiler_cpp` | `g++` | The C++ compiler to use (This value will be assigned to `CMAKE_CXX_COMPILER`) |

Build settings:

| Settings | Key | Sample Value | Description |
| :--- | :--- | :--- | :--- |
| Enable | `perform_build` | `true` | Whether to launch the build after cmake successfully generated the buildsystem |
| Parallel Jobs | `build_parallel_jobs` | `16` | The number of parallel jobs to use when building |
