package K_hash_table.A_jcf;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        System.out.println("demoing HashMap");
        Map<String, Integer> map1 = new HashMap<>();
        demo(map1);

        System.out.println("demoing LinkedHashMap");
        SequencedMap<String, Integer> map2 = new LinkedHashMap<>();
        demo(map2);
    }

    private static void demo(Map<String, Integer> map) {
        map.put("January", 31);
        map.put("February", 28);
        map.put("March", 31);
        System.out.println("map = " + map);
        System.out.println(map.get("March")); // 31
        System.out.println(map.put("February", 29)); // 28
        System.out.println("map = " + map);
        Set<String> keys = map.keySet();
        System.out.println("map's keys: " + keys);
        Collection<Integer> values = map.values();
        System.out.println("map's values: " + values);
        System.out.println();
    }
}
