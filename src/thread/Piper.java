package thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Serializable;

public class Piper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6403047334886923014L;

	public static void main(String[] args) {
		PiperSender ps = new PiperSender();
		PiperRecevier pr = new PiperRecevier();
		
		try {
			ps.getPos().connect(pr.getPis());
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(ps).start();
		new Thread(pr).start();
	}
}
class PiperSender implements Runnable{

	private PipedOutputStream pos =null;
	public PiperSender() {
		pos = new PipedOutputStream();
	}
	@Override
	public void run() {
		byte[] b = new String("你好").getBytes();
		try {
			pos.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public PipedOutputStream getPos() {
		return pos;
	}
	
}
class PiperRecevier implements Runnable{
	
	private PipedInputStream pis =null;
	public PiperRecevier() {
		pis = new PipedInputStream();
	}
	@Override
	public void run() {
		byte[] b = new byte[1024];
		int len =0;
		StringBuffer sb = new StringBuffer();
		try {
			while ((len=pis.read(b))!=-1) {
				sb.append(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("接收的数据是："+sb.toString());
	}

	public PipedInputStream getPis() {
		return pis;
	}
	
}