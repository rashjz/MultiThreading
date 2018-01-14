package rashjz.info.test.api;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import rashjz.info.app.api.LoginController;
import rashjz.info.app.api.LoginDao;
import rashjz.info.app.api.LoginService;
import rashjz.info.app.api.UserForm;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    private LoginDao loginDao;

    @Spy
    @InjectMocks
    private LoginService spiedLoginService;

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @Before
    public void setUp() {
//        loginController = new LoginController();
        //you can setup with this or  @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertThatNoMethodHasBeenCalled() {
        loginController.login(null);
        Mockito.verifyZeroInteractions(loginService);
    }

    @Test
    public void assertTwoMethodsHaveBeenCalled() {
        System.out.println("'''əəəəəəə");

        UserForm userForm = new UserForm();
        userForm.username = "foo";
        Mockito.when(loginService.login(userForm)).thenReturn(true);

        String login = loginController.login(userForm);

        Assert.assertTrue(loginService.login(userForm));
        Assert.assertEquals("OK", login);

        Mockito.verify(loginService, atLeast(2)).login(userForm);
//        Mockito.verify(loginService).setCurrentUser("foo");
        Mockito.verify(loginService).setCurrentUser(argThat(
                new Matcher<String>() {
                    @Override
                    public boolean matches(Object item) {
                        return item.equals("foo");
                    }

                    @Override
                    public void describeMismatch(Object item, Description mismatchDescription) {

                    }

                    @Override
                    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

                    }

                    @Override
                    public void describeTo(Description description) {

                    }
                }
        ));



    }

    @Test
    public void assertOnlyOneMethodHasBeenCalled() {
        UserForm userForm = new UserForm();
        userForm.username = "foo";
        Mockito.when(loginService.login(userForm)).thenReturn(false);

        String login = loginController.login(userForm);

        Assert.assertEquals("KO", login);
        Mockito.verify(loginService).login(userForm);
        Mockito.verifyNoMoreInteractions(loginService);
    }
}