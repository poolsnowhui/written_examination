package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket socket;
	private DataInputStream input;
	private DataOutputStream out;

	public Client() {
		try {
			socket = new Socket("127.0.0.1", 8089);
			// 读取字符发送给服务器
			System.out.println("Please Enter:");

			String message;
			Scanner scanner = new Scanner(System.in);
			message = scanner.nextLine();
			System.out.println("client send:" + message);
			// 发送消息
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(message);

			// 接收消息
			input = new DataInputStream(socket.getInputStream());
			System.out.println("Server says " + input.readUTF());
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}

	}

	public static void main(String[] args) {
		new Client();
	}
}
