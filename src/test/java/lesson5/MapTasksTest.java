package lesson5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class MapTasksTest {

    @Test
    @Tag(name = "Example")
    public final void shoppingListCostTest() {
        Map itemCosts = Map.of("Хлеб", 50.0, "Молоко", 100.0);
        assertEquals(150.0, MapTasks.shoppingListCost(List.of(new String[]{"Хлеб", "Молоко"}), itemCosts));
        assertEquals(150.0, MapTasks.shoppingListCost(List.of(new String[]{"Хлеб", "Молоко", "Кефир"}), itemCosts));
        assertEquals(0.0, MapTasks.shoppingListCost(List.of(new String[]{"Хлеб", "Молоко", "Кефир"}), emptyMap()));
    }


    @Test
    @Tag(name = "Example")
    public final void removeFillerWords() {
        assertEquals(List.of("Я", "люблю", "Котлин"),
                MapTasks.removeFillerWords(List.of("Я", "как-то", "люблю", "Котлин"), new String[]{"как-то"}));
        assertEquals(List.of("Я", "люблю", "Котлин"), MapTasks.removeFillerWords(List.of("Я", "люблю", "Котлин"), new String[]{"как-то"}));
        assertEquals(List.of("Я", "люблю", "Котлин"), MapTasks.removeFillerWords(List.of("Я", "как-то", "люблю", "таки", "Котлин"),
                new String[]{"как-то", "таки"}));
    }

    @Test
    @Tag(name = "Example")
    public final void buildWordSet() {
        //Дополните тесты далее сами
        assertEquals(Set.of("Слово", "слово", "Slovo"), MapTasks.buildWordSet(List.of("Слово", "слово", "Слово", "Slovo")), "Word set for repetitive words is wrong");
        assertEquals(Set.of("Всем", "Привет", "список", "слов"), MapTasks.buildWordSet(List.of("Всем", "Привет", "список", "слов")), "Word set is wrong");
        assertEquals(Set.of("Я", "люблю", "Котлин"), MapTasks.buildWordSet(List.of("Я", "люблю", "Котлин")), "Word set is wrong");
    }

    @Test
    @Tag(name = "Normal")
    public final void mergePhoneBooks() {
        assertEquals(Map.of("Emergency", "112, 911", "Police", "02"),
                MapTasks.mergePhoneBooks(Map.of("Emergency", "112", "Police", "02"),
                        Map.of("Emergency", "911", "Police", "02")), "Phonebooks merged wrong");

        assertEquals(Map.of("Emergency", "112, 911", "Police", "02", "Fire", "112"),
                MapTasks.mergePhoneBooks(Map.of("Emergency", "112", "Police", "02", "Fire", "112"),
                        Map.of("Emergency", "911", "Police", "02")), "Phonebooks merged wrong");

        assertEquals(Map.of("Emergency", "112, 911", "Police", "02", "Ambulance", "119, 999"),
                MapTasks.mergePhoneBooks(Map.of("Emergency", "112", "Police", "02", "Ambulance", "119"),
                        Map.of("Emergency", "911", "Police", "02", "Ambulance", "999")), "Phonebooks merged wrong");
    }

    @Test
    @Tag(name = "Easy")
    public final void buildGrades() {
        Map<String, Integer> students = Map.of(
                "Василий", 5,
                "Георгий", 4,
                "Александр", 3,
                "Евгений", 2,
                "Семён", 4,
                "Сергей", 2,
                "Иван", 3,
                "Дмитрий", 5
        );

        Map<Integer, List<String>> expectedGrades = new HashMap<>(Map.of(
                5, new ArrayList<>(List.of("Василий", "Дмитрий")),
                4, new ArrayList<>(List.of("Георгий", "Семён")),
                3, new ArrayList<>(List.of("Александр", "Иван")),
                2, new ArrayList<>(List.of("Евгений", "Сергей"))
        ));

        Map<Integer, List<String>> actualGrades = MapTasks.buildGrades(students);
        assertEquals(expectedGrades.size(), actualGrades.size(), "Grades maps sizes are not equal");

        for (Integer grade : expectedGrades.keySet()) {
            Collections.sort(expectedGrades.get(grade));
            Collections.sort(actualGrades.get(grade));

            assertEquals(expectedGrades.get(grade), actualGrades.get(grade), "Grades were built wrong");
//            assertEquals(new HashSet<>(expectedGrades.get(grade)), new HashSet<>(actualGrades.get(grade)));
        }

        Map<Integer, List<String>> expectedGrades1 = new HashMap<>(Map.of(
                3, new ArrayList<>(List.of("Марат")),
                5, new ArrayList<>(List.of("Семён", "Михаил"))
        ));
        Map<Integer, List<String>> actualGrades1 = MapTasks.buildGrades(Map.of("Марат", 3, "Семён", 5, "Михаил", 5));
        assertEquals(expectedGrades1.size(), actualGrades1.size(), "Grades maps sizes are not equal");
        for (Integer grade : expectedGrades1.keySet()) {
            Collections.sort(expectedGrades1.get(grade));
            Collections.sort(actualGrades1.get(grade));

            assertEquals(expectedGrades1.get(grade), actualGrades1.get(grade), "Grades were built wrong");
        }

        assertEquals(emptyMap(), MapTasks.buildGrades(emptyMap()), "Grades were built wrong");
    }

    @Test
    @Tag(name = "Easy")
    public final void containsIn() {
        assertTrue(MapTasks.containsIn(Map.of("a", "z"), Map.of("a", "z", "b", "sweet")), "Map \"a\" is not contained in map \"b\"");
        assertTrue(MapTasks.containsIn(Map.of("a", "z", "b", "sweet", "z", "last"), Map.of("a", "z", "b", "sweet", "z", "last", "y", "me")), "Map \"a\" is not contained in map \"b\"");
        assertFalse(MapTasks.containsIn(Map.of("a", "z"), Map.of("a", "zee", "b", "sweet")), "Map \"a\" is not contained in map \"b\"");
        assertFalse(MapTasks.containsIn(Map.of("a", "z"), Map.of("b", "sweet")), "Map \"a\" is not contained in map \"b\"");
        assertFalse(MapTasks.containsIn(Map.of("a", "z", "c", "zet"), Map.of("b", "sweet")), "Map \"a\" is not contained in map \"b\"");
    }

    @Test(dataProvider = "stockPriceDataProvider")
    @Tag(name = "Normal")
    public final void averageStockPrice(Map<String, List<Double>> stockPrices, Map<String, Double> expectedAverage) {
        assertEquals(MapTasks.averageStockPrice(stockPrices), expectedAverage, "Average stock prices are counted incorrectly");
    }

    @DataProvider(name = "stockPriceDataProvider")
    public Object[][] provideStockPricesForAverage() {
        return new Object[][]{
                {
                        new HashMap<>(Map.of(
                                "MSFT", List.of(100.0, 200.0),
                                "NFLX", List.of(40.0),
                                "APPL", List.of(300.0, 500.0)
                        )),
                        new HashMap<>(Map.of(
                                "MSFT", 150.0,
                                "NFLX", 40.0,
                                "APPL", 400.0
                        ))
                },
                {
                        new HashMap<>(Map.of(
                                "GOOG", List.of(50.0, 150.0),
                                "AMZN", List.of(90.0)
                        )),
                        new HashMap<>(Map.of(
                                "GOOG", 100.0,
                                "AMZN", 90.0
                        ))
                }
        };
    }

    @Test(dataProvider = "dataForFindCheapestStuff")
    @Tag(name = "Normal")
    public final void findCheapestStuff(Map<String, Map<String, Double>> stuff, String kind, String expectedResult) {
        assertEquals(MapTasks.findCheapestStuff(stuff, kind), expectedResult, "Cheapest Stuff should be " + expectedResult);
    }

    @DataProvider(name = "dataForFindCheapestStuff")
    public static Object[][] dataForFindCheapestStuff() {
        return new Object[][]{
                {
                        Map.of(
                                "Мария", Map.of("печенье", 20.0),
                                "Орео", Map.of("печенье", 100.0),
                                "Чокопай", Map.of("кекс", 100.0),
                                "Сникерс", Map.of("шоколад", 55.0),
                                "Марс", Map.of("шоколад", 50.0)
                        ),
                        "печенье",
                        "Мария"
                },
                {
                        Map.of(
                                "Мария", Map.of("печенье", 20.0),
                                "Орео", Map.of("печенье", 100.0),
                                "Сникерс", Map.of("шоколад", 55.0),
                                "Марс", Map.of("шоколад", 50.0)
                        ),
                        "кекс",
                        null
                },
                {
                        Map.of(
                                "Мария", Map.of("печенье", 20.0),
                                "Орео", Map.of("печенье", 100.0),
                                "Сникерс", Map.of("шоколад", 55.0),
                                "Марс", Map.of("шоколад", 50.0)
                        ),
                        "шоколад",
                        "Марс"
                },
        };
    }

    @Test(dataProvider = "dataForPropagateHandshakes")
    @Tag(name = "Hard")
    public final void propagateHandshakes(Map<String, Set<String>> friends, Map<String, Set<String>> expectedResultMap) {
        assertEquals(MapTasks.propagateHandshakes(friends), expectedResultMap, "Friends list is incorrect");
    }

    @DataProvider(name = "dataForPropagateHandshakes")
    public static Object[][] dataForPropagateHandshakes() {
        return new Object[][]{
                {
                        Map.of(
                                "Marat", Set.of(),
                                "Sveta", Set.of(),
                                "Mikhail", Set.of(),
                                "Oleg", Set.of("Ivan")
                        ),
                        Map.of(
                                "Marat", Set.of(),
                                "Sveta", Set.of(),
                                "Mikhail", Set.of(),
                                "Oleg", Set.of("Ivan")
                        )
                },
                {
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta"),
                                "Sveta", Set.of("Marat"),
                                "Mikhail", Set.of("Sveta")
                        ),
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta"),
                                "Sveta", Set.of("Marat", "Mikhail"),
                                "Mikhail", Set.of("Sveta", "Marat")
                        )
                },
                {
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta", "Oleg", "Sergei"),
                                "Sveta", Set.of("Marat"),
                                "Mikhail", Set.of("Sveta", "Semen", "Ivan")
                        ),
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta", "Oleg", "Sergei", "Semen", "Ivan"),
                                "Sveta", Set.of("Marat", "Mikhail", "Oleg", "Sergei", "Semen", "Ivan"),
                                "Mikhail", Set.of("Sveta", "Marat", "Oleg", "Sergei", "Semen", "Ivan")
                        )
                },
                {
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta"),
                                "Sveta", Set.of("Marat", "Ivan"),
                                "Mikhail", Set.of("Sveta"),
                                "Ivan", Set.of("Oleg")
                        ),
                        Map.of(
                                "Marat", Set.of("Mikhail", "Sveta", "Ivan", "Oleg"),
                                "Sveta", Set.of("Marat", "Ivan", "Mikhail", "Oleg"),
                                "Mikhail", Set.of("Sveta", "Marat", "Oleg", "Ivan"),
                                "Ivan", Set.of("Oleg")
                        )
                }
        };
    }

    @Test(dataProvider = "dataForSubtractOf")
    @Tag(name = "Easy")
    public final void subtractOf(Map<String, String> mapA, Map<String, String> mapB, Map<String, String> expectedMap) {
        MapTasks.subtractOf(mapA, mapB);
        assertEquals(mapA, expectedMap, "mapB Subtracted incorrectly from mapA");
    }

    @DataProvider(name = "dataForSubtractOf")
    public static Object[][] dataForSubtractOf() {
        return new Object[][]{
                {
                        new HashMap<>(Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300"
                        )),
                        new HashMap<>(Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300"
                        )),
                        Map.of()
                },

                {
                        new HashMap<>(Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300",
                                "BA", "200",
                                "AMZN", "150",
                                "AMD", "300"
                        )),
                        Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300"
                        ),
                        Map.of(
                                "BA", "200",
                                "AMZN", "150",
                                "AMD", "300"
                        )
                },

                {
                        new HashMap<>(Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300",
                                "BA", "200",
                                "AMZN", "150",
                                "AMD", "300"
                        )),
                        Map.of(
                                "BP", "100.0",
                                "SNY", "40.0",
                                "DNA", "300"
                        ),
                        Map.of(
                                "MSFT", "100.0",
                                "NFLX", "40.0",
                                "APPL", "300",
                                "BA", "200",
                                "AMZN", "150",
                                "AMD", "300"
                        )
                },

                {
                        new HashMap<>(Map.of(
                                "NFLX", "40.0",
                                "BP", "100.0",
                                "SNY", "40.0",
                                "DNA", "300"
                        )),
                        Map.of(
                                "MSFT", "100.0",
                                "APPL", "300",
                                "BA", "200",
                                "AMZN", "150",
                                "AMD", "300",
                                "BP", "100.0",
                                "SNY", "40.0",
                                "DNA", "300"
                        ),
                        Map.of("NFLX", "40.0")
                },
        };
    }

    @Test
    @Tag(name = "Easy")
    public final void whoAreInBoth() {
        assertEquals(emptyList(), MapTasks.whoAreInBoth(emptyList(), emptyList()));
        assertEquals(List.of("Marat"),
                MapTasks.whoAreInBoth(List.of(new String[]{"Marat", "Mikhail"}), List.of(new String[]{"Marat", "Kirill"})));
        assertEquals(emptyList(),
                MapTasks.whoAreInBoth(List.of(new String[]{"Marat", "Mikhail"}), List.of(new String[]{"Sveta", "Kirill"})));
    }

    @Test
    @Tag(name = "Normal")
    public final void extractRepeats() {
        assertEquals(emptyMap(), MapTasks.extractRepeats(emptyList()));
        assertEquals(Map.of("a", 2), MapTasks.extractRepeats(List.of(new String[]{"a", "b", "a"})));
        assertEquals(emptyMap(), MapTasks.extractRepeats(List.of(new String[]{"a", "b", "c"})));
    }

    @Test
    @Tag(name = "Normal")
    public final void hasAnagrams() {
        assertFalse(MapTasks.hasAnagrams(emptyList()));
        assertTrue(MapTasks.hasAnagrams(List.of(new String[]{"рот", "свет", "тор"})));
        assertFalse(MapTasks.hasAnagrams(List.of(new String[]{"рот", "свет", "код", "дверь"})));
        assertFalse(MapTasks.hasAnagrams(List.of(new String[]{"роттт", "свет", "ттор"})));
        assertTrue(MapTasks.hasAnagrams(List.of(new String[]{"ротт", "свет", "ттор"})));
    }

    @Test
    @Tag(name = "Impossible")
    public final void bagPacking() {
    }

}
