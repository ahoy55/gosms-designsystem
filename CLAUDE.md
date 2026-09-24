# GoSMS Design System

Shared theme and Compose components for GoSMS apps. Kotlin Multiplatform library (Android + iosArm64 + iosSimulatorArm64) on Compose Multiplatform, published to GitHub Packages.

Consumers:
- `gosms-mobile` (KMP) → `ru.gosms:designsystem` (root coordinate, Gradle picks the artifact per target).
- `android-client` (pure Jetpack Compose) → `ru.gosms:designsystem-android`.

Every change here ships to both apps — keep the public API stable.

## Layout (`src/commonMain/kotlin/ru/gosms/designsystem`)

- `theme/`
  - `Color.kt` — `internal object Palette`, raw hex values. Never used directly by UI.
  - `AppColors.kt` — semantic tokens (brand, bg*, border*, text*, status{Ok,Warn,Danger}*, stream*) + `LightAppColors` / `DarkAppColors`.
  - `Typography.kt` — 8 tokens (`topBar`, `titleMd`, `bodyMd`, `bodySm`, `labelMd`, `labelSm`, `mono`, `monoSm`), Inter + JetBrains Mono.
  - `Shapes.kt` — `sm` 6dp / `md` 10dp / `lg` 16dp.
  - `MaterialBridge.kt` — maps `AppColors` onto a Material3 `ColorScheme` so stock M3 components pick up our colors.
  - `AppTheme.kt` — `@Composable fun AppTheme(darkTheme: Boolean? = null)` + `object AppTheme { colors; typography; shapes }` accessors.
- `component/` — `AppButton`, `AppDivider`, `AppTopBar`, `CardHeader`, `CardColumn`/`CardRow`, `CardSwitchRow`, `CodeTextField`, `InfoCard`, `InfoDialog` (+ `AppDialogState`), `LoadingDialog`, `QuestionDialog`, `ScreenSurface`/`ScreenColumn`.
- `src/commonMain/composeResources/font/` — Inter and JetBrains Mono `.ttf`.

## Rules

- **New color**: add the raw value to `Palette`, then expose it through a semantic `AppColors` field (both light and dark). Consumers read only `AppTheme.colors.*`.
- **New typography token** only for a genuinely new visual role — adjust an existing one otherwise.
- **Components take plain values** (`String`, `ImageVector`, lambdas). No `@StringRes Int` / `StringResource` — the library can't see a consumer's `R` or `Res`. No domain models (`Sms`, DTOs) — map in the app.
- **Style through tokens** (`AppTheme.colors/typography/shapes`), not hardcoded colors or radii.
- **Backward compatibility**: add parameters with defaults; don't rename or remove public API without a minor bump and updating both consumers.
- **Previews** wrap content in `AppTheme { }` — `LocalAppTypography` throws outside it (fonts need composition, see Gotchas).
- `commonMain` only: no `android.*`, `androidx.core`, `Context`. Platform-specific helpers don't belong here.

## Verify

```bash
./gradlew compileKotlinMetadata compileAndroidMain compileKotlinIosArm64 compileKotlinIosSimulatorArm64
```

iOS linking/tests need full Xcode; this machine has only Command Line Tools, so iOS *compilation* is the most that can be checked here.

## Release

Versioning is semver in `build.gradle.kts` (`version = ...`): patch = fix, minor = new component/param, breaking change = minor bump + consumer updates.

1. **Try in an app first**: set `X.Y.Z-SNAPSHOT`, run `./gradlew publishToMavenLocal`, point the consumer's catalog at the snapshot (consumers have `mavenLocal()` first), build with `--refresh-dependencies`.
2. **Release**: drop `-SNAPSHOT`, commit, push, then `./gradlew publish`.
   - Always `publish` (all publications). Running single `publish*Publication*` tasks once left the iOS klibs unpublished and broke iOS resolution in gosms-mobile.
   - Check the exit code — don't pipe into `tail` and trust the output.
3. Bump the consumers' catalogs to the released version.

Credentials: `gpr.user` / `gpr.token` in `~/.gradle/gradle.properties` (classic PAT with `write:packages`, `read:packages`, `repo`). Never put tokens in the repo or in chat.

## Gotchas

- Generated resource package `ru.gosms.designsystem.generated.resources` is built from `group` (`ru.gosms`) + `rootProject.name` (`designsystem`). Changing either breaks the font imports in `Typography.kt`.
- `org.jetbrains.compose.resources.Font()` is `@Composable` (unlike androidx `Font()`), so typography is built in `defaultAppTypography()` inside `AppTheme`, not as a top-level `val`.
- `material-icons-core/extended` are versioned separately from Compose Multiplatform (`composeMaterialIcons` in the catalog) and are `implementation` deps — consumers don't get `Icons.*` transitively.

## Git

Remote `git@github.com:ahoy55/gosms-designsystem.git`, branch `main`. Commit, push and publish only with the user's go-ahead.
