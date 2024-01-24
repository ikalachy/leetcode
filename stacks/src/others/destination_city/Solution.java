//package others.destination_city;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Solution {
//
//    public String destCity(List<List<String>> paths) {
//
//        Map<String, Integer> routes = new HashMap<>();
//        String result = null;
//
//        for (List<String> path : paths) {
//            String first = path.getFirst();
//            String last = path.getLast();
//
//            routes.compute(first, (k, v) -> routes.getOrDefault(k, 0) + 1);
//            routes.computeIfAbsent(last, (k) -> routes.getOrDefault(k, 0));
//        }
//
//        for (Map.Entry<String, Integer> entry : routes.entrySet()) {
//            if (entry.getValue().equals(0)  ) {
//                result = entry.getKey();
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Solution instance = new Solution();
////      [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//        List<List<String>> routes = List.of(
//                List.of("London", "New York"),
//                List.of("New York", "Lima"),
//                List.of("Lima", "Sao Paulo")
//        );
//
//        String result = instance.destCity(routes);
//        System.out.println("Result: " + result);
//
//
//    }
//
//
//}
