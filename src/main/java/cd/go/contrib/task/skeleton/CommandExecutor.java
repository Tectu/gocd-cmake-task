package cd.go.contrib.task.skeleton;

import com.thoughtworks.go.plugin.api.task.JobConsoleLogger;

import java.io.File;
import java.io.IOException;
import java.util.List;

// TODO: execute your task and setup stdout/stderr to pipe the streams to GoCD
public class CommandExecutor {
    private List<String> m_command;

    protected void setCommands(List<String> command) { m_command = command; }

    public Result execute(Context context, JobConsoleLogger console) {
        try {
            return runCommand(context, m_command, console);
        } catch (Exception e) {
            return new Result(false, "Failed to execute command", e);
        }
    }

    private Result runCommand(Context taskContext, List<String> commands, JobConsoleLogger console) throws IOException, InterruptedException {
        // Create process builder
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        console.printLine("Launching command: " + processBuilder.command());
        processBuilder.environment().putAll(taskContext.getEnvironmentVariables());
        processBuilder.directory(new File(taskContext.getWorkingDir()));

        // Start process
        Process process = processBuilder.start();
        console.readErrorOf(process.getErrorStream());
        console.readOutputOf(process.getInputStream());

        // Wait for process to finnish
        int exitCode = process.waitFor();
        process.destroy();

        if (exitCode != 0)
            return new Result(false, "Failed running process. Please check the output");

        return new Result(true, "Running process completed successfully.");
    }
}
