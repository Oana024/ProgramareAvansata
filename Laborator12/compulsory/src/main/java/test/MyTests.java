package test;


public class MyTests {
    @Test
    public void m1() {
    }

    public void m2() {
    }

    @Test
    public void m3() {
        throw new RuntimeException("Boom");
    }

    @Test
    public void m4() {
        System.out.println("Test 4");
    }

    @Test
    public void m5() {
    }

    public void m6() {
    }

    @Test
    public void m7() {
        throw new RuntimeException("Crash");
    }

    public void m8() {
    }
}
