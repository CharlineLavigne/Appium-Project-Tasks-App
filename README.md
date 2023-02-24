# Appium Android Project
Here is a simple project automating the open source application Tasks.

## Requirements
* Java 11 or above
* Maven
* Android emulator
* Appium
* For more details, please visit : 
  * https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
  * https://appium.io/docs/en/about-appium/getting-started/?lang=en

## Current Project Versions
* Java 15.0.0
* Maven 3.9.0
* Testng 7.7.0
* Appium 2.0.0-beta.53

## Setup
1. Start any Android emulator
2. Build the Maven pom.xml
3. Install the application tested : Tasks.app
   * The application path is available within the project folder : AppiumAndroidProject/src/main/resources/app/tasks.apk
   * Drag and drop the application in the Android emulator or run `adb install <local path of the app on your local machine>` (*Note that the second option requires to have adb installed*)
4. Launch Appium server

## Launch Tests
In the project root folder run `mvn test -DsuiteXmlFile=testng.xml`

