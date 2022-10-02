object Dependencies {
    object Compose {
        const val version = "1.2.1"

        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material3:material3:1.0.0-beta03"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"

        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:$version"
        const val composeUITooling = "androidx.compose.ui:ui-tooling:$version"
        const val testManifest = "androidx.compose.ui:ui-test-manifest:$version"
        const val activityCompose = "androidx.activity:activity-compose:1.6.0"
    }

    object Kotlin {
        const val core = "androidx.core:core-ktx:1.9.0"
    }

    object Android {
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    }

    object Testing {
        const val JUnit = "junit:junit:4.13.2"
        const val androidJUnit ="androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
}