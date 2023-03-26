import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TranslatorTest {

    @Test
    public void testTranslation() {
        String translation = Translator.translate("english", "spanish", "dog");
        assertEquals("Translation: perro", translation);
    }
}