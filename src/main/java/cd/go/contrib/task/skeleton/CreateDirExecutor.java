package cd.go.contrib.task.skeleton;

import java.util.ArrayList;
import java.util.List;

public class CreateDirExecutor extends CommandExecutor
{
    public CreateDirExecutor(TaskConfig taskConfig)
    {
        List<String> command = new ArrayList<>();

        command.add("mkdir");
        command.add(taskConfig.buildDir);

        setCommands(command);
    }
}
