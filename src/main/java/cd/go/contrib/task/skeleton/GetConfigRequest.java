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

// TODO: change this to allow configuration options in your configuration
public class GetConfigRequest {

    public GoPluginApiResponse execute() {
        HashMap<String, Object> config = new HashMap<>();

        HashMap<String, Object> url = new HashMap<>();
        url.put("display-order", "0");
        url.put("display-name", "Url");
        url.put("required", true);
        config.put(TaskPlugin.URL_PROPERTY, url);

        HashMap<String, Object> secure = new HashMap<>();
        secure.put("default-value", TaskPlugin.SECURE_CONNECTION);
        secure.put("display-order", "1");
        secure.put("display-name", "Secure Connection");
        secure.put("required", false);
        config.put(TaskPlugin.SECURE_CONNECTION_PROPERTY, secure);

        HashMap<String, Object> requestType = new HashMap<>();
        requestType.put("default-value", TaskPlugin.REQUEST_TYPE);
        requestType.put("display-order", "2");
        requestType.put("display-name", "Request Type");
        requestType.put("required", false);
        config.put(TaskPlugin.REQUEST_PROPERTY, requestType);

        HashMap<String, Object> additionalOptions = new HashMap<>();
        additionalOptions.put("display-order", "3");
        additionalOptions.put("display-name", "Additional Options");
        additionalOptions.put("required", false);
        config.put(TaskPlugin.ADDITIONAL_OPTIONS, additionalOptions);

        return DefaultGoPluginApiResponse.success(TaskPlugin.GSON.toJson(config));
    }
}
