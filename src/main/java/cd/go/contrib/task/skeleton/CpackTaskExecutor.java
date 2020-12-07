package cd.go.contrib.task.skeleton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CpackTaskExecutor extends CommandExecutor
{

    public CpackTaskExecutor(TaskConfig taskConfig) {
        // Assemble command
        List<String> command = new ArrayList<>();
        {
            command.add("cpack");

            if (!taskConfig.cpackGenerator.isEmpty()) {
                command.add("-G");
                command.add(taskConfig.cpackGenerator);
            }

            if (!taskConfig.buildType.isEmpty()) {
                command.add("-C");
                command.add(taskConfig.buildType);
            }

            // Build directory
            command.add("--config");
            command.add(taskConfig.buildDir + File.separator + "CPackConfig.cmake");

            // Override package file name
            if (!taskConfig.cpackPackageFileName.isEmpty()) {
                command.add("-D");
                command.add("CPACK_PACKAGE_FILE_NAME=" + taskConfig.cpackPackageFileName);
            }
        }

        setCommands(command);
    }
}
