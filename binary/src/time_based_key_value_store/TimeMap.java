package time_based_key_value_store;

import java.util.*;
import java.util.List;

class TimeMap {

    private final Map<String, List<TimeValue>> cache;

    public TimeMap() {
        cache = new HashMap<>( 120_000);
    }

    public void set(String key, String value, int timestamp) {
        List<TimeValue> values = cache.getOrDefault(key, new ArrayList<TimeValue>(10000));
        values.add(new TimeValue(value, timestamp));
        cache.put(key, values);
    }

    public String get(String key, int timestamp) {
        List<TimeValue> timeValues = cache.get(key);
        if (timeValues == null) return "";

        timeValues.sort(Comparator.comparingInt(TimeValue::timestamp));

        int left = 0, right = timeValues.size() - 1;
        int latest = -1;
        // 1 2 3 4 5 6  ll-3 kk-4 hig-5  low-6  hig-7 low-8
        while (left <= right) {
            int mid = (left + right) / 2;
            if (timeValues.get(mid).timestamp() == timestamp) {
                return timeValues.get(mid).value();
            }

            if (timestamp > timeValues.get(mid).timestamp()) {
                latest = Math.max(latest, left);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }


        return latest != -1 ? timeValues.get(latest).value : "Empty";
    }

    record TimeValue(String value, int timestamp) {
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */