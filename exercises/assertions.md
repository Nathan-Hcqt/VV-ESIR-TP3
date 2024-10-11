# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion fails due to inaccuracies related to floating-point numbers (double). In Java (and many other languages), operations with floating-point numbers are not always exact because of how these numbers are represented in memory. The calculated value of 3 * 0.4 is not exactly 1.2 in memory.

Correct code:

double result = 3 * 0.4;
double expected = 1.2;
double epsilon = 0.000001;
assertTrue(Math.abs(result - expected) < epsilon);

2. AssertEquals(Object expected, Object actual) verifies that two objects are equal according to their equals() method. This assertion compares the values or content of the objects. AssertSame(Object expected, Object actual) verifies that two objects are the same instance, meaning they point to the same address in memory.

Scenarios where they produce the same result: If the two objects compared are exactly the same instance (identical references), then both assertEquals and assertSame will succeed.


String str1 = "Test";
String str2 = str1;  // str2 is the same instance as str1
assertEquals(str1, str2);  // Checks value equality
assertSame(str1, str2);    // Checks if it's the same instance
Scenarios where they produce different results: If two objects have equal values but are different instances, assertEquals will succeed while assertSame will fail.

String str1 = new String("Test");
String str2 = new String("Test");
assertEquals(str1, str2);  // Checks value equality
assertSame(str1, str2);    // Fails because str1 and str2 are not the same instance

3. fail can be used to explicitly mark a failure in the case where an unexpected condition occurs or to indicate that a test did not complete correctly. It can also be used to indicate that certain code branches should never be reached.

Use Case 1: Conditional Test When multiple conditions need to be checked in a test, and no valid condition is met, fail can be used to explicitly indicate that an error has occurred.

public void testCondition() {
    int value = getValueFromService();
    if (value > 0) {
        // Do something
    } else if (value < 0) {
        // Do something else
    } else {
        fail("The value should not be zero!");
    }
}

4. The assertThrows method in JUnit 5 offers several advantages over the JUnit 4 approach with @Test(expected):

Advantages of assertThrows:

More precise control: With assertThrows, you can test not only the type of the exception but also check additional conditions after the exception is thrown. For example, you can analyze the exception's error message.
More limited test scope: In JUnit 4, the exception could be thrown at any point in the test method, which could lead to less precise tests. With assertThrows, the exception must be thrown specifically in a block of code, ensuring that only the part of the code you want to test is involved.
Improved readability: assertThrows is more explicit and makes the test more readable. It clearly shows which part of the code is expected to throw the exception.

@Test
void testDivisionByZero() {
    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
        int result = 10 / 0;
    });
    assertEquals("/ by zero", exception.getMessage());
}





