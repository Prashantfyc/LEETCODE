class TimeMap {

    class Data {
        String value;
        int time;

        Data(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    HashMap<String, ArrayList<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Data> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;

        String answer = "";

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid).time <= timestamp) {

                answer = list.get(mid).value;

                // This timestamp works.
                // Try to find a later one.
                low = mid + 1;

            } else {

                // Timestamp is too big.
                high = mid - 1;
            }
        }

        return answer;
    }
}