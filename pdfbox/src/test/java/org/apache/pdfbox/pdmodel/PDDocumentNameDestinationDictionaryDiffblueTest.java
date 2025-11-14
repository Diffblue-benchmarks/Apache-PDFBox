package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDocumentNameDestinationDictionaryDiffblueTest {
  /**
   * Test {@link
   * PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDestinationDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocumentNameDestinationDictionary.<init>(COSDictionary)"})
  void testNewPDDocumentNameDestinationDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDDocumentNameDestinationDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDDocumentNameDestinationDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDDocumentNameDestinationDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDDocumentNameDestinationDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDDocumentNameDestinationDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDDocumentNameDestinationDictionary#getDestination(String)}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDDocumentNameDestinationDictionary#PDDocumentNameDestinationDictionary(COSDictionary)}
   *       with dict is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocumentNameDestinationDictionary#getDestination(String)}
   */
  @Test
  @DisplayName(
      "Test getDestination(String); given PDDocumentNameDestinationDictionary(COSDictionary) with dict is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination PDDocumentNameDestinationDictionary.getDestination(String)"
  })
  void testGetDestination_givenPDDocumentNameDestinationDictionaryWithDictIsCOSStream()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDocumentNameDestinationDictionary(new COSStream()).getDestination("Name"));
  }

  /**
   * Test {@link PDDocumentNameDestinationDictionary#getDestination(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocumentNameDestinationDictionary#getDestination(String)}
   */
  @Test
  @DisplayName("Test getDestination(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination PDDocumentNameDestinationDictionary.getDestination(String)"
  })
  void testGetDestination_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDocumentNameDestinationDictionary(new COSDictionary()).getDestination("Name"));
  }

  /**
   * Test {@link PDDocumentNameDestinationDictionary#getDestination(String)}.
   *
   * <ul>
   *   <li>When {@code COSDictionary}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDocumentNameDestinationDictionary#getDestination(String)}
   */
  @Test
  @DisplayName(
      "Test getDestination(String); when 'org.apache.pdfbox.cos.COSDictionary'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination PDDocumentNameDestinationDictionary.getDestination(String)"
  })
  void testGetDestination_whenOrgApachePdfboxCosCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        new PDDocumentNameDestinationDictionary(new COSDictionary())
            .getDestination("org.apache.pdfbox.cos.COSDictionary"));
  }
}
