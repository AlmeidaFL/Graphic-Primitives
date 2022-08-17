package Primitives2D.Line2D.PolygonalLine2D;

import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import Primitives2D.GraphicPrimitive2D;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.PointGr;

public class PolygonalLine implements GraphicPrimitive2D{
    
    private DoublyLinkedList data;
    private LineGr lineGr;
    private PointGr A;
    private PointGr B;


    public PolygonalLine(){
        
    }


    @Override
    public void draw(Graphics g) {
        if(g != null){
            lineGr = new LineGr(A, B);
            lineGr.draw(g);
            lastPoint();
            //data.push(lineGr);
        }
    }

    @Override
    public void erase(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    public void setPointA(int x,int y){
        A = new PointGr(x,y);
    }

    public void setPointB(int x,int y){
        B = new PointGr(x,y);
    }

    private void lastPoint(){
        A = B;
    }
  
}
