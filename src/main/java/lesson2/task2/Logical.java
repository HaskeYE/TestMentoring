package lesson2.task2;

import java.time.YearMonth;

import static lesson1.Simple.sqr;

public class Logical {
    /**
     * Пример
     * <p>
     * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
     */
    public static boolean pointInsideCircle(double x, double y, double x0, double y0, double r) {
        return sqr(x - x0) + sqr(y - y0) <= sqr(r);
    }

    /**
     * Простая
     * <p>
     * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
     * Определить, счастливое ли заданное число, вернуть true, если это так.
     */
    public static boolean isNumberHappy(int number) {
        int firstDigit = number / 1000;
        int secondDigit = (number / 100) % 10;
        int thirdDigit = (number / 10) % 10;
        int fourthDigit = number % 10;

        int sumFirstTwo = firstDigit + secondDigit;
        int sumLastTwo = thirdDigit + fourthDigit;

        return sumFirstTwo == sumLastTwo;
    }

    /**
     * Простая
     * <p>
     * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
     * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
     * Считать, что ферзи не могут загораживать друг друга.
     */
    public static boolean queenThreatens(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }

    /**
     * Простая
     * <p>
     * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
     * Вернуть число дней в этом месяце этого года по григорианскому календарю.
     */
    public static int daysInMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);

        return yearMonth.lengthOfMonth();
    }

    /**
     * Средняя
     * <p>
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     * Вернуть true, если утверждение верно
     */
    public static boolean circleInside(double x1, double y1, double r1, double x2, double y2, double r2) {
        // расстояние между двумя точками sqrt(sqr(x2 - x1) + sqr(y2 - y1))
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        return distance + r1 <= r2;
    }

    /**
     * Средняя
     * <p>
     * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
     * Стороны отверстия должны быть параллельны граням кирпича.
     * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
     * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
     * Вернуть true, если кирпич пройдёт
     */
    public static boolean brickPasses(int a, int b, int c, int r, int s) {
        return (a <= r && b <= s) || (a <= s && b <= r) ||
               (a <= r && c <= s) || (a <= s && c <= r) ||
               (b <= r && c <= s) || (b <= s && c <= r);
    }
}
