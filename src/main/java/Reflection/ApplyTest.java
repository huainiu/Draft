package Reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 11/13/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
class ApplyTest {

    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < 10; i++)
            shapes.add(new Shape());
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes,Shape.class.getMethod("resize", int.class), 5);

        List<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 10; i++)
            squares.add(new Square());
        Apply.apply(squares, Square.class.getMethod("rotate"));
        Apply.apply(squares, Square.class.getMethod("resize", int.class), 5);

    }

}
