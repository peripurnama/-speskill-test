import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpeSkillTest {

	public static void main(String[] args) {

		// test result answer no.1
		System.out.println("No 1");
		int num1 = 153;
		int num2 = 111;
		printAnswerNo1(num1);
		printAnswerNo1(num2);
		System.out.println("==============================");

		// test result answer no.2
		int arrs1[] = new int[] { 2, 4, 0, 100, 4, 11, 2602, 36 };
		int arrs2[] = new int[] { 160, 3, 1719, 19, 11, 13, -21 };
		int arrs3[] = new int[] { 11, 13, 15, 19, 9, 13, -21 };

		System.out.println("No 2");
		System.out.println(findOutlier(arrs1));
		System.out.println(findOutlier(arrs2));
		System.out.println(findOutlier(arrs3));
		System.out.println("==============================");

		// test result answer no.3
		System.out.println("No 3");
		findNeedle(new String[] { "red", "blue", "yellow", "black", "grey" }, "blue");
		System.out.println("==============================");

		// test result answer no.

		System.out.println("No 4");
		getPrefixArr(Arrays.asList(1, 2, 3, 4, 6, 10), Arrays.asList(1));
		getPrefixArr(Arrays.asList(1, 5, 5, 5, 5, 3), Arrays.asList(5));
		System.out.println("==============================");

	}

	// start function answer no 1 Narcissistic Number
	private static void printAnswerNo1(int num) {
		if (checkNarcissistic(num))
			System.out.println("this will return true");
		else
			System.out.println("this will return false");
	}

	private static int countDig(int num) {
		if (num == 0)
			return 0;
		return 1 + countDig(num / 10);
	}

	private static boolean checkNarcissistic(int num) {

		int p = countDig(num);

		int temp = num;

		int sum = 0;

		while (temp > 0) {

			sum += Math.pow(temp % 10, p);

			temp = temp / 10;
		}

		return (num == sum);
	}
	// end function answer no 1

	// start function answer no 2

	public static String findOutlier(int[] integers) {

		int oddCount = 0;
		for (int n : integers) {
			if (n % 2 != 0) {
				oddCount += 1;
			}
		}

		if (oddCount == 1) {
			for (int n : integers) {
				if (n % 2 != 0) {

					return "Should return: " + n + " (the only odd number)";
				}
			}
		} else {
			for (int n : integers) {
				if (n % 2 == 0) {
					return "Should return: " + n + " (the only even number)";
				}
			}
		}
		return "Should return: false (all odd integer, no outlier)";
	}
	// end function answer no 2

	// start function answer no 3
	public static void findNeedle(String[] haystack, String find) {
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i] == find)
				System.out.println("This function should return " + i + " as the index of the needle (" + find + ")");
		}
	}
	// end function answer no 3

	// start function answer no 4
	private static void getPrefixArr(List<Integer> subArray, List<Integer> prefixArr) {

		List<Integer> collect = subArray.stream().filter(f -> {
			return prefixArr.stream().filter(f2 -> f != f2).findFirst().isPresent();
		}).collect(Collectors.toList());

		String message = "Should return " + collect + " because " + prefixArr + " is present in the second list";

		System.out.println(message);

	}

}
