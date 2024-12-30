<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CustomEmptyState Library</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
            color: #333;
            background-color: #f5f5f5;
        }

        h1 {
            color: #4CAF50;
            text-align: center;
            background: linear-gradient(to right, #4CAF50, #81C784);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        h2 {
            color: #2196F3;
            border-bottom: 2px solid #2196F3;
            padding-bottom: 5px;
            margin-top: 40px;
        }

        h3 {
            color: #FF5722;
            margin-top: 30px;
        }

        pre {
            background: #fff;
            padding: 15px;
            border-left: 4px solid #4CAF50;
            overflow-x: auto;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        code {
            font-family: Consolas, monospace;
            color: #4CAF50;
        }

        a {
            color: #2196F3;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        .toc {
            background: #fff;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .toc ul {
            list-style: none;
            padding-left: 0;
        }

        .toc li {
            margin-bottom: 5px;
        }

        .toc a {
            color: #4CAF50;
        }

        footer {
            text-align: center;
            margin-top: 50px;
            padding-top: 20px;
            border-top: 1px solid #ddd;
            color: #777;
        }

        footer a {
            color: #2196F3;
        }
    </style>
</head>

<body>
    <h1>CustomEmptyState Library</h1>
    <p style="text-align: center; font-size: 1.2em;">A simple and customizable library for displaying empty states in Android applications.</p>

    <div class="toc">
        <h3>Table of Contents</h3>
        <ul>
            <li><a href="#installation">📦 Installation</a></li>
            <li><a href="#xml-usage">🛠️ XML Usage</a></li>
            <li><a href="#kotlin-usage">🛠️ Kotlin Usage</a></li>
            <li><a href="#license">📜 License</a></li>
        </ul>
    </div>

    <h2 id="installation">📦 Installation</h2>
    <p>Add this dependency to your <code>build.gradle</code>:</p>
    <pre>
<code>maven { url 'https://jitpack.io' }
implementation 'com.github.M-Hosein-Developer:CustomEmptyState:1.0.3'</code>
    </pre>

    <h2 id="xml-usage">🛠️ XML Usage</h2>

    <h3>Max Line and Single Line Configuration</h3>
    <pre>
<code>
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
</code>
    </pre>

    <h3>Setting Text</h3>
    <pre>
<code>
app:titleText="this is title"
app:descText="this is description"
app:btnSuccessText="this is button"
</code>
    </pre>

    <h3>Text Colors</h3>
    <pre>
<code>
app:titleTextColor="@color/blue"
app:descTextColor="#fff000"
app:btnSuccessTextColor="@color/white"
</code>
    </pre>

    <h3>Font Configuration</h3>
    <pre>
<code>
app:fontFamily="@font/font_test_dialog"
</code>
    </pre>

    <h3>Text Sizes</h3>
    <pre>
<code>
app:titleTextSize="12sp"
app:descTextSize="20sp"
app:btnSuccessTextSize="10sp"
</code>
    </pre>

    <h3>Parent View Settings</h3>
    <pre>
<code>
app:cardRadius="20dp"
app:cardElevation="20dp"
app:cardBackgroundColor="@color/white"
</code>
    </pre>

    <h3>Paddings</h3>
    <pre>
<code>
app:titlePadding="20dp"
app:descPadding="20dp"
app:btnSuccessPadding="20dp"
app:imgPadding="20dp"
</code>
    </pre>

    <h3>Visibility Settings</h3>
    <pre>
<code>
app:btnSuccessVisibility="visible"
app:txtTitleVisibility="visible"
app:txtDescriptionVisibility="visible"
app:imgVisibility="visible"
app:mainCustomEmptyStateVisibility="visible"
</code>
    </pre>

    <h3>Background Configurations</h3>
    <pre>
<code>
app:btnSuccessBackground="@color/blue"
app:mainCustomDialogBackground="@color/blue"
app:txtTitleBackground="@color/blue"
app:txtDescriptionBackground="@color/blue"
</code>
    </pre>

    <h3>Lottie Animation</h3>
    <pre>
<code>
app:autoPlay_animation="true"
app:loop_animation="true"
app:rawRes_animation="@raw/error"
app:lottieVisibility="visible"
</code>
    </pre>

    <h3>Button Customization</h3>
    <pre>
<code>
app:buttonCornerRadius="20dp"
app:setIconButton="@drawable/ic_android_black_24dp"
app:setIconButtonGravity="textEnd"
app:iconButtonSize="30dp"
</code>
    </pre>

    <h2 id="kotlin-usage">🛠️ Kotlin Usage</h2>

    <h3>Visibility Control</h3>
    <pre>
<code>
customEmptyState.setDialogVisibility(true)
customEmptyState.setSuccessButtonVisibility(false)
customEmptyState.setImageAndLottieVisibility(isImageVisible = true, isLottieVisible = false)
customEmptyState.setTitleVisibility(true)
customEmptyState.setDescriptionVisibility(false)
</code>
    </pre>

    <h3>Setting Text</h3>
    <pre>
<code>
customEmptyState.setDialog("Title", "Description", R.drawable.ic_sample)
customEmptyState.setTitleAndDescription("New Title", "New Description")
</code>
    </pre>

    <h3>Single Line and Max Line Configuration</h3>
    <pre>
<code>
customEmptyState.setTitleSingleLine(true)
customEmptyState.setDescriptionSingleLine(false)
customEmptyState.setTitleMaxLine(2)
customEmptyState.setDescriptionMaxLine(3)
</code>
    </pre>

    <h3>Button Text</h3>
    <pre>
<code>
customEmptyState.setTextButton("Confirm")
customEmptyState.setCornerButton(16)
customEmptyState.setButtonIcon(R.drawable.ic_sample_icon)
</code>
    </pre>

    <h3>Text Colors</h3>
    <pre>
<code>
customEmptyState.setTitleTextColor(R.color.black)
customEmptyState.setDescriptionTextColor(R.color.gray)
customEmptyState.setDescriptionColorAndTitleTextColor(R.color.blue)
customEmptyState.textButtonColor(R.color.white)
</code>
    </pre>

   
