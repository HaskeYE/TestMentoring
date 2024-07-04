package lesson3;

import java.sql.SQLOutput;

import static java.lang.Math.sqrt;

public class Loops {
    /**
     * Пример
     *
     * Вычисление факториала
     */
    public static double factorial(int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Пример
     *
     * Проверка числа на простоту -- результат true, если число простое
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int m = 3; m <= (int) sqrt(n); m+= 2) {
            if (n % m == 0) return false;
        }
        return true;
    }

    /**
     * Пример
     *
     * Проверка числа на совершенность -- результат true, если число совершенное
     */
    public static boolean isPerfect(int n) {
        int sum = 1;
        for (int m = 2; m <= n/2; m++) {
            if (n % m > 0) continue;
            sum += m;
            if (sum > n) break;
        }
        return sum == n;
    }

    /**
     * Пример
     *
     * Найти число вхождений цифры m в число n
     */
    public static int digitCountInNumber(int n, int m) {
        return n == m ? 1 : (n < 10 ? 0 : digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m));
    }

    //Ремарка: многие задачи здесь можно решить переиспользованием предыдущих из этого урока =)

    /**
     * Тривиальная
     *
     * Найти количество цифр в заданном числе n.
     * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static int digitNumber(int n) {
        int count = 0;

        if(n == 0) return 1;

        while(n > 0){
            count++;
            n /= 10;
        }

        return count;
    }

    /**
     * Простая
     *
     * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
     * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
     */
    public static int fib(int n) {
        if(n <= 1) return n;

        return fib(n-1) + fib(n-2);
    }

    public static int fibiter(int n){
        if(n <= 1) return n;

        int fib1 = 0, fib2 = 1, fibonacci = 0;
        for (int i = 2; i <= n; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }


    /**
     * Простая
     *
     * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
     * минимальное число k, которое делится и на m и на n без остатка
     */
    public static int lcm1(int m, int n) {
        int number = Math.max(m, n);

        while(!(number % m == 0 && number % n == 0)){
            number++;
        }

        return number;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для нахождения НОК (наименьшее общее кратное)
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Простая
     *
     * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
     */
    public static int minDivisor(int n) {
        int divisor = 2;

//        while(!(n % divisor == 0)){
//            divisor++;
//        }

        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                divisor = i;
                break;
            }
        }

        return divisor;
    }

    /**
     * Простая
     *
     * Для заданного числа n > 1 найти максимальный делитель, меньший n
     */
    public static int maxDivisor(int n) {

        for(int i = n-1; i > 0; i--){
            if(n % i == 0){
                return i;
            }
        }

        return 0;
    }

    /**
     * Простая
     *
     * Определить, являются ли два заданных числа m и n взаимно простыми.
     * Взаимно простые числа не имеют общих делителей, кроме 1.
     * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
     */
    public static boolean isCoPrime(int m, int n) {
        for(int i = 2; i <= Math.max(m, n); i++){
            if(m % i == 0 && n % i == 0){
                return false;
            }
        }

        return true;
    }

    /**
     * Простая
     *
     * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
     * то есть, существует ли такое целое k, что m <= k*k <= n.
     * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
     */
    public static boolean squareBetweenExists(int m, int n) {

        int start = (int) Math.ceil(Math.sqrt(m));
        int end = (int) Math.floor(Math.sqrt(n));

        for (int i = start; i <= end; i++) {
            int square = i * i;
            if (square >= m && square <= n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Средняя
     *
     * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
     *
     *   ЕСЛИ (X четное)
     *     Xслед = X /2
     *   ИНАЧЕ
     *     Xслед = 3 * X + 1
     *
     * например
     *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
     * Данная последовательность рано или поздно встречает X == 1.
     * Написать функцию, которая находит, сколько шагов требуется для
     * этого для какого-либо начального X > 0.
     */
    public static int collatzSteps(int x) {
        int steps = 0;

        while(x > 1){
            if(x % 2 == 0){
                x = x /2;
            }else{
                x = 3 * x + 1;
            }

            steps++;
        }
        return steps;
    }

    /**
     * Средняя
     *
     * Для заданного x рассчитать с заданной точностью eps
     * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     */
    public static double sin(double x, double eps) {
        double term = x;
        double sum = term;
        int n = 1;

        while (Math.abs(term) >= eps) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }

        return sum;
    }

    /**
     * Средняя
     *
     * Для заданного x рассчитать с заданной точностью eps
     * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     */
    public static double cos(double x, double eps) {
        double term = 1.0;
        double sum = term;
        int n = 1;

        while(Math.abs(term) >= eps) {
            term *= -x * x / ((2 * n - 1) * (2 * n));
            sum += term;
            n++;
        }

        return sum;
    }

    /**
     * Средняя
     *
     * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static int revert(int n) {
        int result = 0;

        while(n > 0){
            int digit = n % 10;
            result = result * 10 + digit;
            n /= 10;
        }

        return result;
    }

    /**
     * Средняя
     *
     * Проверить, является ли заданное число n палиндромом:
     * первая цифра равна последней, вторая -- предпоследней и так далее.
     * 15751 -- палиндром, 3653 -- нет.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static boolean isPalindrome(int n) {
        return n == Loops.revert(n);
    }

    /**
     * Средняя
     *
     * Для заданного числа n определить, содержит ли оно различающиеся цифры.
     * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static boolean hasDifferentDigits(int n) {
        int first, second = 0;

        while(n != 0){
            first = n % 10;

            n /= 10;

            if(n == 0) return false;

            second = n % 10;

            if(first != second){
                return true;
            }
        }

        return false;
    }

    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из квадратов целых чисел:
     * 1 4 9 16 25 36 49 64 81 100 121 144...
     * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static int squareSequenceDigit(int n) {
        int counter = 0;
        int number = 1;

        while (true) {
            int square = number * number;
            int numDigits = (int) Math.log10(square) + 1;

            for (int i = numDigits - 1; i >= 0; i--) {
                int digit = (square / (int) Math.pow(10, i)) % 10;
                counter++;

                if (counter == n) {
                    return digit;
                }
            }

            number++;
        }
    }


    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
     * 1123581321345589144...
     * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    public static int fibSequenceDigit(int n) {
        int counter = 0;
        int fibonacci;
        int k = 0;

        while(true){
            fibonacci = Loops.fib(k++);

            int numDigits = (int) Math.log10(fibonacci) + 1;

            for(int i = numDigits - 1; i >=0; i--){
                int digit = (fibonacci / (int)Math.pow(10, i)) % 10;
                counter++;

                if(counter == n){
                    return digit;
                }
            }
        }
    }
}
