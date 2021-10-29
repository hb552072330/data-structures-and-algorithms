package cn.baymax.example._enum;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2021/10/13
 */
public class PizzaTest {
    public static void main(String[] args) {
        testEnumSet();
        testEnumMap();
        givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges();

    }

    public static void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        System.out.println("givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges():" + (pz.getStatus() == Pizza.PizzaStatus.DELIVERED));
    }

    private static void testEnumMap() {
        List<Pizza> pzList = getPizzas();
        EnumMap<Pizza.PizzaStatus, List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
        System.out.println("testEnumMap():" + (map.get(Pizza.PizzaStatus.DELIVERED).size() == 1));
        System.out.println("testEnumMap():" + (map.get(Pizza.PizzaStatus.ORDERED).size() == 2));
        System.out.println("testEnumMap():" + (map.get(Pizza.PizzaStatus.READY).size() == 1));
    }

    private static List<Pizza> getPizzas() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);
        return pzList;
    }

    private static void testEnumSet() {
        List<Pizza> pzList = getPizzas();

        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);
        System.out.println("testEnumSet():" + (undeliveredPzs.size() == 3));
    }


}
