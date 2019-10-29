# fod-uploader-java
Java Utility for uploading packages to FoD

## Usage

### Current

This fork of the FoDUpload launches start-scan-with-defaults instead of start-scan-advanced to fix TCP RST issues

```
FodUpload.jar -z <file> -ac <key> <secret> | -uc <username> <password> [-P <proxyUrl> <username> <password> <ntDomain> <ntWorkstation>] [-h] [-v]
```

Each option has a short and long name:

Short Name | Long Name              | Required? | Description                                                      
---------- | ---------------------- |:---------:| --------------------------------------------------------
 -z        | -zipLocation           | Yes       | Location of scan 
 -ac       | -apiCredentials        | Yes*      | Api credentials ("key:" does not need to be appended to `<key>`)                                                  
 -uc       | -userCredentials       | Yes*      | User login credentials ex (wrap each in quotations to avoid escaping characters in the CLI)                       
 -P        | -proxy                 | No        | Credentials for accessing the proxy                   
 -h        | -help                  | No        | Print help dialog                                                
 -v        | -version               | No        | Print jar version   

*One of either apiCredentials or userCredentials is required.

## Developer Setup

The FoD-Uploader is configured to build a fat jar with the Gradle Shadow plugin as the default gradle task.

To compile, simply use the gradlew or gradlew.bat depending on your operating system.

```
.\gradlew.bat
```

For a better breakdown of the build process, compile gradle with the following:

```
.\gradlew.bat -I init.gradle build
```

If you are behind a firewall, you will need to configure gradle's proxy settings in:

*/\<user-directory>/.gradle/gradle.properties*

```
systemProp.http.proxyHost=<web-proxy-host>
systemProp.http.proxyPort=<web-proxy-port>

systemProp.https.proxyHost=<web-proxy-host>
systemProp.https.proxyPort=<web-proxy-port>
```
