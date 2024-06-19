package lesson1;

public class Simple {

    /**
     * Пример
     * <p>
     * Вычисление квадрата целого числа
     */
    public static int sqr(int x) {
        return x * x;
    }


    /**
     * Пример
     * <p>
     * Вычисление квадрата вещественного числа
     */
    public static double sqr(double x) {
        return x * x;
    }


    /**
     * Пример
     * <p>
     * Вычисление дискриминанта квадратного уравнения
     */
    public static double discriminant(double a, double b, double c) {
        return sqr(b) - (double) 4 * a * c;
    }


    /**
     * Пример
     * <p>
     * Поиск одного из корней квадратного уравнения
     */
    public static double quadraticEquationRoot(double a, double b, double c) {
        double var10000 = -b;
        double var6 = discriminant(a, b, c);
        return (var10000 + Math.sqrt(var6)) / ((double) 2 * a);
    }


    /**
     * Пример
     * <p>
     * Поиск произведения корней квадратного уравнения
     */
    public static double quadraticRootProduct(double a, double b, double c) {
        double x1 = discriminant(a, b, c);
        double sd = Math.sqrt(x1);
        x1 = (-b + sd) / ((double) 2 * a);
        double x2 = (-b - sd) / ((double) 2 * a);
        return x1 * x2;
    }


    /**
     * Пример главной функции
     * Можно попробовать её запустить по кнопке Play рядом с названием функции
     */
    public static void main(String[] args) {
        double x1x2 = quadraticRootProduct(1.0, 13.0, 42.0);
        String var3 = "Root product: " + x1x2;
        System.out.println(var3);
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
     * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
     */
    public static int seconds(int hours, int minutes, int seconds) {
        return seconds + minutes * 60 + hours * 3600;
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
     * Определить длину того же отрезка в метрах (в данном случае 18.98).
     * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
     */
    public static double lengthInMeters(int sagenes, int arshins, int vershoks) {
        double arshinsFactor = 48 / 3.0;
        double sagenesFactor = 3;

        double vershoksInCm = 4.445;
        double arshinsInCm = vershoksInCm * arshinsFactor;
        double sagenesInCm = arshinsInCm * sagenesFactor;


        double lengthInCm = vershoks * vershoksInCm;
        lengthInCm += arshins * arshinsInCm;
        lengthInCm += sagenes * sagenesInCm;

        return lengthInCm / 100;
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
     * Вывести значение того же угла в радианах (например, 0.63256).
     */
    public static double angleInRadian(int grad, int min, int sec) {
        double decimalGrad = grad + min / 60.0 + sec / 3600.0;

        return decimalGrad * Math.PI/180;
    }


    /**
     * Тривиальная
     * <p>
     * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
     * Например, расстояние между (3, 0) и (0, 4) равно 5
     */
    public static double trackLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое число, большее 100 (например, 3801).
     * Определить третью цифру справа в этом числе (в данном случае 8).
     */
    public static int thirdDigit(int number) {
        int count = 3, counter = 0;
        int digit = 0;

        while( count != counter ){
            digit = number % 10;
            number = number / 10;

            counter++;
        }

        return digit;
    }


    /**
     * Простая
     * <p>
     * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
     * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
     * Определите время поезда в пути в минутах (в данном случае 216).
     */
    public static int travelMinutes(int hoursDepart, int minutesDepart, int hoursArrive, int minutesArrive) {
        int arriveTime = hoursArrive * 60 + minutesArrive;
        int departTime = hoursDepart * 60 + minutesDepart;

        return arriveTime - departTime;
    }


    /**
     * Простая
     * <p>
     * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
     * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
     * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
     */
    public static double accountInThreeYears(int initial, int percent) {
        int years = 3;
        double account = initial;

        for(int i=0; i<years; i++){
            account += (account/100) * percent;
        }

        return account;
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое трехзначное число (например, 478).
     * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
     */
    public static int numberRevert(int number) {
        String strNumber = Integer.toString(number);
        String reversedStrNumber = new StringBuilder(strNumber).reverse().toString();

        return Integer.parseInt(reversedStrNumber);
    }
}