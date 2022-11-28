// ДЗ 3. Дана json строка (можно сохранить в файл и читать из файла)

// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода:

// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package DZ;

import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        String json_string = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\"," +
                "\"оценка\":\"5\",\"предмет\":\"Физика\"}";

        //объявляем переменные для поиска подстрок и массимы для хранения соответствующих значений
        String last_name = "фамилия";
        String grade = "оценка";
        String lesson = "предмет";
        String[] last_names = new String[3];
        String[] grades = new String[3];
        String[] lessons = new String[3];

        StringBuilder sb = new StringBuilder();

        String str[] = json_string.split("},");


        //Удаляем из строки все лишнее
        for (int i = 0; i < str.length ; i++) {
            str[i] = str[i].replaceAll("\\{", "");
            str[i] = str[i].replaceAll("}", "");
            str[i] = str[i].replaceAll(":", "");

        }

        //в этом цикле ищем вхождения нужных подстрок и вытаскиваем нужные значения
        for (int i = 0; i < str.length; i++) {

            if (str[i].indexOf(last_name) > 0) {
                int startIndex = str[i].indexOf(last_name) + 9;
                int endIndex = str[i].indexOf("\"", startIndex);
                String temp = str[i].substring(startIndex, endIndex);
                last_names[i] = temp;
            }
            if (str[i].indexOf(grade) > 0) {
                int startIndex = str[i].indexOf(grade) + 8;
                int endIndex = str[i].indexOf("\"", startIndex);
                String temp = str[i].substring(startIndex, endIndex);
                grades[i] = temp;
            }
            if (str[i].indexOf(lesson) > 0) {
                int startIndex = str[i].indexOf(lesson) + 9;
                int endIndex = str[i].indexOf("\"", startIndex);
                String temp = str[i].substring(startIndex, endIndex);
                lessons[i] = temp;
            }
            
        }

        //ну а тут просто добавляем строки для вывода
        for (int i = 0; i < str.length; i++) {
            sb.append("Студент " + last_names[i] + " получил " + grades[i] + " по предмету " + lessons[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
