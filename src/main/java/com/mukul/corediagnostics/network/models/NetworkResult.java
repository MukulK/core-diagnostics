package com.mukul.corediagnostics.network.models;

public class NetworkResult {
    private final String command;
    private final String target;
    private final String output;
    private final int exitCode;

    public NetworkResult(String command, String target, String output, int exitCode) {
        this.command = command;
        this.target = target;
        this.output = output;
        this.exitCode = exitCode;
    }

    public String getCommand() {
        return command;
    }

    public String getTarget() {
        return target;
    }

    public String getOutput() {
        return output;
    }

    public int getExitCode() {
        return exitCode;
    }

    @Override
    public String toString() {
        return String.format("Command: %s, Target: %s, ExitCode: %d%nOutput:%n%s", command, target, exitCode, output);
    }
}
