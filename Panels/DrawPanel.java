package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Line2D.PolygonalLine2D.PolygonalLine;
import Primitives2D.Point2D.PointGr;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;

  //Control variables
  private boolean needPoint = false;
  private boolean firstTime = true;

  //Space variables (changes everytime)
  private int xLine;
  private int yLine;

  //Type variable
  private Type type = new Type();

  //Primitives 2D
  private PolygonalLine polygonalLine;
  private CircleGr circleGr;
  private LineGr lineGr;
  
  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
    addMouseListener(this);
    addMouseMotionListener(this);
    circleGr = new CircleGr(0, 0, 70);
    lineGr = new LineGr(0, 0, 0, 0);
    polygonalLine = getNewPL();
  }

  public DrawPanel() {
    initialize();
  }

  @Override
  /**
   * Paint lines and circles when the window opens
   */
  public void paintComponent(Graphics g) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  /**
   * If the circle button was pressed, draw a circle of radius 70
   * if the line button was pressed, it draws a semi-line given the two points
   * clicked
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    Graphics g = getGraphics();

    draw(x, y, g);

  }

  private void draw(int x, int y, Graphics g) {
    switch (type.getTypeButton()) {
      case CIRCLE:
        circleGr.setX(x);
        circleGr.setY(y);
        circleGr.draw(g);
        break;
      case LINE:
        if (changeLineState()) {
          xLine = x;
          yLine = y;
          needPoint = true;
          lineGr.setP1(new PointGr(xLine, yLine));
        }
        lineGr.setP2(new PointGr(x, y));
        lineGr.draw(g);
        break;
      case FREE:
        break;

      case POLYGONAL_LINE:
      if (firstTime) {
        polygonalLine.setPointA(x, y);
        firstTime = false;
      }
      polygonalLine.setPointB(x, y);
      polygonalLine.draw(g);
        break;
      default:
        break;
    }
  }

  PolygonalLine getNewPL(){
    return new PolygonalLine();
  }

  /**
   * Change the state of line button. It's necessary because to draw a line it
   * requires that the user press the mouse 2 times
   * 
   * @return boolean
   */
  public boolean changeLineState() {
    needPoint = !needPoint;
    return needPoint;
  }

  public void resetControlVaribles(){
    needPoint = false;
    firstTime = true;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  public Type getTypeButton() {
    return type;
  }
}

class Type {
  private TypeButton type = TypeButton.LINE;

  public TypeButton getTypeButton() {
    return type;
  }

  public void setType(TypeButton value) {
    type = value;
  }
}

enum TypeButton {
  LINE,
  CIRCLE,
  FREE,
  POLYGONAL_LINE,
}
