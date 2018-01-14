package rashjz.info.test.injectmocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import rashjz.info.app.injectmocks.*;

import static org.junit.Assert.assertEquals;

/**
 * @Mock annotation mocks the concerned object.

 @InjectMocks annotation allows to inject into the underlying object the different (and relevant) mocks created by @Mock.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private Player player;

    @InjectMocks
    Game game;

    @Test
    public void attackWithSwordTest() throws Exception {
        Mockito.when(player.getWeapon()).thenReturn("Sword");
        assertEquals("Player attack with: Sword", game.attack());
    }

}