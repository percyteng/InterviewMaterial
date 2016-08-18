package interviewGoogle;

import java.util.Comparator;
//1) Comparator in Java is defined in java.util package while Comparable interface in Java is defined in java.lang package, which very much says that Comparator should be used as an utility to sort objects which Comparable should be provided by default.
//
//2) Comparator interface in Java has method public int compare (Object o1, Object o2) which returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second. While Comparable interface has method public int compareTo(Object o) which returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
//
//
//3) If you see then logical difference between these two is Comparator in Java compare two objects provided to him, while Comparable interface compares "this" reference with the object specified. I have shared lot of tips on how to override compareTo() method and avoid some common mistakes programmer makes while implementing Comparable interface.
//
//4) Comparable in Java is used to implement natural ordering of object. In Java API String, Date and wrapper classes implements Comparable interface.Its always good practice to override compareTo() for value objects.
//
//5) If any class implement Comparable interface in Java then collection of that object either List or Array can be sorted automatically by using  Collections.sort() or Arrays.sort() method and object will be sorted based on there natural order defined by CompareTo method.




/**
 * Comparator implementation which sorts Person objects on person_id field
 */
public class ComparatorSortByPerson_ID implements Comparator{

    public int compare(Object o1, Object o2) {
        ComparablePerson p1 = (ComparablePerson) o1;
        ComparablePerson p2 = (ComparablePerson) o2; 
        return p1.getPersonId() - p2.getPersonId();
    }
}
