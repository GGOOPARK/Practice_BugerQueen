package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.product.product.Product;
import com.parkGu.seb.burgerqueen.product.product.ProductRepository;
import com.parkGu.seb.burgerqueen.product.product.subproduct.BurgerSet;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Drink;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Hamburger;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Side;

import java.util.Arrays;
import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);
    private ProductRepository productRepository;
    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void printCart() {
        System.out.println("장바구니에 담겨 있는 물품");
        System.out.println("-".repeat(45));
        printCartItemDetails();
        System.out.println("-".repeat(45));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가시려면 Enter를 눌러주세요.");
        scanner.nextLine();
    }

    private void printCartItemDetails() {

        for (Product product : items) {
            if (product instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) product; // 참조변수 다운캐스팅
                System.out.printf(
                        " %s 가격:%6d원 음료:%s(빨대 %s), 사이드: %s(케첩 %d개))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음",
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup()
                );
            } else if (product instanceof Hamburger) {
                System.out.printf(
                        " %-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice()
                );
            } else if (product instanceof Side) {
                System.out.printf(
                        "  %-8s %6d원 (케첩 %d개) \n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup() // 참조변수 다운캐스팅
                );
            } else if (product instanceof Drink) {
                System.out.printf(
                        " %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음" // 참조변수 다운캐스팅은 ()반드시 명시
                );
            }
        }
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addToCart(int productId) {
        Product product = productRepository.findById(productId);
        chooseOption(product);

        if (product instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) product;
            if (hamburger.isBurgerSet()) product = composeSet(hamburger);
        }

        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = product;
        items = newItems;

        System.out.printf("[담기성공] %s가 장바구니에 담겼습니다.\n", product.getName());
    }

    private void chooseOption(Product product) {
        String input;

        if (product instanceof Hamburger) {
            System.out.printf(
                    "단품/세트 옵션을 선택해주세요. (1)단품(%d원) (2)세트(%d원)\n",
                    product.getPrice(),
                    ((Hamburger) product).getBurgerSetPrice()
            );
            input = scanner.nextLine();
            if (input.equals(("2"))) ((Hamburger) product).setIsBurgerSet(true);
        } else if (product instanceof Drink) {
            System.out.println("빨대 유무를 선택해주세요. (1)빨대 포함 (2)빨대 미포함");
            input = scanner.nextLine();
            if (input.equals("2")) ((Drink) product).setHaaStraw(false);
        } else if (product instanceof Side) {
            System.out.println("케첩 갯수를 선택해주세요. (최대 3개)");
            input = scanner.nextLine();
            if (Integer.parseInt(input) > 3) input = "3";
            ((Side) product).setKetchup(Integer.parseInt(input));
        }
    }

    private BurgerSet composeSet(Hamburger hamburger) {
        System.out.println("음료 메뉴를 선택해주세요");
        menu.printDrinks(false);

        String drinkId = scanner.nextLine();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(drinkId));
        chooseOption(drink);


        System.out.println("사이드 메뉴를 선택해주세요.");
        menu.printSides(false);

        String sideId = scanner.nextLine();
        Side side = (Side) productRepository.findById(Integer.parseInt(sideId));
        chooseOption(side);

        String name = hamburger.getName() + "세트";
        int price = hamburger.getBurgerSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name, price, kcal,hamburger, side, drink);
    }
}
