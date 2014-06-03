package LT;

/**
 * Created by Michael.Shreiber on 12/29/13.
 */
public class Result{
    int number = 0;
    Double prob = 0.0;

    @Override
    public String toString(){
        return this.number + " (" + this.prob + ")";
    }
}
