// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CariñoMidtermExam extends JFrame implements ActionListener {
   private JTextField display;
   private JButton[] numberButtons = new JButton[10];
   private JButton[] functionButtons = new JButton[8];
   private JButton addButton;
   private JButton subButton;
   private JButton mulButton;
   private JButton divButton;
   private JButton decButton;
   private JButton equButton;
   private JButton delButton;
   private JButton clrButton;
   private double num1 = 0.0;
   private double num2 = 0.0;
   private double result = 0.0;
   private char operator;
   private JTextField emailField = new JTextField(20);
   private JPasswordField passwordField = new JPasswordField(20);
   private JButton loginButton = new JButton("Login");
   private CardLayout cardLayout = new CardLayout();
   private JPanel mainPanel;

   public CariñoMidtermExam() {
      this.mainPanel = new JPanel(this.cardLayout);
      this.setTitle("Calculator App");
      this.setSize(420, 550);
      this.setDefaultCloseOperation(3);
      this.setLocationRelativeTo((Component)null);
      JPanel var1 = this.setupLoginPanel();
      JPanel var2 = this.setupCalculatorPanel();
      this.mainPanel.add(var1, "Login");
      this.mainPanel.add(var2, "Calculator");
      this.add(this.mainPanel);
      this.cardLayout.show(this.mainPanel, "Login");
      this.setVisible(true);
   }

   private JPanel setupLoginPanel() {
      JPanel var1 = new JPanel(new GridBagLayout());
      GridBagConstraints var2 = new GridBagConstraints();
      var2.insets = new Insets(10, 10, 10, 10);
      var2.fill = 2;
      ImageIcon var3 = new ImageIcon("Cari\u00f1o-RainbowCalculator/RainbowCalcu/SiteLogo.jpg");
      Image var4 = var3.getImage();
      Image var5 = var4.getScaledInstance(250, -1, 4);
      ImageIcon var6 = new ImageIcon(var5);
      JLabel var7 = new JLabel(var6);
      var2.gridx = 0;
      var2.gridy = 0;
      var2.gridwidth = 3;
      var2.anchor = 10;
      var1.add(var7, var2);
      JLabel var8 = new JLabel("Welcome to the Calculator App");
      var8.setFont(new Font("Arial", 1, 20));
      var2.gridx = 0;
      var2.gridy = 1;
      var2.gridwidth = 3;
      var2.anchor = 10;
      var2.fill = 0;
      var1.add(var8, var2);
      var2.gridx = 0;
      var2.gridy = 2;
      var2.gridwidth = 1;
      var2.anchor = 10;
      var2.fill = 2;
      var1.add(new JLabel("Email:"), var2);
      var2.gridx = 1;
      var2.gridy = 2;
      var2.gridwidth = 2;
      var2.anchor = 10;
      var1.add(this.emailField, var2);
      var2.gridx = 0;
      var2.gridy = 3;
      var2.gridwidth = 1;
      var2.anchor = 10;
      var1.add(new JLabel("Password:"), var2);
      var2.gridx = 1;
      var2.gridy = 3;
      var2.gridwidth = 2;
      var2.anchor = 10;
      var1.add(this.passwordField, var2);
      var2.gridx = 0;
      var2.gridy = 4;
      var2.gridwidth = 3;
      var2.anchor = 10;
      var2.fill = 0;
      this.loginButton.addActionListener((var1x) -> {
         this.login();
      });
      var1.add(this.loginButton, var2);
      return var1;
   }

   private void login() {
      String var1 = this.emailField.getText();
      String var2 = new String(this.passwordField.getPassword());
      if (var1.equals("carinort.439.stud@cdd.edu.ph") && var2.equals("admin")) {
         JOptionPane.showMessageDialog(this, "Login Successful");
         this.cardLayout.show(this.mainPanel, "Calculator");
      } else {
         JOptionPane.showMessageDialog(this, "Invalid username or password");
      }

   }

   private JPanel setupCalculatorPanel() {
      this.display = new JTextField();
      this.display.setEditable(false);
      this.display.setFont(new Font("Arial", 0, 24));
      this.display.setHorizontalAlignment(4);
      Color[] var1 = new Color[]{Color.blue, Color.red, Color.green, Color.yellow, Color.orange, new Color(143, 0, 255), new Color(75, 0, 130)};
      this.addButton = new JButton("+");
      this.subButton = new JButton("-");
      this.mulButton = new JButton("*");
      this.divButton = new JButton("/");
      this.decButton = new JButton(".");
      this.equButton = new JButton("=");
      this.delButton = new JButton("Delete");
      this.clrButton = new JButton("Clear");
      this.functionButtons[0] = this.addButton;
      this.functionButtons[1] = this.subButton;
      this.functionButtons[2] = this.mulButton;
      this.functionButtons[3] = this.divButton;
      this.functionButtons[4] = this.decButton;
      this.functionButtons[5] = this.equButton;
      this.functionButtons[6] = this.delButton;
      this.functionButtons[7] = this.clrButton;
      JButton[] var2 = this.functionButtons;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         JButton var5 = var2[var4];
         var5.addActionListener(this);
         var5.setFont(new Font("Arial", 0, 35));
         var5.setForeground(Color.white);
         var5.setBackground(Color.RED);
      }

      for(int var6 = 0; var6 < 10; ++var6) {
         this.numberButtons[var6] = new JButton(String.valueOf(var6));
         this.numberButtons[var6].addActionListener(this);
         this.numberButtons[var6].setFont(new Font("Arial", 0, 35));
         this.numberButtons[var6].setBackground(var1[var6 % var1.length]);
         this.numberButtons[var6].setForeground(Color.WHITE);
      }

      JPanel var7 = new JPanel(new GridLayout(4, 4, 10, 10));

      for(var3 = 1; var3 <= 3; ++var3) {
         var7.add(this.numberButtons[var3]);
      }

      var7.add(this.addButton);

      for(var3 = 4; var3 <= 6; ++var3) {
         var7.add(this.numberButtons[var3]);
      }

      var7.add(this.subButton);

      for(var3 = 7; var3 <= 9; ++var3) {
         var7.add(this.numberButtons[var3]);
      }

      var7.add(this.mulButton);
      var7.add(this.decButton);
      var7.add(this.numberButtons[0]);
      var7.add(this.equButton);
      var7.add(this.divButton);
      JPanel var9 = new JPanel(new BorderLayout());
      var9.add(this.display, "North");
      var9.add(var7, "Center");
      JPanel var8 = new JPanel(new GridLayout(1, 2));
      var8.add(this.delButton);
      var8.add(this.clrButton);
      var9.add(var8, "South");
      return var9;
   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(CariñoMidtermExam::new);
   }

   public void actionPerformed(ActionEvent var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         if (var1.getSource() == this.numberButtons[var2]) {
            this.display.setText(this.display.getText().concat(String.valueOf(var2)));
         }
      }

      if (var1.getSource() == this.decButton && !this.display.getText().contains(".")) {
         this.display.setText(this.display.getText().concat("."));
      }

      if (var1.getSource() == this.addButton) {
         this.num1 = Double.parseDouble(this.display.getText());
         this.operator = '+';
         this.display.setText("");
      }

      if (var1.getSource() == this.subButton) {
         this.num1 = Double.parseDouble(this.display.getText());
         this.operator = '-';
         this.display.setText("");
      }

      if (var1.getSource() == this.mulButton) {
         this.num1 = Double.parseDouble(this.display.getText());
         this.operator = '*';
         this.display.setText("");
      }

      if (var1.getSource() == this.divButton) {
         this.num1 = Double.parseDouble(this.display.getText());
         this.operator = '/';
         this.display.setText("");
      }

      if (var1.getSource() == this.equButton) {
         this.num2 = Double.parseDouble(this.display.getText());
         switch (this.operator) {
            case '*':
               this.result = this.num1 * this.num2;
               break;
            case '+':
               this.result = this.num1 + this.num2;
            case ',':
            case '.':
            default:
               break;
            case '-':
               this.result = this.num1 - this.num2;
               break;
            case '/':
               this.result = this.num1 / this.num2;
         }

         this.display.setText(String.valueOf(this.result));
         this.num1 = this.result;
      }

      if (var1.getSource() == this.clrButton) {
         this.display.setText("");
      }

      if (var1.getSource() == this.delButton) {
         String var3 = this.display.getText();
         if (var3.length() > 0) {
            this.display.setText(var3.substring(0, var3.length() - 1));
         }
      }

   }
}
