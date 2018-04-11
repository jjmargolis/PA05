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

    JEditorPane editorPane = new JEditorPane();
    editorPane.setEditable(false);
    content.add(list, BorderLayout.CENTER);

    JPanel inputs = new JPanel(new GridLayout(0,1));
    JTextField ingName = new JTextField("Enter Ingredient Name");
    JTextField ingType = new JTextField("Enter Ingredient Type");
    JTextField ingCost = new JTextField("Enter Ingredient Cost");
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
        ingName.setText("Enter Ingredient Name");
        ingType.setText("Enter Ingredient Type");
        ingCost.setText("Enter Ingredient Cost");
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
      }
    });
  }//main

    private static void addIngredient(JTextField ingName, JTextField ingType, JTextField ingCost){
      printIngredients();
      ingredients.add(new Ingredient(ingName.getText(), ingType.getText(), Double.parseDouble(ingCost.getText())));
      //TODO add try catch for ingredient cost
      ingName.setText("Enter Ingredient Name");
      ingType.setText("Enter Ingredient Type");
      ingCost.setText("Enter Ingredient Cost");
      printIngredients();
    }

    private Object[] getArray(){
      Object[] array = new Object[ingredients.size()];
      for(int x = 0; x < ingredients.size(); x++){
        array[x] = ingredients.get(x).getName();
      }
      return array;
    }

    private static void printIngredients(){
      for(Ingredient i : ingredients){
        System.out.println(i.toString());
      }
    }
}//class
