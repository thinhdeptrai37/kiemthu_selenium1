package Dangnhap;  

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class UserRegistrationUI {  
    public static void main(String[] args) {  
        // Tạo khung cho ứng dụng  
        JFrame frame = new JFrame("User Registration");  
        frame.setSize(400, 300);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLayout(null);  

        // Tên người dùng  
        JLabel usernameLabel = new JLabel("Username:");  
        usernameLabel.setBounds(50, 50, 100, 30);  
        frame.add(usernameLabel);  
        
        JTextField usernameField = new JTextField();  
        usernameField.setBounds(150, 50, 200, 30);  
        frame.add(usernameField);  

        // Mật khẩu  
        JLabel passwordLabel = new JLabel("Password:");  
        passwordLabel.setBounds(50, 100, 100, 30);  
        frame.add(passwordLabel);  
        
        JPasswordField passwordField = new JPasswordField();  
        passwordField.setBounds(150, 100, 200, 30);  
        frame.add(passwordField);  

        // Nút đăng ký  
        JButton registerButton = new JButton("Register");  
        registerButton.setBounds(150, 150, 100, 30);  
        frame.add(registerButton);  

        // Kết quả  
        JLabel resultLabel = new JLabel("");  
        resultLabel.setBounds(50, 200, 300, 30);  
        frame.add(resultLabel);   

        // Listener để xử lý sự kiện khi nhấn nút đăng ký  
        registerButton.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                String username = usernameField.getText();  
                String password = new String(passwordField.getPassword());  

                // Kiểm tra thông tin  
                if (username.isEmpty() || password.isEmpty()) {  
                    resultLabel.setText("Please fill in all fields.");  
                } else {  
                    // Thực hiện thao tác đăng ký (có thể lưu vào cơ sở dữ liệu hoặc tệp, v.v.)  
                    // Ở đây chúng ta chỉ hiển thị thông báo đơn giản  
                    resultLabel.setText("User registered successfully: " + username);  
                    
                    // Xóa các trường nhập  
                    usernameField.setText("");  
                    passwordField.setText("");  
                }  
            }  
        });  

        // Hiện khung  
        frame.setVisible(true);  
    }  
}