package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, 2021));
        assertTrue(Date.isValidDate(29, 2, 2020)); // Leap year
        assertFalse(Date.isValidDate(29, 2, 2021)); // Not a leap year
        assertFalse(Date.isValidDate(31, 4, 2021)); // April has 30 days
        assertFalse(Date.isValidDate(0, 1, 2021)); // Day is 0
        assertFalse(Date.isValidDate(1, 0, 2021)); // Month is 0
        assertFalse(Date.isValidDate(1, 13, 2021)); // Month is 13
        assertFalse(Date.isValidDate(1, 1, 0)); // Year is 0
    }

    @Test
    void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(2021));
        assertTrue(Date.isLeapYear(2000)); // Divisible by 400
        assertFalse(Date.isLeapYear(1900)); // Divisible by 100 but not by 400
    }

    @Test
    void testNextDate() {
        Date date = new Date(31, 12, 2021);
        Date nextDate = date.nextDate();
        assertEquals(new Date(1, 1, 2022), nextDate);

        date = new Date(31, 1, 2021);
        nextDate = date.nextDate();
        assertEquals(new Date(1, 2, 2021), nextDate);

        date = new Date(28, 2, 2020); // Leap year
        nextDate = date.nextDate();
        assertEquals(new Date(29, 2, 2020), nextDate);
    }

    @Test
    void testPreviousDate() {
        Date date = new Date(1, 1, 2022);
        Date previousDate = date.previousDate();
        assertEquals(new Date(31, 12, 2021), previousDate);

        date = new Date(1, 2, 2021);
        previousDate = date.previousDate();
        assertEquals(new Date(31, 1, 2021), previousDate);

        date = new Date(1, 3, 2020); // Leap year
        previousDate = date.previousDate();
        assertEquals(new Date(29, 2, 2020), previousDate);
    }

    @Test
    void testCompareTo() {
        Date date1 = new Date(1, 1, 2021);
        Date date2 = new Date(1, 1, 2022);
        Date date3 = new Date(1, 1, 2021);

        assertTrue(date1.compareTo(date2) < 0);
        assertTrue(date2.compareTo(date1) > 0);
        assertEquals(0, date1.compareTo(date3));

        assertThrows(NullPointerException.class, () -> date1.compareTo(null));
    }
}
