package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class COSBooleanDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#toString()}
   *   <li>{@link COSBoolean#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.getValue()", "String COSBoolean.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSBoolean resultBoolean = COSBoolean.getBoolean(true);

    // Act
    String actualToStringResult = resultBoolean.toString();

    // Assert
    assertTrue(resultBoolean.getValue());
    assertEquals(Boolean.TRUE.toString(), actualToStringResult);
  }

  /**
   * Test {@link COSBoolean#getValueAsObject()}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#getValueAsObject()}
   */
  @Test
  @DisplayName("Test getValueAsObject(); given FALSE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean COSBoolean.getValueAsObject()"})
  void testGetValueAsObject_givenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(COSBoolean.FALSE.getValueAsObject());
  }

  /**
   * Test {@link COSBoolean#getValueAsObject()}.
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#getValueAsObject()}
   */
  @Test
  @DisplayName("Test getValueAsObject(); given TRUE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean COSBoolean.getValueAsObject()"})
  void testGetValueAsObject_givenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(COSBoolean.TRUE.getValueAsObject());
  }

  /**
   * Test {@link COSBoolean#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromBoolean(COSBoolean)} does nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromBoolean(COSBoolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when COSWriter visitFromBoolean(COSBoolean) does nothing; then calls visitFromBoolean(COSBoolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSBoolean.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromBooleanDoesNothing_thenCallsVisitFromBoolean() throws IOException {
    // Arrange
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromBoolean(Mockito.<COSBoolean>any());

    // Act
    COSBoolean.FALSE.accept(visitor);

    // Assert
    verify(visitor).visitFromBoolean(isA(COSBoolean.class));
  }

  /**
   * Test {@link COSBoolean#equals(Object)}, and {@link COSBoolean#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#equals(Object)}
   *   <li>{@link COSBoolean#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.equals(Object)", "int COSBoolean.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSBoolean cosBoolean = COSBoolean.FALSE;
    COSBoolean cosBoolean2 = COSBoolean.FALSE;

    // Act and Assert
    assertEquals(cosBoolean, cosBoolean2);
    int expectedHashCodeResult = cosBoolean.hashCode();
    assertEquals(expectedHashCodeResult, cosBoolean2.hashCode());
  }

  /**
   * Test {@link COSBoolean#equals(Object)}, and {@link COSBoolean#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSBoolean#equals(Object)}
   *   <li>{@link COSBoolean#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.equals(Object)", "int COSBoolean.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act and Assert
    assertEquals(cosBoolean, cosBoolean);
    int expectedHashCodeResult = cosBoolean.hashCode();
    assertEquals(expectedHashCodeResult, cosBoolean.hashCode());
  }

  /**
   * Test {@link COSBoolean#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.equals(Object)", "int COSBoolean.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.TRUE, COSBoolean.FALSE);
  }

  /**
   * Test {@link COSBoolean#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.equals(Object)", "int COSBoolean.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.FALSE, null);
  }

  /**
   * Test {@link COSBoolean#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBoolean.equals(Object)", "int COSBoolean.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(COSBoolean.FALSE, "Different type to COSBoolean");
  }

  /**
   * Test {@link COSBoolean#writePDF(OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is {@code false} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); then ByteArrayOutputStream(int) with one toByteArray is 'false' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSBoolean.writePDF(OutputStream)"})
  void testWritePDF_thenByteArrayOutputStreamWithOneToByteArrayIsFalseBytesIsUtf8() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSBoolean.FALSE.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "false".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSBoolean#writePDF(OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is {@code true} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBoolean#writePDF(OutputStream)}
   */
  @Test
  @DisplayName("Test writePDF(OutputStream); then ByteArrayOutputStream(int) with one toByteArray is 'true' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSBoolean.writePDF(OutputStream)"})
  void testWritePDF_thenByteArrayOutputStreamWithOneToByteArrayIsTrueBytesIsUtf8() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSBoolean.TRUE.writePDF(output);

    // Assert
    byte[] expectedToByteArrayResult = "true".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}
