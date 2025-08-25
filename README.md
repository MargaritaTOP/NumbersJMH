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

* Benchmark                                            (size)  Mode  Cnt   Score    Error  Units
* Home_Work.BenchmarkHomeWork.testArray3or5              1000  avgt   15   0,002 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testArray3or5             10000  avgt   15   0,043 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testArray3or5            100000  avgt   15   0,696 ±  0,018  ms/op
* Home_Work.BenchmarkHomeWork.testArrayAverage           1000  avgt   15  ≈ 10⁻⁴           ms/op
* Home_Work.BenchmarkHomeWork.testArrayAverage          10000  avgt   15   0,003 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testArrayAverage         100000  avgt   15   0,033 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testArrayPrime             1000  avgt   15   0,010 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testArrayPrime            10000  avgt   15   0,176 ±  0,007  ms/op
* Home_Work.BenchmarkHomeWork.testArrayPrime           100000  avgt   15   1,748 ±  0,027  ms/op
* Home_Work.BenchmarkHomeWork.testArraySame              1000  avgt   15   0,028 ±  0,004  ms/op
* Home_Work.BenchmarkHomeWork.testArraySame             10000  avgt   15   0,572 ±  0,013  ms/op
* Home_Work.BenchmarkHomeWork.testArraySame            100000  avgt   15   4,276 ±  0,239  ms/op
* Home_Work.BenchmarkHomeWork.testCF3or5                 1000  avgt   15   0,093 ±  0,003  ms/op
* Home_Work.BenchmarkHomeWork.testCF3or5                10000  avgt   15   0,283 ±  0,015  ms/op
* Home_Work.BenchmarkHomeWork.testCF3or5               100000  avgt   15   1,930 ±  0,084  ms/op
* Home_Work.BenchmarkHomeWork.testCFAverage              1000  avgt   15   0,084 ±  0,004  ms/op
* Home_Work.BenchmarkHomeWork.testCFAverage             10000  avgt   15   0,164 ±  0,006  ms/op
* Home_Work.BenchmarkHomeWork.testCFAverage            100000  avgt   15   0,825 ±  0,026  ms/op
* Home_Work.BenchmarkHomeWork.testCFPrime                1000  avgt   15   0,108 ±  0,005  ms/op
* Home_Work.BenchmarkHomeWork.testCFPrime               10000  avgt   15   0,489 ±  0,031  ms/op
* Home_Work.BenchmarkHomeWork.testCFPrime              100000  avgt   15   3,575 ±  0,205  ms/op
* Home_Work.BenchmarkHomeWork.testCFSame                 1000  avgt   15   0,191 ±  0,012  ms/op
* Home_Work.BenchmarkHomeWork.testCFSame                10000  avgt   15   0,600 ±  0,022  ms/op
* Home_Work.BenchmarkHomeWork.testCFSame               100000  avgt   15   4,031 ±  0,237  ms/op
* Home_Work.BenchmarkHomeWork.testCollection3or5         1000  avgt   15   0,007 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollection3or5        10000  avgt   15   0,163 ±  0,003  ms/op
* Home_Work.BenchmarkHomeWork.testCollection3or5       100000  avgt   15   1,656 ±  0,069  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionAverage      1000  avgt   15   0,001 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionAverage     10000  avgt   15   0,008 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionAverage    100000  avgt   15   0,096 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionPrime        1000  avgt   15   0,015 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionPrime       10000  avgt   15   0,248 ±  0,008  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionPrime      100000  avgt   15   2,624 ±  0,102  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSame         1000  avgt   15   0,045 ±  0,002  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSame        10000  avgt   15   0,289 ±  0,006  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSame       100000  avgt   15   2,536 ±  0,050  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameArray    1000  avgt   15   0,003 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameArray   10000  avgt   15   0,015 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameArray  100000  avgt   15   0,142 ±  0,006  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameMap      1000  avgt   15   0,029 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameMap     10000  avgt   15   0,230 ±  0,006  ms/op
* Home_Work.BenchmarkHomeWork.testCollectionSameMap    100000  avgt   15   2,017 ±  0,044  ms/op
* Home_Work.BenchmarkHomeWork.testFJ3or5                 1000  avgt   15   0,013 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testFJ3or5                10000  avgt   15   0,117 ±  0,008  ms/op
* Home_Work.BenchmarkHomeWork.testFJ3or5               100000  avgt   15   0,543 ±  0,011  ms/op
* Home_Work.BenchmarkHomeWork.testFJAverage              1000  avgt   15   0,011 ±  0,004  ms/op
* Home_Work.BenchmarkHomeWork.testFJAverage             10000  avgt   15   0,063 ±  0,003  ms/op
* Home_Work.BenchmarkHomeWork.testFJAverage            100000  avgt   15   0,205 ±  0,009  ms/op
* Home_Work.BenchmarkHomeWork.testFJPrime                1000  avgt   15   0,030 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testFJPrime               10000  avgt   15   0,237 ±  0,009  ms/op
* Home_Work.BenchmarkHomeWork.testFJPrime              100000  avgt   15   0,589 ±  0,020  ms/op
* Home_Work.BenchmarkHomeWork.testFJSame                 1000  avgt   15   0,058 ±  0,002  ms/op
* Home_Work.BenchmarkHomeWork.testFJSame                10000  avgt   15   0,293 ±  0,006  ms/op
* Home_Work.BenchmarkHomeWork.testFJSame               100000  avgt   15   1,123 ±  0,030  ms/op
* Home_Work.BenchmarkHomeWork.testPStream3or5            1000  avgt   15   0,083 ±  0,001  ms/op
* Home_Work.BenchmarkHomeWork.testPStream3or5           10000  avgt   15   0,135 ±  0,003  ms/op
* Home_Work.BenchmarkHomeWork.testPStream3or5          100000  avgt   15   0,407 ±  0,007  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamAverage         1000  avgt   15   0,041 ±  0,002  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamAverage        10000  avgt   15   0,049 ±  0,005  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamAverage       100000  avgt   15   0,149 ±  0,004  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamPrime           1000  avgt   15   0,077 ±  0,005  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamPrime          10000  avgt   15   0,134 ±  0,003  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamPrime         100000  avgt   15   0,464 ±  0,014  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamSame            1000  avgt   15   0,282 ±  0,011  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamSame           10000  avgt   15   0,597 ±  0,015  ms/op
* Home_Work.BenchmarkHomeWork.testPStreamSame          100000  avgt   15   1,462 ±  0,035  ms/op

#### В виде гистограммы:

![График времени выполнения](/img/i7-5820K_(6_cores,12_logical).png)
