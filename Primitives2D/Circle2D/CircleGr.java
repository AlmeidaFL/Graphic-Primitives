package Primitives2D.Circle2D;
import java.awt.Graphics;

import Primitives2D.GraphicPrimitive2D;
import Primitives2D.Point2D.PointGr;

public class CircleGr extends SuperCircleGr {
  public CircleGr(SuperCircleGr circle) {
    super(circle);
  }

  public CircleGr(int x, int y, int radius, String name) {
    super(x, y, radius, name);
  }

  public CircleGr(int x, int y, int radius) {
    super(x, y, radius);
  }

  public void draw(Graphics g) {
    double angule, rowEnd;

    PointGr point = new PointGr();
    // A constant to find the amount needs to loop
    double inc = 0.18 / (getRadius() / 300);

    for (angule = 0; angule <= 90; angule += inc) {
      plotPoint(angule, point, g);
    }
  }

  public void erase(Graphics g) {

  }

}
