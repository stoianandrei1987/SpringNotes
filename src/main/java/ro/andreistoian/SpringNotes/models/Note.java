package ro.andreistoian.SpringNotes.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "note")
    String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}
