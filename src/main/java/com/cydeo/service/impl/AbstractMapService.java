package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T, ID> {

    // we don't want to create an object from it. some can use it or not
    //why not interface - it will have implementation logic - method inside here

    protected Map<ID,T> map = new HashMap<>();

    T save(ID id, T object){   // T object - userDTO or roleDTO
        map.put(id, object);
        return object;
    }

    List<T> finAll() {
    return new ArrayList<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void update(ID id, T object){
        map.put(id, object);
    }


}
