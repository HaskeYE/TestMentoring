package lesson2.task1;

import static java.lang.Math.sqrt;
import static lesson1.Simple.discriminant;

public class IfElse {

    /**
     * Пример
     * <p>
     * Найти число корней квадратного уравнения ax^2 + bx + c = 0
     */
    public static int quadraticRootNumber(double a, double b, double c) {
        double discriminant = discriminant(a, b, c);
        return discriminant > 0.0 ? 2 : (discriminant == 0.0 ? 1 : 0);
    }

    /**
     * Пример
     * <p>
     * Получить строковую нотацию для оценки по пятибалльной системе
     */
    public static String gradeNotation(int grade) {
        String notation;
        switch (grade) {
            case 2:
                notation = "неудовлетворительно";
                break;
            case 3:
                notation = "удовлетворительно";
                break;
            case 4:
                notation = "хорошо";
                break;
            case 5:
                notation = "отлично";
                break;
            default:
                notation = "несуществующая оценка " + grade;
        }
        return notation;
    }

    /**
     * Пример
     * <p>
     * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
     */
    public static double minBiRoot(double a, double b, double c) {
        // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
        if (a == 0.0) {
            if (b == 0.0) return Double.NaN; // ... и ничего больше не делать
            double bc = -c / b;
            if (bc < 0) return Double.NaN;
            return -sqrt(bc);
            // Дальше функция при a == 0.0 не идёт
        }
        double d = discriminant(a, b, c);//2
        if (d < 0.0) return Double.NaN;//3
        //4:
        double y1 = (-b + sqrt(d)) / ((double) 2 * a);
        double y2 = (-b - sqrt(d)) / ((double) 2 * a);
        double y3 = Math.max(y1, y2); //5
        if (y3 < 0.0) return Double.NaN; //6
        return -sqrt(y3); //7
    }

    /**
     * Простая
     * <p>
     * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
     * вернуть строку вида: «21 год», «32 года», «12 лет».
     */
    public static String ageDescription(int age) {
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        String description = switch (lastDigit) {
            case 1 -> (lastTwoDigits == 11)?"лет":"год";
            case 2, 3, 4 -> (lastTwoDigits >= 12 && lastTwoDigits <= 14)?"лет":"года";
            default -> "лет";
        };

//        String description;
//
//        switch(lastDigit){
//            case 1:
//                if(lastTwoDigits == 11)
//                  description = "лет";
//                else
//                  description = "год";
//                break;

//            case 2, 3, 4:
//                if(lastTwoDigits >= 12 && lastTwoDigits <= 14)
//                  description = "лет";
//                else
//                  description = "года";
//                break;

//            default:
//                description = "лет";
//                break;
//        }

        return age + " " + description;
    }

    /**
     * Простая
     * <p>
     * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
     * и t3 часов — со скоростью v3 км/час.
     * Определить, за какое время он одолел первую половину пути?
     */
    public static double timeForHalfWay(double t1, double v1, double t2, double v2, double t3, double v3) {
        double way1 = t1 * v1;
        double way2 = t2 * v2;
        double way3 = t3 * v3;

        double halfWay = (way1 + way2 + way3) / 2;

        double coveredWay = 0;
        double time = 0;

        if(way1 >= halfWay){
            return halfWay / v1;
        }else{
            coveredWay = way1;
            time = t1;
        }

        if(coveredWay + way2 >= halfWay){
            return time + (halfWay - coveredWay) / v2;
        }else{
            coveredWay += way2;
            time += t2;
        }

        return time + (halfWay - coveredWay) / v3;
    }

    /**
     * Простая
     * <p>
     * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
     * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
     * и 3, если угроза от обеих ладей.
     * Считать, что ладьи не могут загораживать друг друга
     */
    public static int whichRookThreatens(int kingX, int kingY, int rookX1, int rookY1, int rookX2, int rookY2) {
        boolean threatFromRook1 = (kingX == rookX1 || kingY == rookY1) ? true : false;
        boolean threatFromRook2 = (kingX == rookX2 || kingY == rookY2) ? true : false;

        if(threatFromRook1 && threatFromRook2){
            return 3;
        }else if(threatFromRook1){
            return 1;
        }else if(threatFromRook2){
            return 2;
        }

        return 0;
    }

    /**
     * Простая
     * <p>
     * На шахматной доске стоят черный король и белые ладья и слон
     * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
     * Проверить, есть ли угроза королю и если есть, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
     * и 3, если угроза есть и от ладьи и от слона.
     * Считать, что ладья и слон не могут загораживать друг друга.
     */
    public static int rookOrBishopThreatens(int kingX, int kingY, int rookX, int rookY, int bishopX, int bishopY) {
        boolean threatFromRook = (kingX == rookX || kingY == rookY);
        boolean threatFromBishop = (Math.abs(kingX-bishopX) == Math.abs(kingY-bishopY));

        if(threatFromRook && threatFromBishop){
            return 3;
        }else if(threatFromRook){
            return 1;
        }else if(threatFromBishop){
            return 2;
        }

        return 0;
    }

    /**
     * Простая
     * <p>
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    public static int triangleKind(double a, double b, double c) {
        if(a + b <= c || a + c <= b || b + c <= a){
            return -1;
        }

        double[] sides = {a ,b ,c};
        java.util.Arrays.sort(sides);

        double x2 = sides[0] * sides[0];
        double y2 = sides[1] * sides[1];
        double z2 = sides[2] * sides[2];

        if(x2 + y2 == z2){
            return 1;
        }else if(x2 + y2 < z2){
            return 2;
        }

        return 0;
    }


    /**
     * Средняя
     * <p>
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     * (Можно написать двумя способами - через switch statement или if statement
     * будет классно, если будут имплементированы оба и будет написан второй тест)
     */

    public static int segmentLengthIf(int a, int b, int c, int d) {
        if(b < c || d < a){
            return -1;
        }

        int segmentStart;
        int segmentEnd;

        if(a > c){
            segmentStart = a;
        }else{
            segmentStart = c;
        }

        if(b < d){
            segmentEnd = b;
        }else{
            segmentEnd = d;
        }

        return segmentEnd - segmentStart;
    }

    public static int segmentLength(int a, int b, int c, int d) {
        if(b < c || d < a){
            return -1;
        }

        int start = Math.max(a, c);
        int end = Math.min(b, d);

        return Math.max(0, end - start);
    }
}
