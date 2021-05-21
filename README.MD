English | [Русский](README.ru.MD)

[![Boilerplate 2020 by TheLongRunSmoke](https://user-images.githubusercontent.com/5612507/119089718-088d5080-ba24-11eb-813f-70cba39b6b3d.jpg)](#)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Simple boilerplate for android application. Basically, it is a template that I used in past 2020 year.

By default, it's configured to build APK files, instead of application bundle AAB, because it more convenient outside of Play Market. 

**Features:**
1. Design based on Material with bottom navigation and side drawer, backed by Jetpack Navigation library.
2. Simple MVVM architecture based on Jetpack.
3. DI support using Dagger with additional submodules support and simplified ViewModel injects.
4. Preferences system and screen with day-night theme switch and additional templates.
5. Easy to use common dependencies library in dependencies.gradle.
6. CI ready.

## Using

1. Clone this repository and remove or change remote.
```
git clone git@github.com:TheLongRunSmoke/android-boilerplate-2020.git
git remote rm origin
```

2. Change app package to you choice.

2. Rename application in app AndroidManifest.xml. 

3. Set app parameters in project build.gradle, like package, build versions, e.t.c.

4. Check app module build.gradle and add/remove libraries, see dependencies.gradle for details.

5. Develop!

## Signing APK

If you want to build release version, create keystore and set it up in keystore.properties. 

**Do not forget to remove keystore.properties from git index and uncomment it in .gitignore**
```
git rm keystore.properties
```

## Contacts

Rise issues, if you have questions or support request.