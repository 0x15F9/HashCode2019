import java.util.*;
/**
 * test
 */
public class test {

    public static void main(String[] args) {
        testImageCreate();
        operationsTests();
    }

    public static void testImageCreate() {
        Image im = new Image("5", "H 3 cat beach sun");
        System.out.println(im.toString());
    }

    public static void operationsTests() {
        Set<String> a = new HashSet<String>();
        Set<String> b = new HashSet<String>();
        a.add("cat");
        a.add("beach");
        a.add("sun");
        a.add("dog");
        
        b.add("garden");
        b.add("cat");
        b.add("rain");
        b.add("dog");
        System.out.println("a: "+a.toString());
        System.out.println("b: "+b.toString());

        System.out.println("Union: "+ Operations.union(a, b).toString());
        System.out.println("Inter: "+ Operations.intersection(a, b).toString());
        System.out.println("a-b  : "+ Operations.a_b(a, b).toString());
        System.out.println("b-a  : "+ Operations.b_a(a, b).toString());
        System.out.println("min  : "+ Operations.minInterest(a, b));
    }
}