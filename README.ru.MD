[English](README.MD) | Русский

[![Boilerplate 2020 by TheLongRunSmoke](https://user-images.githubusercontent.com/5612507/119089718-088d5080-ba24-11eb-813f-70cba39b6b3d.jpg)](#)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Простой бойлерплейт для андроид приложений. В целом, это шаблон который я использовал в прошедшем 2020 году.

По умолчанию, проект сконфигурирован для сборки APK вместо AAB, поскольку это удобнее вне Play Market.

**Особенности:**
1. Дизайн на базе Material с нижней и боковой навигацией, использующий Jetpack Navigation.
2. Простая MVVM архитектура на базе Jetpack.
3. Поддрежка DI на базе Dagger с дополнительной поддержкой субмодулей и упрощенными инъекциями во ViewModel.
4. Минимальная система и экран настроек с переключателем светлая-тёмная тема и примерами.
5. Простая в использовании система популярных зависимостей в dependencies.gradle.
6. Готов для CI.

## Использование

1. Клонируйте репозиторий. Удалите remote или измените на свой.
```
git clone git@github.com:TheLongRunSmoke/android-boilerplate-2020.git
git remote rm origin
```

2. Измените пакет приложения.

2. Переименуйте приложение в AndroidManifest.xml. 

3. Установите параметры приложения в build.gradle, такие как пакет, версия, версии АПИ, и т.д.

4. Вроверьте build.gradle модуля и добавьте/удалите библиотеки, смотрите dependencies.gradle.

5. Пишите!

## Подписывание APK

Если вы планируете собирать релиз версию, создайте новое хранилище ключей и укажите его в keystore.properties. 

**Не забудьте удалить keystore.properties из индекса git и раскоментировать этот файл в .gitignore**
```
git rm keystore.properties
```

## Контакты

Используйте тикеты (issues), если у вас есть вопросы.