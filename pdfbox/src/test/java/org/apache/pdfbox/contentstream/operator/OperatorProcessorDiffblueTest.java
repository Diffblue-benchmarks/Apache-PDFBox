package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.encryption.StandardSecurityHandler;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OperatorProcessorDiffblueTest {
  /**
   * Test {@link OperatorProcessor#getContext()}.
   * <p>
   * Method under test: {@link OperatorProcessor#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.contentstream.PDFStreamEngine OperatorProcessor.getContext()"})
  void testGetContext() {
    // Arrange
    PDFMarkedContentExtractor context = new PDFMarkedContentExtractor();

    // Act and Assert
    assertSame(context, (new DrawObject(context)).getContext());
  }

  /**
   * Test {@link OperatorProcessor#checkArrayTypesClass(List, Class)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatorProcessor#checkArrayTypesClass(List, Class)}
   */
  @Test
  @DisplayName("Test checkArrayTypesClass(List, Class); given FALSE; when ArrayList() add FALSE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperatorProcessor.checkArrayTypesClass(List, Class)"})
  void testCheckArrayTypesClass_givenFalse_whenArrayListAddFalse_thenReturnFalse() {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(drawObject.checkArrayTypesClass(operands, StandardSecurityHandler.PROTECTION_POLICY_CLASS));
  }

  /**
   * Test {@link OperatorProcessor#checkArrayTypesClass(List, Class)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatorProcessor#checkArrayTypesClass(List, Class)}
   */
  @Test
  @DisplayName("Test checkArrayTypesClass(List, Class); given FALSE; when ArrayList() add FALSE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperatorProcessor.checkArrayTypesClass(List, Class)"})
  void testCheckArrayTypesClass_givenFalse_whenArrayListAddFalse_thenReturnFalse2() {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertFalse(drawObject.checkArrayTypesClass(operands, StandardSecurityHandler.PROTECTION_POLICY_CLASS));
  }

  /**
   * Test {@link OperatorProcessor#checkArrayTypesClass(List, Class)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperatorProcessor#checkArrayTypesClass(List, Class)}
   */
  @Test
  @DisplayName("Test checkArrayTypesClass(List, Class); when ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperatorProcessor.checkArrayTypesClass(List, Class)"})
  void testCheckArrayTypesClass_whenArrayList_thenReturnTrue() {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());

    // Act and Assert
    assertTrue(drawObject.checkArrayTypesClass(new ArrayList<>(), StandardSecurityHandler.PROTECTION_POLICY_CLASS));
  }
}
