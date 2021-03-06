# Проект автоматизации тестирования сайта GeekBrains

Тесты написаны для https://geekbrains.ru/

## Описание проекта
Данный проект включает в себя 4 теста: SearchTest, LeftNavigationTest, CourseTest и AuthorizationTest.

- SearchTest 
проверяет поиск по сайту. Включает в себя проверку, что были найдены все обязательные блоки
и найдно верное количество элементов в каждом блоке. Так включает в себя проверку отображения футера и хэдера
для неавторизованного пользователя

- LeftNavigationTest 
проверяет работу меню навигации. Включает в себя проверку работы для кажой кнопки навигации, 
открытие страницы и сравнение ожидаемого и полученного результата

- CourseTest 
проверяет работу табов и поиска на странице Курсов. Включает в себя проверку, что открылся нужный таб, 
работу чек боксов, а также проверку, что были найдены нужные элементы.  

- AuthorizationTest проверяет авторизацию пользователя с валидными логином и паролем. 
Включает в себя проверку редиректа после авторизации пользователя, а также проверку футера и хэдера для 
авторизованного пользователя

## Чтобы запустить тесты и просмотреть отчет соберите проект командой:

```mvn
mvn clean test allure:serve
```

## Используемые библиотеки

  - selenium-java
  - junit-jupiter
  - webdrivermanager
  - hamcrest
  - allure-junit5
  

## Автор проекта
Кряжова Светлана Юрьевна
