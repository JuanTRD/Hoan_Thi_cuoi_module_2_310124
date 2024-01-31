package Validate;


import java.util.List;
import java.util.Scanner;

import Module.Product;

public class ValidateProduct {
    static Scanner scanner = new Scanner(System.in);

    public static int ValidateQuantity() {
        while (true) {
            try {

                System.out.println("Nhap so luong");
                return Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Nhap lai");
            }
        }
    }

    public static int ValidatePrice() {
        while (true) {
            try {

                System.out.println("Nhap gia");
                return Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Nhap lai");
            }
        }
    }

    public static int ValidateId(List<Product> products) {
        int idMax = 0;
        for (Product product : products) {
            if (product.getId() > idMax) {
                idMax = product.getId();
            }
        }
        return idMax + 1;
    }

    public static String ValidateName(List<Product> products) {
        while (true) {
            System.out.println("Nhap ten san pham");
            String name = scanner.nextLine();
            boolean check = true;
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    check = false;
                    break;
                }
            }
            if(check){
                return name;
            }
        }
    }
}

