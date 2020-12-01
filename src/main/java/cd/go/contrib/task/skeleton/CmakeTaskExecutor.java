package cd.go.contrib.task.skeleton;

import java.util.ArrayList;
import java.util.List;

public class CmakeTaskExecutor extends CommandExecutor
{

    public CmakeTaskExecutor(TaskConfig taskTaskConfig) {
        // Assemble command
        List<String> command = new ArrayList<>();
        {
            // Executable
            command.add("cmake");

            // Build directory
            command.add("-B");
            command.add(taskTaskConfig.buildDir);

            // Source directory
            command.add("-S");
            command.add(taskTaskConfig.sourceDir);

            // Generator
            if (!taskTaskConfig.generator.isEmpty()) {
                command.add("-G");
                command.add(taskTaskConfig.generator);
            }

            // C Compiler
            if (!taskTaskConfig.compilerC.isEmpty())
                command.add("-DCMAKE_C_COMPILER=" + taskTaskConfig.compilerC);

            // C++ Compiler
            if (!taskTaskConfig.compilerCpp.isEmpty())
                command.add("-DCMAKE_CXX_COMPILER=" + taskTaskConfig.compilerCpp);
        }

        setCommands(command);
    }
}
