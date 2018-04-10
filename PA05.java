import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class PA05 {

  public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

  public static void main(String[] args){
    JFrame window = new JFrame("PA05");


    MouseDrawDemo drawWidget1 = new MouseDrawDemo();
    drawWidget1.drawingColor = Color.RED;
    MouseDrawDemo drawWidget2 = new MouseDrawDemo();
    drawWidget2.drawingColor = Color.BLUE;


    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());

    JPanel buttons = new JPanel(new GridLayout(0,1));
    JButton clear = new JButton("Clear");
    JButton newIngredient = new JButton("New Ingredient");
    buttons.add(clear);
    buttons.add(newIngredient);
    content.add(buttons, BorderLayout.LINE_START);

    JTable tableModel = newTable();
    content.add(tableModel, BorderLayout.CENTER);

    JPanel inputs = new JPanel(new GridLayout(0,1));
    JTextField ingName = new JTextField("Enter Ingredient Name");
    JTextField ingType = new JTextField("Enter Ingredient Type");
    JFormattedTextField ingCost = new JFormattedTextField(new DecimalFormat());
    inputs.add(ingName);
    inputs.add(ingType);
    inputs.add(ingCost);
    content.add(inputs, BorderLayout.LINE_END);


    /*content.add(drawWidget1);
    content.add(clear);
    content.add(drawWidget2); */

    window.setContentPane(content);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocation(120,70);
    window.setSize(400,300);
    window.setVisible(true);

    clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        drawWidget1.points.clear();
        drawWidget1.repaint();
        System.out.println("points1 length="+
           drawWidget1.points.size());
        drawWidget2.points.clear();
        drawWidget2.repaint();
      }
    });

    newIngredient.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        addIngredient(ingName, ingType, ingCost);
        tableModel.updateUI();
      }
    });
  }//main

    private static void addIngredient(JTextField ingName, JTextField ingType, JFormattedTextField ingCost){
      printIngredients();
      ingredients.add(new Ingredient(ingName.getText(), ingType.getText(), //fuck));
      //TODO add try catch for ingredient cost
      ingName.setText("Enter Ingredient Name");
      ingType.setText("Enter Ingredient Type");
      ingCost.setText("Enter Ingredient Cost");
      printIngredients();
    }

    private static JTable newTable(){
      String[] columnNames = {"Name of Ingredient",
                          "Type of Ingredient",
                          "Cost Per Unit"};
      Object[][] data = {
                          {"Eggs", "Organic",
                           10},
                          };
      JTable table = new JTable(data, columnNames);
      table.setRowSelectionAllowed(false);
      return new JTable(data, columnNames);
    }

    private static void printIngredients(){
      for(Ingredient i : ingredients){
        System.out.println(i.toString());
      }
    }
}//class
