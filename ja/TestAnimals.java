/* 1. Create the Animal class, which is the abstract superclass of all animals.

a) Declare a protected integer attribute called legs, which records the number of legs for this animal.

b) Define a protected constructor that initializes the legs attribute.

c) Declare an abstract method.

d) Declare a concrete method walk that prints out something about how the animals walks (including the number of legs).
*/

abstract class Animal {
 protected int legs;
 protected Animal(int legs) {
 this.legs = legs;
 }
 public void walk() {
 System.out.println("This animal walks with " + legs + " legs.");
 }
 public abstract void eat();
}
/* 2. Create the Spider class.

a) The Spider class extends the Animal class.

b) Define a default constructor that calls the superclass constructor to specify that all spiders have eight legs.

c) Implement the eat methods to specify that "The spider is eating".
*/
class Spider extends Animal {
    public Spider() {
    super(8);
    }
    @Override
    public void eat() {
    System.out.println("The spider is eating.");
    }
   }
   /* 3. Create the pet interface specified by the diagram*/
   interface Pet {
    String getName();
    void setName(String name);
    void play();
   }
   /*4. Create the Cat class that extends Animal and implements Pet.

a) This class should include a String attribute to store the pet's name of the pet.

b) Define a constructor that takes one string parameter that specifies the cat's name. This constructor should also call the superclass's constructor to specify that all cats have four legs.

c) Define another constructor that takes no parameters. Have this constructor calls the previous constructor (using the "this" keyword) and pass an empty string as the argument.

d) Implement the Pet interface methods.

e) Implement the eat method. */

   class Cat extends Animal implements Pet {
    private String name;
    public Cat(String name) {
    super(4);
    this.name = name;
    }
    public Cat() {
    this("");
    }
    @Override
    public String getName() {
    return name;
    }
    @Override
    public void setName(String name) {
    this.name = name;
    }
    @Override
    public void play() {
    System.out.println(name + " is playing.");
    }
    @Override
    public void eat() {
    System.out.println("The cat is eating.");
    }
   }
   /*Create the Fish class. Override the Animal methods to specify that fish can't walk and don't have legs.*/
   class Fish extends Animal implements Pet {
    private String name;
    public Fish() {
    super(0);
    }
    @Override
    public String getName() {
    return name;
    }
    @Override
    public void setName(String name) {
    this.name = name;
    }
    @Override
    public void play() {
    System.out.println(name + " is playing in the water.");
    }
    @Override
    public void eat() {
    System.out.println("The fish is eating.");
    }
    @Override
    public void walk() {
    System.out.println("Fish can't walk and don't have legs.");
    }
   }
   /*6. Create a TestAnimals program.Have the main method create and manipulate instances of the classes you created above. Start with:
            Fish d = new Fish();
            Cat c = new Cat("Fluffy");
            Animal a = new Fish();
            Animal e = new Spider();
            Pet p = new Cat(); */
   public class TestAnimals {
    public static void main(String[] args) {
    Fish d = new Fish();
    Cat c = new Cat("Fluffy");
    Animal a1 = new Fish();
    Animal a2 = new Spider();
    Pet p = new Cat();
    // Calling methods in each object
    d.setName("Nemo");
    d.play();
    d.walk();
    d.eat();
    c.play();
    c.walk();
    c.eat();
    a1.eat();
    a1.walk();
    a2.eat();
    a2.walk();
    // Casting objects
    if (p instanceof Cat) {
    Cat catPet = (Cat) p;
    catPet.setName("Kitty");
    catPet.play();
    }
    // Using polymorphism
    Animal[] animals = {d, c, a1, a2};
    for (Animal animal : animals) {
    animal.walk();
    animal.eat();
    }
    // Using super to call superclass methods
    System.out.println("Calling superclass methods via subclass instances:");
    d.walk();
    c.walk();
    }
   }
