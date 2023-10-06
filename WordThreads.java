import java.io.*;
import java.util.*;

public class WordThreads implements Runnable {
    // Список слов
    private final List<String> words = new ArrayList<>();
    // Номер потока
    private final int threadId;
    // Конструктор
    public WordThreads(int threadId) {
       this.threadId = threadId;
    }

    // Функция run() переопределенная из интерфейса Runnable
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/words.txt"))) {
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for(int i = threadId; i < lines.size(); i += 4)
            {
                String[] lineWords = lines.get(i).split(" ");
                Collections.addAll(words, lineWords);
            }
            printWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Функция для вывода слов
    public void printWords() {
        System.out.println(Thread.currentThread().getName() + ": " + words);
    }

    // Метод main)
    public static void main(String[] args){
        // Список для хранения экземпляров класса WordThreads
        List<WordThreads> word_list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WordThreads word_thread = new WordThreads(i);
            // Добавляем экземпляры класса в список для того, чтобы прочитать весь считанный текст
            word_list.add(word_thread);
            // Инициализация потока
            Thread thread = new Thread(word_thread);
            // Пуск потока
            thread.start();
            try {
                // Ожидание окончания потока
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        // Вывод текста в обратном порядке
        List<String> all_words = new ArrayList<>();
        for (WordThreads wordReader : word_list) {
            all_words.addAll(wordReader.words);
        }
        Collections.reverse(all_words);
        System.out.println("Весь считанный текст в обратном порядке:" + all_words);
    }
}
