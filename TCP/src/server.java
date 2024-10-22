/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
    import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  

public class server {  
    public static void main(String[] args) {  
        int port = 1605; // Cổng mà Server sẽ lắng nghe  

        try (ServerSocket serverSocket = new ServerSocket(port)) {  
            System.out.println("Server is listening on port " + port);  

            while (true) {  
                try (Socket socket = serverSocket.accept()) {  
                    DataInputStream dis = new DataInputStream(socket.getInputStream());  
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());  

                    // Nhận chuỗi từ Client  
                    String studentInfo = dis.readUTF();  
                    System.out.println("Received: " + studentInfo);  

                    // Gửi hai số nguyên a và b  
                    int a = 10; // hoặc bất kỳ số nguyên nào khác  
                    int b = 20; // hoặc bất kỳ số nguyên nào khác  
                    dos.writeInt(a);  
                    dos.writeInt(b);  
                    dos.flush(); // Đảm bảo dữ liệu được gửi đi  

                    // Nhận và xử lý dữ liệu từ Client nếu cần thiết  
                    int sum = dis.readInt(); // Đọc tổng gửi từ Client  
                    int product = dis.readInt(); // Đọc tích gửi từ Client  
                    System.out.println("Sum received from client: " + sum);  
                    System.out.println("Product received from client: " + product);  
                }  
            }  
        } catch (IOException e) {  
            System.err.println("Error in server: " + e.getMessage());  
            e.printStackTrace();  
        }  
    }  
}
