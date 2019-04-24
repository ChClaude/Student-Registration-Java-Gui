public class Graduate extends Student implements Comparable<Graduate> {

    private  String qualification;
    private double fee;

    public Graduate() {
    }

    public Graduate(String iD, String name, int score, String qualification, double fee) {
        super(iD, name, score);
        this.qualification = qualification;
        this.fee = fee;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("Graduate = [ID: %s, Name: %s, Score: %d, Qualification: %s, Fee: %.2f]", super.getiD(), super.getName(), super.getScore(), qualification, fee);
    }

    @Override
    public int compareTo(Graduate g) {
        return this.getName().compareTo(g.getName());
    }
}
