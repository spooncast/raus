[![](https://jitpack.io/v/spooncast/raus.svg)](https://jitpack.io/#spooncast/raus)

# raus
Rooftop Android UI System


## Download
Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.spooncast:raus:{version}'
}
```

## Usecase
### 1. Button
* Solid Button
```kotlin
SolidButton(
    text = "Button",
    onClick = {}
)
```

## 2. Popup
```kotlin
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
