public class Animal {
  /*Every animal has a hunger value, which is a whole number
  Every animal has a thirst value, which is a whole number
  when creating a new animal object these values are created with the default 50 value
  Every animal can eat() which decreases their hunger by one
  Every animal can drink() which decreases their thirst by one
  Every animal can play() which increases both by one
  */
  static int hunger = 50;
  static int thirst = 50;
  public void eat(){
    hunger+=1;
  }
  public void drink(){
    thirst+=1;
  }
  public void play(){
    hunger-=1;
    thirst-=1;
  }
}
