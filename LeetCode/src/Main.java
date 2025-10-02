import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, 
        new int[]{1,1,3,3}));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return false;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int counter = 0;
        char[] stonesArr = stones.toCharArray();
        char[] jewelsArr = jewels.toCharArray();
        for (char s : stonesArr) {
            for (char j : jewelsArr) {
                if (s == j) counter++;
            }
        }
        return counter;
    }

    public static String[] fizzBuzz(int n) {
        String[] arr = new String[n];
        for(int i = 1; i <= n; i++) {
            String ans;
            if((i % 3) == 0 && (i % 5) == 0) {
                ans = "FizzBuzz";
            } 
            else if ((i % 3) == 0) {
                ans = "Fizz"; 
            } 
            else if ((i % 5) == 0) {
                ans = "Buzz"; 
            } 
            else {
                ans = String.valueOf(i);
            }
            arr[i-1] = ans;
        }
        return arr;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];

        return solution;
    }

    public static int[] topKFrequentVer2(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        List<List<Integer>> list = new ArrayList<>();
        // [1][k]
        // [2][k]
        int[] solution = new int[k];
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            l++;
            h--;
        }
        return solution;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int[] solution = new int[k];
        int l = 0, h = nums.length - 1;
        Map<Integer, Integer> tracker = new HashMap<>();
        while (l <= h) {
            Integer valuel = tracker.putIfAbsent(nums[l], 1);
            if (valuel != null) {
                tracker.put(nums[l], valuel + 1);
            }

            Integer valueh = tracker.putIfAbsent(nums[h], 1);
            if (valueh != null && h != l) {
                tracker.put(nums[h], valueh + 1);
            }

            l++;
            h--;
        }

        List<Map.Entry<Integer, Integer>> list = tracker.entrySet().stream()
                .sorted((Map.Entry.comparingByValue(Comparator.reverseOrder()))).toList();
        for (int i = 0; i < solution.length; i++) {
            solution[i] = list.get(i).getKey();
        }
        return solution;
    }

    public static void lengthOfLongest() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String substring = input.substring(1, input.length() - 1);
        String[] split = substring.split(",");
        int[] intArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            intArr[i] = Integer.parseInt(split[i].trim());
        }
        // Example [10, 9, 3, 5, 2, 7, 101, 4]
        int solution = 0;
        int temp = 1;
        for (int i = 0; i < intArr.length - 1 && solution >= (intArr.length - i - 1); i++) {
            if (intArr[i] < intArr[i + 1]) {
                temp++;
                if (temp > solution)
                    solution = temp;
            } else {
                temp = 1;
            }
            if (solution >= intArr.length - i - 1)
                break;
        }
        System.out.println(solution);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramLists = new ArrayList<>();
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String key = String.copyValueOf(charArray);
            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(string);
            } else {
                List<String> listSameAnagrams = new ArrayList<>();
                listSameAnagrams.add(string);
                anagrams.put(key, listSameAnagrams);
            }
        }
        anagrams.forEach((a, s) -> anagramLists.add(s));
        return anagramLists;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracker = new HashMap<>();
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int complement = target - nums[l];
            if (tracker.containsKey(complement)) {
                return new int[] { l, tracker.get(complement) };
            }
            tracker.put(nums[l], l);

            complement = target - nums[h];
            if (tracker.containsKey(complement)) {
                return new int[] { h, tracker.get(complement) };
            }
            tracker.put(nums[h], h);

            l++;
            h--;
        }
        return new int[] {};

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        char[] charA = s.toCharArray();
        char[] charB = t.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        return Arrays.equals(charA, charB);

    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = 0; i < aux.length; i++) {
            aux[i] = a[i]; // Copy the original array
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = a[j++];
            else if (j > hi)
                a[k] = a[i++];
            else if (aux[i] <= aux[j])
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int actualValue = head.val;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == actualValue) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
                actualValue = temp.val;
            }
        }

        return head;
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] solution = new int[n];
        solution[0] = 1;
        solution[1] = 2;
        for (int i = 2; i < n; i++) {
            solution[i] = solution[i - 1] + solution[i - 2];
        }

        return solution[n - 1];
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int start = 1;
        int end = x;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid == x)
                return mid;
            else if ((long) mid * mid > (long) x)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return end;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit == 9) {
                digits[i] = 0;
            } else {
                digits[i] = ++digit;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static int lengthOfLastWord(String s) {
        char space = ' ';
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == space && counter != 0)
                break;
            if (s.charAt(i) != space)
                counter++;
        }
        return counter;
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int hayStackLength = haystack.length();
        if (needleLength > hayStackLength)
            return -1;

        for (int i = 0; i <= hayStackLength - needleLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean coincidence = true;
                for (int j = 1; j < needleLength; j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        coincidence = false;
                        break;
                    }
                }
                if (coincidence)
                    return i;
            }
        }
        return -1;
    }

    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    public static int removeDuplicates(int[] nums) {
        Stream<Integer> boxed = Arrays.stream(nums).boxed().distinct();
        long count = boxed.count();
        return Math.toIntExact(count);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}