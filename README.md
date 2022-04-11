# О проекте 
Данный проект создан в рамках курсовой работы. Плагин умеет:
1)	Проверять модуль на одновременное использование Java и Kotlin кода.
1)	Проверять на наличие генерации BuildConfig’a и предупреждать об этом.
2)	Отключать неиспользуемые Android Gradle Plugin Features.
3)	Отключать Jetifier.
4)	Включать Gradle daemons.
5)	Отключать R8 для debug сборки.
6)	Разбивать ресурсов из библиотек и ресурсов приложения или использование не транзитивных R классов
7)	Запускать Gradle tasks в параллельном режиме.
8)	Отключать сжатия PNG картинок при каждой сборке 

# Как установить
Скачать [JAR файл](https://github.com/Freeezzzi/coursework3/blob/master2/jars/) и установить самостоятельно
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

# Как пользоваться
## Локальные оптимизации
Нужно зайти в ```build.gradle``` или ```gradle.properties``` файл модуля, который нужно оптимизировать. 
В панели инструментов можно будет выбрать доступные действия для данного файла и применить их и применить их <kbd>OptimizeBuildTimePlugin</kbd> -> <kbd>Optimizations</kbd> 
![Локальные оптимизации](/images/Optimizations.jpg)

## Проверка модуля на наличие Java и Kotlin кода
Данная проверка включена по дефолту. Включить/отключить ее можно в настройках <strong>Preferences</strong> -> <strong>Editor</strong> -> <kbd>Inspections</kbd> -> <kbd>OptimizeBuildTimePlugin</kbd> -> <kbd>Java and Kotlin code together inspection</kbd>


# Демонстрация (нужно нажать на картинку)
[<img src="https://img.youtube.com/vi/ioheOYLuvAE/maxresdefault.jpg" width="50%">](https://youtu.be/ioheOYLuvAE)
