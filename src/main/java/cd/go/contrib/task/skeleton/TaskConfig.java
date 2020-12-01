/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.contrib.task.skeleton;

import java.util.Map;

// TODO: edit this to map to the fields in your task configuration
public class TaskConfig {
    public final String buildDir;
    public final String sourceDir;
    public final String generator;
    public final String compilerC;
    public final String compilerCpp;

    public TaskConfig(Map config) {
        buildDir    = getValue(config, TaskPlugin.BUILD_DIRECTORY);
        sourceDir    = getValue(config, TaskPlugin.SOURCE_DIRECTORY);
        generator   = getValue(config, TaskPlugin.GENERATOR);
        compilerC   = getValue(config, TaskPlugin.COMPILER_C);
        compilerCpp = getValue(config, TaskPlugin.COMPILER_CPP);
    }

    private String getValue(Map config, String property) {
        return (String) ((Map) config.get(property)).get("value");
    }
}
