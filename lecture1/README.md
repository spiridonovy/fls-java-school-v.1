# FLS Java School - Lecture 1

## Основные команды для работы с GIT

1. `git clone https://github.com/spiridonovy/fls-java-school-v.1.git` для клонирования удаленного репозитория в локальную директорию
2. `git branch` - показывает существующие ветки, использую дополнительные аргументы можно создавать и удалять ветки
3. `git checkout -b <branch_name>` - создать новую ветку и переключиться на нее
4. `git checkout <branch_name>` - переключиться на указанную ветку
5. `git status` отображает какие изменения были сделаны
6. `git add` - для добавления содержимого в индекс перед коммитом
7. `git commit -m '<commit message>'` - берет данные из индекса и фиксирует их в локальной рабочей версии репозитория
8. `git push` отправляет изменения в удаленный репозиторий
9. `git pull` забирает последние изменения из репозитория

## Как выполнять задания
#### Пукнты 1-6 выполняются 1 раз
1. Создать Github-account
2. Сделать Fork основного репозитория Java-школы
3. Клонировать только что форкнутый репозиторий в локальную директорию на компьютере:
> git clone https://github.com/<YOUR_USERNAME>/fls-java-school-v.1.git
4. Перейти в локальную директорию клонированного репозитория
5. Добавить референс на основной репозиторий Java-школы:
> git remote add upstream https://github.com/spiridonovy/fls-java-school-v.1.git
6. Командой `git remote -v` проверить, что вы имеете 2 референса: origin и upstream
7. Выполнить команду `git checkout master`, чтобы перейти на master-ветку вашего форкнутого репозитория
8. Выполнить команду `git fetch upstream`, чтобы подтянуть все изменения с центрального репозитория Java-школы в ваш форкнутый репозиторий
9. Создайте новый GIT-branch (формат имени создаваемого бранча указан ниже)
10. Делаем необходимые изменения в соответствии с домашним заданием
11. Добавляем изменения в GIT индекс: `git add .`
12. Фиксируем изменения в локальный репозиторий: `git commit -m '<commit message>'`
13. Отправляем коммит в центральный репозиторий: `git push origin <your_branch_name>`
14. Переходим на Github.com и создаем новый Pull Request

## Если git push не проходит, то нужно выполнить команду:
> git remote set-url origin git@github.com:<YOUR_USERNAME>/fls-java-school-v.1.git и только затем git push 

## Какое имя давать для ветки в GIT
> fls-lecture-<номер_лекции>-<github_username>

## Полезные ссылки

1. [GIT](https://git-scm.com/) - система контроля версий
2. [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE for Java
3. [GIT book](https://git-scm.com/book/ru/v2) - Отличная книга о GIT
4. [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Development Toolkit (version 8)
