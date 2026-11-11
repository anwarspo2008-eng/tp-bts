import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personne p = new personne();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            p.setAge(age);
        } catch (ageInvalideException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}

class ageInvalideException extends Exception {
    public ageInvalideException(String message) {
        super(message);
    }
}

class personne {
    private int age;
    public void setAge(int age) throws ageInvalideException {
        if (age < 0 ) {
            throw new ageInvalideException("age invalide");
        }
        else {
            System.out.println("Age valide");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}