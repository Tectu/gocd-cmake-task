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

import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;

public class GetConfigRequest {

    public GoPluginApiResponse execute() {
        HashMap<String, Object> config = new HashMap<>();

        HashMap<String, Object> buildDir = new HashMap<>();
        buildDir.put("display-order", "0");
        buildDir.put("display-name", "Build Directory");
        buildDir.put("required", true);
        config.put(TaskPlugin.BUILD_DIRECTORY, buildDir);

        HashMap<String, Object> sourceDir = new HashMap<>();
        buildDir.put("display-order", "1");
        buildDir.put("display-name", "Source Directory");
        buildDir.put("required", true);
        config.put(TaskPlugin.SOURCE_DIRECTORY, sourceDir);

        HashMap<String, Object> generator = new HashMap<>();
        generator.put("display-order", "2");
        generator.put("display-name", "Generator");
        generator.put("required", false);
        config.put(TaskPlugin.GENERATOR, generator);

        HashMap<String, Object> compilerC = new HashMap<>();
        compilerC.put("display-order", "3");
        compilerC.put("display-name", "C Compiler");
        compilerC.put("required", false);
        config.put(TaskPlugin.COMPILER_C, compilerC);

        HashMap<String, Object> compilerCpp = new HashMap<>();
        compilerCpp.put("display-order", "4");
        compilerCpp.put("display-name", "C++ Compiler");
        compilerCpp.put("required", false);
        config.put(TaskPlugin.COMPILER_CPP, compilerCpp);

        return DefaultGoPluginApiResponse.success(TaskPlugin.GSON.toJson(config));
    }
}
