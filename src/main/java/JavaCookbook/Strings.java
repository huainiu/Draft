package JavaCookbook;

/**
 * Created by Michael.Shreiber on 2/10/14.
 */
public class Strings {

    public static void unicodeConversionTest() {
        StringBuffer b = new StringBuffer();
        for (char c = 'a'; c < 'd'; c++) {
            b.append(c);
        }
        b.append('\u00a5'); // Japanese Yen symbol
        b.append('\u01FC'); // Roman AE with acute accent
        b.append('\u0391'); // GREEK Capital Alpha
        b.append('\u03A9'); // GREEK Capital Omega
        for (int i = 0; i < b.length(); i++) {
            System.out.println("Character #" + i + " is " + b.charAt(i));
        }
        System.out.println("Accumulated characters are " + b);
    }


    public static void main(String[] args) {
        //StringTokenizer st = new StringTokenizer("Java is a great language. It was developed in C++. It's very wide spread across the world!", ". ", true);
        //while(st.hasMoreElements()){
        //    System.out.println("Token: " + st.nextToken());
        //}

        StringBuffer sb = new StringBuffer("AbcDe");
        //System.out.println(sb.insert(2,"xxxxx"));
        System.out.println(sb + " --> " + sb.reverse());


        unicodeConversionTest();




    }
}
