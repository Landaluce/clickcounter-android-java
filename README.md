[![Travis-CI Build Status](https://travis-ci.org/LoyolaChicagoCode/clickcounter-android-java.svg?branch=master)](https://travis-ci.org/LoyolaChicagoCode/clickcounter-android-java)
[![BuddyBuild Status](https://dashboard.buddybuild.com/api/statusImage?appID=5855a9487c97b60100e6e5d6&branch=master&build=latest)](https://dashboard.buddybuild.com/apps/5855a9487c97b60100e6e5d6/build/latest?branch=master)
[![Bitrise Build Status](https://www.bitrise.io/app/30d887c4432aae84.svg?token=he-jVnNMOn-4NnxAJCshOA&branch=master)](https://www.bitrise.io/app/30d887c4432aae84)
[![Download from Bintray](https://api.bintray.com/packages/loyolachicagocode/generic/clickcounter-android-java/images/download.svg) ](https://bintray.com/loyolachicagocode/generic/clickcounter-android-java/_latestVersion)
[![License](http://img.shields.io/:license-mit-blue.svg)](http://doge.mit-license.org)

[![codecov.io](https://codecov.io/github/LoyolaChicagoCode/clickcounter-android-java/branch/master/graph/badge.svg)](https://codecov.io/github/LoyolaChicagoCode/clickcounter-android-java)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3f4e4411f308417e81c950228f5d299f)](https://www.codacy.com/app/laufer/clickcounter-android-java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LoyolaChicagoCode/clickcounter-android-java&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/f3b52f05-9bb8-4b6a-9c17-52bb5d9b433f)](https://codebeat.co/projects/github-com-loyolachicagocode-clickcounter-android-java)

[![Pull requests closed in](http://issuestats.com/github/LoyolaChicagoCode/clickcounter-android-java/badge/pr)](http://issuestats.com/github/LoyolaChicagoCode/clickcounter-android-java)
[![Issues closed in](http://issuestats.com/github/LoyolaChicagoCode/clickcounter-android-java/badge/issue)](http://issuestats.com/github/LoyolaChicagoCode/clickcounter-android-java)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/LoyolaChicagoCode/clickcounter-android-java.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/clickcounter-android-java "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/LoyolaChicagoCode/clickcounter-android-java.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/clickcounter-android-java "Percentage of issues still open")

# Learning Objectives

* Simple dependency injection
* Event-driven program execution
* State dependence in applications
* Mapping the model-view-adapter architecture to Android (and the command-line)
* Android application life cycle management (including rotation and back button)
* Playing a notification sound in Android
* Adapter pattern (wrapper, as opposed to the adapter in MVA)
* Dependency inversion principle (DIP)
* Automated unit and integration testing with JUnit
* Testcase Superclass pattern for xUnit testing
* Automated system testing by interacting with the GUI
* Automated GUI testing in Android

# Setting up the Environment

Check out the project using Android Studio. If AS asks you if you want to create the project, 
say No and then Open the project from the directory where it was downloaded. This creates 
the `local.properties` file with the required line:

    sdk.dir=<root folder of Android Studio's Android SDK installation>

# Running the Application (in an emulator or connected Android device)

In Android Studio: `Run > Run app`

# Running the Tests

## Unit tests including out-of-emulator system tests using Robolectric

In Android Studio:

* in the Android view, right-click on `app/java/edu.luc.etl.cs313 (test)`, then choose `Run Tests in edu.luc.etl.cs313`

You can also use Gradle:

    $ ./gradlew testDebug # the "./" may not be necessary any more

You can view the resulting test reports in HTML by opening this file in your browser:

    app/build/reports/tests/debug/index.html

## Unit test code coverage

In Gradle:

    $ ./gradlew jacocoTestDebugUnitTestReport # the "./" may not be necessary any more

You can view the resulting test reports in HTML by opening this file in your browser:

    app/build/reports/jacoco/jacocoTestDebugUnitTestReport/html/index.html

## Android instrumentation tests (in-emulator/device system tests)

In Android Studio:

* in the Android view, right-click on `app/java/edu...clickcounter (androidTest)`, then choose `Run Tests in edu...`

You can also use Gradle:

    $ ./gradlew connectedDebugAndroidTest # the "./" may not be necessary any more
