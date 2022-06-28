package pl.pp.spring.trainingrecorderapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workouts")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double amountKilometers;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    private Long amountCalories;

    @Lob
    private String description;

    public Training() {
    }

    public Training(Long id, LocalDate date, Double amountKilometers,
                    Integer hours, Integer minutes, Integer seconds, Long amountCalories, String content) {
        this.id = id;
        this.date = date;
        this.amountKilometers = amountKilometers;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.amountCalories = amountCalories;
        this.description = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmountKilometers() {
        return amountKilometers;
    }

    public void setAmountKilometers(Double amountKilometers) {
        this.amountKilometers = amountKilometers;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Long getAmountCalories() {
        return amountCalories;
    }

    public void setAmountCalories(Long amountCalories) {
        this.amountCalories = amountCalories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", date=" + date +
                ", amountKilometers=" + amountKilometers +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                ", amountCalories=" + amountCalories +
                ", content='" + description + '\'' +
                '}';
    }

    public String getFullTime() {
        return hours + ":" + minutes + ":" + seconds;
    }

    public String getAverageSpeedTime() {
        int allSeconds = hours * 3600 + minutes * 60 + seconds;
        double allMeters = amountKilometers * 1000;
        double averageSpeed = (Math.round(allMeters / allSeconds * 100));

        return averageSpeed / 100 + "";
    }

}
