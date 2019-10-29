package com.fortify.fod.parser;

import com.beust.jcommander.Parameter;
import com.fortify.fod.parser.converters.*;
import com.fortify.fod.parser.validators.FileValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FortifyCommands {
    private static final String HELP = "-help";
    private static final String HELP_SHORT = "-h";
    @Parameter(names = {HELP, HELP_SHORT},
            description = "print this message",
            help = true)
    public boolean help = false;


    private static final String VERSION = "-version";
    private static final String VERSION_SHORT = "-v";
    @Parameter(names = {VERSION, VERSION_SHORT},
            description = "print the version information and exit",
            help = true)
    public boolean version = false;

    private static final String ZIP_LOCATION = "-zipLocation";
    private static final String ZIP_LOCATION_SHORT = "-z";
    @Parameter(names = {ZIP_LOCATION, ZIP_LOCATION_SHORT},
            description = "location of scan",
            required = true,
            converter = FileConverter.class,
            validateWith = FileValidator.class)
    public File payload;

    private static final String TENANT_CODE = "-tenant";
    private static final String TENANT_CODE_SHORT = "-t";
    @Parameter(names = {TENANT_CODE, TENANT_CODE_SHORT},
            description = "tenant",
            required = true)
    public String tenant;

    private static final String RELEASE_ID = "-releaseId";
    private static final String RELEASE_ID_SHORT = "-r";
    @Parameter(names = {RELEASE_ID, RELEASE_ID_SHORT},
            description = "release id",
            required = true)
    public Integer release;

    public String scanTool = "FoDUploader";
    public String scanMethodType = "CICD";

    private static final String API_CREDENTIALS = "-apiCredentials";
    private static final String API_CREDENTIALS_SHORT = "-ac";
    @Parameter(names = {API_CREDENTIALS, API_CREDENTIALS_SHORT},
            description = "api credentials",
            arity = 2)
    public List<String> apiCredentials = new ArrayList<>();

    public boolean hasApiCredentials() {
        return apiCredentials != null &&
                apiCredentials.size() == 2;
    }

    private static final String USER_CREDENTIALS = "-userCredentials";
    private static final String USER_CREDENTIALS_SHORT = "-uc";
    @Parameter(names = {USER_CREDENTIALS, USER_CREDENTIALS_SHORT},
            description = "user credentials",
            arity = 2)
    public List<String> userCredentials = new ArrayList<>();

    public boolean hasUserCredentials() {
        return userCredentials != null &&
                userCredentials.size() == 2;
    }

    private static final String PROXY = "-proxy";
    private static final String PROXY_SHORT = "-P";
    @Parameter(names = {PROXY, PROXY_SHORT},
            description = "credentials for accessing the proxy",
            arity = 5,
            variableArity = true)
    public List<String> proxy = new ArrayList<>();

    public void version() {
        Package p = getClass().getPackage();
        System.out.println("Version " + p.getImplementationVersion());
    }

    public String getImplementedVersion() {
        return getClass().getPackage().getImplementationVersion();
    }
}
