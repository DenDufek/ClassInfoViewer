import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfoViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть повне ім'я класу (наприклад, java.lang.String):");
        String className = scanner.nextLine();

        try {
            Class<?> selectedClass = Class.forName(className);
            printClassInfo(selectedClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Клас не знайдено. Перевірте правильність імені класу.");
        }
    }

    private static void printClassInfo(Class<?> clazz) {
        System.out.println("Інформація про клас: " + clazz.getName());

        System.out.println("\nПоля класу:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + field.getType().getName() + " " + field.getName());
        }

        System.out.println("\nМетоди класу:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("  " + method.getReturnType().getName() + " " + method.getName());
        }
    }
}
