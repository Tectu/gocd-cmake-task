package cd.go.contrib.task.skeleton;

import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;

public class GetConfigRequest {

    public GoPluginApiResponse execute() {
        HashMap<String, Object> config = new HashMap<>();

        HashMap<String, Object> buildType = new HashMap<>();
        buildType.put("display-order", "0");
        buildType.put("display-name", "Build Type");
        buildType.put("required", false);
        config.put(TaskPlugin.BUILD_TYPE, buildType);

        HashMap<String, Object> buildDir = new HashMap<>();
        buildDir.put("display-order", "1");
        buildDir.put("display-name", "Build Directory");
        buildDir.put("required", true);
        config.put(TaskPlugin.BUILD_DIRECTORY, buildDir);

        HashMap<String, Object> sourceDir = new HashMap<>();
        sourceDir.put("display-order", "2");
        sourceDir.put("display-name", "Source Directory");
        sourceDir.put("required", true);
        config.put(TaskPlugin.SOURCE_DIRECTORY, sourceDir);

        HashMap<String, Object> generator = new HashMap<>();
        generator.put("display-order", "3");
        generator.put("display-name", "Generator");
        generator.put("required", false);
        config.put(TaskPlugin.GENERATOR, generator);

        HashMap<String, Object> compilerC = new HashMap<>();
        compilerC.put("display-order", "4");
        compilerC.put("display-name", "C Compiler");
        compilerC.put("required", false);
        config.put(TaskPlugin.COMPILER_C, compilerC);

        HashMap<String, Object> compilerCpp = new HashMap<>();
        compilerCpp.put("display-order", "5");
        compilerCpp.put("display-name", "C++ Compiler");
        compilerCpp.put("required", false);
        config.put(TaskPlugin.COMPILER_CPP, compilerCpp);

        HashMap<String, Object> performBuild = new HashMap<>();
        performBuild.put("display-order", "6");
        performBuild.put("display-name", "Perform Build");
        performBuild.put("required", false);
        config.put(TaskPlugin.PERFORM_BUILD, performBuild);

        HashMap<String, Object> buildParallelJobs = new HashMap<>();
        buildParallelJobs.put("display-order", "7");
        buildParallelJobs.put("display-name", "Build Parallel Jobs");
        buildParallelJobs.put("required", false);
        config.put(TaskPlugin.BUILD_PARALLEL_JOBS, buildParallelJobs);

        HashMap<String, Object> cpackEnable = new HashMap<>();
        cpackEnable.put("display-order", "8");
        cpackEnable.put("display-name", "Enable CPack");
        cpackEnable.put("required", false);
        config.put(TaskPlugin.CPACK_ENABLE, cpackEnable);

        HashMap<String, Object> cpackGenerator = new HashMap<>();
        cpackGenerator.put("display-order", "9");
        cpackGenerator.put("display-name", "CPack Generator");
        cpackGenerator.put("required", false);
        config.put(TaskPlugin.CPACK_GENERATOR, cpackGenerator);

        HashMap<String, Object> cpackPackageFileName = new HashMap<>();
        cpackPackageFileName.put("display-order", "10");
        cpackPackageFileName.put("display-name", "CPack Package File Name");
        cpackPackageFileName.put("required", false);
        config.put(TaskPlugin.CPACK_PACKAGE_FILE_NAME, cpackPackageFileName);

        return DefaultGoPluginApiResponse.success(TaskPlugin.GSON.toJson(config));
    }
}
