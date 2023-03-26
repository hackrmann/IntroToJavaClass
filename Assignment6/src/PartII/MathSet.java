package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
    public Set<E> intersection(Set<E> s2) {
        Set<E> intersec = new HashSet<>(s2);
        intersec.retainAll(this);
        return intersec;
    }

    public Set<E> union(Set<E> s2) {
        Set<E> union = new HashSet<>(s2);
        union.addAll(this);
        return union;
    }

    public <T> Set<Pair<E, T>> cartesianProduct(Set<T> s2) {
        E[] arr1 = (E[]) this.toArray();
        T[] arr2 = (T[]) s2.toArray();
        Set<Pair<E, T>> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                set.add(new Pair<>(arr1[i],arr2[j]));
            }
        }
        return set;
    }


    public static void main(String[] args) {
        // create two MathSet objects of the same type.
        // See if union and intersection works.

        // create another MathSet object of a different type
        // calculate the cartesian product of this set with one of the
        // above sets
        MathSet<Integer> s1 = new MathSet<Integer>();
        s1.add(5);
        s1.add(7);
        s1.add(9);
        MathSet<Integer> s2 = new MathSet<Integer>();
        s2.add(5);
        s2.add(7);
        s2.add(4);
        s2.add(6);
        s2.add(8);
        System.out.println(s1.intersection(s2));
        System.out.println(s1.union(s2));

        System.out.println(s1.cartesianProduct(s2));

    }
}
