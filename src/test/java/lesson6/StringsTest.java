package lesson6;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.lang.reflect.Executable;
import java.util.List;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class StringsTest {

    @Test
    @Tag(name = "Example")
    public final void timeStrToSeconds() {
        assertEquals(36000, Strings.timeStrToSeconds("10:00:00"));
        assertEquals(41685, Strings.timeStrToSeconds("11:34:45"));
        assertEquals(86399, Strings.timeStrToSeconds("23:59:59"));
    }

    @Test
    @Tag(name = "Example")
    public final void twoDigitStr() {
        assertEquals("00", Strings.twoDigitStr(0));
        assertEquals("09", Strings.twoDigitStr(9));
        assertEquals("10", Strings.twoDigitStr(10));
        assertEquals("99", Strings.twoDigitStr(99));
    }

    @Test
    @Tag(name = "Example")
    public final void timeSecondsToStr() {
        assertEquals("10:00:00", Strings.timeSecondsToStr(36000));
        assertEquals("11:34:45", Strings.timeSecondsToStr(41685));
        assertEquals("23:59:59", Strings.timeSecondsToStr(86399));
    }

    @Test
    @Tag(name = "Normal")
    public final void dateStrToDigit() {
        assertEquals("15.07.2016", Strings.dateStrToDigit("15 июля 2016"));
        assertEquals("", Strings.dateStrToDigit("29 февраля 0"));
        assertEquals("02.12.2", Strings.dateStrToDigit("02 декабря 2"));
        assertEquals("", Strings.dateStrToDigit("30 февраля 2009"));
        assertEquals("", Strings.dateStrToDigit("3 мартобря 1918"));
        assertEquals("", Strings.dateStrToDigit(">J.X6?*qg{b*/;N\\\\\\t[P|hgyM[/Y7kTU}+Fd.`pg):fNWN 32>\\\"'.$Mn&>#|)dOqXS;4I$2s\\n*n<yz~NsgC*xWP'p~rbGl|=)qiyX>U(lK,s>Lu8x}lu%{{+u)j's8Zie1\\n{de~Yik{1[FuZHM!qU_9.<`%I0/T(, .>I/7?Nt;\\\\UCb;MJbD*WWDqCx0NvXq,'6m^-W^H[\\\"ZS4-D~(8n~PCxCk1pHt'N##dfOC\\\"F-3Bm8U}n0\\\\:tJrC"));
        assertEquals("18.11.2018", Strings.dateStrToDigit("18 ноября 2018"));
        assertEquals("", Strings.dateStrToDigit("23"));
        assertEquals("03.04.2011", Strings.dateStrToDigit("3 апреля 2011"));
        assertEquals("", Strings.dateStrToDigit("32 сентября 2011"));
        assertEquals("", Strings.dateStrToDigit("32 сентября 2011"));
        assertEquals("", Strings.dateStrToDigit("29 февраля 1993"));
        assertEquals("02.12.2", Strings.dateStrToDigit("02 декабря 2"));
    }

    @Test
    @Tag(name = "Normal")
    public final void dateDigitToStr() {
        assertEquals("", Strings.dateDigitToStr("28.солнечного.1976"));
        assertEquals("", Strings.dateDigitToStr(" })icjEAF~+.?*+O XNewOx,avkI5MtI4;P\\nv1h;S1Lr+PF/cyQBA@z/`S).u~HaPNN7us[\\nO LSmHZ!YfZq?GtINX[~NVC0|wK}76V.^Tks*1Jw3`3U\\t.yh-/j\\nS\\n=y<!E^FcD$\\\\ As}s\\nb>(W\\\\d/-U5iXLsR\\\"\\nWv\\\\s6ksy!l_M<tr@l^0'/kz26\\tQcZJz| qW\\t^7i!/zKxS{optP+"));
        assertEquals("15 июля 2016", Strings.dateDigitToStr("15.07.2016"));
        assertEquals("", Strings.dateDigitToStr("01.02.20.19"));
        assertEquals("", Strings.dateDigitToStr("28.00.2000"));
        assertEquals("3 апреля 2011", Strings.dateDigitToStr("03.04.2011"));
        assertEquals("", Strings.dateDigitToStr("ab.cd.ef"));
        assertEquals("", Strings.dateDigitToStr("32.09.2011"));
        assertEquals("", Strings.dateDigitToStr("29.02.1993"));
        assertEquals("", Strings.dateDigitToStr("UH2p1\\\"`^/Z)}_9o`9.T/PR7tCMwgtT\\tqCe+?f$;h8_nPgC:_D3sIm77^;`>k(>DAxhv%,2DHk\\\\w[B*$y&fmf&pmlK\\tF E7,dkzLdb1,%ykownLh}['OP+md$(9K%v &\\\""));
    }

    @Test
    @Tag(name = "Normal")
    public final void flattenPhoneNumber() {
        assertEquals("+79211234567", Strings.flattenPhoneNumber("+7 (921) 123-45-67"));
        assertEquals("123456798", Strings.flattenPhoneNumber("12 --  34- 5 -- 67 -98"));
        assertEquals("", Strings.flattenPhoneNumber("ab-123"));
        assertEquals("", Strings.flattenPhoneNumber("+5 )24( 324"));
        assertEquals("+12345", Strings.flattenPhoneNumber("+12 (3) 4-5"));
        assertEquals("+12345", Strings.flattenPhoneNumber("+12 (3 4-5"));
        assertEquals("", Strings.flattenPhoneNumber("134_+874"));
        assertEquals("", Strings.flattenPhoneNumber("+7+)("));
        assertEquals("", Strings.flattenPhoneNumber("+"));
    }

    @Test
    @Tag(name = "Normal")
    public final void bestLongJump() {
        assertEquals(717, Strings.bestLongJump("706 % - 717 - 703"));
        assertEquals(-1, Strings.bestLongJump("% - - % -"));
        assertEquals(754, Strings.bestLongJump("700 717 707 % 754"));
        assertEquals(-1, Strings.bestLongJump("700 + 700"));
    }

    @Test
    @Tag(name = "Hard")
    public final void bestHighJump() {
        assertEquals(226, Strings.bestHighJump("226 +"));
        assertEquals(-1, Strings.bestHighJump("???"));
        assertEquals(230, Strings.bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"));
    }

    @Test
    @Tag(name = "Hard")
    public final void plusMinus() {
        assertEquals(0, Strings.plusMinus("0"));
        assertEquals(4, Strings.plusMinus("2 + 2"));
        assertEquals(6, Strings.plusMinus("2 + 31 - 40 + 13"));
        assertEquals(-7, Strings.plusMinus("2 + 31 - 40"));
        assertEquals(-1, Strings.plusMinus("0 - 1"));
        assertEquals(4, Strings.plusMinus("4"));
        assertThrows(IllegalArgumentException.class, null);
        
    }

    @Test
    @Tag(name = "Hard")
    public final void firstDuplicateIndex() {
        assertEquals(-1, Strings.firstDuplicateIndex("Привет"));
        assertEquals(9, Strings.firstDuplicateIndex("Он пошёл в в школу"));
        assertEquals(40, Strings.firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"));
        assertEquals(9, Strings.firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"));
    }

    @Test
    @Tag(name = "Hard")
    public final void mostExpensive() {
        assertEquals("", Strings.mostExpensive(""));
        assertEquals("", Strings.mostExpensive("Хлеб 0.0пукр9; Молоко 62.5; Курица 184.0; Конфеты 89.9"));
        assertEquals("Курица", Strings.mostExpensive("Хлеб 0.09; Молоко 62.5; Курица 184.0; Конфеты 89.9"));
        assertEquals("Курица", Strings.mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"));
        assertEquals("Курица", Strings.mostExpensive("Хлеб 39.9; Молоко 35; Курица 184.0; Конфеты 89.9"));
        assertEquals("Вино", Strings.mostExpensive("Вино 255.0"));
    }

    @Test
    @Tag(name = "Hard")
    public final void fromRoman() {
        assertEquals(1, Strings.fromRoman("I"));
        assertEquals(3000, Strings.fromRoman("MMM"));
        assertEquals(1978, Strings.fromRoman("MCMLXXVIII"));
        assertEquals(694, Strings.fromRoman("DCXCIV"));
        assertEquals(49, Strings.fromRoman("XLIX"));
        assertEquals(-1, Strings.fromRoman("Z"));
        assertEquals(-1, Strings.fromRoman("IVI"));
        assertEquals(-1, Strings.fromRoman("VVV"));
        assertEquals(-1, Strings.fromRoman("CCCCCC"));
    }

    @Test
    @Tag(name = "Impossible")
    public final void computeDeviceCells() {
        assertEquals(List.of(new Integer[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}), Strings.computeDeviceCells(10, "+>+>+>+>+", 10000));
        assertEquals(List.of(new Integer[]{-1, -1, -1, -1, -1, 0, 0, 0, 0, 0}), Strings.computeDeviceCells(10, "<-<-<-<-<-", 10000));
        assertEquals(List.of(new Integer[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0}), Strings.computeDeviceCells(10, "- <<<<< +[>+]", 10000));
        assertEquals(List.of(new Integer[]{0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0}), Strings.computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000));
        assertEquals(List.of(new Integer[]{0, 0, 0, 0, 0, 1, 1, 0, 0, 0}), Strings.computeDeviceCells(10, "+>+>+>+>+", 4));
        assertEquals(List.of(new Integer[]{0, 0, -1, -1, -1, 0, 0, 0, 0, 0}), Strings.computeDeviceCells(10, "<-<-<-<-<-", 6));
        assertEquals(List.of(new Integer[]{1, 1, 1, 0, 0, -1, 0, 0, 0, 0}), Strings.computeDeviceCells(10, "- <<<<< +[>+]", 17));
        assertEquals(List.of(new Integer[]{0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2}), Strings.computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256));
        assertThrows(IllegalArgumentException.class, null);
        assertThrows(IllegalArgumentException.class, null);
        assertThrows(IllegalStateException.class, null);
    }
}
