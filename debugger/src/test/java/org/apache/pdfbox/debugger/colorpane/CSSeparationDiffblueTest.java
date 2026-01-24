package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CSSeparationDiffblueTest {
  /**
   * Test {@link CSSeparation#CSSeparation(COSArray)}.
   *
   * <ul>
   *   <li>Then calls {@link COSName#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link CSSeparation#CSSeparation(COSArray)}
   */
  @Test
  @DisplayName("Test new CSSeparation(COSArray); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSSeparation.<init>(COSArray)"})
  void testNewCSSeparation_thenCallsGetName() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    when(cosName.getName()).thenThrow(new NumberFormatException());

    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosName);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new CSSeparation(array));
    verify(array).getObject(2);
    verify(cosName).getName();
  }

  /**
   * Test {@link CSSeparation#CSSeparation(COSArray)}.
   *
   * <ul>
   *   <li>Then calls {@link COSObject#getObject()}.
   * </ul>
   *
   * <p>Method under test: {@link CSSeparation#CSSeparation(COSArray)}
   */
  @Test
  @DisplayName("Test new CSSeparation(COSArray); then calls getObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSSeparation.<init>(COSArray)"})
  void testNewCSSeparation_thenCallsGetObject() throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenThrow(new NumberFormatException());

    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosObject);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new CSSeparation(array));
    verify(array).getObject(2);
    verify(cosObject).getObject();
  }

  /**
   * Test {@link CSSeparation#CSSeparation(COSArray)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link CSSeparation#CSSeparation(COSArray)}
   */
  @Test
  @DisplayName("Test new CSSeparation(COSArray); then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CSSeparation.<init>(COSArray)"})
  void testNewCSSeparation_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenThrow(new NumberFormatException());

    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosArray);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> new CSSeparation(array));
    verify(array).getObject(2);
    verify(cosArray).isEmpty();
  }
}
