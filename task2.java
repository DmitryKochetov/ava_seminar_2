// ДЗ 2. 
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package DZ;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task2 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] { 15, 2, 3, 1, 4, 2, 8, 0, 3 };
        int temp = 0;

// не до конца понял смысл каждой из строк, но они нужны для работы логгера в нужном формате и записи его в файл

        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

// реализуем сортировку и записываем каждое состояние массива до конца сортировки
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            logger.info(Arrays.toString(arr));
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                        temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                        sorted = false;

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
