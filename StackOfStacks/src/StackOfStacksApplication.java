import java.util.Optional;
import java.util.Stack;

class Plate {
	public String name;

	public Plate(String name) {
		this.name = name;
	}
}

// Leetcode Problem: we try to pile up plates, but they should not be piled more than 5 
// otherwise they can fall
// we have capacity of 15 plates and in previous shift dishwasher guy spread plates to places randomly,
// so you need to take over the shift now

public class StackOfStacksApplication {

	public static Stack<Stack<Plate>> putMyCleanPlateToStack(Stack<Stack<Plate>> plateBasket, Plate newComing) {
		Optional<Stack<Plate>> findFirst = plateBasket.stream().filter(k -> !isFull(k, 5)).findFirst();
		if (findFirst.isEmpty()) {
			System.out.println("I could not add:" + newComing.name);
			return plateBasket;
		}

		Stack<Plate> stack = findFirst.get();
		stack.push(newComing);
		return plateBasket;
	}

	public static boolean isFull(Stack<Plate> plateBasket, int capacity) {
		return plateBasket.size() >= capacity;
	}

	public static void main(String args[]) {

		Stack<Stack<Plate>> basket = new Stack<Stack<Plate>>();
		Stack<Plate> firstLine = new Stack<Plate>();
		Stack<Plate> secondLine = new Stack<Plate>();
		Stack<Plate> thirdLine = new Stack<Plate>();
		Plate p1 = new Plate("A");
		Plate p2 = new Plate("B");
		Plate p3 = new Plate("C");
		Plate p4 = new Plate("D");
		Plate p5 = new Plate("E");
		Plate p6 = new Plate("F");
		Plate p7 = new Plate("G");
		
		firstLine.add(p1);
		firstLine.add(p2);
		firstLine.add(p3);
		firstLine.add(p4);
		firstLine.add(p5);
		thirdLine.add(p6);
		thirdLine.add(p7);
		basket.add(firstLine);
		basket.add(secondLine);
		basket.add(thirdLine);
		
		//take over the shift here
		
		Plate p8 = new Plate("G");
		Plate p9 = new Plate("H");
		Plate p10 = new Plate("I");
		Plate p11 = new Plate("J");
		Plate p12 = new Plate("K");
		Plate p13 = new Plate("L");
		Plate p14 = new Plate("M");
		Plate p15 = new Plate("N");
		Plate p16 = new Plate("O");
		
		putMyCleanPlateToStack(basket, p8);
		putMyCleanPlateToStack(basket, p9);
		putMyCleanPlateToStack(basket, p10);
		putMyCleanPlateToStack(basket, p11);
		putMyCleanPlateToStack(basket, p12);
		putMyCleanPlateToStack(basket, p13);
		putMyCleanPlateToStack(basket, p14);
		putMyCleanPlateToStack(basket, p15);
		putMyCleanPlateToStack(basket, p16);
		
		
	}
}
