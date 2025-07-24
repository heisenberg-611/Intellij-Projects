package AssignmentTasks.Task3;

public class RemoveConsecutiveDuplicates{
	
    // You have to write this method
    // YOU MUST SUBMIT THIS METHOD
    public static String removeConsecDups(String word) {
        if (word == null || word.length() == 0) return word;
        String neko = "";
        LinkedListQueue lineEdarao = new LinkedListQueue();
        char heru = word.charAt(0);
        lineEdarao.enqueue(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            char samprotic = word.charAt(i);
            if (samprotic != heru) {
                lineEdarao.enqueue(samprotic);
                heru = samprotic;
            }
        }
        while (!lineEdarao.isEmpty()) {
            neko += (char) lineEdarao.dequeue();
        }
        return neko;
    }
    
    //DO NOT CHANGE and DO NOT SUBMIT THIS METHOD
    public static void assertTest(Object actual, Object expected) {
	if( actual==null || !actual.equals(expected)){
            System.out.println("Test Failed! Expected: " + expected + ", but got: " + actual);
	} else {
            System.out.println("Test Success!!! Expected: " + expected + ", but got: " + actual);
        }
    }

    //DO NOT SUBMIT THE TESTER METHOD
    //DO NOT MODIFY THE MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Test 01");
        String string1 = "aabbbccccdd";
        String returned1 = removeConsecDups(string1);
        assertTest(returned1, "abcd");
        System.out.println("-----------------------------------------");

        System.out.println("Test 02");
        String string2 = "aaabbaa";
        String returned2 = removeConsecDups(string2);
        assertTest(returned2, "aba");
        System.out.println("-----------------------------------------");

        System.out.println("Test 03");
        String string3 = "abcabcabc";
        String returned3 = removeConsecDups(string3);
        assertTest(returned3, "abcabcabc");
        System.out.println("-----------------------------------------");

        System.out.println("Test 04");
        String string4 = "aaaaa";
        String returned4 = removeConsecDups(string4);
        assertTest(returned4, "a");
        System.out.println("-----------------------------------------");
    }
}
