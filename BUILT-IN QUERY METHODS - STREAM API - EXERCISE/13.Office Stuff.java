package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OfficeStuff {

    private static class Product {
        private int quantity;
        private String name;

        public Product(int quantity, String name) {
            this.quantity = quantity;
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s-%d", this.getName(), this.getQuantity());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Product>> companies = new TreeMap<>();

        int companiesCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < companiesCount; i++) {
            String line = input.readLine();
            String[] productInfo = line.split("\\|| - ");
            String companyName = productInfo[1];
            int productQuantity = Integer.parseInt(productInfo[2]);
            String productName = productInfo[3];
            addCompany(companies, companyName, productQuantity, productName);
        }

        printCompanies(companies);
    }

    private static void printCompanies(Map<String, List<Product>> companies) {
        StringBuilder sb = new StringBuilder();
        companies.forEach((k, p) -> {
            sb.append(String.format("%s: ", k));
            p.forEach(product -> sb.append(product.toString()).append(", "));
            sb.delete(sb.length() - 2, sb.length());
            sb.append(System.lineSeparator());
        });

        System.out.println(sb);
    }

    private static void addCompany(Map<String, List<Product>> companies, String companyName, int productQuantity, String productName) {
        companies.putIfAbsent(companyName, new ArrayList<>());
        int indexOfProduct = getProductIndex(companies.get(companyName), productName);
        if (indexOfProduct == -1) {
            companies.get(companyName).add(new Product(productQuantity, productName));
        } else {
            int currentQuantity = companies.get(companyName).get(indexOfProduct).getQuantity();
            companies.get(companyName).get(indexOfProduct).setQuantity(currentQuantity + productQuantity);
        }
    }

    private static int getProductIndex(List<Product> products, String productName) {
        int index = 0;
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return index;
            }
            index++;
        }

        return -1;
    }
}
