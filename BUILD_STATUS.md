# Verification record

The source project is complete. An APK is not included because this execution environment has no Android SDK and blocks network sockets needed to download Gradle and build dependencies.

The attempted command was:

```bash
./gradlew --no-daemon testDebugUnitTest lintDebug assembleDebug
```

It stopped while downloading Gradle 8.11.1 with `java.net.SocketException: Operation not permitted`, before any test, lint, compilation, or APK task ran. The included GitHub Actions workflow installs Java 17 and Android SDK 35 and runs these tasks in its runner.

On 12 October 2026, the build path was updated to install Gradle 8.11.1 explicitly in GitHub Actions, verify the project location, separate compilation/tests/lint, and preserve Gradle stack-trace logs with verification reports. The local environment still cannot download the SDK or dependencies, so this update does not establish a successful compilation. The app-bar title was also constrained to one line to avoid clipping on narrow screens with enlarged text.

Static verification completed:

- XML resource files parse successfully.
- All 78 English and Telugu resource keys match, including format placeholders; every Kotlin string/plural resource reference exists.
- Gradle wrapper shell syntax and JAR archive integrity pass. The JAR and distribution checksums match the official Gradle 8.11.1 release.
- GitHub Actions YAML parses, and its SDK, Java, build tasks, APK path, and artifact uploads agree with the project configuration.
- Independent source review checked navigation, adaptive layouts, preference persistence, content IDs, bilingual search, and the article source references.

Five local JUnit tests are included for bilingual search, category filtering, language resolution, and catalog integrity. These tests have not run in this environment.

Before distributing the app, run the workflow or local build, then verify on an Android phone and tablet: switch languages, search both languages, save/remove bookmarks, restart the app, rotate the screen, return from an article, increase system text size, use dark mode, and read with network access disabled. Opening an external official reference requires a browser and an internet connection.
