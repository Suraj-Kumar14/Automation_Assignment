public class StringOperations 
{
    public static void main(String[] args) {

        String str = "  Hello World Java  ";
        String str2 = "Hello World Java";

        // length()
        System.out.println("Length: " + str.length());

        // isEmpty()
        System.out.println("Is Empty: " + str.isEmpty());

        // charAt()
        System.out.println("Character at index 1: " + str.charAt(1));

        // toString()
        System.out.println("To String: " + str.toString());

        // equals()
        System.out.println("Equals: " + str.equals(str2));

        // compareTo()
        System.out.println("Compare To: " + str.compareTo(str2));

        // contains()
        System.out.println("Contains 'World': " + str.contains("World"));

        // indexOf()
        System.out.println("Index Of 'o': " + str.indexOf('o'));

        // lastIndexOf()
        System.out.println("Last Index Of 'o': " + str.lastIndexOf('o'));

        // startsWith()
        System.out.println("Starts With '  He': " + str.startsWith("  He"));

        // endsWith()
        System.out.println("Ends With 'Java  ': " + str.endsWith("Java  "));

        // matches()
        System.out.println("Matches regex: " + str.trim().matches("Hello.*Java"));

        // substring()
        System.out.println("Substring (2 to 7): " + str.substring(2, 7));

        // toLowerCase()
        System.out.println("Lowercase: " + str.toLowerCase());

        // trim()
        System.out.println("Trimmed: '" + str.trim() + "'");

        // replace()
        System.out.println("Replace: " + str.replace("Java", "Programming"));

        // split()
        String[] words = str.trim().split(" ");
        System.out.println("Split:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", words);
        System.out.println("Joined: " + joined);

        // valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("Value Of: " + numStr);
    }
}
