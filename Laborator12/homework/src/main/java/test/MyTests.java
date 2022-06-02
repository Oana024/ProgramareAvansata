package test;


public class MyTests {
    private int x;
    @Test
    public void m1(int a, int b) {
        System.out.println("a = " + a + " | b = " + b + " | sum: " + (a+b));
    }

    public void m2(float c) {
    }

    @Test
    public void m3() {
        throw new RuntimeException("Boom");
    }

    @Test
    public static void m4(String s) {
        System.out.println("My String is " + s);
    }

    @Test
    public void m5() {
        System.out.println("Test 5");
    }

    private void m6(int a) {
    }

    @Test
    public void m7() {
        throw new RuntimeException("Crash");
    }

    public void m8() {
    }
}
