import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket = null;

    public HttpServerV2(int port) throws IOException {
        serverSocket =  new ServerSocket(port);
    }
    public void start(){
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
        System.out.println("request:"+request);
        HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
        response.setHeader("Content-Type", "text/html");
        if (request.getUrl().startsWith("/hello")) {
            response.setStatus(200);
            response.setMessage("OK");
            response.writeBody("<h1>hello</h1>");

        }
}
