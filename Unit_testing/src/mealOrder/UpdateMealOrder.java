package mealOrder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpdateMealOrder {
	MealOrderMgmt mgmt;
    MealOrder mo1;
    MealOrder mo2;
    MealOrder mo3;
    MealOrder mo4;
    MealOrder mo5;
    MealOrder mo6;
    @BeforeEach
    void setUp(){
        mgmt = new MealOrderMgmt();
        mo1 = new MealOrder(1001);
        mo2 = new MealOrder(1002);
        mo3 = new MealOrder(1003);
        mo4 = new MealOrder(1004);
        mo5 = new MealOrder(1005);
        mo6 = new MealOrder(1006);
    }
 
    @AfterEach
    void teardown(){
        mgmt = null;
        mo1 = null;
        mo2 = null;
        mo3 = null;
        mo4 = null;
        mo5 = null;
        mo6 = null;
    }

    @Test
    void testaddMealOrder(){
        assertEquals(0, mgmt.getOrderCount());
        mgmt.addMealOrder(mo1);
        assertEquals(1, mgmt.getOrderCount());
        mgmt.addMealOrder(mo2);
        assertEquals(2, mgmt.getOrderCount());
 
        mgmt.addMealOrder(mo3);
        mgmt.addMealOrder(mo4);
        mgmt.addMealOrder(mo5);
        mgmt.addMealOrder(mo6);
        assertEquals(6, mgmt.getOrderCount());
    }
    @Test
    void testUpdateMealOrder(){
        assertEquals(OrderStatus.INACTIVE, mo1.getStatus());
        mgmt.addMealOrder(mo1);
        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.ORDERED);
        assertEquals(OrderStatus.ORDERED, mo1.getStatus());
     
    }
 
    @Test
    void testCountOrderStatus(){
        assertEquals(0, mgmt.countNumberOf(OrderStatus.ORDERED));
        assertEquals(0, mgmt.countNumberOf(OrderStatus.IN_KITCHEN));
        mgmt.addMealOrder(mo1);
        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.IN_KITCHEN);
 
        mgmt.addMealOrder(mo2);
        mgmt.updateMealOrder(mo2.getOrderID(), OrderStatus.ORDERED);
 
        mgmt.addMealOrder(mo3);
        mgmt.updateMealOrder(mo3.getOrderID(), OrderStatus.ORDERED);
 
        assertEquals(1, mgmt.countNumberOf(OrderStatus.IN_KITCHEN));
        assertEquals(2, mgmt.countNumberOf(OrderStatus.ORDERED));
 
        mgmt.addMealOrder(mo4);
        mgmt.addMealOrder(mo5);
        mgmt.addMealOrder(mo6);
        mgmt.updateMealOrder(mo4.getOrderID(), OrderStatus.IN_KITCHEN);
        mgmt.updateMealOrder(mo5.getOrderID(), OrderStatus.ORDERED);
        mgmt.updateMealOrder(mo6.getOrderID(), OrderStatus.ORDERED);
        assertEquals(2, mgmt.countNumberOf(OrderStatus.IN_KITCHEN));
        assertEquals(4, mgmt.countNumberOf(OrderStatus.ORDERED));
        System.out.print("Printing order counted:"+mgmt.countNumberOf(OrderStatus.IN_KITCHEN));
    }
 
    @Test
    void testBeforeAndAfterCount(){
        int old_count = mgmt.getOrderCount();
        mgmt.addMealOrder(mo1);
        assertEquals(mgmt.getOrderCount(), old_count + 1);
    }
 
  
}
