package lesson4;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ListsTest {
    @Test
    @Tag(name = "Example")
    public final void sqRoots() {
        assertEquals(List.of(), Lists.sqRoots(-1.0));
        assertArrayEquals(toDoubleArray(List.of(0.0)), toDoubleArray(Lists.sqRoots(0.0)), 1.0E-5);
        assertArrayEquals(toDoubleArray(List.of(new Double[]{-5.0, 5.0})), toDoubleArray(Lists.sqRoots(25.0)), 1.0E-5);
    }

    @Test
    @Tag(name = "Example")
    public final void biRoots() {
        assertEquals(List.of(), Lists.biRoots(0.0, 0.0, 1.0));
        assertEquals(List.of(), Lists.biRoots(0.0, 1.0, 2.0));
        assertArrayEquals(toDoubleArray(List.of(new Double[]{-2.0, 2.0})), toDoubleArray(Lists.biRoots(0.0, 1.0, -4.0)), 1.0E-5);
        assertEquals(List.of(), Lists.biRoots(1.0, -2.0, 4.0));
        assertArrayEquals(toDoubleArray(List.of(new Double[]{-1.0, 1.0})), toDoubleArray(Lists.biRoots(1.0, -2.0, 1.0)), 1.0E-5);
        assertEquals(List.of(), Lists.biRoots(1.0, 3.0, 2.0));
    }

    @Test
    @Tag(name = "Example")
    public final void negativeList() {
        assertEquals(List.of(), Lists.negativeList(List.of(new Integer[]{1, 2, 3})));
        assertEquals(List.of(new Integer[]{-1, -5}), Lists.negativeList(List.of(new Integer[]{-1, 2, 4, -5})));
    }

    @Test
    @Tag(name = "Example")
    public final void invertPositives() {
        List<Integer> resultList1 = Lists.invertPositives(List.of(new Integer[]{1, 2, 3}));
        assertEquals(List.of(new Integer[]{-1, -2, -3}), resultList1);
        List<Integer> resultList2 = Lists.invertPositives(List.of(new Integer[]{-1, 2, 4, -5}));
        assertEquals(List.of(new Integer[]{-1, -2, -4, -5}), resultList2);
    }

    @Test
    @Tag(name = "Example")
    public final void squares() {
        assertEquals(List.of(0), Lists.squares(List.of(0)));
        assertEquals(List.of(new Integer[]{1, 4, 9}), Lists.squares(List.of(new Integer[]{1, 2, -3})));
    }


    @Test
    @Tag(name = "Example")
    public final void isPalindrome() {
        assertFalse(Lists.isPalindrome("Барабан"));
        assertTrue(Lists.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(Lists.isPalindrome("Шалаш"));
    }

    @Test
    @Tag(name = "Example")
    public final void buildSumExample() {
        assertEquals("42 = 42", Lists.buildSumExample(List.of(42)));
        assertEquals("3 + 6 + 5 + 4 + 9 = 27", Lists.buildSumExample(List.of(new Integer[]{3, 6, 5, 4, 9})));
    }

    @Test
    @Tag(name = "Easy")
    public final void abs() {
        assertEquals(0.0, Lists.abs(List.of()), 1.0E-5);
        assertEquals(3.0, Lists.abs(List.of(3.0)), 1.0E-5);
        assertEquals(5.0, Lists.abs(List.of(new Double[]{3.0, -4.0})), 1.0E-5);
        assertEquals(8.774964, Lists.abs(List.of(new Double[]{4.0, -5.0, 6.0})), 1.0E-5);
    }

    @Test
    @Tag(name = "Easy")
    public final void mean() {
        assertEquals(0.0, Lists.mean(List.of()), 1.0E-5);
        assertEquals(1.0, Lists.mean(List.of(1.0)), 1.0E-5);
        assertEquals(2.0, Lists.mean(List.of(new Double[]{3.0, 1.0, 2.0})), 1.0E-5);
        assertEquals(3.0, Lists.mean(List.of(new Double[]{0.0, 2.0, 7.0, 8.0, -2.0})), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void center() {
        assertEquals(List.of(), Lists.center(new ArrayList<>()));
        assertArrayEquals(toDoubleArray(List.of(0.0)), toDoubleArray(Lists.center(new ArrayList<>(List.of(new Double[]{3.14})))), 1.0E-5);
        assertArrayEquals(toDoubleArray(List.of(new Double[]{1.0, -1.0, 0.0})), toDoubleArray(Lists.center(new ArrayList<>(List.of(new Double[]{3.0, 1.0, 2.0})))), 1.0E-5);
        assertArrayEquals(toDoubleArray(List.of(new Double[]{-3.0, -1.0, 4.0, 5.0, -5.0})), toDoubleArray(Lists.center(new ArrayList<>(List.of(new Double[]{0.0, 2.0, 7.0, 8.0, -2.0})))), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void times() {
        assertEquals(0.0, Lists.times(List.of(), List.of()), 1.0E-5);
        assertEquals(-5.0, Lists.times(List.of(new Double[]{1.0, -4.0}), List.of(new Double[]{3.0, 2.0})), 1.0E-5);
        assertEquals(-19.0, Lists.times(List.of(new Double[]{-1.0, 2.0, -3.0}), List.of(new Double[]{3.0, -2.0, 4.0})), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void polynom() {
        assertEquals(0.0, Lists.polynom(List.of(), 1000.0), 1.0E-5);
        assertEquals(42.0, Lists.polynom(List.of(42.0), -1000.0), 1.0E-5);
        assertEquals(13.0, Lists.polynom(List.of(new Double[]{3.0, 2.0}), 5.0), 1.0E-5);
        assertEquals(0.0, Lists.polynom(List.of(new Double[]{2.0, -3.0, 1.0}), 1.0), 1.0E-5);
        assertEquals(45.0, Lists.polynom(List.of(new Double[]{-7.0, 6.0, 4.0, -4.0, 1.0}), -2.0), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void accumulate() {
        assertEquals(List.of(), Lists.accumulate(new ArrayList()));
        assertArrayEquals(toDoubleArray(List.of(3.14)), toDoubleArray(Lists.accumulate(new ArrayList<>(List.of(3.14)))), 1.0E-5);
        assertArrayEquals(toDoubleArray(List.of(new Double[]{1.0, 3.0, 6.0, 10.0})),
                          toDoubleArray(Lists.accumulate(new ArrayList(List.of(1.0, 2.0, 3.0, 4.0)))), 1.0E-5);
    }

    @Test
    @Tag(name = "Normal")
    public final void factorize() {
        assertEquals(List.of(2), Lists.factorize(2));
        assertEquals(List.of(new Integer[]{3, 5, 5}), Lists.factorize(75));
        assertEquals(List.of(new Integer[]{2, 3, 3, 19}), Lists.factorize(342));
    }

    @Test
    @Tag(name = "Hard")
    public final void factorizeToString() {
        assertEquals("2", Lists.factorizeToString(2));
        assertEquals("3*5*5", Lists.factorizeToString(75));
        assertEquals("2*3*3*19", Lists.factorizeToString(342));
        assertEquals("7*7*31*31*151*151", Lists.factorizeToString(1073676289));
        assertEquals("1073676287", Lists.factorizeToString(1073676287));
        assertEquals(String.valueOf(Integer.MAX_VALUE), Lists.factorizeToString(Integer.MAX_VALUE));
    }

    @Test
    @Tag(name = "Normal")
    public final void convert() {
        assertEquals(List.of(1), Lists.convert(1, 2));
        assertEquals(List.of(new Integer[]{1, 2, 1, 0}), Lists.convert(100, 4));
        assertEquals(List.of(new Integer[]{1, 3, 12}), Lists.convert(250, 14));
        assertEquals(List.of(new Integer[]{2, 14, 12}), Lists.convert(1000, 19));
    }

    @Test
    @Tag(name = "Hard")
    public final void convertToString() {
        assertEquals("1", Lists.convertToString(1, 2));
        assertEquals("1210", Lists.convertToString(100, 4));
        assertEquals("13c", Lists.convertToString(250, 14));
        assertEquals("2ec", Lists.convertToString(1000, 19));
        assertEquals("z", Lists.convertToString(35, 36));
        assertEquals("a02220281", Lists.convertToString(Integer.MAX_VALUE, 11));
    }

    @Test
    @Tag(name = "Normal")
    public final void decimal() {
        assertEquals(1, Lists.decimal(List.of(1), 2));
        assertEquals(100, Lists.decimal(List.of(new Integer[]{1, 2, 1, 0}), 4));
        assertEquals(250, Lists.decimal(List.of(new Integer[]{1, 3, 12}), 14));
        assertEquals(1000, Lists.decimal(List.of(new Integer[]{2, 14, 12}), 19));
    }

    @Test
    @Tag(name = "Hard")
    public final void decimalFromString() {
        assertEquals(1, Lists.decimalFromString("1", 2));
        assertEquals(100, Lists.decimalFromString("1210", 4));
        assertEquals(250, Lists.decimalFromString("13c", 14));
        assertEquals(1000, Lists.decimalFromString("2ec", 19));
        assertEquals(35, Lists.decimalFromString("z", 36));
        assertEquals(Integer.MAX_VALUE, Lists.decimalFromString("a02220281", 11));
    }

    @Test
    @Tag(name = "Hard")
    public final void roman() {
        assertEquals("I", Lists.roman(1));
        assertEquals("MMM", Lists.roman(3000));
        assertEquals("MCMLXXVIII", Lists.roman(1978));
        assertEquals("DCXCIV", Lists.roman(694));
        assertEquals("XLIX", Lists.roman(49));
    }

    @Test
    @Tag(name = "Impossible")
    public final void russian() {
        assertEquals("триста семьдесят пять", Lists.russian(375));
        assertEquals("девятьсот девяносто три тысячи девятьсот двенадцать", Lists.russian(993912));
        assertEquals("сто десять тысяч шестьсот восемьдесят", Lists.russian(110680));
        assertEquals("девятьсот сорок тысяч сто десять", Lists.russian(940110));
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", Lists.russian(22964));
        assertEquals("сто девятнадцать тысяч пятьсот восемь", Lists.russian(119508));
        assertEquals("две тысячи три", Lists.russian(2003));
        assertEquals("двести тысяч два", Lists.russian(200002));
        assertEquals("девятьсот тысяч", Lists.russian(900000));
        assertEquals("сто двадцать тысяч двадцать три", Lists.russian(120023));
        assertEquals("двенадцать", Lists.russian(12));
        assertEquals("двенадцать тысяч", Lists.russian(12000));
        assertEquals("двадцать", Lists.russian(20));
        assertEquals("сто двадцать", Lists.russian(120));
        assertEquals("сто тысяч сто двадцать пять", Lists.russian(100125));
    }

    public static double[] toDoubleArray(List<Double> values) {
        double ret[] = new double[values.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = values.get(i);
        return ret;
    }
}
