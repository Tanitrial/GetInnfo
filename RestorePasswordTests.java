package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RestorePasswordTests {
    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }

    @Test
    void testRestorePasswordLinkExists() {
        Page page = browser.newPage();
        page.navigate("https://dev2.getinfo.radugi.net");
        assertTrue(page.locator("text=Забыли пароль").isVisible());
        page.close();
    }
}
