package _12_javaCollectionFramework.pratice.p2;

 class Student {
  private String name;
  private int age;
  private String address;

  public Student(String name, int age, String address) {
   this.name = name;
   this.age = age;
   this.address = address;
  }

  public int getAge() {
   return age;
  }

  public void setAge(int age) {
   this.age = age;
  }

  public String getName() {
   return name;
  }

  public void setName(String name) {
   this.name = name;
  }

  public String getAddress() {
   return address;
  }

  public void setAddress(String address) {
   this.address = address;
  }

  @Override
  public String toString() {
   return "name= "+this.name +", age= "+ this.age +", address= "+ this.address;
  }
 }
