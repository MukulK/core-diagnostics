package com.mukul.corediagnostics.diagnostics;

import java.lang.management.ManagementFactory;
import java.util.Properties;

public class SystemDiagnostics {
    public Properties fetchSystemProperties() {
        return System.getProperties();
    }

    public String fetchRuntimeClasspath() {
        return System.getProperty("java.class.path");
    }

    public String[] fetchCommandLineArgs() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toArray(new String[0]);
    }
}
