# Notes CLI

Консольная утилита для работы с текстовыми заметками на Java.  
Позволяет добавлять, выводить и удалять заметки, хранит данные в файле `data/notes.csv`.  

Автор: malikborov19  
GitHub: [https://github.com/malikborov19](https://github.com/malikborov19)

---

## Структура проекта

notes-cli/
├─ src/
│ └─ com/example/
│ ├─ App.java
│ └─ NotesStore.java
├─ data/
│ └─ notes.csv
├─ Dockerfile
├─ .github/workflows/ci.yml
├─ .gitignore
└─ README.md

markdown
Copy code

---

## Возможности и версии

**v1.0.0**
- Добавление заметки (`add`)
- Вывод всех заметок (`list`)
- Постоянное хранение данных в `data/notes.csv`
- Проверка компиляции Java через CI

**v1.1.0**
- Удаление заметки по ID (`rm`)

> Важно: если удаляемая заметка не найдена, выводится:
Not found #ID

yaml
Copy code

**v1.2.0 (опционально, зависит от выбора дополнительной команды)**
- Подсчёт количества заметок (`count`)

---

## Локальный запуск

**Добавить заметку**
```bash
java -cp src com.example.App --cmd=add --text="Купить хлеб"
Посмотреть список заметок

bash
Copy code
java -cp src com.example.App --cmd=list
Удалить заметку по ID

bash
Copy code
java -cp src com.example.App --cmd=rm --id=1
Подсчитать количество заметок

bash
Copy code
java -cp src com.example.App --cmd=count
Примеры
Пример содержимого data/notes.csv:

Copy code
1;Купить молоко
2;Позвонить другу
3;Сделать домашку
Вывод команды list:

Copy code
1;Купить молоко
2;Позвонить другу
3;Сделать домашку
Вывод команды rm для несуществующего ID:

nginx
Copy code
Not found #4
Запуск через Docker
Сборка образа

bash
Copy code
docker build -t notes-cli:dev .
Добавление заметки

bash
Copy code
docker run --rm -v "$PWD/data:/app/data" notes-cli:dev --cmd=add --text="Test note"
Просмотр списка заметок

bash
Copy code
docker run --rm -v "$PWD/data:/app/data" notes-cli:dev --cmd=list
Удаление заметки по ID

bash
Copy code
docker run --rm -v "$PWD/data:/app/data" notes-cli:dev --cmd=rm --id=1
Обратите внимание: данные сохраняются на хосте в папке data даже после остановки контейнера.

CI (Continuous Integration)
Каждый push и pull request запускает компиляцию Java-файлов через GitHub Actions.
Файл workflow расположен по пути:

bash
Copy code
.github/workflows/ci.yml
Цель CI:

Проверка компиляции всех .java файлов

Автоматическая проверка при каждом push и pull request

Релизы
v1.0.0

Первые полезные функции: add, list

v1.1.0

Добавлена команда rm (удаление заметки по ID)

v1.2.0

Опционально: count (подсчёт количества заметок)