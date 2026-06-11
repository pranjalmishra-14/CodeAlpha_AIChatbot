import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;

public class AIChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AIChatbotGUI() {

        setTitle("AI Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: Ask me something.\n\n");

        sendButton.addActionListener(this::processMessage);

        inputField.addActionListener(this::processMessage);
    }

    private void processMessage(ActionEvent e) {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty())
            return;

        chatArea.append("You: " + userInput + "\n");

        String response = getResponse(userInput);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    private String getResponse(String input) {

        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if (input.contains("name")) {
            return "I am CodeAlpha AI Chatbot.";
        }

        else if (input.contains("java")) {
            return "Java is an object-oriented programming language.";
        }

        else if (input.contains("oop")) {
            return "OOP stands for Object-Oriented Programming.";
        }

        else if (input.contains("college")) {
            return "College life is a great time to learn and grow.";
        }

        else if (input.contains("upsc")) {
            return "UPSC is one of India's toughest competitive exams.";
        }

        else if (input.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else if (input.contains("how are you")) {
            return "I am doing great. Thanks for asking!";
        }

        else if (input.contains("time")) {
            return "I cannot access live time, but you can check your system clock.";
        }

        else {
            return "Sorry, I don't understand that yet.";
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AIChatbotGUI().setVisible(true);
        });
    }
}