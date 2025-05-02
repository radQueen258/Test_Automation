package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Notes")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoteDataList {

    @XmlElement(name = "NoteData")
    private List<NoteData> notes;

    public NoteDataList() {}
    public NoteDataList(List<NoteData> notes) {
        this.notes = notes;
    }

    public List<NoteData> getNotes() {
        return notes;
    }
}
