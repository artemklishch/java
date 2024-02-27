//class Pair<K extends Integer, V extends String> {
//    private K key;
//    private V value;
//
//    public Pair(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//
//    @Override
//    public boolean equals(Object pair) {
//        if (pair == this) {
//            return true;
//        }
//        if (pair == null || !(pair.getClass().equals(Pair.class))) {
//            return false;
//        }
//        Pair current = (Pair) pair;
//        if (current.hashCode() == this.hashCode()) {
//            return true;
//        }
//        return current.key == this.key
//                && this.value.equals(current.value);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + (key != null ? key : 0);
//        result = 31 * result + (value != null ? value.hashCode() : 0);
//        return result;
//    }
//}
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object pair) {
        if (pair == this) {
            return true;
        }
        if (pair == null || !(pair.getClass().equals(Pair.class))) {
            return false;
        }
        Pair current = (Pair) pair;
        if (current.hashCode() == this.hashCode()) {
            return true;
        }
        return current.key == this.key
                && this.value.equals(current.value);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}