# storytale-sample

Reference starter project created for the [Writing Your First Story](https://aryapreetam.github.io/storytale/getting-started/first-story/) guide in [Storytale](https://aryapreetam.github.io/storytale/).

This project demonstrates how to isolate, document, and test Compose UI components across Android, iOS, Desktop (JVM), and Web (Wasm) without altering your production application codebase.

---

## Prerequisites

- **JDK**: Version 17 or 21 (`java -version`)
- **Android Studio** (Ladybug 2024.2+) or **IntelliJ IDEA** (2024.2+)
- **Xcode** 15+ (for iOS simulator targets on macOS)

---

## Quick Start

### Running Component Stories Gallery

Execute the target-specific story gallery runner from the Gradle tool window (under the `storytale` task group) or via terminal:

| Platform | Command | Description |
| :--- | :--- | :--- |
| **Desktop (JVM)** | `./gradlew :shared:jvmStoriesRun` | Native desktop window running your story suite. |
| **Web (Wasm)** | `./gradlew :shared:wasmJsBrowserStoriesDevelopmentRun` | Local development server with Hot Module Replacement. |
| **Android** | `./gradlew :shared:androidStoriesRun` | Assembles and launches the test runner APK on ADB device/emulator. |
| **iOS (Apple Silicon)** | `./gradlew :shared:iosSimulatorArm64StoriesRun` | Boots iOS simulator and runs native story gallery app. |
| **iOS (Intel Mac)** | `./gradlew :shared:iosX64StoriesRun -PcmpProfile=1.10` | Uses Compose Multiplatform 1.10.1 with `iosX64` support. |

> **Intel Mac iOS Simulators**: Compose Multiplatform dropped `iosX64` binaries in CMP 1.11+. Passing `-PcmpProfile=1.10` switches the version catalog to CMP 1.10.1 and registers the `iosX64()` target automatically.

### Running Host Applications

To run the production application hosts:

- **Desktop**: `./gradlew :desktopApp:run`
- **Web (Wasm)**: `./gradlew :webApp:wasmJsBrowserDevelopmentRun`
- **Android**: `./gradlew :androidApp:installDebug`
- **iOS**: Open `iosApp/` in Xcode and launch on your selected simulator or device.

---

## Project Structure

```text
storytale-sample/
├── gradle/
│   └── libs.versions.toml
├── shared/
│   ├── build.gradle.kts          # Storytale plugin and multiplatform targets
│   └── src/
│       ├── commonMain/           # Production Compose UI components
│       └── commonStories/        # Component stories (isolated from production)
├── androidApp/                   # Android application host
├── desktopApp/                   # Desktop JVM application host
├── webApp/                       # Wasm Browser application host
└── iosApp/                       # Xcode project & iOS application host
```

---

## Writing Stories

Stories live in `shared/src/commonStories/kotlin/` using the `.story.kt` extension.

Example (`shared/src/commonStories/kotlin/org/storytale/sample/Button.story.kt`):

```kotlin
package org.storytale.sample

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import org.jetbrains.compose.storytale.story

val `Primary Action Button` by story(group = "Buttons") {
  val text by parameter("Click me!")
  val isEnabled by parameter(true)

  Button(
    onClick = {},
    enabled = isEnabled
  ) {
    Text(text)
  }
}
```

- **Natural Names**: Use Kotlin backticks (`` `Primary Action Button` ``) for human-readable story labels.
- **Parameters**: Use `val text by parameter("...")` to expose interactive knobs in the gallery sidebar.
- **Hierarchical Groups**: Organize categories using `group = "Components/Buttons"`.

---

## Notes & Troubleshooting

### Android Device Test Manifest
Storytale synthesizes `shared/src/androidDeviceTest/AndroidManifest.xml` during Gradle execution to configure the instrumented APK runner for ADB. This file is excluded in `.gitignore` and automatically cleaned up by `./gradlew clean`.

---

## Documentation

- **[Storytale Documentation](https://aryapreetam.github.io/storytale/)**
- **[Writing Your First Story Guide](https://aryapreetam.github.io/storytale/getting-started/first-story/)**
- **[Interactive Parameters Guide](https://aryapreetam.github.io/storytale/guides/parameters/)**
- **[Live Web Showcase](https://aryapreetam.github.io/storytale/gallery/)**