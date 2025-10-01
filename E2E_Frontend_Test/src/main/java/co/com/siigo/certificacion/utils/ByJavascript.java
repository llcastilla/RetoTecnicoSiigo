package co.com.siigo.certificacion.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByJavascript extends By {

    private final String script;

    public ByJavascript(String script) {
        this.script = script;
    }

    @Override
    public WebElement findElement(SearchContext context) {
        WebDriver driver = (WebDriver) context;
        return (WebElement) ((JavascriptExecutor) driver).executeScript(script);
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        WebDriver driver = (WebDriver) context;
        Object result = ((JavascriptExecutor) driver).executeScript(script);
        if (result instanceof List<?>) {
            return (List<WebElement>) result;
        }
        return List.of();
    }

    public static By js(String script) {
        return new ByJavascript(script);
    }

    public static By shadowElementByIndex(String hostTag, int index, String selector) {
        String script = String.format(
                "let waitForElement = (hostTag, index, selector) => {" +
                        "  let attempts = 0;" +
                        "  while (attempts < 10) {" +
                        "    let hosts = document.querySelectorAll(hostTag);" +
                        "    if (hosts.length > index && hosts[index].shadowRoot) {" +
                        "      let elem = hosts[index].shadowRoot.querySelector(selector);" +
                        "      if (elem) return elem;" +
                        "    }" +
                        "    attempts++;" +
                        "    let start = Date.now();" +
                        "    while (Date.now() - start < 200) {}" +
                        "  }" +
                        "  return null;" +
                        "};" +
                        "return waitForElement('%s', %d, '%s');",
                hostTag, index, selector
        );
        return new ByJavascript(script);
    }


    public static By shadowElementByIndex(String hostTag, int hostIndex, String selector, int elementIndex) {
        String script = String.format(
                "let waitForElement = (hostTag, hostIndex, selector, elementIndex) => {" +
                        "  let attempts = 0;" +
                        "  while (attempts < 10) {" +
                        "    let hosts = document.querySelectorAll(hostTag);" +
                        "    if (hosts.length > hostIndex && hosts[hostIndex].shadowRoot) {" +
                        "      let elems = hosts[hostIndex].shadowRoot.querySelectorAll(selector);" +
                        "      if (elems.length > elementIndex) return elems[elementIndex];" +
                        "    }" +
                        "    attempts++;" +
                        "    let start = Date.now();" +
                        "    while (Date.now() - start < 200) {}" +
                        "  }" +
                        "  return null;" +
                        "};" +
                        "return waitForElement('%s', %d, '%s', %d);",
                hostTag, hostIndex, selector, elementIndex
        );
        return new ByJavascript(script);
    }


    public static void clickAndType(WebDriver driver, String hostTag, int index, String selector, String value) {
        String script = String.format(
                "let waitForElement = (hostTag, index, selector) => {" +
                        "  let attempts = 0;" +
                        "  while (attempts < 20) {" +
                        "    let hosts = document.querySelectorAll(hostTag);" +
                        "    if (hosts.length > index && hosts[index].shadowRoot) {" +
                        "      let elem = hosts[index].shadowRoot.querySelector(selector);" +
                        "      if (elem) return elem;" +
                        "    }" +
                        "    attempts++;" +
                        "    let start = Date.now();" +
                        "    while (Date.now() - start < 200) {}" +
                        "  }" +
                        "  return null;" +
                        "};" +
                        "let input = waitForElement('%s', %d, '%s');" +
                        "if(input) {" +
                        "  input.click();" +
                        "  input.value = '%s';" +
                        "  input.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "  input.dispatchEvent(new Event('change', { bubbles: true }));" +
                        "}",
                hostTag, index, selector, value
        );
        ((JavascriptExecutor) driver).executeScript(script);
    }


    public static void shadowElementClickAndType(WebDriver driver, String hostTag, int hostIndex, String selector, int elementIndex, String value) {
        String script = String.format(
                "let waitForElement = (hostTag, hostIndex, selector, elementIndex) => {" +
                        "  let attempts = 0;" +
                        "  while (attempts < 20) {" +
                        "    let hosts = document.querySelectorAll(hostTag);" +
                        "    if (hosts.length > hostIndex && hosts[hostIndex].shadowRoot) {" +
                        "      let elems = hosts[hostIndex].shadowRoot.querySelectorAll(selector);" +
                        "      if (elems.length > elementIndex) return elems[elementIndex];" +
                        "    }" +
                        "    attempts++;" +
                        "    let start = Date.now();" +
                        "    while (Date.now() - start < 200) {}" +
                        "  }" +
                        "  return null;" +
                        "};" +
                        "let input = waitForElement('%s', %d, '%s', %d);" +
                        "if(input) {" +
                        "  input.click();" +
                        "  input.value = '%s';" +
                        "  input.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "  input.dispatchEvent(new Event('change', { bubbles: true }));" +
                        "}",
                hostTag, hostIndex, selector, elementIndex, value
        );
        ((JavascriptExecutor) driver).executeScript(script);
    }
}
