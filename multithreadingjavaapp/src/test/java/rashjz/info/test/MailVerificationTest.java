package rashjz.info.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rashjz.info.app.MailVerification;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class MailVerificationTest {
    List<String> mails = new ArrayList<>();
    @Autowired
    private MailVerification mailVerification;

    @Test
    public void testMails() throws Exception {
        mails.add("rashjz.info@mail.com");
        mails.add("rashjz.info@com");


        assertNotNull(mailVerification);
        for (String mail : mails) {
            System.out.println(mailVerification.validate(mail));
            assertTrue(mailVerification.validate(mail));
        }
    }
}
