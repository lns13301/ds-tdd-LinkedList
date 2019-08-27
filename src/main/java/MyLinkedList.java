import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyLinkedList<E> implements List<E> {
    private int size;
    private Node<E> tail;
    private Node<E> head;

    public MyLinkedList() {
        this.size = 0;
        this.tail = null;
        this. head = null;
    }
    class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
        public String toString() {
            return (String)this.data;
        }
    }

    public Node<E> getNode(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        int previousSize = size;
        if(size == 0){
            head = new Node<>(e, head);
        }
        else {
            Node<E> node = new Node<>(e);
            tail = node.next;
            getNode(size - 1).next = node;
        }
        size++;
        return previousSize + 1 == size;
    }

    @Override
    public boolean remove(Object element) {
        int previousSize = size;

        for(int i = 0; i < size; i++){
            if(getNode(i).data.equals(element)){
                getNode(i-1).next = getNode(i).next;
                size--;
            }
        }
        return previousSize == size - 1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = true;
        for(E element : c){
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int previousSize = size;
        for(E element : c){
            add(index++, element);
        }
        return size == previousSize - c.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = true;
        for(Object element : c){
            remove(element);
        }
        return flag;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E)getNode(index).data;
    }

    @Override
    public E set(int index, E element) {
        getNode(index).data = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node;
        node = getNode(index - 1);
        node. next = new Node<>(element, node.next);
        size++;
    }

    @Override
    public E remove(int index) {
        getNode(index-1).next = getNode(index).next;
        return getNode(index).data;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }
}
