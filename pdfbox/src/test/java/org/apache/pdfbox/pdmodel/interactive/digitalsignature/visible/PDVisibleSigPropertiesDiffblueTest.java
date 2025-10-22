package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDVisibleSigPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PDVisibleSigProperties}
   *   <li>{@link PDVisibleSigProperties#page(int)}
   *   <li>{@link PDVisibleSigProperties#preferredSize(int)}
   *   <li>{@link PDVisibleSigProperties#setVisibleSignature(InputStream)}
   *   <li>{@link PDVisibleSigProperties#signatureReason(String)}
   *   <li>{@link PDVisibleSigProperties#signerLocation(String)}
   *   <li>{@link PDVisibleSigProperties#signerName(String)}
   *   <li>{@link PDVisibleSigProperties#visualSignEnabled(boolean)}
   *   <li>{@link PDVisibleSigProperties#getPage()}
   *   <li>{@link PDVisibleSigProperties#getPdVisibleSignature()}
   *   <li>{@link PDVisibleSigProperties#getPreferredSize()}
   *   <li>{@link PDVisibleSigProperties#getSignatureReason()}
   *   <li>{@link PDVisibleSigProperties#getSignerLocation()}
   *   <li>{@link PDVisibleSigProperties#getSignerName()}
   *   <li>{@link PDVisibleSigProperties#getVisibleSignature()}
   *   <li>{@link PDVisibleSigProperties#isVisualSignEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigProperties.<init>()", "int PDVisibleSigProperties.getPage()",
      "PDVisibleSignDesigner PDVisibleSigProperties.getPdVisibleSignature()",
      "int PDVisibleSigProperties.getPreferredSize()", "String PDVisibleSigProperties.getSignatureReason()",
      "String PDVisibleSigProperties.getSignerLocation()", "String PDVisibleSigProperties.getSignerName()",
      "InputStream PDVisibleSigProperties.getVisibleSignature()",
      "boolean PDVisibleSigProperties.isVisualSignEnabled()", "PDVisibleSigProperties PDVisibleSigProperties.page(int)",
      "PDVisibleSigProperties PDVisibleSigProperties.preferredSize(int)",
      "PDVisibleSigProperties PDVisibleSigProperties.setPdVisibleSignature(PDVisibleSignDesigner)",
      "void PDVisibleSigProperties.setVisibleSignature(InputStream)",
      "PDVisibleSigProperties PDVisibleSigProperties.signatureReason(String)",
      "PDVisibleSigProperties PDVisibleSigProperties.signerLocation(String)",
      "PDVisibleSigProperties PDVisibleSigProperties.signerName(String)",
      "PDVisibleSigProperties PDVisibleSigProperties.visualSignEnabled(boolean)"})
  void testGettersAndSetters() throws IOException {
    // Arrange and Act
    PDVisibleSigProperties actualPdVisibleSigProperties = new PDVisibleSigProperties();
    PDVisibleSigProperties actualPageResult = actualPdVisibleSigProperties.page(1);
    PDVisibleSigProperties actualPreferredSizeResult = actualPdVisibleSigProperties.preferredSize(3);
    ByteArrayInputStream visibleSignature = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    actualPdVisibleSigProperties.setVisibleSignature(visibleSignature);
    PDVisibleSigProperties actualSignatureReasonResult = actualPdVisibleSigProperties.signatureReason("Just cause");
    PDVisibleSigProperties actualSignerLocationResult = actualPdVisibleSigProperties.signerLocation("Signer Location");
    PDVisibleSigProperties actualSignerNameResult = actualPdVisibleSigProperties.signerName("Signer Name");
    PDVisibleSigProperties actualVisualSignEnabledResult = actualPdVisibleSigProperties.visualSignEnabled(true);
    int actualPage = actualPdVisibleSigProperties.getPage();
    PDVisibleSignDesigner actualPdVisibleSignature = actualPdVisibleSigProperties.getPdVisibleSignature();
    int actualPreferredSize = actualPdVisibleSigProperties.getPreferredSize();
    String actualSignatureReason = actualPdVisibleSigProperties.getSignatureReason();
    String actualSignerLocation = actualPdVisibleSigProperties.getSignerLocation();
    String actualSignerName = actualPdVisibleSigProperties.getSignerName();
    InputStream actualVisibleSignature = actualPdVisibleSigProperties.getVisibleSignature();
    boolean actualIsVisualSignEnabledResult = actualPdVisibleSigProperties.isVisualSignEnabled();

    // Assert
    assertEquals("Just cause", actualSignatureReason);
    assertEquals("Signer Location", actualSignerLocation);
    assertEquals("Signer Name", actualSignerName);
    assertNull(actualPdVisibleSignature);
    assertEquals(1, actualPage);
    assertEquals(3, actualPreferredSize);
    assertEquals(8, actualVisibleSignature.read(new byte[8]));
    assertTrue(actualIsVisualSignEnabledResult);
    assertSame(visibleSignature, actualVisibleSignature);
    assertSame(actualPdVisibleSigProperties, actualPageResult);
    assertSame(actualPdVisibleSigProperties, actualPreferredSizeResult);
    assertSame(actualPdVisibleSigProperties, actualSignatureReasonResult);
    assertSame(actualPdVisibleSigProperties, actualSignerLocationResult);
    assertSame(actualPdVisibleSigProperties, actualSignerNameResult);
    assertSame(actualPdVisibleSigProperties, actualVisualSignEnabledResult);
  }
}
