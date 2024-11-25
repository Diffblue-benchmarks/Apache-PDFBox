package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CSSeparationDiffblueTest {
  /**
   * Test {@link CSSeparation#CSSeparation(COSArray)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CSSeparation#CSSeparation(COSArray)}
   */
  @Test
  @DisplayName("Test new CSSeparation(COSArray); then throw NumberFormatException")
  void testNewCSSeparation_thenThrowNumberFormatException() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenThrow(new NumberFormatException("First element in colorspace array must be a name"));
    when(cosArray.getObject(anyInt())).thenThrow(new NumberFormatException("foo"));
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosArray);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new CSSeparation(array));
    verify(array).getObject(eq(2));
    verify(cosArray).isEmpty();
  }
}
