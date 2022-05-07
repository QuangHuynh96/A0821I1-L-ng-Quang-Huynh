package codegym.entity;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @Column( columnDefinition = "varchar(10)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String songWriter;
    private String songType;
    private String link;

    public Song() {
    }

    public Song(String name, String songWriter, String songType, String link) {
        this.name = name;
        this.songWriter = songWriter;
        this.songType = songType;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
