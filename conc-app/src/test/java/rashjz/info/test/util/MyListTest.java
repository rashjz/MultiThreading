package rashjz.info.test.util;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import rashjz.info.app.util.MyList;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyListTest {
    @Mock
    MyList myList;

    @Before
    public void setUp() {

    }

    @Test
    public void testMyListMethods() {
        Assert.assertNotNull(myList);
//        when(myList.add(anyString())).thenReturn(false);
        when(myList.add(anyString())).then(invocation -> false);



        Assert.assertFalse(myList.add(anyString()));

        myList.add(randomAlphabetic(6));
        verify(myList, times(2)).add(anyString());
    }
}
