import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***Temperature Converter***");

        float v = 0;
        boolean vt = false;
        System.out.print("\n1. Celsius\n2. Fahrenheit\n3. Kelvin\nEnter the unit of the temperature: ");
        int fm = sc.nextInt();

        while (!vt) {
            try {
                System.out.print("\nEnter the temperature value: ");
                v = sc.nextFloat();
                vt = true;
            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid temperature value.");
                sc.nextLine();
            }
        }

        System.out.print("\n1. Celsius\n2. Fahrenheit\n3. Kelvin\nEnter the unit to convert: ");
        int ut = sc.nextInt();
        String[] u = {"CELSIUS", "FAHRENHEIT", "KELVIN"};
        float s = convertTemperature(v, u[fm - 1], u[ut - 1]);
        System.out.println("\nCONVERTED TEMPERATURE: " + s + " " + u[ut - 1]);
        sc.close();
    }

    public static float convertTemperature(float v, String fm, String ut) {
        float r = 0;

        if (fm.equalsIgnoreCase("Celsius") && ut.equalsIgnoreCase("Fahrenheit")) {
            r = (v * 9 / 5) + 32;
        } else if (fm.equalsIgnoreCase("Celsius") && ut.equalsIgnoreCase("Kelvin")) {
            r = v + 273.15f;
        } else if (fm.equalsIgnoreCase("Fahrenheit") && ut.equalsIgnoreCase("Celsius")) {
            r = (v - 32) * 5 / 9;
        } else if (fm.equalsIgnoreCase("Fahrenheit") && ut.equalsIgnoreCase("Kelvin")) {
            r = (v - 32) * 5 / 9 + 273.15f;
        } else if (fm.equalsIgnoreCase("Kelvin") && ut.equalsIgnoreCase("Celsius")) {
            r = v - 273.15f;
        } else if (fm.equalsIgnoreCase("Kelvin") && ut.equalsIgnoreCase("Fahrenheit")) {
            r = (v - 273.15f) * 9 / 5 + 32;
        } else if (fm.equalsIgnoreCase(ut)) {
            r = v;
        } else {
            System.out.println("Invalid temperature units!");
            System.exit(1);
        }

        return r;
    }
}