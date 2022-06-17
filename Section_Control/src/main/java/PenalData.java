public class PenalData {
    private String plateNumber;
    private double speed;

    public PenalData(String plateNumber, double speed) {
        this.plateNumber = plateNumber;
        this.speed = speed;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "PenalData{" +
                "plateNumber='" + plateNumber + '\'' +
                ", speed=" + speed +
                '}';
    }
}
