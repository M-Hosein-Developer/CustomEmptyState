# Empty State Library

A brief description of your library and its purpose. Explain why it's useful and what problems it solves.

## Features
- Feature 1
- Feature 2
- Feature 3

## Installation
You can add the library to your project via Gradle:

Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.M-Hosein-Developer:CustomEmptyState:1.0.3'
}
```
[![](https://jitpack.io/v/M-Hosein-Developer/CustomEmptyState.svg)](https://jitpack.io/#M-Hosein-Developer/CustomEmptyState)

## Usage XML
XML Example for Attributes
```
<ir.androidcoder.customdialog.CustomEmptyState
    android:id="@+id/customEmptyState"
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

Setting Text for Title, Description, and Button
```
app:titleText="this is title"
app:descText="this is description"
app:btnSuccessText="this is button"
```

Customizing Text Colors
```
app:titleTextColor="@color/blue"
app:descTextColor="#fff000"
app:btnSuccessTextColor="@color/white
```

Setting Custom Font
```
app:fontFamily="@font/font_test_dialog"
```

Customizing Text Sizes
```
app:titleTextSize="12sp"
app:descTextSize="20sp"
app:btnSuccessTextSize="10sp"
```

Parent View Customization
```
app:cardRadius="20dp"
app:cardElevation="20dp"
app:cardBackgroundColor="@color/white"
```

Padding Customization
```
app:titlePadding="20dp"
app:descPadding="20dp"
app:btnSuccessPadding="20dp"
app:imgPadding="20dp"
```

Visibility Settings
```
app:btnSuccessVisibility="visible"
app:txtTitleVisibility="visible"
app:txtDescriptionVisibility="visible"
app:imgVisibility="visible"
app:mainCustomEmptyStateVisibility="visible"
```

Background Customization
```
app:btnSuccessBackground="@color/blue"
app:mainCustomDialogBackground="@color/blue"
app:txtTitleBackground="@color/blue"
app:txtDescriptionBackground="@color/blue"
```

Using Lottie Animation Instead of Image
```
app:autoPlay_animation="true"
app:loop_animation="true"
app:rawRes_animation="@raw/error"
app:lottieVisibility="visible"
```

Button Customization
```
app:buttonCornerRadius="20dp"
app:setIconButton="@drawable/ic_android_black_24dp"
app:setIconButtonGravity="textEnd"
app:iconButtonSize="30dp"
```

## Usage Kotlin
Kotlin Example for Attributes

Control visibility
```
customEmptyState.setEmptyStateVisibility(isVisible = true)
```

```
customEmptyState.setOkButtonVisibility(isVisible = true)
```

```
customEmptyState.setImageAndLottieVisibility(isImageVisible = true, isLottieVisible = false)
```

```
customEmptyState.setTitleVisibility(isVisible = true)
```

```
customEmptyState.setDescriptionVisibility(isVisible = false)
```

Sets the title, description, and image for the Empty State view
```
customEmptyState.setEmptyState(
    title = "Title Text",
    description = "Description Text",
    src = R.drawable.ic_image
)
```

Updates the title and description text
```
customEmptyState.setTitleAndDescription(
    title = "New Title",
    description = "New Description"
)
```

Controls whether the title text should be a single line or multi-line and max line
```
customEmptyState.setTitleSingleLine(singleLine = true)
```

```
customEmptyState.setDescriptionSingleLine(singleLine = false)
```

```
customEmptyState.setTitleMaxLine(maxLine = 2)
```

```
customEmptyState.setDescriptionMaxLine(maxLine = 3)
```

Sets the text for the Empty State button
```
customEmptyState.setTextButton(textButton = "Click Me")
```

Sets the corner radius for the Empty State button
```
customEmptyState.setCornerButton(radius = 8)
```

Sets the icon for the Empty State button
```
customEmptyState.setButtonIcon(icon = R.drawable.ic_icon)
```


Set the text color for views
```
customEmptyState.setDescriptionColorAndTitleTextColor(color = R.color.commonColor)
```

```
customEmptyState.setTitleTextColor(titleColor = R.color.titleColor)
```

```
customEmptyState.setDescriptionTextColor(descriptionColor = R.color.descriptionColor)
```

```
customEmptyState.textButtonColor(color = R.color.buttonTextColor)
```

Set text fon for views








