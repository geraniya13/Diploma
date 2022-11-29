# Проект по автоматизации тестирования
## Проект состоит из двух частей: <a href="#part1">тестирование веб-приложения</a> и <a href="#part2">тестирование мобилного приложения</a>

## :bookmark: Содержание
* <a href="#part1">Автоматизация веб-тестирования интернет магазина Мегацвет-24</a>
  + <a href="#description-web">Описание</a>
* <a href="#part2">Aвтоматизация тестов для мобилного приложения CoinKeeper</a>
  + <a href="#description-mobile">Описание</a>
* <a href="#stack">Cтек технологий</a>
* <a href="#gradle-launch">Запуск проекта с помощью терминала</a>
* <a href="#jenkins-launch">Запуск проекта с помощью Jenkins</a>
* <a>Отчётность, скриншоты и видео</a>
  + <a href="#allure">Allure</a>
  + <a href="#allure-testops">Allure TestOps</a>
  + <a href="#selenoid">Selenoid</a>
  + <a href="#browserstack">Browserstack</a>
  + <a href="#telegram">Telegram</a>

## <a name="part1">Тестирование магазина Мегацвет-24</a>
![logo_megacvet.png](https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/logo_megacvet.png)
## :green_book: <a id="description-web">Описание</a>
Проект содержит в себе тесты на UI, API\
Список того, что было реализовано в проекте:
- [x] Реализация `Page Object` с использованием `Chain of Invocations`
- [x] Параметризованные тесты
- [x] Параллельное выполнение тестов с помощью `JUnit 5`
- [x] Генерация рандомных значений с помощью библиотеки `Faker`
- [x] Параметризованные билды `Jenkins`
- [x] Использование `POJO` для моделей для API тестов
- [x] Использование Request/Response спецификаций для API тестов
- [x] Использование `XPath` для поиска информации на html-странице
- [x] Кастомный Allure listener для форматированного логирования API запросов/ответов
- [x] Интеграция с `Allure TestOps`

## :vibration_mode: <a name="part2">Тестирование мобилного приложения CoinKeeper</a>
![logo_megacvet.png](https://play-lh.googleusercontent.com/koRxwP270fRjxWwb5cilmbP6xiAKG4BpYAMG0B50YJfZjeZvuj01AvLq4myOOXyLXT-J)
<a id="description-mobile"></a>
## :closed_book: Описание
Проект содержит в себе тесты для Mobile (Android)\
Список того, что было реализовано в проекте:
- [x] Реализация `Page Object` с использованием `Chain of Invocations`
- [x] Генерация рандомных значений с помощью библиотеки `Faker`
- [x] Параметризованные билды `Jenkins`
- [x] Использование `XPath` для поиска информации на html-странице
- [x] Интеграция с `Allure TestOps`

<a id="stack"></a>
## :gear: Cтек технологий
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="pictures/Intelij_IDEA.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="pictures/Java.svg" width="50"/></a>
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="pictures/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="pictures/Selenide.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="REST Assured" height="50" src="pictures/Rest-Assured.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="pictures/Gradle.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure" height="50" src="pictures/Allure.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="pictures/Jenkins.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="pictures/Selenoid.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="pictures/GitHub.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="pictures/Telegram.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="pictures/Allure TestOps.svg" width="50/></a>
<a href="https://appium.io/"><img alt="Appium" height="45" src="pictures/Appium.svg" width="45"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="45" src="pictures/Browserstack.svg" width="45"/></a>
</div>

<a id="gradle-launch"></a>
## :computer: Запуск проекта с помощью терминала

Для запуска тестов с помощью Gradle используется команда:
```bash
gradle clean <task> -Denvironment=<environment>
```
`task` - выбор вида тестов:
>- *all_tests*
>- *api_tests*
>- *ui_tests*
>- *mobile_tests*

`env` - окружение, на котором будут выполнятся тесты:
>- *remote (для всех видов тестов)*
>- *local (для всех видов тестов)*

Property file выбирается в зависимости от выбранного окружения 

<a id="jenkins-launch"></a>
##  <a href="https://jenkins.autotests.cloud/job/chitai-gorod/"><img alt="Jenkins" height="50" src="pictures/Jenkins.svg" width="50"/>Запуск проекта с помощью Jenkins</a>

Страница проекта в Jenkins

<a href="https://jenkins.autotests.cloud/job/chitai-gorod/"><img src="https://user-images.githubusercontent.com/110110734/202859544-d8c8b67d-1dcf-48b0-8d80-6170ec8f19a4.png" alt="Jenkins">
</a>

Параметры сборки:
>- *`tag` - выбор вида тестов*
>- *`platform` - платформа*
>- *`env` - окружение, на котором будут выполнятся тесты*
>- *`browser` - браузер*
>- *`REMOTE_URL` - адрес Selenoid / Browserstack*
>- *`VIDEO_STORAGE` - адрес хранилища видео Selenoid*

<a id="allure"></a>
## <a href="https://jenkins.autotests.cloud/job/014-java-geraniya-diploma/allure/"><img alt="Allure" height="50" src="pictures/Allure.svg" width="50"/>Allure</a>

Пример Allure отчёта

<table>
    <tr>
        <td>
        <a href="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Allure_1.png">
        <img src="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Allure_1.png">
        </a>
        </td>
        </tr>
        <tr>
        <td>
        <a href="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Allure_2.png">
        <img src="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Allure_2.png">
        </a>
        </td>
</table>

<a id="allure-testops"></a>
## <a href="https://allure.autotests.cloud/project/1715/dashboards"><img alt="Allure TestOps" height="50" src="pictures/Allure TestOps.svg" width="50"/>Allure Test Ops</a>

Пример Allure TestOps отчёта

<table>
    <tr>
        <td>
        <a href="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/test_ops.png">
        <img src="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/test_ops.png">
        </a>
        </td>
   </tr>
        <tr>
        <td>
        <a href="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Test_ops_dashboard.png">
        <img src="https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/Test_ops_dashboard.png">
        </a>
        </td>
        </tr>
</table>

<a id="selenoid"></a>
## <img alt="Selenoid" height="50" src="pictures/Selenoid.svg" width="50"/>Selenoid</a>

Видео-пример выполнения UI-теста с помощью Selenoid

<video src="https://user-images.githubusercontent.com/geraniya13/Diploma/master/pictures/UI.mp4" controls="controls" style="max-width: 730px;" poster="/pictures/logos/Selenoid.svg"></video>

<a id="browserstack"></a>
## <img alt="Browserstack" height="45" src="pictures/Browserstack.svg" width="45"/>Browserstack</a>

Видео-пример выполнения Mobile-теста с помощью Browserstack

<video src="https://user-images.githubusercontent.com/geraniya13/Diploma/master/pictures/Mobile.mp4" controls="controls" style="max-width: 730px;" poster="/pictures/logos/Browserstack.svg"></video>

<a id="telegram"></a>
## <a href="https://t.me/qa_guru_14_geraniya_bot"><img alt="Telegram" height="50" src="pictures/Telegram.svg" width="50"/>Telegram</a>

Пример уведомления в Telegram-бот по окончании выполнения тестов

![Telegram screenshot](https://raw.githubusercontent.com/geraniya13/Diploma/master/pictures/telegram_notification.jpg)
