package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;
import com.mukul.corediagnostics.network.utils.CommandUtils;

public class NetstatOperation implements NetworkOperation {
    public NetworkResult execute(String target) throws Exception {
        String command;
        String os = System.getProperty("os.name").toLowerCase();

        // Determine the appropriate netstat command based on the operating system
        if (os.contains("win")) {
            command = "netstat -a"; // Windows
        } else {
            command = "netstat -an"; // Unix-based
        }
        return CommandUtils.executeCommand(command,"N/A");
    }
}
