package dev.example.restaurantManager;

import dev.example.restaurantManager.model.MenuRestaurant;
import dev.example.restaurantManager.repository.MenuItemRepository;
import dev.example.restaurantManager.repository.MenuRestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@DataJpaTest
public class RelationshipMenuMenuItemTest {

    @Autowired
    private MenuRestaurantRepository menuRestaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Test
    public void TestRelationshipMenuMenuItem() {

        // Create menus
        MenuRestaurant menu1 = new MenuRestaurant("M01", "Burger Menu", 10.99, "Burger, fries, and drink", true, true);
        MenuRestaurant menu2 = new MenuRestaurant("M02", "Pizza Menu", 12.99, "Pizza and salad", true, false);
        MenuRestaurant menu3 = new MenuRestaurant("M03", "Salad Menu", 8.99, "Mixed salad and dressing", true, true);
        // Save menus
        menuRestaurantRepository.save(menu1);
        menuRestaurantRepository.save(menu2);
        menuRestaurantRepository.save(menu3);

        // Create MenuItems
//        MenuItem menuItem1 = new MenuItem("VeggieMeat", "Fresh and tasty", true, true, true);
//        MenuItem menuItem2 = new MenuItem("Salad", "Mix", false, false, true);
//        MenuItem menuItem3 = new MenuItem("Meat", "Bloody", false, false, true);
//        MenuItem menuItem4 = new MenuItem("Rice", "Juicy", true, false, true);

        MenuItem item1 = new MenuItem();
        item1.setName("Tacos");
        item1.setSpicy(true);
        item1.setHasGluten(false);
        item1.setAvailable(true);
        item1.setCourseType(CourseType.MAIN);
        menuItemRepository.save(item1);

        MenuItem item2 = new MenuItem();
        item2.setName("Brownie");
        item2.setDescription("Rich and fudgy brownie without gluten.");
        item2.setSpicy(false);
        item2.setHasGluten(false);
        item2.setAvailable(true);
        item2.setCourseType(CourseType.DESSERT);
        menuItemRepository.save(item2);

        MenuItem item3 = new MenuItem();
        item3.setName("Salad");
        item3.setDescription("Classic Caesar salad with a creamy dressing.");
        item3.setSpicy(false);
        item3.setHasGluten(true);
        item3.setAvailable(false);
        item3.setCourseType(CourseType.STARTER);
        menuItemRepository.save(item3);

        MenuItem item4 = new MenuItem();
        item4.setName("Hotpot");
        item4.setDescription("Spicy Sichuan hotpot with a variety of vegetables.");
        item4.setSpicy(true);
        item4.setHasGluten(false);
        item4.setAvailable(true);
        item4.setCourseType(CourseType.MAIN);
        menuItemRepository.save(item4);

        MenuItem item5 = new MenuItem();
        item5.setName("Garlic Bread");
        item5.setDescription("Freshly baked bread with garlic and herbs.");
        item5.setSpicy(false);
        item5.setHasGluten(true);
        item5.setAvailable(false);
        item5.setCourseType(CourseType.STARTER)
        menuItemRepository.save(item5);

        // Adding items to menus
        menu1.getMenuItems().add(item1);
        menu1.getMenuItems().add(item2);

        menu2.getMenuItems().add(item2);
        menu2.getMenuItems().add(item5);

        menu3.getMenuItems().add(item3);
        menu3.getMenuItems().add(item4);
        menu3.getMenuItems().add(item5);

        // Create a list of all menu
        ArrayList<MenuRestaurant> menus = new ArrayList<>();
        menus.addAll(Arrays.asList(menu1, menu2, menu3));
        // Print the number of orders
        System.out.println("Menus");
        System.out.println("Total number of orders: " + menus.size() + " menus.");
        System.out.println("--------------------");

        // Create a list of all menuItems
        ArrayList<MenuItem> menuitems = new ArrayList<>();
        menuitems.addAll(Arrays.asList(item1, item2, item3, item4, item5));
        // Print the number of items
        System.out.println("Menu Items");
        System.out.println("Total number of items: " + menuitems.size() + " items.");
        System.out.println("--------------------");


    }


}