# MVVM Databinding Sample Project for Android

## Goal
Provide Android developers with a current, up to date example project and guide regarding creating a Model-View-ViewModel(*MVVM*) architected Android project using native databinding, a feature introduced as of Android Marshmallow(*6.0*).  

## Table of Contents
1. [Intro & Gradle Setup](https://github.com/khuckins/android_databinding_MVVM_guide/tree/master)
2. [File Structure, Base Classes, and ViewModel](https://github.com/khuckins/android_databinding_MVVM_guide/tree/2-Activities-File-Structure)
3. [View](https://github.com/khuckins/android_databinding_MVVM_guide/tree/3-View)

## Step 1: Layout
We began this tutorial by not generating any Activities.  This is where we start.  Under the `res` folder, create a new android resource directory, setting the resource type to *layout*.  This will automatically set the name to layout.  We'll be setting this layout up from scratch to show you how it should be put together.  Any future activities you create may be created as you normally would, but will require certain modifications that we'll make clear by using this method.
1. Begin with a <layout> tag.  We'll be wrapping all the content of this activity layout inside this tag.  As such, we'll want to define our xmlns attributes here as well.
2. Just under our opening <layout> tag, we're going to add a <data> tag.  It will have no attributes.  Between it's opening and closing, we'll add a <variable /> tag, with the following attributes:
- name="viewModel"
- type="com.example.mvvmsampleproject.viewmodel.MainViewModel"
The type will be path to your MainViewModel class.
3. At this point, you should be able to put in any content you would regularly place in your layouts after the closing <data> tag. YOu should have something like the following:
```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable name="viewModel" type="com.example.mvvmsampleproject.viewmodel.MainViewModel"/>
    </data>

    YOUR CONTENT HERE

</layout>
```

## MainActivity.java
Now that we have our XML view, it's time to add the Java side to this.  This is the final step to having a finished skeleton for an MVVM architected Android app using Databinding.  This file will be largley the same as a normal Java Activity class.
1. Once you've built out a normal Activity Class(At this point, I'd recommend creating a new Activity to use as a template), Instantiate the following variables:
```
private MainViewModel mainViewModel;
private ActivityMainBinding mainBinding;
```
Notice those red squigglies under mainBinding?  Those, like BaseObservable in the previous section, should resolve themselves once you build your project at the end of this section.
2. Follow your varaibles with this function, placed above your onCreate:
```
public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
}
```
3. Alright, now, if you created your Activities manually, rather than using Android Studio's templates, you'll need to add your Acitivty to AndroidManifest.xml as the default Activity.  This can be done with the following code, placed within the <application> tags.:
 ```
<activity
  android:label="MVVM Sample Project"
  android:name=".view.MainActivity" >
    <intent-filter >
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
 </activity>
 ```
4. Now you're set up to use MVVM properly.  Build the project, and your errors should be gone.  Where can we take this?  Say I want to add a Toolbar.  Normally, I would have to use the following code:
```
Toolbar toolbar = (Toolbar) findViewById(toolbar)
setSupportActionBar(toolbar);
```
Two lines in the java, nto so bad, right?  But whenever we want to do sometihng to a TextView, or any other object in our layout, we have to keep findViewById'ing.  It's pretty annoying.  Let's chop the lines of code in half.  That mainBinding variable should do the trick.  Try this:
```
setSupportActionBar(mainBinding.toolbar);
```
Now we've got our toolbar working properly.

## Cool, cool, you've reduced the amount of code I have to write.  But what else do I get out of this?
Testability have become much easier.  You can now reliably unit test your models and xml objects.  Less time spent writing boilerplate, less time spent mapping out just how you're going to write your tests.

## [Previous Step: File Structure, Base Classes, and ViewModel](https://github.com/khuckins/android_databinding_MVVM_guide/tree/2-Activities-File-Structure)