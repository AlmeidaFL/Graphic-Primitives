package Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ButtonPanel extends JPanel {
  private JButton circle;
  private JButton line;
  private JButton polygonalLine;
  private Type type;
  DrawPanel dPanel;

  public ButtonPanel(Type type, DrawPanel dPanel) {
    initialize();
    this.type = type;
    this.dPanel = dPanel;
    setEvents();
  }

  void initialize() {
    setLayout(new FlowLayout());

    // Creating Buttons
    circle = new JButton("Circle");
    line = new JButton("Line");
    polygonalLine = new JButton("Polygonal Line");

    // Adding buttons
    add(circle);
    add(line);
    add(polygonalLine);
  }

  /**
   * Sets the events of both line and circle
   */
  public void setEvents() {

    circle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        type.setType(TypeButton.CIRCLE);  
        dPanel.resetControlVaribles();
      }
    });

    line.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        type.setType(TypeButton.LINE);
        dPanel.resetControlVaribles();
      }
    });

    polygonalLine.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        type.setType(TypeButton.POLYGONAL_LINE);
        dPanel.resetControlVaribles();
      }
    });
  }
}
