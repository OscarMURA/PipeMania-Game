package util;

public interface List {
    void addFirst(Object n);
    void addLast(Object n);
    Object search(Object key);
    void delete(Object key);
    Object get(int index);
}