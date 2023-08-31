package com.dsaninja.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 */
class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> loc;
    private final Random random = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        loc = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        loc.add(val);
        map.put(val, loc.size()-1);
        return true;
    }

    /**
     * <ol>
     *     <li>get current index</li>
     *     <li>add last list element on index</li>
     *     <li>update map for the index details</li>
     *     <li>remove last list element</li>
     * </ol>
     *
     * @param val to be removed
     * @return true if removed, false otherwise
     */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int lastValue = loc.get(loc.size()-1);

            loc.set(index, lastValue);
            map.put(lastValue, index);

            loc.remove(loc.size()-1);
            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        int index = random.nextInt(loc.size());
        return loc.get(index);
    }
}