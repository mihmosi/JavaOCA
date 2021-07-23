package day0.JmProjects;

public class Task3_3_12 {

    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human((byte)30, "Mike", "Jackson", "soccer" );
        Human human3 = new Human((byte)30, "Phil", "Smith");
    }

    public static class Human {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {
        }

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this(age,name,secondName);
            this.favoriteSport = favoriteSport;
        }
    }
}
