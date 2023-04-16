package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatClient extends JFrame implements Runnable {

    private static int WIDTH = 400;
    private static int HEIGHT = 500;

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    JTextField textField;
    JTextArea textArea = null;
    JScrollPane scroll;

    Socket socket;

    public ChatClient() {
        super("Chat Client");

        textField = new JTextField(5);
        textArea = new JTextArea(30, 30);
        textArea.setEditable(false);
        this.setLayout(new BorderLayout());
        textField.addActionListener(new TextFieldListener());
        JPanel bottomPanel = new JPanel(new GridLayout(1, 1));

        bottomPanel.add(textField);
        this.add(scroll, BorderLayout.CENTER);
        this.add(textArea, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        createMenu();
        this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem connectItem = new JMenuItem("Connect");
        JMenuItem exitItem = new JMenuItem("Exit");
        connectItem.addActionListener((e) -> {
            try {
                socket = new Socket("localhost", 9898);
                textArea.append("----------\nConnected!\n----------\n");

                fromServer = new DataInputStream(socket.getInputStream());
                Thread t = new Thread(this);
                t.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        exitItem.addActionListener((e) -> System.exit(1));
        menu.add(connectItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    public void run() {
        while (true) {
            try {
                String getmessage = fromServer.readUTF();
                textArea.append(getmessage + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(socket == null) {
                textArea.append("Chatroom not connected to Server.\nPlease connect to server and try again!\n");
            }
            try {
                toServer = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                textArea.append("ERROR: " + ex.toString() + '\n');
            }

            try {
                String message = textField.getText().trim();
                toServer.writeUTF(message);
                toServer.flush();
                textField.setText("");
                //socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }

        }
    }


    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
    }
}
