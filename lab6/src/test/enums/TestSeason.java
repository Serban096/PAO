package src.test.enums;

import src.enums.Season;

public class TestSeason {
    public static void main(String[] args) {
        Season winter = Season.WINTER;
        System.out.println(winter.name());
        winter.printExpectedVisitors();
    }
}
