# raus
Rooftop Android UI System

## Download
Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.spooncast:raus:Tag'
}
```

## Usecase
### 1. Button
* Solid Button
```
SolidButton(
    text = "Button",
    onClick = {}
)
```

## 2. Popup
```
PopupDialog(
    title = "Title",
    body = {
        Text("This is description")
    },
    primaryButtonText = "Confirm",
    primaryButtonType = ButtonType.Text,
    primaryButtonTextColor = Purple50,
    secondaryButtonText = "Cancel",
    onClickPrimaryButton = {

    },
    onClickSecondaryButton = {

    },
    onDismiss = {

    }
)
```
