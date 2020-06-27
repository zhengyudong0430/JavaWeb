import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp,  int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("->");
            String request = scanner.nextLine();
            if(request.equals("exit")) {
                break;
            }
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String response = new String(responsePacket.getData(),0,requestPacket.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
client.start();
    }
}
