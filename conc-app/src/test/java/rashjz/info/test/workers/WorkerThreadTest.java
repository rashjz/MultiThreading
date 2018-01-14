package rashjz.info.test.workers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rashjz.info.app.workers.WorkerThread;

public class WorkerThreadTest {
    @Mock
    private WorkerThread workerThread;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMockCreation(){
        assertNotNull(workerThread);

    }
}

