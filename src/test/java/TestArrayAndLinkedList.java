import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class TestArrayAndLinkedList {

    @DataProvider(name = "provideListImpl")
    public Object[] provideData() {

        return new Object[]{new ArrayList<>(),
                new LinkedList<>()};

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
    public static void testIteratorThrowsConcurrentModificationException(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        Iterator iterator = list.iterator();
        boolean flag = false;
        try {
            while (iterator.hasNext()) {
                iterator.next();
                list.add("Y");
            }
        } catch (ConcurrentModificationException e) {
            flag = true;
        }

        // then
        assert flag : "ConcurrentModificationException not thrown";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testLastIndexOf(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("B");
        list.add("E");

        // when
        int resultIndex = list.lastIndexOf("E");

        // then
        assert resultIndex == 5 : "Expected different last index of specified element";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testLastIndexOfMethodForNotExistingElement(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");


        // when
        int resultIndex = list.lastIndexOf("E");

        // then
        assert resultIndex == -1 : "Unexpected element found on list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testLastIndexOfEmptyList(List list) {
        //given

        // when
        int resultIndex = list.lastIndexOf("X");

        // then
        assert resultIndex == -1 : "List is empty. Non index should be found";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testListIterator(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        //when
        ListIterator iterator = list.listIterator();

        // then

        assert iterator instanceof ListIterator : "Unexpected class instance";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testListIteratorForSelectedIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        ListIterator iterator = list.listIterator(2);

        // then
        assert iterator instanceof ListIterator : "Unexpected class instance";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testListIteratorForIndexOutOfBound(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean flag = false;
        try {
            list.listIterator(4);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        // then
        assert flag : "IndexOutOfBoundsException not thrown";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRemoveElementAtSpecifiedIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        list.remove(2);

        // then
        assert list.size() == 2 : "Wrong size of list";
        assert list.get(1).equals("B") : "Unexpected element at specified index";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRemoveForIndexOutOfBound(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean flag = false;
        try {
            list.remove(4);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }


        // then
        assert flag : "IndexOutOfBoundsException not thrown";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRemoveSpecifiedObject(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean result = list.remove("B");

        // then
        assert list.size() == 2 : "Unexpected list size";
        assert result : "Unexpected remove method result";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRemoveNotExistingObjectOnList(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean result = list.remove("X");

        // then
        assert list.size() == 3 : "Unexpected list size";
        assert !result : "Unexpected remove method result";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRemoveAllElementFromListContainedInOtherCollection(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        List elementsToRemove = Arrays.asList("A", "C");

        // when
        boolean result = list.removeAll(elementsToRemove);

        // then
        assert list.size() == 1 : "Unexpected list size";
        assert result : "Unexpected remove method result";
    }


    @Test(dataProvider = "provideListImpl")
    public static void testRemoveAllForTwoDifferentLists(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        List elementsToRemove = Arrays.asList("X", "Y");

        // when
        boolean result = list.removeAll(elementsToRemove);

        // then
        assert list.size() == 3 : "Unexpected list size";
        assert !result : "Unexpected remove method result";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testReplaceAll(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        List controlList = Arrays.asList("AX", "BX", "CX");

        // when
        list.replaceAll(element -> element = element.toString() + "X");

        // then
        assert list.equals(controlList) : "Wrong replacement";
        assert list.size() == 3 : "Unexpected size";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRetainAll(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        List controlList = Arrays.asList("B");

        // when
        boolean result = list.retainAll(controlList);


        // then
        assert result : "Unexpected method result";
        assert list.size() == 1 : "Unexpected list size";
        assert list.get(0).equals("B") : "Unexpected object on list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testRetainAllDoesNotModifyList(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");
        List controlList = Arrays.asList("A", "B", "C");

        // when
        boolean result = list.retainAll(controlList);


//        // then
        assert !result : "Expected list is unmodified";
        assert list.size() == 3 : "Unexpected list size";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testSetToExistingIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        list.set(0, "Y");

        // then
        assert list.get(0).equals("Y") : "Unexpected element at specified index";
        assert list.size() == 3 : "Wrong size of list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testSetToNotExistingIndex(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        boolean flag = false;
        try {
            list.set(5, "Y");
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        // then
        assert flag : "IndexOutOfBoundsException not thrown";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testSizeOfList(List list) {
        //given
        list.add("A");
        list.add("B");
        list.add("C");

        // when
        int result = list.size();

        // then
        assert result == 3 : "Unexpected size of list";
    }

    @Test(dataProvider = "provideListImpl")
    public static void testSort(List list) {
        //given
        list.add("B");
        list.add("F");
        list.add("A");
        list.add("H");
        List controlList = Arrays.asList("A", "B", "F", "H");

        Comparator listComparator = (o1, o2) -> o1.toString().compareTo(o2.toString());

        // when
        list.sort(listComparator);

        // then
        assert list.equals(controlList) : "List has been sorted wrong";
    }

//    @Test(dataProvider = "provideListImpl")
//    public static void testSpliterator(List list){
//        //given
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        // when
//        Spliterator spliterator=list.spliterator();
//
//        // then
//        assert :"";
//    }


}
