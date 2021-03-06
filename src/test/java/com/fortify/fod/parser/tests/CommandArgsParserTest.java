package com.fortify.fod.parser.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.beust.jcommander.JCommander;
import com.fortify.fod.parser.FortifyCommands;
import com.fortify.fod.parser.Proxy;
import org.junit.jupiter.api.Test;

class CommandArgsParserTest {

    @Test
    void testParseCommandArgs() {
        final String[] args = new String[]{
                "-ac", "key", "secret",
                "-z", "C:\\_Payloads_and_FPRs\\Static\\Payloads\\java\\10JavaDefects.zip",
                "-t", "Tenant1",
                "-r", "1234"

        };

        FortifyCommands fc = new FortifyCommands();
        JCommander jc = new JCommander(fc);
        jc.parse(args);

        assertEquals("Tenant1", fc.tenant);
        assertEquals(new Integer(1234), fc.release);
        assertEquals(2, fc.apiCredentials.size());
        assertEquals("key", fc.apiCredentials.get(0));
        assertEquals("secret", fc.apiCredentials.get(1));
    }

    @Test
    void testParseProxy() {
        final String[] args = new String[]{
                "-ac", "key", "secret",
                "-tenant", "Tenant1",
                "-r", "12345",
                "-z", "C:\\_Payloads_and_FPRs\\Static\\Payloads\\java\\10JavaDefects.zip",
                "-P", "location", "username", "password"
        };

        FortifyCommands fc = new FortifyCommands();
        JCommander jc = new JCommander(fc);
        jc.parse(args);
        Proxy proxy = new Proxy(fc.proxy);

        //assertEquals("location", proxy.getProxyUri());
        assertEquals("username", proxy.getUsername());
        assertEquals("password", proxy.getPassword());
    }
}
