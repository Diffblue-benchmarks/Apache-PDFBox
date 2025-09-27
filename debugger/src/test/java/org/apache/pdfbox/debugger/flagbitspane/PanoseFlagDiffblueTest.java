package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PanoseFlagDiffblueTest {
  /**
   * Test {@link PanoseFlag#PanoseFlag(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return FlagValue is {@code Panose byte :0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PanoseFlag#PanoseFlag(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PanoseFlag(COSDictionary); then return FlagValue is 'Panose byte :0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PanoseFlag.<init>(COSDictionary)"})
  void testNewPanoseFlag_thenReturnFlagValueIsPanoseByte0123456789abcdef() throws IOException {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act
    PanoseFlag actualPanoseFlag = new PanoseFlag(dictionary);

    // Assert
    verify(dictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    assertEquals("Panose byte :0123456789ABCDEF", actualPanoseFlag.getFlagValue());
    assertEquals("Panose classification", actualPanoseFlag.getFlagType());
    assertArrayEquals(
        new String[] {"Byte Position", "Name", "Byte Value", "Value"},
        actualPanoseFlag.getColumnNames());
  }

  /**
   * Test {@link PanoseFlag#PanoseFlag(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return FlagValue is {@code Panose byte :null}.
   * </ul>
   *
   * <p>Method under test: {@link PanoseFlag#PanoseFlag(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PanoseFlag(COSDictionary); then return FlagValue is 'Panose byte :null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PanoseFlag.<init>(COSDictionary)"})
  void testNewPanoseFlag_thenReturnFlagValueIsPanoseByteNull() throws UnsupportedEncodingException {
    // Arrange
    COSString cosString = mock(COSString.class);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);

    // Act
    PanoseFlag actualPanoseFlag = new PanoseFlag(dictionary);

    // Assert
    verify(dictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosString).getBytes();
    assertEquals("Panose byte :null", actualPanoseFlag.getFlagValue());
    assertEquals("Panose classification", actualPanoseFlag.getFlagType());
    assertArrayEquals(
        new String[] {"Byte Position", "Name", "Byte Value", "Value"},
        actualPanoseFlag.getColumnNames());
  }
}
