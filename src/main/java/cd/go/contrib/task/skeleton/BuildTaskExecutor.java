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

            if (taskConfig.buildParallelJobs >= 1) {
                command.add("--parallel");
                command.add(String.valueOf(taskConfig.buildParallelJobs));
            }
        }

        setCommands(command);
    }
}
