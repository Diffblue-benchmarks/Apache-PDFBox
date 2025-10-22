package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSNumberDiffblueTest {
  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code 9}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '9'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_when9_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("9");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }

  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '4242'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_when4242_thenReturnKeyIsNull() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("4242");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }

  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code -4242}.</li>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '-4242'; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_when4242_thenReturnKeyIsNull2() throws IOException {
    // Arrange and Act
    COSNumber actualGetResult = COSNumber.get("-4242");

    // Assert
    assertTrue(actualGetResult instanceof COSInteger);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
    assertTrue(((COSInteger) actualGetResult).isValid());
  }

  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '--'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_whenDashDash_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSNumber.get("--"));
  }

  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code ++}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '++'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_whenPlusSignPlusSign_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSNumber.get("++"));
  }

  /**
   * Test {@link COSNumber#get(String)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSNumber#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '+'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSNumber COSNumber.get(String)"})
  void testGet_whenPlusSign_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> COSNumber.get("+"));
  }
}
