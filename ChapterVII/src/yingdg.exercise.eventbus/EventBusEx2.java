package yingdg.exercise.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YingDG on 2017/2/14.
 *
 * 转载自：http://uule.iteye.com/blog/2096279
 */
public class EventBusEx2 extends Thread {
    private Socket connection;
    private EventBus channel;
    private BufferedReader in;
    private PrintWriter out;

    public EventBusEx2(Socket connection, EventBus channel) {
        this.channel = channel;

        this.connection = connection;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Subscribe
    public void recieveMessage(String message) {
        if (out != null) {
            out.println(message);
            System.out.println("recieveMessage:" + message);
        }
    }

    @Override
    public void run() {
        try {
            String input;
            while ((input = in.readLine()) != null) {
                channel.post(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reached eof
        channel.unregister(this);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
        in = null;
        out = null;
    }

    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                Socket connection = socket.accept();
                EventBusEx2 eventBus = new EventBusEx2(connection, channel);
                channel.register(eventBus);
                eventBus.start();
            }
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
