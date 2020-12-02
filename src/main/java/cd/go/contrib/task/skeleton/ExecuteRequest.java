package cd.go.contrib.task.skeleton;

import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import com.thoughtworks.go.plugin.api.task.JobConsoleLogger;

import java.util.Map;

public class ExecuteRequest {
    public GoPluginApiResponse execute(GoPluginApiRequest request) {
        Map executionRequest = (Map) new GsonBuilder().create().fromJson(request.requestBody(), Object.class);
        TaskConfig config = new TaskConfig((Map) executionRequest.get("config"));
        Context context = new Context((Map) executionRequest.get("context"));

        JobConsoleLogger logger = JobConsoleLogger.getConsoleLogger();
        Result result;

        // Create build directory
        {
            logger.printLine("Creating build directory...");
            CommandExecutor executor = new CreateDirExecutor(config);
            result = executor.execute(context, logger);
            if (!result.success()) {
                result = new Result(false, "Could not create directory: " + result.message());
                return new DefaultGoPluginApiResponse(result.responseCode(), TaskPlugin.GSON.toJson(result.toMap()));
            }
        }

        // Run cmake
        {
            logger.printLine("Starting cmake...");
            CmakeTaskExecutor executor = new CmakeTaskExecutor(config);
            result = executor.execute(context, logger);
            if (!result.success()) {
                result = new Result(false, "Running cake failed: " + result.message());
                return new DefaultGoPluginApiResponse(result.responseCode(), TaskPlugin.GSON.toJson(result.toMap()));
            }
        }

        // Run build (if supposed to)
        boolean performBuild = Boolean.parseBoolean(config.performBuild);
        if (performBuild) {
            logger.printLine("Starting to run build...");
            BuildTaskExecutor executor = new BuildTaskExecutor(config);
            result = executor.execute(context, logger);
            if (!result.success()) {
                result = new Result(false, "Running build failed: " + result.message());
                return new DefaultGoPluginApiResponse(result.responseCode(), TaskPlugin.GSON.toJson(result.toMap()));
            }
        }

        logger.printLine("Task completed successfully!");

        // We succeeded
        return new DefaultGoPluginApiResponse(200, "{ \"success\": true, \"message\": \"success\" }");
    }
}
