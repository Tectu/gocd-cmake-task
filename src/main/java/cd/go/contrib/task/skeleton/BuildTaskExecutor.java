package cd.go.contrib.task.skeleton;

import java.util.ArrayList;
import java.util.List;

public class BuildTaskExecutor extends CommandExecutor
{

    public BuildTaskExecutor(TaskConfig taskConfig) {
        // Assemble command
        List<String> command = new ArrayList<>();
        {
            command.add("cmake");

            command.add("--build");
            command.add(taskConfig.buildDir);

            if (!taskConfig.buildType.isEmpty()) {
                command.add("--config");
                command.add(taskConfig.buildType);
            }

            command.add("--parallel");
            command.add(taskConfig.buildParallelJobs);
        }

        setCommands(command);
    }
}
