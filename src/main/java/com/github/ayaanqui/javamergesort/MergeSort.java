package com.github.ayaanqui.javamergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {
    private List<T> list;

    public MergeSort(List<T> list) {
        this.list = list;
    }

    public List<T> merge(List<T> l1, List<T> l2) {
        if (l1 == null || l2 == null)
            return (l1 == null) ? l2 : l1;

        List<T> mergedList = new ArrayList<>();
        int len = (l1.size() > l2.size()) ? l2.size() : l1.size();

        int i;
        for (i = 0; i < len; i++) {
            if (l1.get(i).compareTo(l2.get(i)) < 0) {
                mergedList.add(l1.get(i));
                mergedList.add(l2.get(i));
            } else {
                mergedList.add(l2.get(i));
                mergedList.add(l1.get(i));
            }
        }

        if (l1.size() > l2.size())
            mergedList.add(l1.get(i));
        else if (l2.size() > l1.size())
            mergedList.add(l2.get(i));
        return mergedList;
    }

    public List<T> divide(List<T> sublist) {
        if (sublist.size() == 1)
            return sublist;

        final int size = sublist.size();
        return merge(divide(sublist.subList(0, size / 2)), divide(sublist.subList(size / 2, size)));
    }

    public List<T> sort() {
        return divide(this.list);
    }
}
