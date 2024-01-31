package MenuProduct;

import Manager.ProductManager;
import ProductIO.ProductIO;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();
    public static void menu(){


        while (true){
            System.out.println("----------Quan Ly San Pham----------");
            System.out.println("1. Xem danh sach san pham");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Tim san pham co gia dat nhat");
            System.out.println("7. Doc tu file");
            System.out.println("8. Ghi vao file");
            System.out.println("9. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    productManager.displayProduct();
                    break;
                case 2:
                    productManager.addProduct(productManager.createProduct());
                    break;
                case 3:

                    productManager.editProduct();
                    break;
                case 4:
                    productManager.removeProduct();
                    break;
                case 5:
                    sortMenu();
                    break;
                case 6:
                    System.out.println(productManager.searchExpensiveProduct());
                    break;
                case 7:
                    System.out.println("Doc file se ghi mat ca du lieu hien tai?");
                    System.out.println("Co chac chan Doc file? Y/N");
                    String inputRead = scanner.nextLine();
                    if(inputRead.equals("Y")){
                        productManager.read();
                        System.out.println("Doc file thanh cong");
                    }

                    break;
                case 8:
                    System.out.println("Ghi file se ghi mat ca du lieu hien tai?");
                    System.out.println("Co chac chan ghi file? Y/N");
                    String inputWrite = scanner.nextLine();
                    if(inputWrite.equals("Y")){
                        productManager.write();
                        System.out.println("Ghi file thanh cong");
                    }

                    break;
                case 9:
                    return;
            }
        }
    }
    public static void sortMenu(){
        System.out.println("Sap xep san pham");
        System.out.println("1. Tang dan");
        System.out.println("2. Giam dan");
        System.out.println("3. Thoat");
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice){
            case 1:
                productManager.sortIncreaseProduct();
                break;
            case 2:
                productManager.sortDecreaseProduct();
                break;
            case 3:
                return;
        }

    }
}
