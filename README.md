
## Spring Test application 
##### * stored procedure call
##### * multithreading 

###### Testing static methods is like 
###### we prepare class for test @PrepareForTest(FileUtil.class) then using powermockito to when then return 




import com.rashjz.app.FileUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtil.class)
public class FileUtilTest {

    @Test
    public void shouldCalculateInAStrangeWay() {
        PowerMockito.mockStatic(FileUtil.class);
        try {
            PowerMockito.when(FileUtil.getParentDir(path + "\\log4j.xml")).thenReturn(path);
            String actual = FileUtil.getParentDir(path + "\\log4j.xml");

            verifyStatic();

            assertEquals(path, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
