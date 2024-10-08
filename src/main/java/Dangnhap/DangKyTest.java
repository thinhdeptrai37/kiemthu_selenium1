package Dangnhap;  

import org.testng.Assert;  
import org.testng.annotations.DataProvider;  
import org.testng.annotations.Test;  
import java.util.Arrays;  
import java.util.HashSet;  
import java.util.Set;  

public class DangKyTest {  

    // Dữ liệu kiểm thử  
    @DataProvider(name = "registrationData")  
    public Object[][] registrationData() {  
        return new Object[][] {  
            {"existingUser", "WeakPass1", false}, // Tên người dùng đã tồn tại  
            {"newUser", "weak", false},            // Mật khẩu không đủ mạnh  
            {"newUser", "StrongPass1", true},      // Đăng ký thành công  
        };  
    }  

    @Test(dataProvider = "registrationData")  
    public void testUserRegistration(String username, String password, boolean expectedOutcome) {  
        // Gọi phương thức đăng ký và kiểm tra kết quả  
        boolean actualOutcome = registerUser(username, password);  
        Assert.assertEquals(actualOutcome, expectedOutcome, "Registration outcome should match expected outcome");  
    }  

    // Phương thức giả lập đăng ký  
    private boolean registerUser(String username, String password) {  
        // Giả lập danh sách người dùng đã tồn tại  
        Set<String> existingUsers = new HashSet<>(Arrays.asList("existingUser", "user1", "user2"));  
        
        // Kiểm tra tên người dùng  
        if (existingUsers.contains(username)) {  
            return false; // Tên người dùng đã tồn tại  
        }  

        // Kiểm tra độ mạnh của mật khẩu  
        if (!isPasswordStrong(password)) {  
            return false; // Mật khẩu không đủ mạnh  
        }  

        // Nếu vượt qua cả hai kiểm tra, giả sử đăng ký thành công  
        return true;  
    }  

    // Phương thức kiểm tra độ mạnh của mật khẩu  
    private boolean isPasswordStrong(String password) {  
        // Kiểm tra điều kiện mật khẩu:  
        // 1. Có ít nhất 8 ký tự  
        // 2. Có ít nhất 1 ký tự in hoa  
        // 3. Có ít nhất 1 ký tự in thường  
        // 4. Có ít nhất 1 số  
        return password.length() >= 8 && password.chars().anyMatch(Character::isUpperCase)  
                && password.chars().anyMatch(Character::isLowerCase)  
                && password.chars().anyMatch(Character::isDigit);  
    }  
}