import Weapon.Weapons;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopProgram {
    public static Map CreateDB(){

        Map<String, Weapons> temp = new HashMap<>();

        temp.put("Сумка",new Weapons("Сумочка женская", 500, 10));
        temp.put("Баресетка",new Weapons("Барсетка", 200, 15));
        temp.put("Рюкзаки",new Weapons("Рюкзак походный", 300, 5));
        temp.put("Сумка на выход",new Weapons("Shoper", 700, 20));

        temp.put("Туфли",new Weapons("Туфли", 450, 10));
        temp.put("Кеды",new Weapons("Кеды Nike", 250, 7));
        temp.put("Тапки",new Weapons("Шлепанцы", 50, 30));


        return temp;
    }

    public static void add_To_DB(Map<String,Weapons> assortment){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите категорию товара");
            String category = scanner.nextLine();

            System.out.println("Введите наименование товара");
            String namesProduct = scanner.nextLine();

            System.out.println("Введите цену товара");
            int cost = scanner.nextInt();

            System.out.println("Введите количество товара");
            int quantityProduct = scanner.nextInt();

            assortment.put(category, new Weapons(namesProduct, cost, quantityProduct));
        } catch (Exception e) {
            System.out.println("Товар не добавлен" + e);
        }
    }

    public static Map redactor(Map<String,Weapons> temp){
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        while(ch != 5) {
            System.out.println("------------------------------------------");
            System.out.println("Какой пункт хотите отредактировать?");
            System.out.println("1) Категория");
            System.out.println("2) Наименование товара");
            System.out.println("3) Цена");
            System.out.println("4) Количество");
            System.out.println("5) Выход");
            System.out.println("------------------------------------------");
            System.out.print("Выберете пункт меню: ");
            ch = scanner.nextInt();

            try {
                ch = Integer.parseInt(String.valueOf(ch));
            } catch (NumberFormatException e) {
                System.out.println("Не верно выбран пункт меню");
            }

            switch (ch) {
                case 1->{
                    System.out.println("------------------------------------------");
                    System.out.println(temp.keySet());

                    try {
                        System.out.println("Какую категорию хотите отредактировать?");
                        String category_ = scanner.next();
                        temp.containsKey(category_);
                        System.out.println("Введите новое название для этой категории");
                        String new_category = scanner.next();
                        temp.put(new_category,temp.get(category_));


                    } catch (Exception e) {
                        System.out.println("Категория с таким именем не найдена");
                    }
                }
                case 2->{
                    System.out.println("------------------------------------------");
                    for(Map.Entry<String, Weapons> elem :temp.entrySet())
                        System.out.format("|%23s|%25s|\n",elem.getKey(),elem.getValue().getTitle());
                    try {
                        System.out.println("Какое наименование товара хотите заменить?");
                        String name_ = scanner.next();
                        String key = searcher(temp, name_);
                        System.out.println(key);
                        System.out.println("Введите новое имя товара");
                        String new_name = scanner.next();
                        temp.get(key).title = new_name;

                    } catch (Exception e) {
                        System.out.println("Категория с таким именем не найдена");
                    }

                }
                case 3->{
                    System.out.println("------------------------------------------");
                    for(Map.Entry<String, Weapons> elem :temp.entrySet())
                        System.out.format("%25s|\n", elem.getValue().getTitle());
                        System.out.println("Цену какого товара хотите заменить?");
                        try {
                            String name_ = scanner.next();
                            String key = searcher(temp, name_);
                            System.out.println("Введите новую цену товара");
                            int temp_cost = scanner.nextInt();
                            temp.get(key).cost = temp_cost;
                        }catch (Exception e){
                            System.out.println("Категория с таким именем не найдена");
                        }

                }
                case 4->{
                    System.out.println("------------------------------------------");
                    for(Map.Entry<String, Weapons> elem :temp.entrySet())
                        System.out.format("%25s|\n",elem.getValue().getTitle());

                    try {
                        System.out.println("Количество какого товара хотите изменить?");
                        String name_ = scanner.next();
                        String key = searcher(temp, name_);
                        System.out.println("Введите новое количество товара");
                        int temp_quantity = scanner.nextInt();
                        temp.get(key).quantity = temp_quantity;
                    }catch (Exception e){
                        System.out.println("Категория с таким именем не найдена");
                    }
                }
                case 5-> System.out.println("Возвращаю в основное меню");
                default -> System.out.println("Выбранный пунтк не существует");
            }
        }
        return temp;
    }

    public static String searcher(Map<String,Weapons> temp, String name){
        String key = "";
        for (String k : temp.keySet())
            if (temp.get(k).getTitle().equals(name)) {
                key = k;
                break;
            }
        return key;
    }
    public static Map deleter(Map<String,Weapons> temp,String name){
        try {
            temp.containsKey(name);
            temp.remove(name);
            System.out.println("Удаление завершено!");
        }catch (Exception e){
            System.out.println("Категория не найдена!" + e);
        }

        return temp;
    }
}
