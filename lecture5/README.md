## Домашнее задание (Pull Request'ы можно присылать до пятницы это недели)

Необходимо реализовать библиотечный метод calculate, который будет в соответствии с заданными условиями выполнять операции умножения, деления, сложения или вычитания... Исходные данные программа должна читать из файла. Данные в файле соответствуют следующему формату:

`<знак операции>`

`<числа через пробел, над которыми надо произвести вычисление>`

Например:

`+`

`1 2 3 4`

Соответственно метод calculate должен вернуть результат сложения 1 + 2 + 3 + 4

Все исключительные ситуации, которые могут возникнуть должны пробрасываться через exception, который вы определите сами. Исключительными ситуациями может быть: ошибка чтения файла, файл не найден, деление на ноль, неправильный формат файла и т.д.

