package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionTypeIdentityDiffblueTest {
  /**
   * Test {@link PDFunctionTypeIdentity#PDFunctionTypeIdentity(COSBase)}.
   *
   * <p>Method under test: {@link PDFunctionTypeIdentity#PDFunctionTypeIdentity(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionTypeIdentity(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionTypeIdentity.<init>(COSBase)"})
  void testNewPDFunctionTypeIdentity() {
    // Arrange and Act
    PDFunctionTypeIdentity actualPdFunctionTypeIdentity =
        new PDFunctionTypeIdentity(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionTypeIdentity.getRangeValues());
    assertNull(actualPdFunctionTypeIdentity.getCOSObject());
    assertNull(actualPdFunctionTypeIdentity.getPDStream());
    assertEquals(0, actualPdFunctionTypeIdentity.getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDFunctionTypeIdentity#getFunctionType()}.
   *
   * <p>Method under test: {@link PDFunctionTypeIdentity#getFunctionType()}
   */
  @Test
  @DisplayName("Test getFunctionType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFunctionTypeIdentity.getFunctionType()"})
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDFunctionTypeIdentity(COSBoolean.FALSE).getFunctionType());
  }

  /**
   * Test {@link PDFunctionTypeIdentity#eval(float[])}.
   *
   * <p>Method under test: {@link PDFunctionTypeIdentity#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionTypeIdentity.eval(float[])"})
  void testEval() throws IOException {
    // Arrange and Act
    float[] actualEvalResult =
        new PDFunctionTypeIdentity(COSBoolean.FALSE).eval(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualEvalResult, 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFunctionTypeIdentity#toString()}
   *   <li>{@link PDFunctionTypeIdentity#getRangeValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.cos.COSArray PDFunctionTypeIdentity.getRangeValues()",
    "String PDFunctionTypeIdentity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFunctionTypeIdentity pdFunctionTypeIdentity = new PDFunctionTypeIdentity(COSBoolean.FALSE);

    // Act
    String actualToStringResult = pdFunctionTypeIdentity.toString();

    // Assert
    assertEquals("FunctionTypeIdentity", actualToStringResult);
    assertNull(pdFunctionTypeIdentity.getRangeValues());
  }
}
