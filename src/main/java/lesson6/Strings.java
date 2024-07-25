package lesson6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lesson1.Simple.seconds;

public class Strings {

    /**
     * Пример
     * <p>
     * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
     * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
     */
    public static final int timeStrToSeconds(String str) {
        List<String> parts = List.of(str.split(":"));

        return seconds(
                Integer.parseInt(parts.get(0)),
                Integer.parseInt(parts.get(1)),
                Integer.parseInt(parts.get(2)));
    }

    /**
     * Пример
     * <p>
     * Дано число n от 0 до 99.
     * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
     */
    public static final String twoDigitStr(int n) {
        return n < 10 ? String.format("0%d", n) : String.valueOf(n);
    }

    /**
     * Пример
     * <p>
     * Дано seconds -- время в секундах, прошедшее с начала дня.
     * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
     */
    public static final String timeSecondsToStr(int seconds) {
        int hour = seconds / 3600;
        int minute = seconds % 3600 / 60;
        int second = seconds % 60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }


    /**
     * Средняя
     * <p>
     * Дата представлена строкой вида "15 июля 2016".
     * Перевести её в цифровой формат "15.07.2016".
     * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
     * При неверном формате входной строки вернуть пустую строку.
     * <p>
     * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
     * входными данными.
     */
    public static final String dateStrToDigit(String str) {

        DateFormat inputFormat = new SimpleDateFormat("d MMMM yyyy", new Locale("ru"));
        DateFormat outputFormat = new SimpleDateFormat("dd.MM.y");

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputFormat.parse(str));

            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("ru"));
            int year = calendar.get(Calendar.YEAR);

            String recreactedDateStr1 = String.format("%d %s %d", day, month, year);
            String recreactedDateStr2 = String.format("%02d %s %d", day, month, year);

            if (!(str.equals(recreactedDateStr1) || str.equals(recreactedDateStr2))) {
                return "";
            }

            return outputFormat.format(calendar.getTime());
        } catch (ParseException e) {
            return "";
        }
    }


    /**
     * Средняя
     * <p>
     * Дата представлена строкой вида "15.07.2016".
     * Перевести её в строковый формат вида "15 июля 2016".
     * При неверном формате входной строки вернуть пустую строку
     * <p>
     * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
     * входными данными.
     */
    public static final String dateDigitToStr(String digital) {
        DateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat outputFormat = new SimpleDateFormat("d MMMM yyyy", new Locale("ru"));

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputFormat.parse(digital));

            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);

            String recreatedDateStr = String.format("%02d.%02d.%d", day, month, year);

            if (!digital.equals(recreatedDateStr)) {
                return "";
            }

            return outputFormat.format(calendar.getTime());
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * Средняя
     * <p>
     * Номер телефона задан строкой вида "+7 (921) 123-45-67".
     * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
     * Может присутствовать неограниченное количество пробелов и чёрточек,
     * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
     * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
     * "+79211234567" или "123456789" для приведённых примеров.
     * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
     * При неверном формате вернуть пустую строку
     */
    public static final String flattenPhoneNumber(String phone) {
        String cleanedPhone = phone.replaceAll("[\\s-]", "");

        if (!cleanedPhone.matches("[+\\d]*\\(?\\d*\\)?\\d+")) {
            return "";
        }

        cleanedPhone = cleanedPhone.replaceAll("[()]", "");

        return cleanedPhone;
    }

    /**
     * Средняя
     * <p>
     * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
     * "706 - % 717 % 703".
     * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
     * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
     * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
     * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
     */
    public static final int bestLongJump(String jumps) {
        if (!jumps.matches("(?:\\d+|[%-])(?:\\s(?:\\d+|[%-]))*")) {
            return -1;
        }

        Pattern pattern = Pattern.compile("(\\d+|[%-])");
        Matcher matcher = pattern.matcher(jumps);

        List<Integer> successfulJumps = new ArrayList<>();

        while (matcher.find()) {
            String match = matcher.group(1);
            if (match.matches("\\d+"))
                successfulJumps.add(Integer.valueOf(match));
        }

        return !successfulJumps.isEmpty() ? Collections.max(successfulJumps) : -1;
    }


    /**
     * Сложная
     * <p>
     * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
     * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
     * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
     * Высота и соответствующие ей попытки разделяются пробелом.
     * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
     * При нарушении формата входной строки вернуть -1.
     */
    public static final int bestHighJump(String jumps) {
        if (!jumps.matches("\\d+\\s[%+-]+(?:\\s\\d+\\s[%+-]+)*")) {
            return -1;
        }

        Pattern pattern = Pattern.compile("(\\d+\\s[%+-]+)");
        Matcher matcher = pattern.matcher(jumps);

        List<Integer> highJumps = new ArrayList<>();

        while (matcher.find()) {
            List<String> match = List.of(matcher.group(1).split("\\s"));
            String jumpHeight = match.get(0);
            String attempts = match.get(1);

            if (attempts.contains("+") && jumpHeight.matches("\\d+")) {
                highJumps.add(Integer.valueOf(jumpHeight));
            }
        }

        return !highJumps.isEmpty() ? Collections.max(highJumps) : -1;
    }

    /**
     * Сложная
     * <p>
     * В строке представлено выражение вида "2 + 31 - 40 + 13",
     * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
     * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
     * Вернуть значение выражения (6 для примера).
     * Про нарушении формата входной строки бросить исключение IllegalArgumentException
     */
//Works with first element = +4/-4
    public static final int plusMinus(String expression) {
        return 0;
    }

    /**
     * Сложная
     * <p>
     * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
     * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
     * Слова, отличающиеся только регистром, считать совпадающими.
     * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
     * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
     */

    public static final int firstDuplicateIndex(String str) {
        return 0;
    }


    /**
     * Сложная
     * <p>
     * Строка содержит названия товаров и цены на них в формате вида
     * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
     * То есть, название товара отделено от цены пробелом,
     * а цена отделена от названия следующего товара точкой с запятой и пробелом.
     * Вернуть название самого дорогого товара в списке (в примере это Курица),
     * или пустую строку при нарушении формата строки.
     * Все цены должны быть больше либо равны нуля.
     */
    public static final String mostExpensive(String description) {
        return null;
    }

    /**
     * Сложная
     * <p>
     * Перевести число roman, заданное в римской системе счисления,
     * в десятичную систему и вернуть как результат.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: XXIII = 23, XLIV = 44, C = 100
     * <p>
     * Вернуть -1, если roman не является корректным римским числом
     */


    public static final int fromRoman(String roman) {
        return 0;
    }


    /**
     * Очень сложная
     * <p>
     * Имеется специальное устройство, представляющее собой
     * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
     * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
     * Каждая команда кодируется одним специальным символом:
     * > - сдвиг датчика вправо на 1 ячейку;
     * < - сдвиг датчика влево на 1 ячейку;
     * + - увеличение значения в ячейке под датчиком на 1 ед.;
     * - - уменьшение значения в ячейке под датчиком на 1 ед.;
     * [ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
     * не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
     * ] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
     * не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
     * (комбинация [] имитирует цикл)
     * пробел - пустая команда
     * <p>
     * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
     * <p>
     * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
     * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
     * значении под датчиком равном 0) и пробелы.
     * <p>
     * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
     * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
     * <p>
     * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
     * То же исключение формируется, если у символов [ ] не оказывается пары.
     * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
     * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
     * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
     * IllegalArgumentException.
     * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
     */
    public static final List computeDeviceCells(int cells, String commands, int limit) {
        return null;
    }
}
