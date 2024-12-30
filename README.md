# Empty State Library

A brief description of your library and its purpose. Explain why it's useful and what problems it solves.

## Features
- Feature 1
- Feature 2
- Feature 3

## Installation
You can add the library to your project via Gradle:

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.M-Hosein-Developer:CustomEmptyState:1.0.3'
}
```
[![](https://jitpack.io/v/M-Hosein-Developer/CustomEmptyState.svg)](https://jitpack.io/#M-Hosein-Developer/CustomEmptyState)

## Usage
#XML Example for Title and Description (Single Line/Multiple Line)
```
<ir.androidcoder.customdialog.CustomEmptyState
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:titleSingleLine="false"
    app:descSingleLine="false"
    app:titleMaxLine="2"
    app:descMaxLine="3"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

#Setting Text for Title, Description, and Button
```
app:titleText="this is title"
app:descText="this is description"
app:btnSuccessText="this is button"
```

#Customizing Text Colors
```
app:titleTextColor="@color/blue"
app:descTextColor="#fff000"
app:btnSuccessTextColor="@color/white
```

#Setting Custom Font
```
app:fontFamily="@font/font_test_dialog"
```

