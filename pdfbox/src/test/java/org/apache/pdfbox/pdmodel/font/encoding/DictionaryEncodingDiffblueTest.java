package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DictionaryEncodingDiffblueTest {
  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(250L, 250));
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding2() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObjectKey key = new COSObjectKey(250L, 250);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding3() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(new COSObjectKey(250L, 250), null);
    when(cosObjectable.getCOSObject()).thenReturn(cosObject);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSFloat.ONE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_givenCOSObjectableGetCOSObjectReturnOne2() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSInteger.ONE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName("Test new DictionaryEncoding(COSName, COSArray); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_givenNull() {
    // Arrange
    COSArray differences = new COSArray(new ArrayList<>());
    differences.setDirect(false);
    differences.setKey(null);

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Then return BaseEncoding CodeToNameMap is {@link Encoding#codeToName}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); then return BaseEncoding CodeToNameMap is codeToName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_thenReturnBaseEncodingCodeToNameMapIsCodeToName() {
    // Arrange
    COSArray differences = new COSArray(new ArrayList<>());
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>Then return Differences size is one.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); then return Differences size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_thenReturnDifferencesSizeIsOne() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSName.A);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray differences = new COSArray(cosObjectables);
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, differences);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertTrue(actualDictionaryEncoding.getBaseEncoding() instanceof StandardEncoding);
    Map<Integer, String> differences2 = actualDictionaryEncoding.getDifferences();
    assertEquals(1, differences2.size());
    assertEquals("A", differences2.get(-1));
    Map<Integer, String> codeToNameMap = actualDictionaryEncoding.getCodeToNameMap();
    assertEquals(150, codeToNameMap.size());
    assertEquals("A", codeToNameMap.get(-1));
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(150, integerStringMap.size());
    assertEquals("A", integerStringMap.get(-1));
    assertTrue(codeToNameMap.containsKey(33));
    assertTrue(codeToNameMap.containsKey(34));
    assertTrue(codeToNameMap.containsKey(35));
    assertTrue(codeToNameMap.containsKey(36));
    assertTrue(codeToNameMap.containsKey(Integer.SIZE));
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); when A; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new DictionaryEncoding(COSName.A, new COSArray()));
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return EncodingName is {@code differences}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSDictionary); when COSDictionary(); then return EncodingName is 'differences'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary)"})
  void testNewDictionaryEncoding_whenCOSDictionary_thenReturnEncodingNameIsDifferences() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();

    // Act
    DictionaryEncoding actualDictionaryEncoding = new DictionaryEncoding(fontEncoding);

    // Assert
    assertEquals("differences", actualDictionaryEncoding.getEncodingName());
    assertNull(actualDictionaryEncoding.getBaseEncoding());
    assertTrue(actualDictionaryEncoding.getDifferences().isEmpty());
    assertTrue(actualDictionaryEncoding.getCodeToNameMap().isEmpty());
    assertTrue(actualDictionaryEncoding.getNameToCodeMap().isEmpty());
    assertTrue(actualDictionaryEncoding.codeToName.isEmpty());
    assertTrue(actualDictionaryEncoding.inverted.isEmpty());
    assertSame(fontEncoding, actualDictionaryEncoding.getCOSObject());
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then BaseEncoding return {@link MacExpertEncoding}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean,
   * Encoding)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'false'; then BaseEncoding return MacExpertEncoding")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenFalse_thenBaseEncodingReturnMacExpertEncoding() {
    // Arrange
    MacExpertEncoding builtIn = MacExpertEncoding.INSTANCE;

    // Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(new COSDictionary(), false, builtIn);

    // Assert
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof MacExpertEncoding);
    assertEquals("MacExpertEncoding with differences", actualDictionaryEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = builtIn.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, actualDictionaryEncoding.codeToName);
    Map<String, Integer> stringIntegerMap = builtIn.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, actualDictionaryEncoding.inverted);
    assertSame(MacExpertEncoding.INSTANCE, baseEncoding);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean,
   * Encoding)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'false'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenFalse_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new DictionaryEncoding(new COSDictionary(), false, null));
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then COSObject return {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); when 'null'; then COSObject return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_whenNull_thenCOSObjectReturnCOSDictionary() {
    // Arrange and Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(COSName.STANDARD_ENCODING, null);

    // Assert
    COSBase cOSObject = actualDictionaryEncoding.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    Encoding baseEncoding = actualDictionaryEncoding.getBaseEncoding();
    assertTrue(baseEncoding instanceof StandardEncoding);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(integerStringMap, actualDictionaryEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, baseEncoding.getCodeToNameMap());
    assertEquals(integerStringMap, ((StandardEncoding) baseEncoding).codeToName);
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(stringIntegerMap, actualDictionaryEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, baseEncoding.getNameToCodeMap());
    assertEquals(stringIntegerMap, ((StandardEncoding) baseEncoding).inverted);
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSName, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSName, COSArray); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSName, COSArray)"})
  void testNewDictionaryEncoding_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    COSArray differences = new COSArray(new ArrayList<>());
    differences.setDirect(false);
    differences.setKey(new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DictionaryEncoding(null, differences));
  }

  /**
   * Test {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean, Encoding)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then BaseEncoding return {@link StandardEncoding}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#DictionaryEncoding(COSDictionary, boolean,
   * Encoding)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryEncoding(COSDictionary, boolean, Encoding); when 'true'; then BaseEncoding return StandardEncoding")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DictionaryEncoding.<init>(COSDictionary, boolean, Encoding)"})
  void testNewDictionaryEncoding_whenTrue_thenBaseEncodingReturnStandardEncoding() {
    // Arrange and Act
    DictionaryEncoding actualDictionaryEncoding =
        new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE);

    // Assert
    assertTrue(actualDictionaryEncoding.getBaseEncoding() instanceof StandardEncoding);
    assertEquals("StandardEncoding with differences", actualDictionaryEncoding.getEncodingName());
    Map<Integer, String> integerStringMap = actualDictionaryEncoding.codeToName;
    assertEquals(149, integerStringMap.size());
    Map<String, Integer> stringIntegerMap = actualDictionaryEncoding.inverted;
    assertEquals(149, stringIntegerMap.size());
    assertTrue(integerStringMap.containsKey(33));
    assertTrue(integerStringMap.containsKey(34));
    assertTrue(integerStringMap.containsKey(35));
    assertTrue(integerStringMap.containsKey(36));
    assertTrue(integerStringMap.containsKey(37));
    assertTrue(integerStringMap.containsKey(Integer.SIZE));
    assertTrue(stringIntegerMap.containsKey("asterisk"));
    assertTrue(stringIntegerMap.containsKey("braceright"));
    assertTrue(stringIntegerMap.containsKey("cedilla"));
    assertTrue(stringIntegerMap.containsKey("parenright"));
    assertTrue(stringIntegerMap.containsKey("ring"));
    assertTrue(stringIntegerMap.containsKey("three"));
    Map<Integer, String> expectedCodeToNameMap = actualDictionaryEncoding.codeToName;
    assertEquals(expectedCodeToNameMap, actualDictionaryEncoding.getCodeToNameMap());
    Map<String, Integer> expectedNameToCodeMap = actualDictionaryEncoding.inverted;
    assertEquals(expectedNameToCodeMap, actualDictionaryEncoding.getNameToCodeMap());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DictionaryEncoding#getBaseEncoding()}
   *   <li>{@link DictionaryEncoding#getCOSObject()}
   *   <li>{@link DictionaryEncoding#getDifferences()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Encoding DictionaryEncoding.getBaseEncoding()",
    "COSBase DictionaryEncoding.getCOSObject()",
    "Map DictionaryEncoding.getDifferences()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary fontEncoding = new COSDictionary();
    DictionaryEncoding dictionaryEncoding = new DictionaryEncoding(fontEncoding);

    // Act
    Encoding actualBaseEncoding = dictionaryEncoding.getBaseEncoding();
    COSBase actualCOSObject = dictionaryEncoding.getCOSObject();

    // Assert
    assertNull(actualBaseEncoding);
    assertTrue(dictionaryEncoding.getDifferences().isEmpty());
    assertSame(fontEncoding, actualCOSObject);
  }

  /**
   * Test {@link DictionaryEncoding#getEncodingName()}.
   *
   * <ul>
   *   <li>Then return {@code differences}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName(); then return 'differences'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DictionaryEncoding.getEncodingName()"})
  void testGetEncodingName_thenReturnDifferences() {
    // Arrange, Act and Assert
    assertEquals("differences", new DictionaryEncoding(new COSDictionary()).getEncodingName());
  }

  /**
   * Test {@link DictionaryEncoding#getEncodingName()}.
   *
   * <ul>
   *   <li>Then return {@code StandardEncoding with differences}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryEncoding#getEncodingName()}
   */
  @Test
  @DisplayName("Test getEncodingName(); then return 'StandardEncoding with differences'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DictionaryEncoding.getEncodingName()"})
  void testGetEncodingName_thenReturnStandardEncodingWithDifferences() {
    // Arrange, Act and Assert
    assertEquals(
        "StandardEncoding with differences",
        new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE)
            .getEncodingName());
  }
}
