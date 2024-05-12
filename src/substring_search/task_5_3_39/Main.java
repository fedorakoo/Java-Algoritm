package substring_search.task_5_3_39;

public class Main {
    public static void main(String [] args) {
        System.out.println("Условие задания: Замер времени. Напишите программу, которая выполняет замеры времени выполнения для поиска всеми четырьмя методами поиска \"it is a far far better thing that i do than i have ever done\" в тексте “Повести о двух городах”. Объясните степень совпадения, до которой ваши результаты подтверждают сведения о производительности, приведенные в тексте раздела.");
        String condition = "it is a far far better thing that i do than i have ever done";
        String text = FileProcessing.getFileText("src/substring_search/task_5_3_39/A_Tale_of_Two_Cities.txt");
        try (LogDuration logDuration = new LogDuration("Алгоритм Рабина Карпа")) {
            RabinCarp.search(condition, text);
        }
        try (LogDuration logDuration = new LogDuration("Алгоритм Кнута-Морриса-Прата")) {
            KMP.search(condition, text);
        }
        try (LogDuration logDuration = new LogDuration("Примитивный поиск")) {
            PrimitiveSearch.search(condition, text);
        }
        try (LogDuration logDuration = new LogDuration("Алгоритм Бойера-Мура")) {
            BoyerMoore.search(condition, text);
        }

    }
}
