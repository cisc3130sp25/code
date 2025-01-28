package A_prerequisites.C_toString_equals_hashCode.E_overriding_hashCode;

import java.util.Objects;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "student with name " + name + " and id " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student other = (Student) o;
            return this.name.equals(other.name) && this.id == other.id;
        } else {
            return false;
        }
    }

    /*
    The documentation for Object's equals method states the following:
    "It is generally necessary to override the hashCode method whenever
    this method is overridden, so as to maintain the general contract for
    the hashCode method, which states that equal objects must have equal
    hash codes."

    A hash code is an integer associated with an object.
    Hash codes are necessary in order to make certain data
    structures, such as HashMap, work correctly.
    (We'll learn about HashMap in a few weeks.)

    The hashCode method returns a hash code for an object.
    This method is found in the Object class, but we are
    supposed to override it whenever we override equals.

    The most important property that a hashCode method must
    have is that equal objects must have equal hash codes.
    As the hashCode documentation in the Object class states:
    "If two objects are equal according to the equals method,
    then calling the hashCode method on each of the two objects
    must produce the same integer result."
    That is, if o1.equals(o2) is true, then
    o1.hashCode() == o2.hashCode() must be true.

    We must always abide by specification that we inherit.
    We are allowed to add requirements in our subclass
    (for example, make hashCode only return non-negative by using Math.abs()),
    but cannot violate the inherited specification.
    In the case of the hashCode method,
    if we violate the specification inherited from Object,
    then HashMap (etc.) will not work correctly.

    Question: does the following hashCode method follow the specification?
    @Override
    public int hashCode() {
        return 42;
    }

    Answer: yes, since it guarantees that equal objects will have equal hash codes.

    Ideally, however, a good hashCode method should try as
    much as possible to produce unequal hash codes for unequal objects.
    In order to accomplish this, the hash code for an object should
    depend on its fields that are used in the equals method.
    If we don't follow this ideal way,
    HashMap (etc.) will still work correctly (as long as we follow
    the earlier rule) but will work very slowly.

    Writing our own code to make an ideal hashCode method is not easy.
    Luckily, there's a shortcut: the static hash method in the java.util.Objects class.
    (Note the 's' at the end of Objects.)
    We can send as many fields as we want to this method, and
    the method returns an integer based on the fields. The
    fields that we send to this method should be the
    same as those that are used in the equals method.
    */
    @Override
    public int hashCode() {
        int result = Objects.hash(name, id);
        return result;

        // or simply: return Objects.hash(name, id);
    }
}
