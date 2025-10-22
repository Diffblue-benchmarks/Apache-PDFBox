package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSNameDiffblueTest {
  /**
   * Test {@link COSName#getPDFName(String)}.
   * <ul>
   *   <li>When {@code A Name}.</li>
   *   <li>Then return Name is {@code A Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  @DisplayName("Test getPDFName(String); when 'A Name'; then return Name is 'A Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName COSName.getPDFName(String)"})
  void testGetPDFName_whenAName_thenReturnNameIsAName() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("A Name");

    // Assert
    assertEquals("A Name", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Test {@link COSName#getPDFName(String)}.
   * <ul>
   *   <li>When {@code Yes}.</li>
   *   <li>Then return Name is {@code Yes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#getPDFName(String)}
   */
  @Test
  @DisplayName("Test getPDFName(String); when 'Yes'; then return Name is 'Yes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSName COSName.getPDFName(String)"})
  void testGetPDFName_whenYes_thenReturnNameIsYes() {
    // Arrange and Act
    COSName actualPDFName = COSName.getPDFName("Yes");

    // Assert
    assertEquals("Yes", actualPDFName.getName());
    assertNull(actualPDFName.getKey());
    assertFalse(actualPDFName.isDirect());
    assertFalse(actualPDFName.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#toString()}
   *   <li>{@link COSName#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String COSName.getName()", "String COSName.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSName cosName = COSName.A;

    // Act
    String actualToStringResult = cosName.toString();

    // Assert
    assertEquals("A", cosName.getName());
    assertEquals("COSName{A}", actualToStringResult);
  }

  /**
   * Test {@link COSName#equals(Object)}, and {@link COSName#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.equals(Object)", "int COSName.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSName cosName = COSName.A;
    COSName cosName2 = COSName.A;

    // Act and Assert
    assertEquals(cosName, cosName2);
    int expectedHashCodeResult = cosName.hashCode();
    assertEquals(expectedHashCodeResult, cosName2.hashCode());
  }

  /**
   * Test {@link COSName#equals(Object)}, and {@link COSName#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSName#equals(Object)}
   *   <li>{@link COSName#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.equals(Object)", "int COSName.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSName cosName = COSName.A;

    // Act and Assert
    assertEquals(cosName, cosName);
    int expectedHashCodeResult = cosName.hashCode();
    assertEquals(expectedHashCodeResult, cosName.hashCode());
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.equals(Object)", "int COSName.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.AA, COSName.A);
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.equals(Object)", "int COSName.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, null);
  }

  /**
   * Test {@link COSName#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.equals(Object)", "int COSName.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSName.A, "Different type to COSName");
  }

  /**
   * Test {@link COSName#compareTo(COSName)} with {@code COSName}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#compareTo(COSName)}
   */
  @Test
  @DisplayName("Test compareTo(COSName) with 'COSName'; when A; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int COSName.compareTo(COSName)"})
  void testCompareToWithCOSName_whenA_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, COSName.A.compareTo(COSName.A));
  }

  /**
   * Test {@link COSName#isEmpty()}.
   * <p>
   * Method under test: {@link COSName#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSName.isEmpty()"})
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(COSName.A.isEmpty());
  }

  /**
   * Test {@link COSName#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromName(COSName)} does nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromName(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSName#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given A; when COSWriter visitFromName(COSName) does nothing; then calls visitFromName(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSName.accept(ICOSVisitor)"})
  void testAccept_givenA_whenCOSWriterVisitFromNameDoesNothing_thenCallsVisitFromName() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromName(Mockito.<COSName>any());

    // Act
    COSName.A.accept(visitor);

    // Assert
    verify(visitor).visitFromName(isA(COSName.class));
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSName.writePDF(OutputStream)"})
  void testWritePDF() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.A.writePDF(output);

    // Assert
    assertArrayEquals(new byte[]{'/', 'A'}, output.toByteArray());
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSName.writePDF(OutputStream)"})
  void testWritePDF2() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ABSOLUTE_COLORIMETRIC.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "/AbsoluteColorimetric".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSName.writePDF(OutputStream)"})
  void testWritePDF3() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_PKCS7_DETACHED.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "/adbe.pkcs7.detached".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSName#writePDF(OutputStream)}.
   * <p>
   * Method under test: {@link COSName#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSName.writePDF(OutputStream)"})
  void testWritePDF4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSName.ADBE_X509_RSA_SHA1.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "/adbe.x509.rsa_sha1".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}
