package com.eopi.exercises.heaps;

import java.util.*;

public class Exercise10_1 {

    /**
     * Calculates the union of the given lists of sorted integers and returns it, also in sorted order.
     */
    static List<Integer> computeUnion(List<List<Integer>> listsToCombine) {

        //Create a min-heap with the size equal to the number of lists.  We will store on the heap
        //the minimum value that has not yet been processed for each of the given lists
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(listsToCombine.size(),
                Comparator.comparingInt(entry -> entry.value));

        List<Iterator<Integer>> iterators = new ArrayList<>();
        for (List<Integer> list : listsToCombine) {
            iterators.add(list.iterator());
        }

        //Initialize the heap by adding the smallest entry from each list
        for (int i = 0; i < iterators.size(); i++) {
            minHeap.add(new ArrayEntry(iterators.get(i).next(), i));
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            //Remove the smallest entry from the heap, which corresponds to the smallest item of the union of all available
            //lists that has yet to be processed.
            ArrayEntry entry = minHeap.poll();

            //Add the item to the result set
            result.add(entry.value);

            //Retrieve and add to the heap the next-smallest item from the same sublist as entry we just removed
            //from the heap.  If the sublist contains no more entries, then skip this part as we are done processing
            //that sublist.
            if (iterators.get(entry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iterators.get(entry.arrayId).next(), entry.arrayId));
            }
        }

        return result;
    }
}
