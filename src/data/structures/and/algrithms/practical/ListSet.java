package data.structures.and.algrithms.practical;

import java.util.*;

/**
 * Edited by Warrick Wills - 13831575
 */

/* Question 2: Implement a Set abstract data type using singly linked lists
 */
public class ListSet<E> implements Iterable<E> {

    SinglyLinkedList<E> sl;

    public ListSet() {
        sl = new SinglyLinkedList<E>();
    }

    public void add(E e) {
        if (!contains(e)) {
            sl.add(e);
        }
    }

    public void clear() {
        sl.clear();
    }

    public void remove(E e) {
        sl.remove(e);
    }

    public int size() {
        return sl.size();
    }

    public boolean contains(E e) {
        if (sl.indexOf(e) != -1) {
            return true;
        } else {
            return false;
        }
    }

    //Complete the product method which outputs the Cartesian product of this and s
    //YOu must use the Tuple class that implements an ordered tuple
    public ListSet<Tuple<E>> product(ListSet<E> s) 
    {
        ////Write your code below
        Iterator<E> i = iterator();
        ListSet<Tuple<E>> last = new ListSet();
        while(i.hasNext())
        {
            Iterator<E> other = s.iterator();
            E e = i.next();
            while(other.hasNext())
            {
                Tuple<String> daTup = new Tuple(2);
                String[] tupRep = {e.toString(), other.next().toString()};
                daTup.set(tupRep);
                last.add((Tuple<E>) daTup);
            }
        }
        return last;
        ////Write your code above
    }

    public Iterator<E> iterator() {
        return sl.iterator();
    }

    //This method checks if this is a superset of the given set s1
    public boolean superset(ListSet<E> s1) 
    {
        ////Write your code below
        Iterator<E> i = s1.iterator();
        while(i.hasNext()) 
        {
            if(!contains(i.next())) 
                return false;
        }
        return true;
        ////Write your code above
    }

    //This method checks if this is a subset of the given set s2
    public boolean subset(ListSet<E> s2) 
    {
        return s2.superset(this);
    }

    //This method returns a String representing this set
    @Override
    public String toString() 
    {
        ////Write your code below
        String s = "";
        Iterator<E> i = iterator();
        
        s += "{";

        while(i.hasNext())
        {
            s += i.next();
            
            if(i.hasNext())
                s += ", ";
        }

        s += "}";
        
        return s;
        ////Write your code above
    }

    //This method returns the union of this and s 
    public ListSet<E> union(ListSet<E> s) 
    {
        ////Write your code below
        ListSet<E> list =  new ListSet();
        Iterator<E> i1 = iterator();
        Iterator<E> i2 = s.iterator();
            
        while(i1.hasNext() || i2.hasNext())
        {
            list.add(i1.next());
            list.add(i2.next());
        }
        
        return list;
        ////Write your code above
    }

    //This method returns the set difference of this versus s
    public ListSet<E> difference(ListSet<E> s) 
    {
        ////Write your code below
        ListSet<E> list =  new ListSet();
        Iterator<E> i1 = iterator();
        Iterator<E> i2 = s.iterator();
        
        while(i1.hasNext() || i2.hasNext())
        {
            list.remove(i1.next());
            list.remove(i2.next());
        }
        
        return list;
        ////Write your code above
    }

    //This method returns the intersection of this and s
    public ListSet<E> intersection(ListSet<E> s) {
        ////Write your code below
        ListSet<E> list = new ListSet();
        Iterator<E> i1 = s.iterator();

        while(i1.hasNext()) 
        {
            E temp = i1.next();
            
            if(contains(temp)) 
                list.add(temp);
        }
        
        return list;
        ////Write your code above
    }

    public boolean equals(ListSet<E> s) {
        return subset(s) && superset(s);
    }

    //You are not allowed to change the main method in anyway
    public static void main(String[] args) {
        ListSet<String> l1 = new ListSet<String>();
        char c = 'e';
        for (int i = 0; i < 7; i++) {
            l1.add("" + c);
            c++;
        }

        l1.remove("h");
        l1.remove("c");
        l1.add("e");
        l1.add("f");

        ListSet<String> l2 = new ListSet<String>();
        l2.add("e");
        l2.add("f");

        ListSet<String> l3 = new ListSet<String>();

        System.out.println("l1=" + l1 + " l2=" + l2 + " l3=" + l3);

        if (l1.superset(l2)) {
            System.out.println("l1 is a superset of l2");
        }
        if (l3.subset(l1)) {
            System.out.println("l3 is a subset of l1");
        }

        c = 'h';
        for (int i = 0; i < 6; i++) {
            l3.add("" + c);
            c++;
        }
        l2.clear();
        c = 'm';
        for (int i = 0; i < 6; i++) {
            l2.add("" + c);
            c--;
        }
        System.out.println("l2=" + l2 + " l3=" + l3);

        System.out.println("l1 union l3 is " + l1.union(l3));
        System.out.println("l1 intersect l3 is " + l1.intersection(l3));

        System.out.print("The elements in l1 are ");
        for (String s : l1) {
            System.out.print(" " + s);
        }
        System.out.print("\n");

        if (l2.equals(l3)) {
            System.out.println("l2 equals l3");
        }

        l2.clear();
        l2.add("0");
        l2.add("1");
        System.out.println(l1.product(l2));
    }

}
