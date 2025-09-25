import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericListTest {
    static GenericQueue<Integer> current;
    static GenericQueue<Integer> testLink;
    //    static Node testLink;
    //    static Node testlink2;
    @BeforeAll
    static void setUp(){
        current =  new GenericQueue(0);
        testLink = new GenericQueue(0);
//        GenericList.Node current = testLink.getHead();
//        GenericList<Integer> testLink2;
    }

    @Test
    void similarityTest(){
//        GenericList<Integer> current;
        current.setHead(null);
        assertEquals(null, current.getHead(), "testLink is supposed to be empty");

        current.add(1);
        current.add(2);

        testLink.add(1);
        testLink.add(2);

        GenericList.Node temp = testLink.getHead();
        GenericList.Node cTemp = current.getHead();
        while(temp.next != null){
            assertEquals(temp.data, cTemp.data, "Looks like the values are different");
            temp = temp.next;
            cTemp = cTemp.next;
        }



    }

    @Test
    void SetAndGetLengthTest(){

        testLink.add(1);
        testLink.add(2);
        testLink.add(3);
        testLink.add(4);
        testLink.add(5);

        assertEquals(7,testLink.getLength(),"The lengths are different. (Test 1)");

        testLink.setLength(10);
        assertEquals(10,testLink.getLength(),"The lengths are different. (Test 2)");
        testLink.setLength(5);
        assertEquals(5,testLink.getLength(),"The lengths are different. (Test 3)");


    }
}
