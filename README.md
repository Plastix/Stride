# Stride

<p align="center">
    <img src="app/src/main/res/mipmap-xxxhdpi/ic_web.png" width="200">
</p>

## Libraries
* [Dagger 2](http://google.github.io/dagger/)
* [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [PaperParcel](https://github.com/grandstaish/paperparcel)
* [Google Support Libraries](http://developer.android.com/tools/support-library/index.html)

## Testing Libraries
* [JUnit](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)

## Requirements
To compile and run the project you'll need:

- [Android SDK](http://developer.android.com/sdk/index.html)
- [Android N (API 24)](http://developer.android.com/tools/revisions/platforms.html)
- Android SDK Tools
- Android SDK Build Tools `24.0.0`
- Android Support Repository
- [Kotlin](https://kotlinlang.org/) `1.0.3`
- Kotlin plugin for Android Studio

Building
--------

To build, install and run a debug version, run this from the root of the project:

```
./gradlew assembleDebug
```

Testing
-------

To run **unit** tests on your machine:

```
./gradlew test
```

To run **instrumentation** tests on connected devices:

```
./gradlew connectedAndroidTest
```


## Release Builds
A release build needs to be signed with an Android Keystore. The easiest way to generate a keystore is to open
Android Studio and go to `Build -> Generate Signed Apk -> Create New...` After that you need to create a
`signing.properties` file in the root directory and add the following info to it:
```INI
STORE_FILE=/path/to/your.keystore
STORE_PASSWORD=yourkeystorepass
KEY_ALIAS=projectkeyalias
KEY_PASSWORD=keyaliaspassword
```
Running `./gradlew assembleRelease` will then build and sign a release version of the app.
