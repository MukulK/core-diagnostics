package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;
import com.mukul.corediagnostics.network.utils.CommandUtils;

public class TNSPingOperation implements NetworkOperation {
    public NetworkResult execute(String target) throws Exception {
        String command = "tnsping " + target;
        return CommandUtils.executeCommand(command,target);
    }
}
