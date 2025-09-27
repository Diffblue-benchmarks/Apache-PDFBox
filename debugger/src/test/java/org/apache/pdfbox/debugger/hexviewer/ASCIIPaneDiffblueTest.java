package org.apache.pdfbox.debugger.hexviewer;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ASCIIPaneDiffblueTest {
  /**
   * Test {@link ASCIIPane#ASCIIPane(HexModel)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then calls {@link HexModel#addHexModelChangeListener(HexModelChangeListener)}.
   * </ul>
   *
   * <p>Method under test: {@link ASCIIPane#ASCIIPane(HexModel)}
   */
  @Test
  @DisplayName(
      "Test new ASCIIPane(HexModel); given two; then calls addHexModelChangeListener(HexModelChangeListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCIIPane.<init>(HexModel)"})
  void testNewASCIIPane_givenTwo_thenCallsAddHexModelChangeListener() {
    // Arrange
    HexModel model = mock(HexModel.class);
    when(model.totalLine()).thenReturn(2);
    doNothing().when(model).addHexModelChangeListener(Mockito.<HexModelChangeListener>any());

    // Act
    new ASCIIPane(model);

    // Assert
    verify(model).addHexModelChangeListener(isA(HexModelChangeListener.class));
    verify(model).totalLine();
  }
}
