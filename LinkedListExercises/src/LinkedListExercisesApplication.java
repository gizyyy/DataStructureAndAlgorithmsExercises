import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExercisesApplication {

	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(4);
		list.add(5);
		System.out.println(findLastNthElement(list, 6));
		removeDuplicate(list).stream().forEach(System.out::println);

		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(5);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(5);
		sumLists(list1, list2).stream().forEach(System.out::println); //360

	}

	// remove duplicates of a Linked List * complexity: O(n)
	public static LinkedList<Integer> removeDuplicate(LinkedList<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		HashSet<Integer> uniqs = new HashSet<Integer>();

		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (!uniqs.contains(next)) {
				uniqs.add(next);
			} else {
				iterator.remove();
			}
		}
		return list;
	}

	// find nth last element  of a Linked List * complexity: O(n)
	public static Integer findLastNthElement(LinkedList<Integer> list, int n) {
		Iterator<Integer> descendingIterator = list.descendingIterator();
		Integer target = 0;
		if (n > list.size()) {
			System.out.print("I can only return you the last element of the list");
		}

		while (descendingIterator.hasNext()) {
			n--;
			target = descendingIterator.next();
			if (n == 0) {
				break;
			}
		}

		return target;
	}

	// You have two numbers represented by a linked list, where each node contains a
	// single digit. The digits are stored in reverse order, such that the 1's digit
	// is at the head of the list. Write a function that adds the two numbers and
	// returns the sum as a linked list.
	public static LinkedList<Integer> sumLists(LinkedList<Integer> list, LinkedList<Integer> list2) {

		Iterator<Integer> biggerIterator = list.descendingIterator();
		Iterator<Integer> smallerIterator = list2.descendingIterator();

		if (list2.size() > list.size()) {
			biggerIterator = list2.descendingIterator();
			smallerIterator = list.descendingIterator();
		}

		LinkedList<Integer> result = new LinkedList<Integer>();

		int remaining = 0;
		while (biggerIterator.hasNext()) {
			Integer totalDigit = smallerIterator.next() + biggerIterator.next() + remaining;
			remaining = 0;
			if (totalDigit < 10) {
				result.add(totalDigit);
			} else {
				result.add(totalDigit % 10);
				remaining = 1;
			}
		}
		if (remaining > 0) {
			result.add(remaining);
		}

		Iterator<Integer> descendingIterator3 = result.descendingIterator();
		LinkedList<Integer> reversed = new LinkedList<Integer>();
		while (descendingIterator3.hasNext()) {
			reversed.add(descendingIterator3.next());
		}
		return reversed;
	}

}
