import java.util.Scanner;

class EEC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long P, G, x, a, y, b, ka, kb;

        System.out.print("Enter a prime number P: ");
        P = sc.nextLong();
        System.out.println("The value of P: " + P);

        System.out.print("Enter a primitive root for P (G): ");
        G = sc.nextLong();
        System.out.println("The value of G: " + G);

        System.out.print("Enter the private key for Alice (a): ");
        a = sc.nextLong();
        System.out.println("The private key a for Alice: " + a);

        x = power(G, a, P);

        System.out.print("Enter the private key for Bob (b): ");
        b = sc.nextLong();
        System.out.println("The private key b for Bob: " + b);

        y = power(G, b, P);

        ka = power(y, a, P);
        kb = power(x, b, P);

        System.out.println("Secret key for Alice: " + ka);
        System.out.println("Secret key for Bob: " + kb);
    }

    private static long power(long a, long b, long p) {
        if (b == 1)
            return a;
        else
            return ((long) Math.pow(a, b) % p);
    }
}
