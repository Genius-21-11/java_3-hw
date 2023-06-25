// Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену товаров 1го или 2-го сорта среди товаров, 
// название которых содержит «высший».

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class task1 {
    public static void main(String[] args) {
        Items item1 = new Items("Соль", 32.0, 1);
        Items item2 = new Items("Сахар", 62.99, 1);
        Items item3 = new Items("Мука Высший мельник", 99.99, 3);
        Items item4 = new Items("Креветки высший свет", 529.99, 1);
        Items item5 = new Items("Соль высший помол йодированная", 62.0, 2);
        Items item6 = new Items("Устрицы высший свет", 529.99, 2);
    
        List<Items> itemsList = new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        itemsList.add(item6);
        
        String searchName = "высший";
        Double maxPrice = 0.0;
        String maxPriceSortedNames = "";

        for (Items items : itemsList) {
            if (items.getName().toLowerCase().contains(searchName) && (items.getSort() == 1 || items.getSort() == 2)) {
                if (maxPrice < items.getPrice()) {
                    maxPrice = items.getPrice();
                }
            }
        }

        for (Items items : itemsList) {
            if (items.getName().toLowerCase().contains(searchName) && (items.getSort() == 1 || items.getSort() == 2)) {
                if (Objects.equals(items.getPrice(), maxPrice)) {

                    maxPriceSortedNames += items.getName() + "\n";
                }
            }
        }
        System.out.println("Самые дорогие товары первого и второго сорта, в названии которых есть слово 'высший': ");
        System.out.println(maxPriceSortedNames);
        System.out.println("Наибольшая цена: " + maxPrice);
    }
}