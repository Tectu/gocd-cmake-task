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
        sourceDir.put("display-order", "1");
        sourceDir.put("display-name", "Source Directory");
        sourceDir.put("required", true);
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

        HashMap<String, Object> performBuild = new HashMap<>();
        performBuild.put("display-order", "5");
        performBuild.put("display-name", "Perform Build");
        performBuild.put("required", false);
        config.put(TaskPlugin.PERFORM_BUILD, performBuild);

        HashMap<String, Object> buildParallelJobs = new HashMap<>();
        buildParallelJobs.put("display-order", "6");
        buildParallelJobs.put("display-name", "Build Parallel Jobs");
        buildParallelJobs.put("required", false);
        config.put(TaskPlugin.BUILD_PARALLEL_JOBS, buildParallelJobs);

        return DefaultGoPluginApiResponse.success(TaskPlugin.GSON.toJson(config));
    }
}
