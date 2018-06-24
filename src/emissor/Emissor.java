package emissor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Emissor implements Runnable {
	
	private String ipEnvio;
	private Integer porta;
	private String ipOrigem;
	private String ipDestino;
	private String msg;
	
	public Emissor(String ipEnvio, Integer porta, String ipOrigem, String ipDestino, String msg) {
		this.ipEnvio = ipEnvio;
		this.porta = porta;
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.msg = msg;
	}

	@Override
	public void run() {
		/*Pacote packet = new Pacote(ipOrigem, ipDestino, msg);
		System.out.println(this.toString());
		System.out.println(packet.toString());*/
		
		DatagramSocket sendSocket;
		DatagramPacket sendPacket;
		
		Pacote packet = new Pacote(ipOrigem, ipDestino, msg);
		//System.out.println(packet.toString());
		
		try {
			sendSocket = new DatagramSocket();
			byte[] sendData = packet.toString().getBytes();
			sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(this.ipEnvio), this.porta);
			sendSocket.send(sendPacket);
                        JOptionPane.showMessageDialog(null, "Mensagem enviada para\n" + "("+ipEnvio+", "+porta+")", "Enviado.", JOptionPane.INFORMATION_MESSAGE);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String toString() {
		return "Emissor [ipEnvio=" + ipEnvio + ", porta=" + porta + ", ipOrigem=" + ipOrigem + ", ipDestino="
				+ ipDestino + ", msg=" + msg + "]";
	}
	
}