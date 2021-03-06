package io.linguarobot.aws.cdk.maven.process;

import com.google.common.collect.ImmutableList;
import io.linguarobot.aws.cdk.maven.CdkPluginException;

import javax.annotation.Nullable;
import java.util.List;

public class ProcessExecutionException extends CdkPluginException {

    private final Integer exitCode;
    private final List<String> command;

    public ProcessExecutionException(List<String> command, Throwable cause) {
        super("The process exited with an error", cause);
        this.command = ImmutableList.copyOf(command);
        this.exitCode = null;
    }

    public ProcessExecutionException(List<String> command, int exitCode, Throwable cause) {
        super("The process exited with " + exitCode + " exit code", cause);
        this.command = ImmutableList.copyOf(command);
        this.exitCode = exitCode;
    }

    @Nullable
    public Integer getExitCode() {
        return exitCode;
    }

}
