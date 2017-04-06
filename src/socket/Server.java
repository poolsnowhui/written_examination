package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
	private ServerSocket serverSocket;
	private Socket socket;
	private SocketAddress clientID;
	private DataInputStream input;
	private DataOutputStream out;

	public Server() {
		try {
			serverSocket = new ServerSocket(8089, 10000);// 在服务器端制定8089端口创建套接字
			while (true) {
				socket = serverSocket.accept();// 告诉服务器不停等待，直到客户端连接到该ServerSocket指定的端口
				clientID = socket.getRemoteSocketAddress();// 获取客户端IP地址
				// 客户端地址与端口
				System.out.println("clientID:" + clientID);
				// 获得客户端发送的消息
				// SocketChannel socketChannel = SocketChannel.open(clientID);
				// input = new BufferedReader(new
				// InputStreamReader(Channels.newInputStream(socketChannel)));
				input = new DataInputStream(socket.getInputStream());
				System.out.println("client send message is " + input.readUTF());

				// 发回消息给客户端
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(socket.getLocalSocketAddress() + "Server:Your Message Received!");
				System.out.println("Server:Your Message Received!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new Server();
	}
}
