public class Student {

    private String iD;
    private String name;
    private int score;

    public Student() {
    }

    public Student(String iD, String name, int score) {
        this.iD = iD;
        this.name = name;
        this.score = score;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student = [ID: %s, Name: %s, Score: %d]", iD, name, score);
    }

}
