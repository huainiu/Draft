package EffectiveJavaNotes;

/**
 * Created by Michael.Shreiber on 1/13/14.
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix,
                       int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max,
                                   String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        //1. check if the object is the reference of the current object (itself)
        if (o == this)
            return true;
        //2. check if the object is at all the instance of the same class
        if (!(o instanceof PhoneNumber))
            return false;
        //3. check if the fields of the object are equal to the fields of the current object.
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    /**
     * Here is a simple recipe for overriding hashCode:
     1. Store some constant nonzero value, say, 17, in an  int variable called  result .
     2. For each significant field  f in your object (each field taken into account by the
     equals method, that is), do the following:
        a. Compute an  int hash code  c for the field:
            i. If the field is a  boolean , compute  (f ? 1 : 0) .
            ii. If the field is a  byte , char , short , or  int , compute  (int) f .
            iii. If the field is a  long , compute  (int) (f ^ (f >>> 32)) .
            iv. If the field is a  float , compute  Float.floatToIntBits(f) .
            v. If the field is a  double , compute  Double.doubleToLongBits(f) , and
               then hash the resulting  long as in step 2.a.iii.
            vi. If the field is an object reference and this class’s  equals method
                compares the field by recursively invoking  equals , recursively
                invoke  hashCode on the field. If a more complex comparison is
                required, compute a “canonical representation” for this field and
                invoke  hashCode on the canonical representation. If the value of the
                field is  null , return  0 (or some other constant, but  0 is traditional).
            vii. If the field is an array, treat it as if each element were a separate field.
                 That is, compute a hash code for each significant element by applying
                 these rules recursively, and combine these values per step 2.b. If every
                 element in an array field is significant, you can use one of the
                 Arrays.hashCode methods added in release 1.5.
        b. Combine the hash code c computed in step 2.a into  result as follows:
           result = 31 * result + c;
     3. Return  result.
     4. When you are finished writing the  hashCode method, ask yourself whether
        equal instances have equal hash codes. Write unit tests to verify your intuition!
        If equal instances have unequal hash codes, figure out why and fix the problem.
     */

    @Override
    public int hashCode() {
        //1. take an arbitrary number (check the book for details..)
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    /**
     * Returns the string representation of this phone number.
     * The string consists of fourteen characters whose format
     * is "(XXX) YYY-ZZZZ", where XXX is the area code, YYY is
     * the prefix, and ZZZZ is the line number. (Each of the
     * capital letters represents a single decimal digit.)
     *
     * If any of the three parts of this phone number is too small
     * to fill up its field, the field is padded with leading zeros.
     * For example, if the value of the line number is 123, the last
     * four characters of the string representation will be "0123".
     *
     * Note that there is a single space separating the closing
     * parenthesis after the area code from the first digit of the
     * prefix.
     */
    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d",
                areaCode, prefix, lineNumber);
    }


    public static void main(String[] args) {
        PhoneNumber n = new PhoneNumber(555, 0, 10);
        System.out.println(n);
    }
}
