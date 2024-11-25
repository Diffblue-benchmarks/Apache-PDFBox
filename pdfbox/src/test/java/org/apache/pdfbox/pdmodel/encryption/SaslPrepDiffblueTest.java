package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SaslPrepDiffblueTest {
  /**
   * Test {@link SaslPrep#saslPrepQuery(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#saslPrepQuery(String)}
   */
  @Test
  @DisplayName("Test saslPrepQuery(String); when '42'; then return '42'")
  void testSaslPrepQuery_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", SaslPrep.saslPrepQuery("42"));
  }

  /**
   * Test {@link SaslPrep#saslPrepQuery(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#saslPrepQuery(String)}
   */
  @Test
  @DisplayName("Test saslPrepQuery(String); when 'Str'; then return 'Str'")
  void testSaslPrepQuery_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", SaslPrep.saslPrepQuery("Str"));
  }

  /**
   * Test {@link SaslPrep#saslPrepStored(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#saslPrepStored(String)}
   */
  @Test
  @DisplayName("Test saslPrepStored(String); when '42'; then return '42'")
  void testSaslPrepStored_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", SaslPrep.saslPrepStored("42"));
  }

  /**
   * Test {@link SaslPrep#saslPrepStored(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#saslPrepStored(String)}
   */
  @Test
  @DisplayName("Test saslPrepStored(String); when 'Str'; then return 'Str'")
  void testSaslPrepStored_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", SaslPrep.saslPrepStored("Str"));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1757}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1757'; then return 'true'")
  void testProhibited_when1757_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1757));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1807}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1807'; then return 'true'")
  void testProhibited_when1807_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1807));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 5760}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '5760'; then return 'true'")
  void testProhibited_when5760_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(5760));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 6158}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '6158'; then return 'true'")
  void testProhibited_when6158_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(6158));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8192}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8192'; then return 'true'")
  void testProhibited_when8192_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8192));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8204}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8204'; then return 'true'")
  void testProhibited_when8204_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8204));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8205}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8205'; then return 'true'")
  void testProhibited_when8205_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8205));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8232}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8232'; then return 'true'")
  void testProhibited_when8232_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8232));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8233}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8233'; then return 'true'")
  void testProhibited_when8233_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8233));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8239}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8239'; then return 'true'")
  void testProhibited_when8239_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8239));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8287}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8287'; then return 'true'")
  void testProhibited_when8287_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8287));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8288}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8288'; then return 'true'")
  void testProhibited_when8288_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8288));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8289}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8289'; then return 'true'")
  void testProhibited_when8289_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8289));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8290}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8290'; then return 'true'")
  void testProhibited_when8290_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8290));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8291}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8291'; then return 'true'")
  void testProhibited_when8291_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8291));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8297}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8297'; then return 'false'")
  void testProhibited_when8297_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(8297));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8298}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8298'; then return 'true'")
  void testProhibited_when8298_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(8298));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 8304}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '8304'; then return 'false'")
  void testProhibited_when8304_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(8304));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 12288}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '12288'; then return 'true'")
  void testProhibited_when12288_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(12288));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 57343}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '57343'; then return 'true'")
  void testProhibited_when57343_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(57343));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 57344}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '57344'; then return 'true'")
  void testProhibited_when57344_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(57344));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 64976}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '64976'; then return 'true'")
  void testProhibited_when64976_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(64976));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 65279}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '65279'; then return 'true'")
  void testProhibited_when65279_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(65279));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 65528}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '65528'; then return 'false'")
  void testProhibited_when65528_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(65528));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 65529}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '65529'; then return 'true'")
  void testProhibited_when65529_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(65529));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 65533}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '65533'; then return 'true'")
  void testProhibited_when65533_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(65533));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 65534}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '65534'; then return 'true'")
  void testProhibited_when65534_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(65534));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 119154}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '119154'; then return 'false'")
  void testProhibited_when119154_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(119154));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 119155}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '119155'; then return 'true'")
  void testProhibited_when119155_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(119155));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 119163}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '119163'; then return 'false'")
  void testProhibited_when119163_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(119163));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 131070}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '131070'; then return 'true'")
  void testProhibited_when131070_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(131070));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 983039}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '983039'; then return 'true'")
  void testProhibited_when983039_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(983039));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1048573}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1048573'; then return 'true'")
  void testProhibited_when1048573_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1048573));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1048574}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1048574'; then return 'true'")
  void testProhibited_when1048574_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1048574));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1114109}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1114109'; then return 'true'")
  void testProhibited_when1114109_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1114109));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@code 1114110}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when '1114110'; then return 'true'")
  void testProhibited_when1114110_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1114110));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When {@link Float#MAX_EXPONENT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when MAX_EXPONENT; then return 'true'")
  void testProhibited_whenMax_exponent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(Float.MAX_EXPONENT));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when minus one; then return 'false'")
  void testProhibited_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SaslPrep.prohibited(-1));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When one hundred sixty.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when one hundred sixty; then return 'true'")
  void testProhibited_whenOneHundredSixty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(160));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When one hundred twenty-eight.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when one hundred twenty-eight; then return 'true'")
  void testProhibited_whenOneHundredTwentyEight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(128));
  }

  /**
   * Test {@link SaslPrep#prohibited(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaslPrep#prohibited(int)}
   */
  @Test
  @DisplayName("Test prohibited(int); when one; then return 'true'")
  void testProhibited_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SaslPrep.prohibited(1));
  }
}
