package com.sparta.george.sorters;

import com.sparta.george.Starter;

public class SorterFactory {
    public Sorter getSorter(Starter.SortTypes sortType){
        if(sortType == null){
            return null;
        }
        if(sortType.equals(Starter.SortTypes.BUBBLE)){
            return new BubbleSort();
        } else if(sortType.equals(Starter.SortTypes.MERGE)){
            return new MergeSort();
        }
        return null;
    }
}
