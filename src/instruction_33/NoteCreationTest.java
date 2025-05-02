package instruction_33;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import java.util.*;
import model.NoteData;
import util.NoteDataProvider;


@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoteCreationTest extends TestBase{

    private NoteData note;

    public NoteCreationTest(NoteData note) {
        this.note = note;
    }

    @Parameterized.Parameters
    public static Collection<NoteData> data() {
        return NoteDataProvider.getNotesFromXml("src/test/resources/notes.xml");
    }

    @Test
    public void createNoteTest() {
        app.navigation().openHomePage();
        app.login().login("radqueen.nhapulo@gmail.com", "AkdarNhapulo");
        app.login().continueAfterLogin();
        app.notes().createNote(note);

    }
}
