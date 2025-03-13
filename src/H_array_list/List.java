package H_array_list;

// a very abbreviated version of java.util.List
public interface List<E> {
    int size();
    E get(int index);
    void add(int index, E element);
    boolean add(E e);
    void clear();
}
