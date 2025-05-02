package model;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "NoteData")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoteData {

    private String title;
    private String content;

    public NoteData() {}

    public NoteData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
}
