package JavaCookbook;

/**
 * Created by Michael.Shreiber on 2/10/14.
 *
 * CMD arguments:
 *
 */

public class GetOptions {

    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("No arguments were passed.");
        } else {
            for (String arg : args){
                System.out.println(arg);
            }
        }
    }


}