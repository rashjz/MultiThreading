package rashjz.info.test.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import rashjz.info.app.util.FileUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtil.class)
public class FileUtilTest {
    String path = "C:\\Users\\Rashad\\Desktop\\JavaMultiThreading\\multithreadingjavaapp";


    @Test
    public void getParentDirStaticTest() {
        PowerMockito.mockStatic(FileUtil.class);
        try {

            PowerMockito.when(FileUtil.getParentDir(path + "\\pom.xml")).thenReturn(path);
            String actual = FileUtil.getParentDir(path + "\\pom.xml");

            verifyStatic();

            assertEquals(path, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void voidMethodTest() throws Exception {
        FileUtil spy = PowerMockito.spy(new FileUtil());

        for (int i = 0; i < spy.getMaxConnection(); i++) {
            spy.getParentDirVoid(path);
        }
        // verify that only configured number of connections will be created
        verify(spy, times(spy.getMaxConnection())).getParentDirVoid(Matchers.anyString());
    }


    @Test
    public void getPrivateHashOfMaxConnTest(){
        FileUtil fileUtil = PowerMockito.mock(FileUtil.class);

//        FileUtil tested = createPartialMock(FileUtil.class, "getPrivateHashOfMaxConn");

    }



}


