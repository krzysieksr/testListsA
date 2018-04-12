import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class TestArrayAndLinkedList {

    @DataProvider(name = "provideListImpl")
    public Object[] provideData() {

        return new Object[]{new ArrayList<String>(),
                new LinkedList<String>()};

    }

    @Test(dataProvider = "provideListImpl")
    public static void testAdd(List list) {

        // when
        list.add("A");
        list.add("B");

        // then
        Assert.assertEquals(list.get(0), "A");
        Assert.assertEquals(list.get(1), "B");
        Assert.assertEquals(list.size(), 2);
    }

    @Test(dataProvider = "provideListImpl")
    public static void testAddAtIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        list.add(1, "Z");

        // then
        Assert.assertEquals(list.get(1), "Z");
        Assert.assertEquals(list.size(), 4);
    }

    @Test(dataProvider = "provideListImpl", expectedExceptions = {IndexOutOfBoundsException.class})
    public static void testAddAtIndexOutOfBound(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when and then

        list.add(4, "X");

    }

    @Test(dataProvider = "provideListImpl")
    public static void testAddAll(List list) {
        //given
        list.add("X");
        list.add("Y");

        // when
        List<String> strings = Arrays.asList("A", "B", "C");
        list.addAll(strings);

        // then
        Assert.assertEquals(list.size(), 5);
        Assert.assertEquals(list.get(2), "A");
    }


    @Test(dataProvider = "provideListImpl")
    public static void testAddAllForNull(List list) {
        //given
        list.add("X");
        list.add("Y");


        //when and then
        boolean flag = false;
        try {
            list.addAll(null);
        } catch (NullPointerException e) {
            flag = true;
        }

        assert flag : "NullPointerException not thrown";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testAddAllFromSpecifiedIndex(List list) {
        //given
        list.add("X");
        list.add("Y");

        // when
        List<String> strings = Arrays.asList("A", "B", "C");
        list.addAll(2, strings);

        // then
        assert list.size() == 5 : "Wrong size of list";
        assert list.get(2).equals("A") : "Wrong argument at 2nd index";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testClear(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        list.clear();

        // then
        assert list.isEmpty() : "List is not empty";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testContains(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when and then
        assert list.contains("B") : "List does not contain expected element";
        assert !list.contains("X") : "List contains unexpected element";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testContainsAll(List list) {
        //given
        list.add("A");
        list = Arrays.asList("A", "B", "C", "D");
        List list1 = Arrays.asList("A", "B");

        // when and then
        assert list.containsAll(list1) : "List doesn't contain another list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testListDoesNotContainAllOtherList(List list) {
        //given
        list.add("A");
        list = Arrays.asList("A", "B", "C", "D");
        List list1 = Arrays.asList("X", "Y");

        // when and then
        assert !list.containsAll(list1) : "List contains unexpected list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testEqualsLists(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        List list1 = Arrays.asList("A", "B", "C");
        // when and then
        assert list.equals(list1) : "Lists are not equals";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testNotEqualsLists(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        List list1 = Arrays.asList("X", "Y", "Z");
        // when and then
        assert !list.equals(list1) : "List should not be equal";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testGetMethodForExistingIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when and then
        assert list.get(1).equals("B") : "Wrong returned element";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testGetMethodForIndexOutOfBound(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean flag = false;
        try {
            list.get(4);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        //then
        assert flag : "Unexpected element";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testHashCodesAreTheSame(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        List list1 = Arrays.asList("A", "B", "C");


        // when
        int hashCodeList = list.hashCode();
        int hashCodeList1 = list1.hashCode();

        // then
        assert hashCodeList == hashCodeList1 : "Hash codes are not the same";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testHashCodesAreDifferent(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        List list1 = Arrays.asList("A", "B", "C", "X");

        // when
        int hashCodeList = list.hashCode();
        int hashCodeList1 = list1.hashCode();

        // then
        assert hashCodeList != hashCodeList1 : "Hash codes should be different";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testIndexOfExistingElement(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        int index = list.indexOf("B");

        // then
        assert index == 1 : "Wrong index returned";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testIndexOfNotExistingElement(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        int index = list.indexOf("X");

        // then
        assert index == -1 : "Unexpected index returned";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testIndexOfNull(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        int index = list.indexOf(null);

        // then
        assert index == -1 : "Unexpected index returned";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testIsEmpty(List list) {
        // then
        assert list.isEmpty() : "List should be empty";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testIsNotEmpty(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // then
        assert !list.isEmpty() : "List should not be empty";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testIteratingListContainingElements(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        Object[] resultArray = new Object[3];
        int counter = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            resultArray[counter] = iterator.next();
            counter++;
        }


        // then
        assert counter == 3 : "Wrong amount of iteration";
        assert resultArray[1].equals("B") : "unexpected element";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testIteratorThrowsConcurrentModificationException(){
        //given


        // when

        // then
        assert :"";
    }


}
