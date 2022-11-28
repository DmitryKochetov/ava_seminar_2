// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.

// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package DZ;

public class task1 {
    public static void main(String[] args) {

    String request = "select * from students where ";
    String params = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
    //Сначала строка разбивается на части, в которых удаляются ненужные детали если эти части содержат в себе
        // указания на ключи (name, country ...) а потом добавляются в элемент StringBuilder по очереди
        // алгоритм не оптимальный, поскольку не обрабатывает несколько одинаковых ключей



    StringBuilder sb = new StringBuilder();

    String str[] = params.split(", ");
    String names = null;
    String countries = null;
    String cities = null;
    String ages = null;

        for (int i = 0; i < str.length ; i++) {
//            System.out.println(str[i]);

            if(str[i].contains("name")){
                str[i] = str[i].replaceAll("name", "");
                str[i] = str[i].replaceAll("\"", "");
                str[i] = str[i].replaceAll(":", "");
                names = str[i];

            }
            if(str[i].contains("country")){
                str[i] = str[i].replaceAll("country", "");
                str[i] = str[i].replaceAll("\"", "");
                str[i] = str[i].replaceAll(":", "");
                countries = str[i];

            }
            if(str[i].contains("city")){
                str[i] = str[i].replaceAll("city", "");
                str[i] = str[i].replaceAll("\"", "");
                str[i] = str[i].replaceAll(":", "");
                cities = str[i];

            }
            if(str[i].contains("age")){
                str[i] = str[i].replaceAll("age", "");
                str[i] = str[i].replaceAll("\"", "");
                str[i] = str[i].replaceAll(":", "");
                ages = str[i];

            }
        }
//        System.out.println(sb);
    sb.append(request);

        if(!names.equals("null")) {
            sb.append("NAME = ");
            sb.append("\"");
            sb.append(names);
            sb.append("\"");

        }

        if(!countries.equals("null")) {
            if(!names.equals("null")){
                sb.append(" AND ");
            }
            sb.append("COUNTRY = ");
            sb.append("\"");
            sb.append(countries);
            sb.append("\"");
        }

        if(!cities.equals("null")) {
            if(!countries.equals("null")){
                sb.append(" AND ");
            }
            sb.append("CITY = ");
            sb.append("\"");
            sb.append(cities);
            sb.append("\"");
        }

        if(!ages.equals("null")) {
            if(!cities.equals("null")){
                sb.append(" AND ");
            }
            sb.append("AGE = ");
            sb.append("\"");
            sb.append(ages);
            sb.append("\"");
        }

        System.out.println(sb);

    }

    
}
