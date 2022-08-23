import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static ArrayList<String> productList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("����� ���������� � ������ �������. ����������, �������� ������������ ��� ��������. " +
                    "��� ������ �������� end.");
            System.out.println("1. ��������" + "\n" + "2. ��������" + "\n" + "3. �������" + "\n" + "4. �����");
            String input = scanner.nextLine();
            try {
                if ("end".equals(input)) {
                    System.out.println("��������� ���������!");
                    scanner.close();
                    break;
                }
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("������� �������� ��������:");
                        input = scanner.nextLine();
                        productAdd(input);
                        break;
                    case 2:
                        productShow();
                        break;
                    case 3:
                        System.out.println("������ ���������:");
                        productShow();
                        System.out.println("����� ������ �������? ������� ����� ��� ��������");
                        input = scanner.nextLine();
                        productDelete(input);
                        break;
                    case 4:
                        System.out.println("������� ����� ��� ������:");
                        input = scanner.nextLine();
                        productFind(input);
                        break;
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("�� ����� ������������ �����. ���������� �������� ����� �����.");
                continue;
            }
        }
        scanner.close();
    }

    public static void productAdd(String input) {
        productList.add(input);
        System.out.println("����� � ������ �������: " + productList.size());
    }

    public static void productShow() {
        System.out.println("������ ���������:");
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
        System.out.println("�������:");
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
            System.out.println("�� ���������� ��������� ����� � ������ ������ ���.");
        }
    }
}