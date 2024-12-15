package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;
import com.mukul.corediagnostics.network.utils.CommandUtils;

public class PingOperation implements NetworkOperation {
    @Override
    public NetworkResult execute(String target) throws Exception{
        String command = "ping " + target;
        return CommandUtils.executeCommand(command,target);
    }
}