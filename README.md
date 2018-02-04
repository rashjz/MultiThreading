
## Spring Test application 
##### * stored procedure call
##### * multithreading 

###### Testing static methods is like 
###### we prepare class for test @PrepareForTest(FileUtil.class) then using powermockito to when then return 

```java

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
    
    @Test
    public void voidMethod() throws Exception {
        FileUtil spy = PowerMockito.spy(new FileUtil());

        for (int i = 0; i < spy.getMaxConnection(); i++) {
            spy.getParentDirVoid( "test");
        }

        // verify that only configured number of connections will be created
        verify(spy, times(spy.getMaxConnection())).getParentDirVoid(Matchers.anyString());
    }
}

```


maven sonar integration
```xml
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
                <version>3.4.0.905</version>
            </plugin>

```

maven settings.xml file 

```xml
<settings>
    <pluginGroups>
        <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
    </pluginGroups>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
     </profiles>
</settings>
```