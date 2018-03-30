import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PA05 {
  public static void main(String[] args){
    JFrame window = new JFrame("PA05");
    List<Ingredient> ingredients = new ArrayList<Ingredient>();


    MouseDrawDemo drawWidget1 = new MouseDrawDemo();
    drawWidget1.drawingColor = Color.RED;
    MouseDrawDemo drawWidget2 = new MouseDrawDemo();
    drawWidget2.drawingColor = Color.BLUE;


    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());

    JPanel buttons = new JPanel(new GridLayout(0,1));
    JButton clear = new JButton("Clear");
    JButton newIngredent = new JButton("New Ingredent");
    buttons.add(clear);
    buttons.add(newIngredent);
    content.add(buttons, BorderLayout.LINE_START);

    content.add(newTable(), BorderLayout.CENTER);

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

    newIngredent.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        addToTable();
      }
    });

  }

  private static JTable newTable(){
    String[] columnNames = {"Name of Ingredient",
                        "Type of Ingredient",
                        "Cost Per Unit"};
    Object[][] data = {
                        {"Eggs", "Organic",
                         10},
                        };
    return new JTable(data, columnNames);
  }
}
