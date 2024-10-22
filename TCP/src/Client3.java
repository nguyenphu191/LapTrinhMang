import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.Socket;  

public class Client3 {  
    public static void main(String[] args) {  
        String serverAddress = "172.188.19.218";  
        int port = 1606;  
        String studentCode = "B21DCCN592";  
        String qCode = "keyJCC4";  
        
        try (Socket socket = new Socket(serverAddress, port);  
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {  
            
            // a. Gửi chuỗi mã sinh viên và câu hỏi mã hóa đến máy chủ  
            String request = studentCode + ";" + qCode;  
            writer.write(request);  
            writer.newLine();  
            writer.flush();  
            
            // b. Nhận chuỗi từ máy chủ  
            String response = reader.readLine();  
            
            // c. Loại bỏ các âm nguyên trong chuỗi  
            String processedResponse = removeVowels(response);  
            
            // Gửi kết quả lên máy chủ  
            writer.write(processedResponse);  
            writer.newLine();  
            writer.flush();  
            
            writer.close();
            reader.close();

        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

    // Hàm để loại bỏ các âm nguyên  
    private static String removeVowels(String input) {  
        return input.replaceAll("[aeiouAEIOU]", "");  
    }  
}