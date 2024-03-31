package mealOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class AddMealOrderTest {

    @Test
    public void CountAddWrongNewTotalNumberAdded(){
		MealOrderMgmt mgmt = new MealOrderMgmt();
		System.out.println("Enter an input number: ");
		Scanner	 sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(input);
		sc.close();
		
		for(int i = 0 ;i < input;i++)
		{
			mgmt.addMealOrder(new MealOrder(1000+i));
			System.out.println("Creating order " +  1000 + (int)i);
		}
		int count	= mgmt.getOrderCount();
		assertEquals(count, input);
	}
}
