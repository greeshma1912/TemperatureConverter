import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame implements ActionListener {

    private final JTextField inputField;
    private final JLabel outputLabel;
    private final JRadioButton celsiusRadioButton;
    private final JRadioButton fahrenheitRadioButton;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        JPanel inputFieldPanel = new JPanel();
        JLabel inputLabel = new JLabel("Enter temperature:");
        inputField = new JTextField(10);
        inputFieldPanel.add(inputLabel);
        inputFieldPanel.add(inputField);

        JPanel unitSelectionPanel = new JPanel();
        celsiusRadioButton = new JRadioButton("Celsius");
        fahrenheitRadioButton = new JRadioButton("Fahrenheit");
        
        ButtonGroup unitGroup = new ButtonGroup();
        unitGroup.add(celsiusRadioButton);
        unitGroup.add(fahrenheitRadioButton);
        
        celsiusRadioButton.setSelected(true); // Default selection

        unitSelectionPanel.add(celsiusRadioButton);
        unitSelectionPanel.add(fahrenheitRadioButton);
        
        inputPanel.add(inputFieldPanel);
        inputPanel.add(unitSelectionPanel);

        // Output panel
        JPanel outputPanel = new JPanel();
        outputLabel = new JLabel("Converted temperatures will be displayed here.");

        outputPanel.add(outputLabel);

        add(inputPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Convert")) {
            try {
                double inputTemperature = Double.parseDouble(inputField.getText());
                String outputText=null;

                if (celsiusRadioButton.isSelected()) {
                    double fahrenheit = (inputTemperature * 9 / 5) + 32;
                   
                    outputText = String.format("Fahrenheit: %.2f°F", fahrenheit);
                } else if (fahrenheitRadioButton.isSelected()) {
                    double celsius = (inputTemperature - 32) * 5 / 9;
                    
                    outputText = String.format("Celsius: %.2f°C", celsius);
                }

                outputLabel.setText(outputText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
