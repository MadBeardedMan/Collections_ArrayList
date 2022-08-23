import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static ArrayList<String> productList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать в список покупок. Пожалуйста, выберите интересующее вас действие. " +
                    "Для выхода наберите end.");
            System.out.println("1. Добавить" + "\n" + "2. Показать" + "\n" + "3. Удалить" + "\n" + "4. Найти");
            String input = scanner.nextLine();
            try {
                if ("end".equals(input)) {
                    System.out.println("Программа завершена!");
                    scanner.close();
                    break;
                }
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите название продукта:");
                        input = scanner.nextLine();
                        productAdd(input);
                        break;
                    case 2:
                        productShow();
                        break;
                    case 3:
                        System.out.println("Список продкутов:");
                        productShow();
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        input = scanner.nextLine();
                        productDelete(input);
                        break;
                    case 4:
                        System.out.println("Введите текст для поиска:");
                        input = scanner.nextLine();
                        productFind(input);
                        break;
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Вы ввели неправильное число. Пожалуйста сделайте выбор снова.");
                continue;
            }
        }
        scanner.close();
    }

    public static void productAdd(String input) {
        productList.add(input);
        System.out.println("Итого в списке покупок: " + productList.size());
    }

    public static void productShow() {
        System.out.println("Список продуктов:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public static void productDelete(String input) {
        try {
            productList.remove(Integer.parseInt(input) - 1);
        } catch (NumberFormatException e) {
            productList.remove(input);
        }
        productShow();
    }

    public static void productFind(String input) {
        System.out.println("Найдено:");
        input = input.toLowerCase();
        int y = 0;
        for (int i = 0; i < productList.size(); i++) {
            String p = productList.get(i).toLowerCase();
            if (p.contains(input)) {
                System.out.println(i + 1 + ". " + productList.get(i));
                y++;
            }
        }
        if (y == 0) {
            System.out.println("По введенному ключевому слову в списке ничего нет.");
        }
    }
}