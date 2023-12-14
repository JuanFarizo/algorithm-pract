import java.util.*;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {
        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3);

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4);

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5);

        /*
            EXPECTED OUTPUT:
            ----------------
            Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            Result: 6
            Example 2: Input: [1, 2, 3, -4, 5, 6]
            Result: 13
            Example 3: Input: [-1, -2, -3, -4, -5]
            Result: -1
            Example 4: Input: [1, 2, 3, 4, 5]
            Result: 15
            Example 5: Input: [1, -1, 1, -1, 1]
            Result: 1
        */
    }

    public static int maxSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int solution = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > sum + num) sum = num;
            else sum = sum + num;
            if (sum > solution) solution = sum;
        }
        return solution;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        // Reverse the first part
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }


    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        // {0, 1, 2, 3, 4}
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pos] != nums[i]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }

    public static String findLongestString(String[] stringList) {
        if (stringList.length == 0) return null;
        int solution = 0;
        int currentGreat = stringList[0].length();
        for (int i = 0; i < stringList.length; i++) {
            if (currentGreat < stringList[i].length()) {
                currentGreat = stringList[i].length();
                solution = i;
            }
        }
        return stringList[solution];
    }

    public static int[] findMaxMin(int[] myList) {
        int maximum = myList[0];
        int minimum = myList[0];
        for (int num : myList) {
            if (num > maximum) {
                maximum = num;
            } else if (num < minimum) {
                minimum = num;
            }
        }
        return new int[]{maximum, minimum};
    }

    private static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static List<Integer> streamMax(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        if (nums.length == 0) return sol;
        int currentMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int actualNumber = nums[i];
            if (actualNumber > currentMax) {
                currentMax = actualNumber;
            }
            sol.add(currentMax);
        }
        return sol;
    }


    public static int findKthSmallest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        Heap heap = new Heap();
        for (int num :
                nums) {
            heap.insert(num);
        }
        while (heap.getHeap().size() > k) {
            heap.remove();
        }
        return heap.getHeap().get(0);
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            mySet.add(num);
        }
        int bestStrike = 0;
        for (Integer num : mySet) {
            int currentStrike = 1;
            while (mySet.contains(--num)) currentStrike++;
            if (bestStrike < currentStrike) bestStrike = currentStrike;
        }
        return bestStrike;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> solution = new ArrayList<>();
        if (arr2.length == 0 || arr1.length == 0) return solution;
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            mySet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (mySet.contains(target - arr2[i])) {
                int i2 = arr2[i];
                solution.add(new int[]{target - i2, i2});
            }
        }
        return solution;
    }

    public static boolean hasUniqueChars(String string) {
        Set<Character> mySet = new HashSet<>();
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!mySet.add(charArray[i])) {
                return false;
            }
        }
        return true;
    }


    public static List<Integer> removeDuplicatesList(List<Integer> myList) {
        Set<Integer> mySet = new HashSet<>();
        for (Integer num :
                myList) {
            mySet.add(num.intValue());
        }
        List<Integer> arr = new ArrayList<>(mySet);
        return arr;
    }


    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - (nums[i] + nums[j]) == 0) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
        return new int[0];
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> anagramLists = new ArrayList<>();
        HashMap<char[], List<String>> anagrams = new HashMap<>();
        for (String string : strings) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);

            if (anagrams.containsKey(charArray)) {
                anagrams.get(charArray).add(string);
            } else {
                List<String> listSameAnagrams = new ArrayList<>();
                listSameAnagrams.add(string);
                anagrams.put(charArray, listSameAnagrams);
            }
        }
        anagrams.forEach((a, s) -> anagramLists.add(s));
        return anagramLists;
    }

    public static List<Integer> findDuplicates(int[] intArray) {
        List<Integer> duplicates = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer integer : intArray) {
            Integer wasPuted = map.put(integer, integer);
            if (wasPuted != null) {
                if (!duplicates.contains(integer))
                    duplicates.add(integer);
            }
        }
        sort(duplicates);
        return duplicates;
    }

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> occurrences = new HashMap<>();
        for (Character c : string.toCharArray()) {
            Integer value = occurrences.put(c, 0);
            if (value != null) occurrences.replace(c, ++value);
        }
        Character candidate = null;
        for (Map.Entry<Character, Integer> set : occurrences.entrySet()) {
            if (set.getValue() == 0) {
                candidate = set.getKey();
                break;
            }
        }
        return candidate;
    }

    public static void sortStack(StackExam<Integer> originalStack) {
        StackExam<Integer> sortedStack = new StackExam();

        while (!originalStack.isEmpty()) {
            Integer pop = (Integer) originalStack.pop();

            while (!sortedStack.isEmpty() && (Integer) sortedStack.peek() > pop) {
                originalStack.push((Integer) sortedStack.pop());
            }

            sortedStack.push(pop);
        }

        int size = sortedStack.size();

        for (int i = 0; i < size; ++i) {
            originalStack.push((Integer) sortedStack.pop());
        }

        System.out.println("stop here.");
    }

    public static boolean isBalancedParentheses(String string) {
        string = string.trim();
        if (string.length() % 2 != 0) {
            return false;
        } else {
            StackExam<Character> myStack = new StackExam();
            char[] charArray = string.toCharArray();
            char[] var3 = charArray;
            int var4 = charArray.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                myStack.push(c);
            }

            if ((Character) myStack.peek() == '(') {
                return false;
            } else {
                int counter = 0;
                boolean flag = true;

                while (myStack.peek() != null) {
                    Character lastItem = (Character) myStack.pop();
                    if (lastItem == ')') {
                        ++counter;
                    } else {
                        --counter;
                    }

                    if (counter < 0) {
                        flag = false;
                        break;
                    }
                }

                return flag;
            }
        }
    }

    public static String reverse(String string) {
        StackExam<Character> myStack = new StackExam();
        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; ++i) {
            myStack.push(charArray[i]);
        }

        String reversed = "";
        int originalLength = myStack.size();

        for (int i = 0; i < originalLength; ++i) {
            Character pop = (Character) myStack.pop();
            reversed = reversed.concat(pop.toString());
        }

        return reversed;
    }

    public static int factorialRecursion(int n) {
        if (n == 1) return 1;
        return n * factorialRecursion(n - 1);
    }
}
