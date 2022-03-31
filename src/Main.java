public class Main {
    public static void main(String[] args) {
        //task 1
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(sumOfTwoNumbers(array,array.length - 1));
        System.out.println(factorial(5));
        //task 2
        System.out.println(fibonacci(7));
        //task 3
        System.out.println(countOfBlocksOfTriangle(7));
        //task 4
        System.out.println(sumOfDigits(12345));
        //task 5
        System.out.println(countOfSevenDigit(12265546));
        //task 6
        System.out.println(countOfCharX("alkfjhdxxxsfdfsx"));
        //task 7
        System.out.println(deleteCharX("rockxxyx"));
        //task 8
        System.out.println(reverseString("Hello"));
        //task 9
        System.out.println(moveXToEnd("xggxxjjxxgg"));
        //task 10
        System.out.println(stringCleaner("abbcccdddee"));
        //task 11
        System.out.println(isPrime(67));
        //task 12
        System.out.println(findLargestDigit("123654125"));
        //task 13
        System.out.println(numberOfDigits("125afdAf1"));
        //task 14
        System.out.println(addAsteriskBetweenLetters("asfdfdgshsSDFSFsdf"));
        //task 15
        System.out.println(addParenthesis("parsdgdfbsdfents"));
        //task 16
        System.out.println(mirroringString("(asdf(asdfA(s("));
        //task 17
        System.out.println(cutIdenticalLetters("adfduefka"));

    }


    /**
     * task1.1
     * returning sum of elements from given array
     */
    private static int sumOfTwoNumbers(int[] array, int index) {
        if (index == 0) {
            return array[index];
        }
        return array[index] + sumOfTwoNumbers(array, index - 1);
    }

    /**
     * task1.2
     * returning factorial from given number
     */
    private static int factorial(int f) {
        if (f == 0) {
            return 1;
        }
        return f * factorial(f - 1);
    }

    /**
     * task2
     * returning fibonacci number in given index
     */
    private static int fibonacci(int i) {
        if (i == 1) {
            return 1;
        } else if (i == 0) {
            return 0;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    /**
     * task3
     * We have triangles made of blocks. The topmost row has 1 block, the next
     * row down has 2 blocks, the next row has 3 blocks.
     * returning count of blocks in given row of triangle
     */
    private static int countOfBlocksOfTriangle(int index) {
        return index == 0 ? 0 : index + countOfBlocksOfTriangle(index - 1);
    }

    /**
     * task4
     * returning sum of digits from given numbers
     */
    private static int sumOfDigits(int num) {
        return num < 10 ? num : num % 10 + sumOfDigits(num / 10);
    }

    /**
     * task5
     * returning count of digit 7 in given number
     */
    private static int countOfSevenDigit(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10 == 7 ? 1 : 0) + countOfSevenDigit(num / 10);
    }

    /**
     * task6
     * returning count of digit 'x' in given string
     */
    private static int countOfCharX(String str) {
        char[] array = str.toCharArray();
        return countOfX(array, array.length - 1);
    }

    /**
     * helper method for task6
     */
    private static int countOfX(char[] array, int index) {
        if (index == 0) {
            return array[0] == 'x' ? 1 : 0;
        }
        return (array[index] == 'x' ? 1 : 0) + countOfX(array, --index);
    }

    /**
     * task7
     * returning new String without 'x' character
     */
    private static String deleteCharX(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        return helperFOrDeleteCharX(str.toCharArray(), 0);
    }

    /**
     * helping method for task7
     */
    private static String helperFOrDeleteCharX(char[] array, int index) {
        if (index == array.length - 1) {
            return array[index] == 'x' ? "" : String.valueOf(array[0]);
        }
        return (array[index] == 'x' ? "" : String.valueOf(array[index])) + helperFOrDeleteCharX(array, index + 1);
    }

    /**
     * task8
     * returning reversed version of given String
     */
    private static String reverseString(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        return helperForReverseString(str.toCharArray(), str.length() - 1);
    }

    /**
     * helper method for task8
     */
    private static String helperForReverseString(char[] array, int index) {
        if (index == 0) {
            return String.valueOf(array[index]);
        }
        return array[index] + helperForReverseString(array, --index);

    }

    /**
     * task9
     * changing position of char x to end of string and returning new string
     */
    private static String moveXToEnd(String str) {
        int countOfNotXChar = str.length() - countOfCharX(str);
        if (countOfNotXChar == str.length()) {
            return str;
        }
        return helperForMoveXToEnd(str, 0, str.length(), countOfNotXChar);
    }

    /**
     * helping method for task9
     */
    private static String helperForMoveXToEnd(String str, int index, int size, int countOfNotXChar) {
        if (index == countOfNotXChar) {
            return str;
        }
        if (str.charAt(index) == 'x') {
            str = str.substring(0, index) + str.substring(index + 1, size) + "x";
            --index;
        }
        return helperForMoveXToEnd(str, ++index, size, countOfNotXChar);
    }

    /**
     * task 10
     * cleaning and returning cleaned string without duplicate adjacent chars
     */
    private static String stringCleaner(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        return helperForStringCleaner(str, 1);
    }

    /**
     * helping method for task 10
     */
    private static String helperForStringCleaner(String str, int index) {
        if (index == str.length()) {
            return str;
        }
        if (str.charAt(index) == str.charAt(index - 1)) {
            str = str.substring(0, index) + str.substring(index + 1);
            --index;
        }
        return helperForStringCleaner(str, ++index);
    }

    /**
     * task 11
     * checking is given number is prime
     */
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        return helperForIsPrime(num, 2);
    }

    /**
     * helping method for task11
     */
    private static boolean helperForIsPrime(int num, int index) {
        if (index == (num / 2) + 1) {
            return true;
        }
        if (num % index == 0) {
            return false;
        }
        return helperForIsPrime(num, ++index);
    }

    /**
     * task12
     * finding max digit in given string of numbers
     */
    private static String findLargestDigit(String nums) {
        if (checkObject(nums) || !isNum(nums)) {
            return "Invalid argument";
        }
        return String.valueOf(helperForFindLargestDigit(nums, 1, nums.charAt(0)));
    }

    /**
     * helping method for task12
     */
    private static char helperForFindLargestDigit(String nums, int index, char max) {
        if (index == nums.length()) {
            return max;
        }
        if (nums.charAt(index) > max) {
            max = nums.charAt(index);
        }
        return helperForFindLargestDigit(nums, ++index, max);
    }

    /**
     * task 13
     * returning count of digits in given string
     */
    private static int numberOfDigits(String str) {
        if (checkObject(str)) {
            return -1;
        }
        return helperForNumberOfDigits(str, 0, 0);

    }

    /**
     * helping method for task 13
     */
    private static int helperForNumberOfDigits(String str, int count, int index) {
        if (index == str.length()) {
            return count;
        }
        if (isNumChar(str.charAt(index))) {
            count++;
        }
        return helperForNumberOfDigits(str, count, ++index);
    }

    /**
     * task 14
     * adding char '*' after every letter from given string except for the last
     */
    private static String addAsteriskBetweenLetters(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        return helperForAsterisk(str, stringBuilder, 0, str.length()).toString();
    }

    /**
     * helping method for task 14
     */
    private static StringBuilder helperForAsterisk(String str, StringBuilder newStr, int index, int length) {
        if (index == length - 1) {
            return newStr.append(str.charAt(index));
        }
        newStr.append(str.charAt(index));
        newStr.append('*');
        return helperForAsterisk(str, newStr, ++index, length);
    }

    /**
     * task 15
     * inserting parenthesis after every char in given string
     */
    private static String addParenthesis(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        StringBuilder newStr = new StringBuilder("(");

        return helperForAddParenthesis(str, newStr, 0, str.length()).toString();
    }

    /**
     * helping method for task 15
     */
    private static StringBuilder helperForAddParenthesis(String str, StringBuilder newStr, int index, int length) {
        if (index == length) {
            return newStr;
        }
        newStr.append(str.charAt(index));
        if (index < (length / 2) - 1) {
            newStr.append("(");
        } else if ((length & 1) == 1 && index == (length / 2) - 1) {
            newStr.append("(");
        } else if ((length & 1) == 0 && index == (length / 2) - 1) {

        } else {
            newStr.append(")");
        }
        return helperForAddParenthesis(str, newStr, ++index, length);
    }

    /**
     * task 16
     */
    private static String mirroringString(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        StringBuilder newStr = new StringBuilder(str);
        return String.valueOf(helperForMirroring(str, newStr, str.length() - 1));
    }

    /**
     * helping method for task 16
     */
    private static StringBuilder helperForMirroring(String str, StringBuilder newStr, int index) {
        if (index < 0) {
            return newStr;
        }
        newStr.append(str.charAt(index) != '(' ? str.charAt(index) : ')');
        return helperForMirroring(str, newStr, --index);
    }

    /**
     * task 17
     * cutting identical letters located at symmetrical places
     */
    private static String cutIdenticalLetters(String str) {
        if (checkObject(str)) {
            throw new IllegalArgumentException();
        }
        StringBuilder newStr = new StringBuilder(str);
        return String.valueOf(helperForCutIdenticalLetters(str, newStr, str.length(), 0, 0));
    }

    /**
     * helper method for task 17
     *
     */
    private static StringBuilder helperForCutIdenticalLetters(String str, StringBuilder newStr, int length, int index, int index2) {
        if (index2 == newStr.length() / 2) {
            return newStr;
        }
        if (str.charAt(index) == str.charAt(length - 1 - index)) {
            newStr.deleteCharAt(index2);
            newStr.deleteCharAt(newStr.length() - 1 - index2);
            --index2;
        }
        return helperForCutIdenticalLetters(str, newStr, length, ++index, ++index2);
    }


    /**
     * checking is given object null
     *
     */
    private static boolean checkObject(Object o) {
        return o == null;
    }

    /**
     * checking is given char a number
     *
     */
    private static boolean isNumChar(char num) {
        return num >= '0' && num <= '9';
    }

    /**
     * checking is given string contains only nums
     *
     */
    private static boolean isNum(String nums) {
        int size = nums.length();
        for (int i = 0; i < size; i++) {
            if (nums.charAt(i) < '0' || nums.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
