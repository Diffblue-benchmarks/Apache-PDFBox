package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionFactoryDiffblueTest {
  /**
   * Test {@link PDActionFactory#createAction(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionFactory#createAction(COSDictionary)}
   */
  @Test
  @DisplayName("Test createAction(COSDictionary); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDAction PDActionFactory.createAction(COSDictionary)"
  })
  void testCreateAction_whenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(PDActionFactory.createAction(new COSDictionary()));
  }

  /**
   * Test {@link PDActionFactory#createAction(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionFactory#createAction(COSDictionary)}
   */
  @Test
  @DisplayName("Test createAction(COSDictionary); when COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDAction PDActionFactory.createAction(COSDictionary)"
  })
  void testCreateAction_whenCOSStream() {
    // Arrange, Act and Assert
    assertNull(PDActionFactory.createAction(new COSStream()));
  }

  /**
   * Test {@link PDActionFactory#createAction(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionFactory#createAction(COSDictionary)}
   */
  @Test
  @DisplayName("Test createAction(COSDictionary); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDAction PDActionFactory.createAction(COSDictionary)"
  })
  void testCreateAction_whenNull() {
    // Arrange, Act and Assert
    assertNull(PDActionFactory.createAction(null));
  }
}
