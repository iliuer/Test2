// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
}
buildscript{
    val agp_version by extra("8.1.1")
    repositories{
        google()
        mavenCentral()
    }

}
