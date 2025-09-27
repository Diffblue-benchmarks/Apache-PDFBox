package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadMemoryMappedFileDiffblueTest {
  /**
   * Test {@link RandomAccessReadMemoryMappedFile#seek(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadMemoryMappedFile#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadMemoryMappedFile.seek(long)"})
  void testSeek_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadMemoryMappedFile("42").seek(-1L));
  }
}
