import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.Socket;  

public class TcpClient1 {  

    public static void main(String[] args) {  
        String serverAddress = "172.188.19.218"; // Địa chỉ máy chủ  
        int port = 1605; // Cổng kết nối  
        String studentCode = "B21DCCN592"; // Mã sinh viên  
        String qCode = "8OUWD1W"; // Mã bài tập  

        try (Socket client = new Socket(serverAddress, port)) {  
            client.setSoTimeout(5000); // Thiết lập timeout cho kết nối  

            // Gửi mã sinh viên và câu hỏi  
            DataOutputStream dos = new DataOutputStream(client.getOutputStream()) ;  
            String messageToSend = studentCode + ";" + qCode;  
            dos.writeUTF(messageToSend); 
            dos.flush();

            // Nhận dữ liệu từ máy chủ  
            DataInputStream dis = new DataInputStream(client.getInputStream());  
            int a=dis.readInt();
            int b=dis.readInt();
//            System.out.println(a);
//            System.out.println(b);
            int sum=a+b;
            int hieu=a-b;
            int tich=a*b;
            dos.writeInt(sum);
            dos.writeInt(hieu);
            dos.writeInt(tich);
//            System.out.println(sum);
//            System.out.println(tich);
            dos.flush();
            
            dis.close();
            dos.close();
            client.close();
        } catch (IOException e) {  
            System.err.println("Error I/O: " + e.getMessage());  
            e.printStackTrace();  
        }  
    }  
}