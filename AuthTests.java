package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuthTests {
    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    void testWrongCredentials() {
        Page page = browser.newPage();
        page.navigate("https://dev2.getinfo.radugi.net");
        page.fill("input[name=email]", "wrong@example.com");
        page.fill("input[name=password]", "wrongpass");
        page.click("button[type=submit]");
        assertTrue(page.locator(".error").textContent().contains("Неверный логин или пароль"));
        page.close();
    }

    @Test
    void testLoginSuccess() {
        Page page = browser.newPage();
        page.navigate("https://dev2.getinfo.radugi.net");
        page.fill("input[name=email]", "dumbledore@sct.team");
        page.fill("input[name=password]", "12345678qQ1");
        page.click("button[type=submit]");
        page.waitForURL("**/dashboard");
        assertTrue(page.url().contains("dashboard"));
        page.close();
    }
}
