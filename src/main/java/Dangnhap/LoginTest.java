/**
 * 
 */
package Dangnhap;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
public static void main(String[] args) {
// Thiết lập ChromeDriver
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\webdriver\\chromedriver-win64\\chromedriver.exe");
// Khởi tạo ChromeDriver
WebDriver driver = new ChromeDriver();
try {
// Mở trang đăng nhập
driver.get("https://www.facebook.com/");
// Khởi tạo WebDriverWait với thời gian chờ 2 phút (120 giây)
WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
// Nhập tên người dùng
WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))); // Sử dụng ID của trường tên người dùng
username.sendKeys("vuthuyduong009@gmail.com");
// Nhập mật khẩu
WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))); // Sử dụng ID của trường mật khẩu
password.sendKeys("");
// Nhấn nút đăng nhập
WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))); // Cần nhất selector chính xác cho nút đăng nhập
loginButton.click();
// Xác minh người dùng được chuyển hướng đến trang chính
wait.until(ExpectedConditions.urlContains("facebook.com")); // Kiểm tra URL có chứa "facebook.com"
// Kiểm tra có phải là trang chính
WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='banner']"))); // Thay đổi selector thành một phần tử nội bật
if (dashboardElement.isDisplayed()) {
System.out.println("Test Passed: User is redirected to the dashboard.");
} else {
System.out.println("Test Failed: User is not redirected to the dashboard.");
}
} catch (Exception e) {
System.out.println("Test Failed: " + e.getMessage());
} finally {
// Đóng trình duyệt
driver.quit();
}
}
}
