package Algorithms.Strings;

public class ReverseString {

  public static String reverseString(String string) {
    String result = ""; //It's recommended to use "StringBuilder" object when manipulating strings
    final int length = string.length();
    for (int i = length - 1; i >= 0; i--) {
      result += string.charAt(i);
    }
    return result;
  }

  public static String reverseStringWithRealJava(String string) {
    return new StringBuilder(string).reverse().toString();
  }

  public static String reverse(String s) {
    if(s == null || s.isEmpty()) {
      return s;
    }

    StringBuilder reversed = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      reversed.append(s.charAt(i));
    }

    return reversed.toString();
  }


  public static void main(String[] args) {
    System.out.println(reverseString("123456"));
    System.out.println(reverseStringWithRealJava("123456"));

    System.out.println(reverse("hello"));
  }
}
