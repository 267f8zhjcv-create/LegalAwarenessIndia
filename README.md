# Legal Awareness India

A native Android app built with Kotlin, Jetpack Compose, and Material 3. It offers clear English and Telugu introductions to everyday rights in India, with all articles bundled in the app.

## Features

- Home screen with featured reading, topic categories, and legal-help information.
- Searchable topics and article detail pages with practical steps and official reference links.
- Persistent bookmarks and language preference stored locally with DataStore.
- Complete English and Telugu interface and article content.
- Adaptive layouts for phones and tablets, accessible touch targets, and support for system text scaling.
- Offline reading with no account, server, paid service, analytics, API key, or Internet permission.

External source links open in a browser. That browser requires an Internet connection; the bundled articles and bookmarks do not. Bookmarks and language preference stay on the device. Android backup is disabled. Clearing app data or uninstalling removes those preferences.

## Use the app

Use the language button in the top bar to switch between **English** and **తెలుగు**. The first launch follows a Telugu device language or defaults to English; your explicit choice is saved locally. On **Topics**, search in either language and combine your query with a category filter. Tap an article to read it, or its bookmark icon to save it to **Bookmarks**. On wider screens the bottom tabs become a navigation rail and articles use two columns. Light and dark colors follow the device theme.

Android Studio previews are included in `ui/LegalAwarenessApp.kt` for an English phone, Telugu phone, and tablet. Open the file in **Split** or **Design** mode after Gradle sync to inspect them.

## Open in Android Studio

1. Install Android Studio Meerkat (2024.3.1) or newer, with the Android SDK.
2. Open this directory as the project root (the directory containing `settings.gradle.kts`).
3. Use JDK 17 or Android Studio's compatible bundled JDK for Gradle. Install Android SDK Platform 35 and Build Tools 35.0.0 through SDK Manager.
4. Wait for Gradle sync, then run the `app` configuration on an emulator or physical device running Android 8.0 (API 26) or newer.

The first build downloads Gradle and open-source dependencies. No application API keys or paid services are required. Gradle 8.11.1, Android Gradle Plugin 8.9.2, Kotlin 2.1.20, and Compose BOM 2025.04.01 are pinned in the project. The wrapper checks the Gradle distribution against its [official SHA-256 checksum](https://gradle.org/release-checksums/). The SDK, Gradle, and Java versions follow [AGP 8.9 compatibility requirements](https://developer.android.com/build/releases/agp-8-9-0-release-notes).

## Build an APK locally

Android Studio can generate a debug APK through **Build → Build App Bundle(s) / APK(s) → Build APK(s)**. From a terminal at the project root:

```bash
chmod +x gradlew
./gradlew testDebugUnitTest lintDebug assembleDebug
```

On Windows use `gradlew.bat testDebugUnitTest lintDebug assembleDebug`. Android Studio creates `local.properties` automatically; for command-line builds ensure `ANDROID_HOME` points to your Android SDK, or add `sdk.dir=/absolute/path/to/your/sdk` to an untracked `local.properties` file.

The installable debug APK is `app/build/outputs/apk/debug/app-debug.apk`. Install it with:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Debug APKs are automatically signed with a debug key. For production distribution, use **Build → Generate Signed App Bundle / APK**, create and securely store your own release signing key, and choose the release variant. Never commit signing keys or passwords. Release signing is intentionally not tied to any account or paid service.

The delivery environment could not download Gradle or install the Android SDK, so unit tests, Android lint, APK assembly, and device testing have not run here. XML, resource translations and placeholders, wrapper integrity, workflow syntax, and project references were checked statically. See [BUILD_STATUS.md](BUILD_STATUS.md) for the verification record; run the commands above or the included workflow for compilation and test results.

## Build an APK with GitHub Actions

1. Download and extract the project ZIP, then create a GitHub repository. Upload the contents of the extracted `LegalAwarenessIndia` directory, including hidden files. The repository root must contain `settings.gradle.kts`, `app/`, and `.github/workflows/android.yml`. Uploading only the ZIP or an enclosing `LegalAwarenessIndia/` folder will not start this workflow. You can use GitHub Desktop to publish the extracted directory if the browser uploader omits `.github`.
2. Open the repository's **Actions** tab. Enable workflows if GitHub asks.
3. Select **Build Android APK → Run workflow**, or push a commit. This workflow runs on default-branch pushes and manual starts.
4. Open the completed workflow run. It installs Java 17, Android SDK 35, and Gradle 8.11.1 on a GitHub-hosted Ubuntu runner. APK compilation, unit tests, and Android lint are separate steps so any failure identifies the task that needs attention. CI uses the installed `gradle` command; local builds continue to use `./gradlew` or `gradlew.bat`.
5. Under **Artifacts**, download **Legal-Awareness-India-debug**. Unzip it to obtain `app-debug.apk`, then transfer it to an Android device to install. Android may ask you to allow installation from your file manager or browser.

No secrets or API keys are needed. Standard hosted GitHub Actions runners are free for public repositories; private repositories have plan-specific free minute and storage allowances. GitHub's current usage limits apply. The workflow keeps artifacts for 14 days and uploads verification reports alongside the APK. This workflow produces a debug APK; it does not publish the application to Google Play.

If a workflow run fails, open the red step and inspect its error message. **verification-reports** also includes `build-logs/` with Gradle stack traces for any tasks that ran. If the workflow is absent from **Actions**, make sure `.github/workflows/android.yml` is in the repository root on the default branch, rather than inside an uploaded ZIP or enclosing folder. This build runs on GitHub and does not depend on the restricted environment that created the source project.

## Project layout

```text
app/src/main/java/com/legalawareness/india/  Kotlin UI, articles, and local preferences
app/src/main/res/values/                   English interface strings
app/src/main/res/values-te/                Telugu interface strings
app/src/test/                             Local unit tests
.github/workflows/android.yml             APK build and verification workflow
gradle/wrapper/                            Pinned Gradle wrapper
```

To add content, follow the existing bilingual article model: use a stable ID, both language versions, a category, practical steps, and links to official Indian government sources. Keep English and Telugu resource keys in sync. Review legal statements and translations before public release; do not imply government affiliation or professional legal advice.

## Educational scope and license

The app provides general educational information, not legal advice. Laws, state-specific rules, eligibility, and procedures can change. Users should consult current official sources and a qualified lawyer for their circumstances. For immediate danger use India's emergency number 112. NALSA's legal-aid helpline is 15100; eligibility for free legal aid depends on applicable law.

The application code and original summaries are provided under the [MIT License](LICENSE). Gradle wrapper files and third-party dependencies retain their own licenses, including their existing copyright notices. Linked government websites and their materials retain their respective terms. The app does not reproduce an official government service or claim government endorsement.
