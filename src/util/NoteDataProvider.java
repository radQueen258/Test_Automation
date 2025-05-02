package util;

import model.NoteData;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;
import model.NoteDataList;

public class NoteDataProvider {

    public static List<NoteData> getNotesFromXml(String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(NoteDataList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            NoteDataList wrapper = (NoteDataList) unmarshaller.unmarshal(new File(path));
            return wrapper.getNotes();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read XML: " + e.getMessage(), e);
        }
    }
}
