package dependencies

const val COMPILE_SDK = 29
const val MIN_SDK = 26
const val TARGET_SDK = 29

private const val VKOTLIN = "1.3.50"
private const val VCOUROUTINE = "1.1.0"

const val ANDROID_PLUGIN = "com.android.tools.build:gradle:3.5.1"
const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VKOTLIN"
const val VERSIONS_PLUGIN = "com.github.ben-manes:gradle-versions-plugin:0.20.0"

const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:$VKOTLIN"
const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VCOUROUTINE"
const val UI_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VCOUROUTINE"

const val KTX = "androidx.core:core-ktx:1.0.0"
const val ACTIVITYX = "androidx.activity:activity-ktx:1.0.0"
private const val VFRAGMENTX = "1.1.0"
const val FRAGMENT = "androidx.fragment:fragment:$VFRAGMENTX"
const val FRAGMENTX = "androidx.fragment:fragment-ktx:$VFRAGMENTX"

const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.0.0"
const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"
const val CARDVIEW = "androidx.cardview:cardview:1.0.0"

const val MATERIAL = "com.google.android.material:material:1.0.0"
const val COORDINATORLAYOUT = "androidx.coordinatorlayout:coordinatorlayout:1.0.0"

const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0"
const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata:2.0.0"
const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.0.0"
const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:2.0.0"

const val JUNIT = "junit:junit:4.12"
const val JUNIT_KTX = "androidx.test.ext:junit-ktx:1.1.0"
const val TRUTH = "com.google.truth:truth:0.42"
const val TRUTHX = "androidx.test.ext:truth:1.1.0"
const val TEST_RULES = "androidx.test:rules:1.1.1"
const val TEST_RUNNER = "androidx.test:runner:1.1.1"
const val TEST_JUNIT_RULES = "androidx.test.ext:junit:1.1.0"
private const val VTEST_CORE = "1.1.0"
const val TEST_CORE = "androidx.test:core:$VTEST_CORE"
const val TEST_CORE_KTX = "androidx.test:core-ktx:$VTEST_CORE"
const val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0"

private const val VESPRESSO = "3.1.1"
const val ESPRESSO = "androidx.test.espresso:espresso-core:$VESPRESSO"
const val ESPRESSO_INTENTS = "androidx.test.espresso:espresso-intents:$VESPRESSO"
const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:$VESPRESSO"

const val ROBOLECTRIC = "org.robolectric:robolectric:4.2"
const val TEST_FRAGMENTX = "androidx.fragment:fragment-testing:$VFRAGMENTX"
