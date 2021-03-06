public class Gnirts implements CharSequence {

  String string;

  Gnirts(String string) {
    this.string = string;


  }

  @Override
  public int length() {
    return this.string.length();
  }

  @Override
  public char charAt(int index) {
    return this.string.charAt(this.string.length() - index - 1);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    String subSequenceToBeTurned = "";
    for (int i = start; i < end; i++) {
      subSequenceToBeTurned += this.string.charAt(this.string.length()-i-1);
    }

    return subSequenceToBeTurned;
  }
  /*Check out the CharSequence interface
  Create a Gnirts class implementing this interface
  It should have one String field that can be set via the constructor
                  Implementing the interfaces methods always think of the field as backwards, so at the second position of "this example" there is a 'p'
  In a main method try out all the methods
  Create a Shifter class implementing this interface
  This charsequence can be set up with a string (that is to be shifted) and a number (which will tell how many to shift)
  Implement the methods so the returned results of them will be shifted
  Gnirts g = new Gnirts("example");
System.out.println(g.charAt(1));
// should print out: l

  Shifter s = new Shifter("example", 2);
System.out.println(s.charAt(0));
// should print out: a
*/

}

