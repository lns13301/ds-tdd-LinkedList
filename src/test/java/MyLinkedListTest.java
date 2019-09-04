import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLinkedListTest {

    private MyLinkedList myLinkedList = new MyLinkedList();

    @Before
    public void init() {
        myLinkedList.add("element0");
        myLinkedList.add("element1");
        myLinkedList.add("element2");
        myLinkedList.add("element3");
    }

    @Test
    public void testMyLinkedListCreated() {
        assertThat(myLinkedList).isNotNull();
        assertThat(myLinkedList).isNotNull();
    }

    @Test
    public void testMyLinkedListAdd() {
        assertThat(myLinkedList.size()).isEqualTo(4);
    }

    @Test
    public void testMyLinkedListGet() {
        for(int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
    }

    @Test
    public void testMyLinkedListAddIndex() {
        myLinkedList.add(2, "element1.5");
        assertThat(myLinkedList.get(2)).isEqualTo("element1.5");
        assertThat(myLinkedList.get(4)).isEqualTo("element3");
    }

    @Test
    public void testMyLinkedListAddAll() {
        List addList = new LinkedList();
        addList.add("specialElement1");
        addList.add("specialElement2");
        myLinkedList.addAll(addList);
        assertThat(myLinkedList.size()).isEqualTo(6);
    }

    @Test
    public void testMyLinkedListAddAllIndex() {
        List addList = new LinkedList();
        addList.add("specialElement1");
        addList.add("specialElement2");
        myLinkedList.addAll(2,addList);
        assertThat(myLinkedList.size()).isEqualTo(6);
        assertThat(myLinkedList.get(3)).isEqualTo("specialElement2");
        assertThat(myLinkedList.get(4)).isEqualTo("element2");
    }

    @Test
    public void testMyLinkedListRemove() {
        myLinkedList.remove("element1");
        assertThat(myLinkedList.size()).isEqualTo(3);
        assertThat(myLinkedList.get(1)).isEqualTo("element2");
        myLinkedList.remove(1);
        assertThat(myLinkedList.get(1)).isEqualTo("element3");
    }

    @Test
    public void testMyLinkedListRemoveAll() {
        List removeList = new LinkedList();
        assertThat(myLinkedList.size()).isEqualTo(4);
        removeList.add("element1");
        removeList.add("element2");
        assertThat(removeList.size()).isEqualTo(2);
        myLinkedList.removeAll(removeList);
        assertThat(myLinkedList.size()).isEqualTo(2);
        assertThat(myLinkedList.get(1)).isEqualTo("element3");
    }

    @Test
    public void testMyLinkedListRemoveFirst() {
        myLinkedList.removeFirst();
        myLinkedList.removeFirst();
        assertThat(myLinkedList.get(0)).isEqualTo("element2");
        assertThat(myLinkedList.size()).isEqualTo(2);
    }

    @Test
    public void testMyLinkedListRemoveLast() {
        myLinkedList.removeLast();
        myLinkedList.removeLast();
        assertThat(myLinkedList.size()).isEqualTo(2);
    }
}