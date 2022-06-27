import Weapon.Weapons;

import java.util.*;

public class Shop {

    public static void main(String[] args){
        Map<String, Weapons> assortment = ShopProgram.CreateDB();
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        while(ch != 4){
            System.out.println("------------------------------------------");
            System.out.println("_____Меню_____");
            System.out.println("1) Добавить товар");
            System.out.println("2) Посмотреть все товары");
            System.out.println("3) Редактирование");
            System.out.println("4) Выход");
            System.out.println("------------------------------------------");
            System.out.print("Выберете пункт меню: ");
            ch = scanner.nextInt();

            try {
                ch = Integer.parseInt(String.valueOf(ch));
            }catch (NumberFormatException e){
                System.out.println("Не верно выбран пункт меню");
            }

            switch (ch) {

                //метод добавления товара
                case 1 -> {
                    System.out.println("------------------------------------------");
                    System.out.println("Добавление товара");
                    while(ch != 2){
                        System.out.println("1) Добавить товар");
                        System.out.println("2) Вернуться в основное меню");
                        System.out.println("------------------------------------------");
                        ch = scanner.nextInt();

                        try {
                            ch = Integer.parseInt(String.valueOf(ch));
                        }catch (NumberFormatException e){
                            System.out.println("Не верно выбран пункт меню");
                        }
                        switch (ch) {
                            case 1 -> {
                                System.out.println("Добавление товара");
                                ShopProgram.add_To_DB(assortment);
                            }

                            case 2 -> {
                                System.out.println("Возвращаю в основное меню");
                            }
                            default -> System.out.println("Выбранный пунтк не существует");
                        }
                    }
                }

                //метод просмотра ленты товара
                case 2 -> {
                    System.out.println("------------------------------------------");
                    System.out.println("Перечень имеющихся товаров");
                    System.out.println("|       Категория       |   Наименование товара   |     Цена     |  Количество на складе  |");
                    for(Map.Entry<String, Weapons> elem :assortment.entrySet()){
                        System.out.format("|%23s|%25s|%14d|%24d|\n",elem.getKey(),elem.getValue().getTitle(),elem.getValue().getCost(),elem.getValue().getQuantity());

                    }
                }
                //Методы для редактирования товаров
                case 3 -> {
                    System.out.println("------------------------------------------");
                    System.out.println("Редактирование перечня товаров");
                    ch = 0;
                    while(ch != 3){
                        System.out.println("1) Отредактировать товар");
                        System.out.println("2) Удалить товар");
                        System.out.println("3) Вернуться в основное меню");
                        ch = scanner.nextInt();

                        try {
                            ch = Integer.parseInt(String.valueOf(ch));
                        }catch (NumberFormatException e){
                            System.out.println("Не верно выбран пункт меню");
                        }

                        switch (ch) {
                            case 1 -> {
                                System.out.println("------------------------------------------");
                                System.out.println("Редактирование товара");
                                assortment = ShopProgram.redactor(assortment);
                            }

                            case 2 -> {
                                System.out.println("------------------------------------------");
                                System.out.println("Удаление товара");
                                System.out.println("Введите категорию товара, который хотите удалить");
                                String name = scanner.nextLine();
                                assortment = ShopProgram.deleter(assortment, name);
                            }
                            case 3 -> {
                                System.out.println("------------------------------------------");
                                System.out.println("Возвращаю в основное меню");
                            }
                            default -> System.out.println("Выбранный пунтк не существует");
                        }
                    }
                }

                case 4 -> System.out.println("До свидания");
                default -> System.out.println("Выбранный пунтк не существует");
            }
        }
    }


}
