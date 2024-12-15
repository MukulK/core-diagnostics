package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;
import com.mukul.corediagnostics.network.utils.CommandUtils;

public class NSLookupOperation implements NetworkOperation {

    @Override
    public NetworkResult execute(String target) throws Exception {
        String command = "nslookup " + target;
        return CommandUtils.executeCommand(command,target);
    }
}
