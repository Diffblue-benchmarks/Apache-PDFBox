package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TrueTypeCollectionDiffblueTest {
  /**
   * Test {@link TrueTypeCollection#TrueTypeCollection(InputStream)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrueTypeCollection#TrueTypeCollection(InputStream)}
   */
  @Test
  @DisplayName("Test new TrueTypeCollection(InputStream); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrueTypeCollection.<init>(InputStream)"})
  void testNewTrueTypeCollection_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> new TrueTypeCollection(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }
}
