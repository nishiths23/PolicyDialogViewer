# PolicyDialogViewer

Simple dialog to display privacy policy and terms and conditions.

## Requirements
- minSdkVersion 16
- compileSdkVersion 29

## Include the library

Add this to your `dependencies` block in `build.gradle`:

```groovy

implementation 'com.github.nishiths23:PolicyDialogViewer:1.0'

```
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## Include the library

```groovy
val policyDialog = PolicyViewer(this, "[Privacy policy url]");
policyDialog.show()
```

