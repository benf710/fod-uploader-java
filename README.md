# fod-uploader-java
Java Utility for uploading packages to FoD

## Usage

### Current

The command line arguments have been completely reworked for 2.x. Arguments are now named and can be in any order: 

```
FodUpload.jar -bsi <token> -z <file> -ac <key> <secret> | -uc <username> <password> -ep <1|SingleScan|2|Subscription>
[-purchase] [-I <minutes>] [-p <1|Standard|2|Express>] [-P <proxyUrl> <username> <password> <ntDomain> <ntWorkstation>] [-r] [-h] [-v]
```

Each option has a short and long name:

Short Name | Long Name              | Required? | Description                                                      
---------- | ---------------------- |:---------:| --------------------------------------------------------
 -bsi      | -bsiToken              | Yes       | Build server token
 -z        | -zipLocation           | Yes       | Location of scan 
 -ep       | -entitlementPreference | Yes       | Whether to use a single scan or subscription assessment (if available) (1/Single, 2/Subscription)
 -ac       | -apiCredentials        | Yes*      | Api credentials ("key:" does not need to be appended to `<key>`)                                                  
 -uc       | -userCredentials       | Yes*      | User login credentials ex (wrap each in quotations to avoid escaping characters in the CLI)            
 -p        | -scanPreferenceId      | No        | Scan mode (1/Standard, 2/Express)                            
 -I        | -pollingInterval       | No        | Interval between checking scan status in minutes                 
 -P        | -proxy                 | No        | Credentials for accessing the proxy                   
 -h        | -help                  | No        | Print help dialog                                                
 -v        | -version               | No        | Print jar version   
 -r        | -isRemediationScan     | No        | Whether the scan is in remediation 
 -n        | -notes                 | No        | The notes about the scan.

*One of either apiCredentials or userCredentials is required.

### Migration to 2.0

If moving from the old version to this version, there are a few changes required:

Please be sure to adjust your arguments to fit the format described under **Current**.

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
