## Проект бенчмаркинга производительности Java
Этот проект оценивает производительность различных подходов к обработке данных в Java, сравнивая массивы, коллекции, параллельные потоки, CompletableFuture и ForkJoinPool для выполнения типичных задач. Результаты визуализируются с помощью библиотеки JFreeChart.
### Содержание
- Обзор
- Структура проекта 
- Задачи 
- Используемые технологии 
- Установка 
- Запуск бенчмарков 
- Визуализация результатов 
- Результаты бенчмарков 
- Анализ результатов 


### Обзор
- Проект оценивает производительность пяти различных реализаций для четырех типичных задач обработки данных:
- Фильтрация чисел, кратных 3 или 5.
- Фильтрация простых чисел.
- Вычисление среднего значения набора данных.
- Поиск максимальной частоты одинаковых элементов.

Реализации включают:
- Массивы (ArrayTest): Использование примитивных массивов для обработки данных.
- Коллекции (CollectionTest): Использование List<Integer> для обработки данных.
- Параллельные потоки (PStreamTest): Использование параллельных потоков Java.
- CompletableFuture (CFTest): Асинхронная обработка с использованием CompletableFuture.
- ForkJoinPool (FJTest): Использование фреймворка ForkJoin для рекурсивного разделения задач.

Производительность измеряется с помощью Java Microbenchmark Harness (JMH), а результаты визуализируются в виде столбчатой диаграммы с использованием JFreeChart.

top/Home_Work/<br>
├── ArrayTest.java           # Реализация на основе массивов<br>
├── CollectionTest.java      # Реализация на основе коллекций<br>
├── PStreamTest.java         # Реализация с использованием параллельных потоков<br>
├── CFTest.java              # Реализация с использованием CompletableFuture<br>
├── FJTest.java              # Реализация с использованием ForkJoinPool<br>
├── CommonMethods.java       # Вспомогательные методы для проверки делимости и простых чисел<br>
├── BenchmarkHomeWork.java   # Конфигурация бенчмарков JMH<br>
├── py.java                  # Визуализация результатов бенчмарков с помощью JFreeChart<br>
└── benchmark-results.csv    # Файл с результатами бенчмарков<br>

### Задачи
- Проект реализует четыре задачи для каждого подхода:
- 3or5: Фильтрация чисел, кратных 3 или 5.
- Prime: Фильтрация простых чисел.
- Average: Вычисление среднего значения набора данных.
- Same: Поиск максимальной частоты одинаковых элементов в наборе данных.

### Используемые технологии
- Java: Основной язык программирования (рекомендуется версия 17 или выше).
- JMH: Java Microbenchmark Harness для тестирования производительности.
- JFreeChart: Библиотека для визуализации результатов бенчмарков.
- Maven: Система управления зависимостями (необходимы зависимости для JMH и JFreeChart).
- Java Stream API: Для обработки данных с использованием параллельных потоков.
- CompletableFuture: Для асинхронной обработки.
- ForkJoinPool: Для рекурсивного разделения задач.

### Установка
Клонирование репозитория:

git clone <https://github.com/MargaritaTOP/NumericTest><br>
cd <директория-репозитория>

### Настройка Maven:
Убедитесь, что Maven установлен. 


### Полные результаты бенчмарков

| Benchmark                     | (size)  | Mode | Cnt | Score ± Error      | Units |
|-------------------------------|---------|------|-----|--------------------|-------|
| BenchmarkJMH.testArray3or5    | 1000000 | avgt | 3   | 7,024 ± 1,655      | ms/op |
| BenchmarkJMH.testArrayAverage | 1000000 | avgt | 3   | 0,323 ± 0,107      | ms/op |
| BenchmarkJMH.testArrayPrime   | 1000000 | avgt | 3   | 17,921 ± 11,781    | ms/op |
| BenchmarkJMH.testArraySame    | 1000000 | avgt | 3   | 45,317 ± 45,778    | ms/op |
| BenchmarkJMH.testCF3or5       | 1000000 | avgt | 3   | 20,854 ± 23,328    | ms/op |
| BenchmarkJMH.testCFAverage    | 1000000 | avgt | 3   | 7,570 ± 12,261     | ms/op |
| BenchmarkJMH.testCFPrime      | 1000000 | avgt | 3   | 27,100 ± 16,161    | ms/op |
| BenchmarkJMH.testCFSame       | 1000000 | avgt | 3   | 30,279 ± 19,778    | ms/op |
| BenchmarkJMH.testCollection3or5 | 1000000 | avgt | 3 | 39,777 ± 327,465   | ms/op |
| BenchmarkJMH.testCollectionAverage | 1000000 | avgt | 3 | 1,398 ± 0,162     | ms/op |
| BenchmarkJMH.testCollectionPrime | 1000000 | avgt | 3 | 42,113 ± 80,402    | ms/op |
| BenchmarkJMH.testCollectionSame | 1000000 | avgt | 3 | 24,384 ± 25,506    | ms/op |
| BenchmarkJMH.testFJ3or5       | 1000000 | avgt | 3   | 13,629 ± 39,606    | ms/op |
| BenchmarkJMH.testFJAverage    | 1000000 | avgt | 3   | 14,697 ± 98,571    | ms/op |
| BenchmarkJMH.testFJPrime      | 1000000 | avgt | 3   | 12,177 ± 38,031    | ms/op |
| BenchmarkJMH.testFJSame       | 1000000 | avgt | 3   | 12,370 ± 37,024    | ms/op |
| BenchmarkJMH.testPStream3or5  | 1000000 | avgt | 3   | 4,116 ± 6,742      | ms/op |
| BenchmarkJMH.testPStreamAverage | 1000000 | avgt | 3 | 0,679 ± 0,063      | ms/op |
| BenchmarkJMH.testPStreamPrime | 1000000 | avgt | 3   | 3,477 ± 2,920      | ms/op |
| BenchmarkJMH.testPStreamSame  | 1000000 | avgt | 3   | 5,920 ± 4,963      | ms/op |
#### В виде гистограммы:

![График времени выполнения](/img/i7-5820K_(6_cores,12_logical).png)
