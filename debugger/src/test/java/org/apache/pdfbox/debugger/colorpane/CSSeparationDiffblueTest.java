package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CSSeparationDiffblueTest {
  /**
   * Method under test: {@link CSSeparation#CSSeparation(COSArray)}
   */
  @Test
  void testNewCSSeparation() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenThrow(new NumberFormatException("First element in colorspace array must be a name"));
    when(cosArray.getObject(anyInt())).thenThrow(new NumberFormatException("foo"));
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosArray);
    doNothing().when(array).add(Mockito.<COSObjectable>any());
    array.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new CSSeparation(array));
    verify(array).add(isA(COSObjectable.class));
    verify(array).getObject(eq(2));
    verify(cosArray).isEmpty();
  }
}
