


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mendoza950Proy2 extends JFrame implements ActionListener {
    private JButton[] puzzleButtons;
    private JButton startButton;
    private JButton startButton2;
    private JButton checkButton;
    private JTextField playerNameField;
    private JButton saveButton;
    private JButton loadButton;
    private Timer timer;
    private int moves;
    private int seconds;
    private JLabel timeLabel;
    private JLabel movesLabel;
    private List<Player> topPlayers;
    JFrame ventana;

    private static final int PUZZLE_SIZE = 16; // 15 numbered buttons + 1 empty button
    private static final int PUZZLE_DIMENSION = 4; // 4x4 grid layout

    public Mendoza950Proy2() {
        ventana = new JFrame("Rompecabeza");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel puzzlePanel = new JPanel(new GridLayout(PUZZLE_DIMENSION, PUZZLE_DIMENSION));
        puzzleButtons = new JButton[PUZZLE_SIZE];

        for (int i = 0; i < PUZZLE_SIZE; i++) {
            puzzleButtons[i] = new JButton();
            puzzleButtons[i].addActionListener(this);
            puzzlePanel.add(puzzleButtons[i]);
        }

        add(puzzlePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        startButton = new JButton("Iniciar");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);

        startButton2 = new JButton("Iniciar2");
        startButton2.addActionListener(this);
        buttonPanel.add(startButton2);

        checkButton = new JButton("Verificar");
        checkButton.addActionListener(this);
        buttonPanel.add(checkButton);

        playerNameField = new JTextField(10);
        buttonPanel.add(playerNameField);

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        loadButton = new JButton("Consultar archivo");
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        timeLabel = new JLabel("Tiempo: 0 segundos");
        buttonPanel.add(timeLabel);

        movesLabel = new JLabel("Movimientos: 0");
        buttonPanel.add(movesLabel);

        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new TimerListener());

        topPlayers = new ArrayList<>();

        setVisible(true);
    }

    private void startGame() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < PUZZLE_SIZE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int i = 0; i < PUZZLE_SIZE - 1; i++) {
            puzzleButtons[i].setText(String.valueOf(numbers.get(i)));
        }
        puzzleButtons[PUZZLE_SIZE - 1].setText("");

        moves = 0;
        seconds = 0;
        timer.start();
    }

    private void moveButton(int buttonIndex) {
        int emptyIndex = findEmptyButtonIndex();

        if (isAdjacent(buttonIndex, emptyIndex)) {
            swapButtons(buttonIndex, emptyIndex);
            moves++;
            updateMovesLabel();

            if (isPuzzleSolved()) {
                timer.stop();
                String playerName = playerNameField.getText();
                Player currentPlayer = new Player(playerName, seconds);
                topPlayers.add(currentPlayer);
                Collections.sort(topPlayers);
                if (topPlayers.size() > 5) {
                    topPlayers = topPlayers.subList(0, 5);
                }
                JOptionPane.showMessageDialog(this, "¡Felicidades, has resuelto el rompecabezas!");
            }
        }
    }

    private int findEmptyButtonIndex() {
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            if (puzzleButtons[i].getText().equals("")) {
                return i;
            }
        }
        return -1;
    }

    private boolean isAdjacent(int buttonIndex, int emptyIndex) {
        int row1 = buttonIndex / PUZZLE_DIMENSION;
        int col1 = buttonIndex % PUZZLE_DIMENSION;
        int row2 = emptyIndex / PUZZLE_DIMENSION;
        int col2 = emptyIndex % PUZZLE_DIMENSION;

        return (row1 == row2 && Math.abs(col1 - col2) == 1) || (col1 == col2 && Math.abs(row1 - row2) == 1);
    }

    private void swapButtons(int index1, int index2) {
        String tempText = puzzleButtons[index1].getText();
        puzzleButtons[index1].setText(puzzleButtons[index2].getText());
        puzzleButtons[index2].setText(tempText);
    }

    private boolean isPuzzleSolved() {
        for (int i = 0; i < PUZZLE_SIZE - 1; i++) {
            if (!puzzleButtons[i].getText().equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return puzzleButtons[PUZZLE_SIZE - 1].getText().equals("");
    }

    private void updateMovesLabel() {
        movesLabel.setText("Movimientos: " + moves);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startGame();
        } else if (e.getSource() == startButton2) {
            int emptyIndex = findEmptyButtonIndex();
            if (emptyIndex == PUZZLE_SIZE - 1 || emptyIndex == -1) {
                return;
            }
            int lastIndex = PUZZLE_SIZE - 2;
            swapButtons(emptyIndex, lastIndex);
        } else if (e.getSource() == checkButton) {
            if (isPuzzleSolved()) {
                JOptionPane.showMessageDialog(this, "¡El rompecabezas está en orden!");
            } else {
                JOptionPane.showMessageDialog(this, "El rompecabezas aún no está en orden.");
            }
        } else if (e.getSource() == saveButton) {
            String playerName = playerNameField.getText();
            Player currentPlayer = new Player(playerName, seconds);
            topPlayers.add(currentPlayer);
            Collections.sort(topPlayers);
            if (topPlayers.size() > 5) {
                topPlayers = topPlayers.subList(0, 5);
            }
            JOptionPane.showMessageDialog(this, "Jugador guardado correctamente.");
        } else if (e.getSource() == loadButton) {
            StringBuilder playerList = new StringBuilder("Lista de jugadores:\n");
            for (Player player : topPlayers) {
                playerList.append(player.getName()).append(": ").append(player.getTime()).append(" segundos\n");
            }
            JOptionPane.showMessageDialog(this, playerList.toString());
        } else {
            for (int i = 0; i < PUZZLE_SIZE; i++) {
                if (e.getSource() == puzzleButtons[i]) {
                    moveButton(i);
                    break;
                }
            }
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds++;
            timeLabel.setText("Tiempo: " + seconds + " segundos");
        }
    }

    private static class Player implements Comparable<Player> {
        private String name;
        private int time;

        public Player(String name, int time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Player o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PuzzleGame();
            }
        });
    }
}
