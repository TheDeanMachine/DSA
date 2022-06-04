package Algorithms.Strings;

public class CharacterChecks {

    public static boolean isUppercase(String s) {
        return s.chars().allMatch(Character::isUpperCase); // using streams
    }

    public static boolean isLowercase(String s) {
        // s.chars().noneMatch(Character::isUpperCase); // another way to check same thing
        // s.chars().allMatch(c -> Character.isLowerCase(c)); // none method reference call
        return s.chars().allMatch(Character::isLowerCase);
    }

    public static void check(String string) {
        if(string.toLowerCase().equals(string)) {
            System.out.println(string);
        }
    }

    public static void numberCheck(String string) {
        if (string.chars().anyMatch(Character::isDigit)) {
            System.out.println("No numbers please!");
        }
    }

    public static String normalizeString(String s) {
        return s.toLowerCase().trim().replace(",", "");
    }


    public static void parseContents(String s) {
        System.out.println("Option 1");
        for (char c : s.toCharArray()) {
            System.out.print(c);
        }

        System.out.println();

        System.out.println("Option 2");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c);
        }
    }

    public static boolean isAtEvenIndex(String string, char item) {
        // edge case check
        if (string == null || string.isEmpty()) {
            return false;
        }

        for (int i = 0; i < string.length() / 2 + 1; i+=2) {
            if (string.charAt(i) == item) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        System.out.println(isUppercase("hello"));
        System.out.println(isUppercase("HELLO"));

        System.out.println(isLowercase("hello"));
        System.out.println(isLowercase("HELLO"));

        check("hello");
        check("HELLO");

        numberCheck("h3llo");
        numberCheck("hell0");


        System.out.println(normalizeString("   Hello There, BUDDY "));

        String s = "HeLLo";
        System.out.println(s.contains("LL"));

        parseContents(s);


        System.out.println(isAtEvenIndex(s, 'L'));
        System.out.println(isAtEvenIndex(s, 'T'));
        System.out.println(isAtEvenIndex(s, 'H'));
        System.out.println(isAtEvenIndex("", 'H'));
        System.out.println(isAtEvenIndex(null, 'H'));


    }

}
