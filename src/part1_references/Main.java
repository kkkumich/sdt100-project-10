package part1_references;

class Box { public int value; }
public class Main {
    static void change(Box box){box.value=99;} // Reference value is copied; both references point to the same object.
    static void reassign(Box box){box=new Box();box.value=-1;} // Reassigning the local parameter does not reassign the caller.
    public static void main(String[] args) {
        Box first=new Box();Box second=first;first.value=10;
        System.out.println("After first.value=10: "+first.value+", "+second.value);
        second.value=20;System.out.println("After second.value=20: "+first.value+", "+second.value);
        change(first);System.out.println("After mutation in method: "+first.value+", "+second.value);
        reassign(first);System.out.println("After local reassignment: "+first.value+", "+second.value);
        System.out.println("Same object: "+(first==second));
    }
}
