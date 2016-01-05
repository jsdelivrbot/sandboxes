package PrimitiveTypes;

import java.util.*;

/**
 * Created by dustinstanley on 7/25/14.
 */
public class Generics {

    public static void main(String[] args) {
        Map<String, List<String>> test = newHashMap();
        union(new HashSet<String>(), new HashSet<String>());
        Collection<String> col = new ArrayList<String>();
        pushAll(col);
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static <K, V extends List<K>> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }


    public static void pushAll(Iterable<? extends String> src) {
        for (String e : src) {
            //bla
        }
    }
}
