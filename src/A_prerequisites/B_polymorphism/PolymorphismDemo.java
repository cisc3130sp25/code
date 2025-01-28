package A_prerequisites.B_polymorphism;

class Animal {
    void makeSound() {
        System.out.print("Animal... ");
        sound();
    }

    void sound() {
        System.out.println("makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat... ");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("barks");
    }

    void chewBone() {
        System.out.println("Chewing bone");
    }
}

/*
Polymorphism: The ability for the same code to be used with
different types of objects and behave differently with each.

Simple example:
- System.out.println can print any type of value.
  Each one displays in its own way on the console.

Another example:
- A variable of type T can refer to an object of any subclass of T.
- So a variable anim of type Animal can refer to an Animal object, a Dog object, or a Cat object.
- Using anim, you can call any method of Animal.
- But, using anim, you cannot call any methods specific to the subclasses.
  (Unless you perform a cast, which usually isn't recommended for non-primitives.)
- When a method is called, the behavior is based on the object's type, not the variable's type.
  This is known as dynamic binding.
 */

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat();
        Animal dog = new Dog();

        animal.makeSound(); // Animal... makes a sound
        cat.makeSound();    // Cat...
        dog.makeSound();    // Animal... barks

        // cannot do: dog.chewBone();

        System.out.println();

        Animal[] animals = {
                new Animal(),
                new Cat(),
                new Dog()
        };

        for (Animal a : animals) {
            a.makeSound();
        }
        // same output as above
    }
}
