package com.mukul.corediagnostics.network.utils;

import com.mukul.corediagnostics.network.models.NetworkResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandUtils {
    public static NetworkResult executeCommand(String command, String target) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = process.waitFor();

        return new NetworkResult(command, target, output.toString(), exitCode);
    }
}