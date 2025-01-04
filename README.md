# Empty State Library

This library is for using the empty state in the project and you can use it in situations such as internet disconnection and no data state and other cases.

## Features
- Access to change view Attributes
- Full development with Kotlin
- Compatible with all versions

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
    implementation 'com.github.M-Hosein-Developer:CustomEmptyState:1.1.0'
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
    app:es_titleSingleLine="false"
    app:es_descSingleLine="false"
    app:es_titleMaxLine="2"
    app:es_descMaxLine="3"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Setting Text for Title, Description, and Button
```
app:es_titleText="this is title"
app:es_descText="this is description"
app:es_btnOkText="this is button"
```

Customizing Text Colors
```
app:es_titleTextColor="@color/blue"
app:es_descTextColor="#fff000"
app:es_btnOkTextColor="@color/white
```

Setting Custom Font
```
app:es_fontFamily="@font/font_test_dialog"
```

Customizing Text Sizes
```
app:titleTextSize="12sp"
app:descTextSize="20sp"
app:btnOkTextSize="10sp"
```

Parent View Customization
```
app:cardCornerRadius="20dp"
app:cardElevation="20dp"
app:cardBackgroundColor="@color/white"
```

Padding Customization
```
app:es_titlePadding="20dp"
app:es_descPadding="20dp"
app:es_btnOkPadding="20dp"
app:es_imgPadding="20dp"
```

Visibility Settings
```
app:es_btnOkVisibility="visible"
app:es_txtTitleVisibility="visible"
app:es_txtDescriptionVisibility="visible"
app:es_imgVisibility="visible"
app:es_mainCustomEmptyStateVisibility="visible"
```

Background Customization
```
app:es_btnOkBackground="@color/blue"
app:es_mainCustomDialogBackground="@color/blue"
app:es_txtTitleBackground="@color/blue"
app:es_txtDescriptionBackground="@color/blue"
```

Using Lottie Animation Instead of Image
```
app:es_autoPlay_animation="true"
app:es_loop_animation="true"
app:es_rawRes_animation="@raw/error"
app:es_lottieVisibility="visible"
```

Button Customization
```
app:es_buttonCornerRadius="20dp"
app:es_setIconButton="@drawable/ic_android_black_24dp"
app:es_setIconButtonGravity="textEnd"
app:es_iconButtonSize="30dp"
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

Set text font for views
```
customEmptyState.setTextFont(font = R.font.custom_font)
```

```
customEmptyState.setTitleTextFont(font = R.font.title_font)
```

```
customEmptyState.setDescriptionTextFont(font = R.font.description_font)
```

```
customEmptyState.setButtonTextFont(font = R.font.button_font)
```

Set text size for views
```
customEmptyState.setTextSize(
    titleSize = 16f,
    descriptionSize = 14f,
    buttonSize = 18f
)
```

Set padding for view
```
customEmptyState.setPaddingView(
    titlePadding = 10,
    descriptionPadding = 8,
    buttonPadding = 12,
    imagePadding = 6,
    lottiePadding = 4
)
```

Set text style
```
customEmptyState.setTextStyle(
    titleStyle = 1,
    descriptionStyle = 0,
    buttonStyle = 2
)
```

Set background views
```
customEmptyState.setButtonBackgroundColor(background = R.color.button_background)

customEmptyState.setButtonBackgroundDrawable(background = R.drawable.button_background)
```

```
customEmptyState.setTitleBackgroundColor(background = R.color.title_background)

customEmptyState.setTitleBackgroundDrawable(background = R.drawable.title_background)
```

```
customEmptyState.setDescriptionBackgroundColor(background = R.color.description_background)

customEmptyState.setDescriptionBackgroundDrawable(background = R.drawable.description_background)
```

```
customEmptyState.setMainBackgroundColor(background = R.color.mainBackground)

customEmptyState.setMainBackgroundDrawable(background = R.drawable.mainBackground)
```

On click envent for ok button
```
customEmptyState.setOnOkClickListener{
    // Handle click event
}
```

Setup lottie animation
```
customEmptyState.setupLottieAnimation(
    rawRes = R.raw.animation_file,
    loop = true,
    padding = 8
)
```

Setup button ui
```
customEmptyState.setButtonAttribute(
    radius = 6,
    icon = R.drawable.ic_android_black_24dp,
    iconSize = 50,
    color = R.color.red
)
```

## License
MIT License

Copyright (c) [Year] [Your Name or Organization]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is provided to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.




