# MVVM Databinding Sample Project for Android

## Goal
Provide Android developers with a current, up to date example project and guide regarding creating a Model-View-ViewModel(*MVVM*) architected Android project using native databinding, a feature introduced as of Android Marshmallow(*6.0*).  

## Table of Contents
1. [Intro & Gradle Setup](https://github.com/khuckins/android_databinding_MVVM_guide/tree/master)
2. [File Structure, Base Classes, and ViewModel](https://github.com/khuckins/android_databinding_MVVM_guide/tree/2-Activities-File-Structure)
3. View

## Why?
The possibilities that the new databinding feature affords us include the ability to create cleaner, more testable code.  As I initially went to look for example code, much of what I found, while incredibly useful, also contained various other techniques that, though are good practice, muddle things quite a bit when you're looking for specifically MVVM based on databinding.

## What can I expect from this guide and project?
By the end of this guide, you will be able to implement Android Databinding and MVVM architecture into your own projects.  We will go through the creation of an Android App, how to enable Databinding, and how to structure your app using MVVM.  Git affords us the ability to use a new branch for each step in the process, at the end of each *README.MD* there will be a link to the next branch.  This will allow you to compare your code with the sample code, while not getting overwhelmed with information from later steps.  

## What do I need?
- Your IDE of choice(I prefer Android Studio)
- Java
- An interest in following this guide

## Step 1: Create your project.
1. This is the first step to any project.  In Android Studio, we'll create a new project.  As this is an example project, I am using the domain of com.example.
2. Your SDK setting doesn't matter much, Databinding has been made to support as early as Android 2.1(API level 7+).  I am using API 19: Android Kitkat.
3. Finally, select "Add No Activity."  You may add in a blank or empty activity if you wish, however you will have to refactor code.
4. Now we'll wait until Android Studio is done creating our project.

## Step 2: Setting up Gradle
1. To enable Databinding, our Gradle classpath, which can be found in *build.gradle(Project: ProjectName)* as `com.android.tools.build:gradle`, must be at version 1.5.0 or greater.
2. In *build.gradle(Module: App)*, we'll be adding a subsection under android, titled dataBinding, with an entry of `enabled = true`.
```
android {
    ...

    defaultConfig {
        ...
    }

    dataBinding {
        enabled = true
    }
}
```
3. Now we'll need to resync Gradle.

Now that our app is ready for databinding, it's on to the next portion of this guide, which will involve setting up the file structure, and creating our activities.
## [Next Step: File Structure, Base Classes, and ViewModel](https://github.com/khuckins/android_databinding_MVVM_guide/tree/2-Activities-File-Structure)