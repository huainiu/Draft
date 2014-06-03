package Reflection;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 11/13/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
class Shape {

    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {

        System.out.println(this + " resize " + newSize);

    }

}
