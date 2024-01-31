package Manager;

import Module.Product;
import Validate.ValidateProduct;
import ProductIO.ProductIO;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    List<Product> products = new ArrayList<Product>();
    Scanner scanner = new Scanner(System.in);
    public void write(){

        ProductIO.write(products);

    }
    public void read(){

        products = ProductIO.read();

    }

    public int size() {
        return products.size();
    }

    public void displayProduct() {
            int pageSize = 5;
            int currentPage = 1;
            int start = 0;
            int end;
            while (true) {
                System.out.println("2. Them moi");
                System.out.println("ID, Tên, Giá, Số lượng, Mô tả");
                end = Math.min(start + pageSize, products.size());

                for (int i = start; i < end; i++) {
                    System.out.println(products.get(i));
                }
                System.out.println("Nhấn Enter để xem trang tiếp ");
                String input = scanner.nextLine();

                if (!input.isEmpty()) {
                    break;
                }
                currentPage++;
                start = pageSize * (currentPage - 1);
                if (start >= products.size()) {
                    break;
                }
            }
        }


    public void addProduct(Product product) {

        products.add(product);
        System.out.println("Thanh cong them san pham");
    }

    public Product createProduct() {

        int id = ValidateProduct.ValidateId(products);

        String name = ValidateProduct.ValidateName(products);

        int price = ValidateProduct.ValidatePrice();

        int quantity = ValidateProduct.ValidateQuantity();
        System.out.println("Nhap mo ta");
        String description = scanner.nextLine();
        return new Product(id, name, price, quantity, description);


    }


    public void editProduct() {
        try{
            while (true){
                System.out.println("Nhap id muon sua");
                String id = scanner.nextLine();
                if (id.isEmpty()){
                    return;
                }
                int index = getIndexById(Integer.parseInt(id));
                if(index!=-1){
                    products.set(index,createProduct());
                    System.out.println("Them thanh cong");
                    write();
                    return;
                } else {
                    System.out.println("Khong tim duoc san pham voi ma san pham tren");
                }
            }

        }catch(Exception e){
            System.out.println("Nhap lai");
        }


        }

    public int getIndexById(int id){
        for (int i = 0; i <size(); i++){
            if(products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void removeProduct(){

            try{
                while (true) {
                    System.out.println("Nhap id muon xoa");
                    String id = scanner.nextLine();
                    if(id.isEmpty()){
                        return;
                    }
                    int index = getIndexById(Integer.parseInt(id));
                    if(index!=-1){
                        System.out.println("Co chac chan muon xoa? Y/N?");
                        String choice = scanner.nextLine();
                        if(choice.equals("Y")){
                            products.remove(index);
                            System.out.println("Xoa thanh cong");
                            return;
                        } else {
                            return;
                        }

                    } else {
                        System.out.println("Khong tim duoc san pham voi ma san pham tren");
                        System.out.println("Nhap lai");
                    }
                }

            }catch(Exception e){
                System.out.println("Nhap lai");
            }


    }
    public void sortDecreaseProduct(){

        for(int i=0; i<products.size(); i++){
            for (int j=0; j<products.size()-i-1; j++){
                if(products.get(j).getPrice() < products.get(j+1).getPrice()){
                    Product temp = products.get(j);
                    products.set(j, products.get(j+1));
                    products.set(j+1, temp);
                }
            }

        }
    }
    public void sortIncreaseProduct(){

        for(int i=0; i<products.size(); i++){
            for (int j=0; j<products.size()-i-1; j++){
                if(products.get(j).getPrice() > products.get(j+1).getPrice()){
                    Product temp = products.get(j);
                    products.set(j, products.get(j+1));
                    products.set(j+1, temp);
                }
            }

        }
    }
    public Product searchExpensiveProduct(){
        Product maxPrice = products.get(0);
        for(int i = 1; i < products.size(); i++){
            if(products.get(i).getPrice()>maxPrice.getPrice()){
                maxPrice = products.get(i);
            }
        }
        return maxPrice;

    }


}

