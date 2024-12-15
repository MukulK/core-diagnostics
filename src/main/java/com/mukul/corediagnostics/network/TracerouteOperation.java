package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;
import com.mukul.corediagnostics.network.utils.CommandUtils;

public class TracerouteOperation implements NetworkOperation {
    public NetworkResult execute(String target) throws Exception {

        String command="";
        String os = System.getProperty("os.name").toLowerCase();

        // Determine the appropriate traceroute command based on the operating system
        if (os.contains("win")) {
            command = "tracert " + target; // Windows
        } else {
            command = "traceroute " + target; // Unix-based
        }
        return CommandUtils.executeCommand(command,target);
    }
}
