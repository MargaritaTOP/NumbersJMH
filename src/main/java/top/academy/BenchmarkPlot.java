package top.academy;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenchmarkPlot {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String csvFile = "benchmark-results.csv";
        String line;
        String csvSplitBy = ",";
        List<String> orderedBenchmarks = new ArrayList<>();
        Map<String, String> benchmarkToCategory = new HashMap<>();
        Map<String, Double> benchmarkScores = new HashMap<>();
        Map<String, String> benchmarkToImplementation = new HashMap<>();

        // Читаем данные и собираем информацию
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Пропускаем заголовок
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String benchmarkName = data[0].replace("\"", "").replace("top.academy.BenchmarkJMH.", "");
                double score = Double.parseDouble(data[5].replace("\"", ""));
                String implementation = getImplementation(benchmarkName);
                String category = getCategory(benchmarkName);

                benchmarkToCategory.put(benchmarkName, category);
                benchmarkScores.put(benchmarkName, score);
                benchmarkToImplementation.put(benchmarkName, implementation);
                orderedBenchmarks.add(benchmarkName);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Сортировка сначала по категории, потом по реализации
        orderedBenchmarks.sort((a, b) -> {
            String categoryA = getCategory(a);
            String categoryB = getCategory(b);
            if (categoryA.equals(categoryB)) {
                return getImplementation(a).compareTo(getImplementation(b));
            }
            return categoryA.compareTo(categoryB);
        });

        // Добавляем данные в датасет с группировкой по категориям
        for (String benchmarkName : orderedBenchmarks) {
            String implementation = benchmarkToImplementation.get(benchmarkName);
            String category = benchmarkToCategory.get(benchmarkName);
            double score = benchmarkScores.get(benchmarkName);

            // Используем составной ключ для визуальной группировки
            dataset.addValue(score, implementation, category + " - " + benchmarkName);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Benchmark Results by Category",
                "Benchmark Category - Test Name",
                "Time (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // Показывать легенду
                true,
                false
        );

        // Настройка графика
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Поворот подписей

        // Увеличиваем отступы для лучшей читаемости групп
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.2); // Больше места между группами
        domainAxis.setLowerMargin(0.02);
        domainAxis.setUpperMargin(0.02);

        // Настройка рендерера для разных цветов реализаций
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        Color[] colors = new Color[] {
                Color.BLUE,    // Array
                Color.GREEN,   // CF
                Color.RED,     // Collection
                Color.ORANGE,  // FJ
                Color.CYAN     // PStream
        };

        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, colors[i % colors.length]);
        }

        renderer.setItemMargin(0.05); // Ширина столбцов
        renderer.setMaximumBarWidth(0.05); // Максимальная ширина столбцов

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1200, 700));

        JFrame frame = new JFrame("Benchmark Visualization - Grouped by Category");
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static String getCategory(String benchmarkName) {
        if (benchmarkName.contains("3or5")) return "3or5";
        if (benchmarkName.contains("Prime")) return "Prime";
        if (benchmarkName.contains("Average")) return "Average";
        if (benchmarkName.contains("Same")) return "Same";
        return "Other";
    }

    private static String getImplementation(String benchmarkName) {
        if (benchmarkName.contains("Array")) return "Array";
        if (benchmarkName.contains("CF")) return "CF";
        if (benchmarkName.contains("Collection")) return "Collection";
        if (benchmarkName.contains("FJ")) return "FJ";
        if (benchmarkName.contains("PStream")) return "PStream";
        return "Unknown";
    }
}

