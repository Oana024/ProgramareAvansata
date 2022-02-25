package lab1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n = n * 3;
        n = n + Integer.parseInt("10101",2);
        n = n + Integer.parseInt("FF",16);
        n = n * 6;

        int sum = n % 9;
        if(n % 9 == 0)
            sum = 9;

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
}
