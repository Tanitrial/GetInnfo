# QA Automation: E2E Tests (Playwright + Java)

## ✅ Что покрыто:

- Авторизация (успешная и неуспешная)
- Наличие формы восстановления пароля
- Проверка доступа к странице «Компания»
- Проверка соответствия руководителя текущему пользователю

## 🧰 Стек:
- Java 17+
- Playwright Java
- JUnit 5
- Maven

## 🚀 Установка и запуск

```bash
git clone https://github.com/yourname/qa-playwright-tests.git
cd qa-playwright-tests
mvn install
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
mvn test
```

## 🔐 Данные для авторизации

URL: https://dev2.getinfo.radugi.net  
Логин: dumbledore@sct.team  
Пароль: 12345678qQ1
