# MVVM Databinding Sample Project for Android

## Goal
Provide Android developers with a current, up to date example project and guide regarding creating a Model-View-ViewModel(*MVVM*) architected Android project using native databinding, a feature introduced as of Android Marshmallow(*6.0*).  

## Table of Contents
1. [Intro & Gradle Setup](https://github.com/khuckins/android_databinding_MVVM_guide/tree/master)
2. [File Structure, Base Classes, and ViewModel](https://github.com/khuckins/android_databinding_MVVM_guide/tree/2-Activities-File-Structure)
3. [View](https://github.com/khuckins/android_databinding_MVVM_guide/tree/3-View)

## Intro to Section 2:
In this section, we'll build out our File/Folder Structure, setting the organizational structure that will help keep our code neat and organized.  We'll create a couple base classes in order to reduce code duplication later, and then create our Viewmodels, setting the stage for the next section, where we'll connect it all to our views.

## Step 1: Setting up our File Structure
1. As we're using MVVM, to keep our code nice and organized, we're going to create some file structure for our Java classes.  Let's go with something a bit simple.  Create the following folder structure:
```
java/com/example/mvvmsampleproject/
    /model
    /view
    /viewmodel
```
## Step 2: Base Classes
1. Now that we have this structure built out, let's create some base classes.  This isn't strictly required, but it will help us reduce our code duplication, especially when we apply it to a full project.  In our `view` folder, create `BaseActivity.java`, and in our `viewmodel` folder, create `ViewModel.java`.  
- ViewModel will be an interface with only a single line, `void destroy();`.  More code may be added to ViewModel depending on what you'll be reusing between multiple ViewModels in your own project.
- BaseActivity extends AppCompatActivity.  To better support NavigationViews, we'll also implement `NavigationView.onNavigationItemSelectedListener`.  We'll be importing FragmentManager, NavigationView, AppCompatActivity, and MenuItem.  In BaseActivity, we'll go ahead and put in the code to handle onOptionsItemSelected and onNavigationItemSelected

2. You could, at this point, use this opportunity to start building out any base models you'd like to use in your app.  This should be fairly straightforward(you're essentially building POJOs), so we won't cover this.  These would be placed in our `model` folder.

## Step 3: Creating our ViewModel
With our ViewModel ready, let's go ahead and create a new class in our `viewmodel` folder.  Name it `MainViewModel.java`. This ViewModel will be handling our view.  Note that in more complex apps, you'll likely need multiple ViewModels for your Views.  We'll stick to one ViewModel and one View for this tutorial.
1. Import `Context` and `android.databinding.BaseObservable`.  If BaseObservable is not found, don't worry.  The databinding feature generates several classes, and this is one of them.  Once we've finished section 3, we'll build the project, and Android Studio should have no problem finding BaseObservable.
2. Now, for the actual class itself, we'll *extend* `BaseObservable` and *implement* `ViewModel`.  This will allow our ViewModel to move information between our views and our models.
3. Instantiate Context as `context`, then add the following constructor:
```
public MainViewModel(Context context) {
        this.context = context;
   }
```
Great! Now we can make use of this ViewModel in our View.  But that's later.  For now, there's one more step:
4. Create an Overrided function for our void destroy().  This time, we'll actually give it something to do though.  set `context` to `null`.  Now whenever the ViewModel is destroyed(say, we've shut down the app), we'll avoid any potential issues with unexpected data.

## [Previous Step: Intro & Gradle Setup](https://github.com/khuckins/android_databinding_MVVM_guide/tree/master)
## [Next Step: View](https://github.com/khuckins/android_databinding_MVVM_guide/tree/3-View)