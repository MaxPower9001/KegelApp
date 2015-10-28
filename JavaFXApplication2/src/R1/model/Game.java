package R1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Game {
    
    private ObjectProperty<LocalDate> date;
    private ObjectProperty<LocalTime> time;
    
    private ObjectProperty<Button> editButton = new SimpleObjectProperty(new Button("Edit"));
    private ObjectProperty<Button> playButton = new SimpleObjectProperty(new Button("Play"));
    
    private StringProperty creatorMail;
    private IntegerProperty gameId;
    private IntegerProperty eventId;
    private StringProperty  location;
    private IntegerProperty alleyNumber;
    
    private ObjectProperty<HashMap> players;
    
    public Game(String creatorMail, int gameId, int eventId, String location, int alleyNumber, LocalDate date, LocalTime time, HashMap<String,List> players) {
        this.gameId      = new SimpleIntegerProperty(gameId);
        this.eventId     = new SimpleIntegerProperty(eventId);
        this.alleyNumber = new SimpleIntegerProperty(alleyNumber);
        
        this.creatorMail   = new SimpleStringProperty(creatorMail);
        this.location = new SimpleStringProperty(location);
        
        this.date = new SimpleObjectProperty<>(date);
        this.time = new SimpleObjectProperty<>(time);
        
        this.players = new SimpleObjectProperty<HashMap>(players);
    }

    public ObjectProperty<LocalDate> date() {
        return date;
    }

    public void date(ObjectProperty<LocalDate> date) {
        this.date = date;
    }

    public ObjectProperty<LocalTime> time() {
        return time;
    }

    public void time(ObjectProperty<LocalTime> time) {
        this.time = time;
    }

    public StringProperty creatorId() {
        return creatorMail;
    }

    public void creatorId(StringProperty creatorMail) {
        this.creatorMail = creatorMail;
    }

    public IntegerProperty gameId() {
        return gameId;
    }

    public void gameId(IntegerProperty gameId) {
        this.gameId = gameId;
    }

    public IntegerProperty eventId() {
        return eventId;
    }

    public void eventId(IntegerProperty eventId) {
        this.eventId = eventId;
    }

    public StringProperty location() {
        return location;
    }

    public void location(StringProperty location) {
        this.location = location;
    }

    public IntegerProperty alleyNumber() {
        return alleyNumber;
    }

    public void alleyNumber(IntegerProperty alleyNumber) {
        this.alleyNumber = alleyNumber;
    }

    public ObjectProperty<Button> editButton() {
        return editButton;
    }

    public void editButton(ObjectProperty<Button> editButton) {
        this.editButton = editButton;
    }

    public ObjectProperty<Button> playButton() {
        return playButton;
    }

    public void playButton(ObjectProperty<Button> playButton) {
        this.playButton = playButton;
    }
    
    public ObjectProperty<LocalDateTime> dateTime(){
        return new SimpleObjectProperty<>(LocalDateTime.of(this.date.getValue(), this.time.getValue()));
    }

    public ObjectProperty<HashMap> players() {
        return players;
    }

    public void players(ObjectProperty<HashMap> players) {
        this.players = players;
    }
    
    public StringProperty playerProperty() {
        return new SimpleStringProperty(players.getValue().keySet().toString());
    }
    
}
