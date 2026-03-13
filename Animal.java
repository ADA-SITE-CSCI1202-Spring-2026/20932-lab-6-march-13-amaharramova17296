public class Animal {
    private String animalName;
    private String ownerName;
    private int age;

    public Animal(String animalName, String ownerName, int age) {
        this.animalName = animalName;
        this.ownerName = ownerName;
                try {
            setage(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting age: " + e.getMessage());
            this.age = 0; 
        }
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAge() {
        return age;
    }

   public void setanimalName(String animalname) {
      animalName = animalname;
   }
   public void setaownerName(String ownername) {
      ownerName = ownername;
   }
    public void setage(int Age) {
     if (Age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        age = Age;
   }
    @Override
    public String toString() {
        return "Animal Name: " + animalName +
               ", Owner Name: " + ownerName +
               ", Age: " + age;
}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Animal animal = (Animal) obj;

        return age == animal.age &&
               animalName.equals(animal.animalName) &&
               ownerName.equals(animal.ownerName);
 }
}