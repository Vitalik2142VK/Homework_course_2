package sp.course2.homeworks_2.homework_14;

public class Main {
    public static void main(String[] args) {
        String[] arrStr = new String[]{"Hello ", "World ", "!"};
        ListString listString = new ArrayListString(arrStr, 10);
        listString.add("String.");
        listString.add("String_2.");
        listString.add(3, "4Element.");
        listString.set(3, "Other String");
        listString.remove("Other String");
        listString.remove(3);
    }
}
