package entity;

public class Result {
    private int id;
    private double mank;
    private int studentId;
    private int subjectId;

    public Result() {
    }

    public Result(int id, double mank, int studentId, int subjectId) {
        this.id = id;
        this.mank = mank;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMank() {
        return mank;
    }

    public void setMank(double mank) {
        this.mank = mank;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", mank=" + mank +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                '}';
    }
}

