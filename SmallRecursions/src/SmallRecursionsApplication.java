public class SmallRecursionsApplication {

	public static void main(String args[]) {
	

	}

	// calculate factorial
	static int calculateFactorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * calculateFactorial(n - 1);
	}

	// 5th level fibonacci
	static int calculateFibonacci(int n) {
		if (0 == n)
			return 0;
		if (1 == n)
			return 1;
		else {
			return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
		}
	}

	// xy
	static int powerOf(int x, int y) {
		if (y == 0) {
			return 1;
		}
		return x * powerOf(x, y - 1);
	}

	// 8 12 = 4, 15 50 = 5
	static int greatestCommonDivisor(int x, int y) {
		if (y % x == 0) {
			return x;
		}

		return greatestCommonDivisor(y % x, x);
	}

	// recursive total of a number, 5 -> 1+2+3+4+5 = 15
	static int recursiveRange(int num) {
		if (num == 0) {
			return 0;
		} else
			return num + recursiveRange(num - 1);
	}

	// java -> avaj
	static String reverseString(String coming) {

		String forced = new String(coming);

		if (forced.length() == 1)
			return forced;
		else {
			return String.valueOf(forced.charAt(forced.length() - 1))
					.concat(reverseString(forced.substring(0, forced.length() - 1)));
		}

	}

	// catotac -> true
	static boolean isPalindrome(String s) {
		String forced = new String(s);

		if (forced.length() == 1) {
			return true;
		}

		if (forced.length() == 2) {
			return forced.charAt(0) == forced.charAt(0);
		}

		if (forced.length() == 3) {
			return forced.charAt(0) == forced.charAt(2);
		}

		return (forced.charAt(0) == forced.charAt(forced.length() - 1))
				&& isPalindrome(forced.substring(1, forced.length() - 1));

	}

	// gizeM -> M
	static Character firstUpperCase(String str) {
		if (str.length() == 1) {
			if (Character.isUpperCase(str.charAt(0)))
				return str.charAt(0);
			else
				return null;
		}

		if (!Character.isUpperCase(str.charAt(0))) {
			return firstUpperCase(str.substring(1, str.length() - 1));
		} else
			return str.charAt(0);
	}

	public static void twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					System.out.println(i + "-" + j);

				}
			}
		}
	}

}
