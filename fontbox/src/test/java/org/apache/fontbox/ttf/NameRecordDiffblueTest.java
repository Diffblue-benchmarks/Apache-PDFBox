package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameRecordDiffblueTest {
  /**
   * Test {@link NameRecord#initData(TrueTypeFont, TTFDataStream)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link NameRecord} (default constructor) LanguageId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameRecord#initData(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test initData(TrueTypeFont, TTFDataStream); given one; then NameRecord (default constructor) LanguageId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NameRecord.initData(TrueTypeFont, TTFDataStream)"})
  void testInitData_givenOne_thenNameRecordLanguageIdIsOne() throws IOException {
    // Arrange
    NameRecord nameRecord = new NameRecord();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    nameRecord.initData(ttf, data);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(1, nameRecord.getLanguageId());
    assertEquals(1, nameRecord.getNameId());
    assertEquals(1, nameRecord.getPlatformEncodingId());
    assertEquals(1, nameRecord.getPlatformId());
    assertEquals(1, nameRecord.getStringLength());
    assertEquals(1, nameRecord.getStringOffset());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NameRecord}
   *   <li>{@link NameRecord#setLanguageId(int)}
   *   <li>{@link NameRecord#setNameId(int)}
   *   <li>{@link NameRecord#setPlatformEncodingId(int)}
   *   <li>{@link NameRecord#setPlatformId(int)}
   *   <li>{@link NameRecord#setString(String)}
   *   <li>{@link NameRecord#setStringLength(int)}
   *   <li>{@link NameRecord#setStringOffset(int)}
   *   <li>{@link NameRecord#toString()}
   *   <li>{@link NameRecord#getLanguageId()}
   *   <li>{@link NameRecord#getNameId()}
   *   <li>{@link NameRecord#getPlatformEncodingId()}
   *   <li>{@link NameRecord#getPlatformId()}
   *   <li>{@link NameRecord#getString()}
   *   <li>{@link NameRecord#getStringLength()}
   *   <li>{@link NameRecord#getStringOffset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NameRecord.<init>()", "int NameRecord.getLanguageId()", "int NameRecord.getNameId()",
      "int NameRecord.getPlatformEncodingId()", "int NameRecord.getPlatformId()", "String NameRecord.getString()",
      "int NameRecord.getStringLength()", "int NameRecord.getStringOffset()", "void NameRecord.setLanguageId(int)",
      "void NameRecord.setNameId(int)", "void NameRecord.setPlatformEncodingId(int)",
      "void NameRecord.setPlatformId(int)", "void NameRecord.setString(String)", "void NameRecord.setStringLength(int)",
      "void NameRecord.setStringOffset(int)", "String NameRecord.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    NameRecord actualNameRecord = new NameRecord();
    actualNameRecord.setLanguageId(1);
    actualNameRecord.setNameId(1);
    actualNameRecord.setPlatformEncodingId(1);
    actualNameRecord.setPlatformId(1);
    actualNameRecord.setString("42");
    actualNameRecord.setStringLength(3);
    actualNameRecord.setStringOffset(42);
    String actualToStringResult = actualNameRecord.toString();
    int actualLanguageId = actualNameRecord.getLanguageId();
    int actualNameId = actualNameRecord.getNameId();
    int actualPlatformEncodingId = actualNameRecord.getPlatformEncodingId();
    int actualPlatformId = actualNameRecord.getPlatformId();
    String actualString = actualNameRecord.getString();
    int actualStringLength = actualNameRecord.getStringLength();

    // Assert
    assertEquals("42", actualString);
    assertEquals("platform=1 pEncoding=1 language=1 name=1 42", actualToStringResult);
    assertEquals(1, actualLanguageId);
    assertEquals(1, actualNameId);
    assertEquals(1, actualPlatformEncodingId);
    assertEquals(1, actualPlatformId);
    assertEquals(3, actualStringLength);
    assertEquals(42, actualNameRecord.getStringOffset());
  }
}
