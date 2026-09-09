class MyHashMap {

    int[] values;
    boolean[] exists;

    public MyHashMap() {
        values = new int[1000001];
        exists = new boolean[1000001];
    }

    public void put(int key, int value) {
        values[key] = value;
        exists[key] = true;
    }

    public int get(int key) {
        if (exists[key]) {
            return values[key];
        }

        return -1;
    }

    public void remove(int key) {
        exists[key] = false;
    }
}