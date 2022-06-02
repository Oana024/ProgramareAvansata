package test;

public class OtherTests {
    @Test
    public void t1() {
        throw new RuntimeException("Crash");
    }

    @Test
    public static void t2(int a, int b) {
        System.out.println(Math.max(a, b) + " este mai mare decat " + Math.min(a, b));
    }

    @Test
    public void t3() {
        throw new RuntimeException("Crash");
    }

    @Test
    public void t4() {

    }

    @Test
    public void t5() {
        throw new RuntimeException("Crash");
    }
}
