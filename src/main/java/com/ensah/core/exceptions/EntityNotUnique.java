package com.ensah.core.exceptions;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
public class EntityNotUnique extends RuntimeException {
    public EntityNotUnique(Class clazz, String searchParams) {
        super(EntityNotUnique.generateMessage(clazz.getSimpleName(), searchParams));
    }
    
    
    private static String generateMessage(String entity, String searchParams) {
        return searchParams + " of " + entity+
                " already exists in the database";
    }
    
//    private static <K, V> Map<K, V> toMap(
//            Class<K> keyType, Class<V> valueType, Object... entries) {
//        if (entries.length % 2 == 1)
//            throw new IllegalArgumentException("Invalid entries");
//        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
//                .collect(HashMap::new,
//                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
//                        Map::putAll);
//    }
    
}
