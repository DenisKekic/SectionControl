import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionControl {
    private double distance;
    private double maxSpeed;
    Map<String, Duration> map;
    List<PenalData> list;
    PenalData penalData;

    public SectionControl(double distance, double maxSpeed) {
        map = new HashMap<>();
        list = new ArrayList<>();
        this.distance = distance;
        this.maxSpeed = maxSpeed;
    }

    public void newCarEntered(String plateNumber, long startTime){
        Duration duration = new Duration();
        duration.setStartTime(startTime);
        map.put(plateNumber, duration);
    }

    public void carLeft(String plateNumber, long endTime){
        map.get(plateNumber).setEndTime(endTime);
        double averageSpeed =
                calculateAverageSpeed(map.get(plateNumber).getDuration());
        if(averageSpeed > this.maxSpeed){
            list.add(new PenalData(plateNumber, averageSpeed));
        }
        map.remove(plateNumber);
    }

    public double calculateAverageSpeed(long duration){
        return this.distance / duration;
    }

    public List<PenalData> getPenalDataList(){
        return list;
    }
}
