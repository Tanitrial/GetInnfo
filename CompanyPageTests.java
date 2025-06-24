package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyPageTests {
    static Playwright playwright;
    static Browser browser;
    static Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        login();
    }

    static void login() {
        page.navigate("https://dev2.getinfo.radugi.net");
        page.fill("input[name=email]", "dumbledore@sct.team");
        page.fill("input[name=password]", "12345678qQ1");
        page.click("button[type=submit]");
        page.waitForURL("**/dashboard");
    }

    @AfterAll
    static void teardown() {
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    void testCompanyPageVisible() {
        page.click("text=Компания");
        page.waitForSelector("h1");
        assertTrue(page.locator("h1").textContent().contains("Компания"));
    }

    @Test
    void testUserIsManager() {
        page.click("text=Компания");
        String manager = page.locator("text=Руководитель").nth(0).textContent();
        String currentUser = page.locator("header >> text=Dumbledore").textContent();
        assertTrue(manager.contains("Dumbledore"));
        assertEquals(manager, currentUser);
    }
}
