package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class PDVisibleSigPropertiesDiffblueTest {
  /**
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
    actualPdVisibleSigProperties.getPdVisibleSignature();
    int actualPreferredSize = actualPdVisibleSigProperties.getPreferredSize();
    String actualSignatureReason = actualPdVisibleSigProperties.getSignatureReason();
    String actualSignerLocation = actualPdVisibleSigProperties.getSignerLocation();
    String actualSignerName = actualPdVisibleSigProperties.getSignerName();
    InputStream actualVisibleSignature = actualPdVisibleSigProperties.getVisibleSignature();
    boolean actualIsVisualSignEnabledResult = actualPdVisibleSigProperties.isVisualSignEnabled();

    // Assert that nothing has changed
    assertEquals("Just cause", actualSignatureReason);
    assertEquals("Signer Location", actualSignerLocation);
    assertEquals("Signer Name", actualSignerName);
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
