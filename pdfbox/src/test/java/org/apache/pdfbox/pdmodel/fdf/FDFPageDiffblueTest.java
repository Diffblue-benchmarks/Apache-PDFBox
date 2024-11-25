package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFPageDiffblueTest {
  /**
   * Test {@link FDFPage#FDFPage(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFPage#FDFPage(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFPage(COSDictionary)")
  void testNewFDFPage() {
    // Arrange
    COSDictionary p = new COSDictionary();

    // Act and Assert
    assertSame(p, (new FDFPage(p)).getCOSObject());
  }

  /**
   * Test {@link FDFPage#FDFPage()}.
   * <p>
   * Method under test: {@link FDFPage#FDFPage()}
   */
  @Test
  @DisplayName("Test new FDFPage()")
  void testNewFDFPage2() {
    // Arrange and Act
    FDFPage actualFdfPage = new FDFPage();

    // Assert
    assertNull(actualFdfPage.getTemplates());
    COSDictionary cOSObject = actualFdfPage.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfPage.getPageInfo());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFPage#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFPage#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFPage()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFPage#getTemplates()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link FDFTemplate#FDFTemplate()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  @DisplayName("Test getTemplates(); given ArrayList() add FDFTemplate(); then return size is one")
  void testGetTemplates_givenArrayListAddFDFTemplate_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());

    FDFPage fdfPage = new FDFPage();
    fdfPage.setTemplates(templates);

    // Act
    List<FDFTemplate> actualTemplates = fdfPage.getTemplates();

    // Assert
    assertEquals(1, actualTemplates.size());
    FDFTemplate getResult = actualTemplates.get(0);
    assertNull(getResult.getFields());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getTemplateReference());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFPage#getTemplates()}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()} Templates is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  @DisplayName("Test getTemplates(); given FDFPage() Templates is ArrayList(); then return Empty")
  void testGetTemplates_givenFDFPageTemplatesIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFPage fdfPage = new FDFPage();
    fdfPage.setTemplates(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfPage.getTemplates().isEmpty());
  }

  /**
   * Test {@link FDFPage#getTemplates()}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#getTemplates()}
   */
  @Test
  @DisplayName("Test getTemplates(); given FDFPage(); then return 'null'")
  void testGetTemplates_givenFDFPage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFPage()).getTemplates());
  }

  /**
   * Test {@link FDFPage#setTemplates(List)}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} Templates Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  @DisplayName("Test setTemplates(List); given FDFPage(); when ArrayList(); then FDFPage() Templates Empty")
  void testSetTemplates_givenFDFPage_whenArrayList_thenFDFPageTemplatesEmpty() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setTemplates(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfPage.getTemplates().isEmpty());
  }

  /**
   * Test {@link FDFPage#setTemplates(List)}.
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} Templates first Fields is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  @DisplayName("Test setTemplates(List); given FDFTemplate(); then FDFPage() Templates first Fields is 'null'")
  void testSetTemplates_givenFDFTemplate_thenFDFPageTemplatesFirstFieldsIsNull() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(1, templates2.size());
    FDFTemplate getResult = templates2.get(0);
    assertNull(getResult.getFields());
    assertNull(getResult.getTemplateReference());
  }

  /**
   * Test {@link FDFPage#setTemplates(List)}.
   * <ul>
   *   <li>Given {@link FDFTemplate#FDFTemplate()}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} Templates size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  @DisplayName("Test setTemplates(List); given FDFTemplate(); then FDFPage() Templates size is two")
  void testSetTemplates_givenFDFTemplate_thenFDFPageTemplatesSizeIsTwo() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(new FDFTemplate());
    templates.add(new FDFTemplate());

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(2, templates2.size());
    FDFTemplate getResult = templates2.get(1);
    assertNull(getResult.getFields());
    assertNull(getResult.getTemplateReference());
  }

  /**
   * Test {@link FDFPage#setTemplates(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} Templates first COSObject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setTemplates(List)}
   */
  @Test
  @DisplayName("Test setTemplates(List); given 'null'; then FDFPage() Templates first COSObject is 'null'")
  void testSetTemplates_givenNull_thenFDFPageTemplatesFirstCOSObjectIsNull() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    ArrayList<FDFTemplate> templates = new ArrayList<>();
    templates.add(null);

    // Act
    fdfPage.setTemplates(templates);

    // Assert
    List<FDFTemplate> templates2 = fdfPage.getTemplates();
    assertEquals(1, templates2.size());
    assertNull(templates2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFPage#setPageInfo(FDFPageInfo)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  @DisplayName("Test setPageInfo(FDFPageInfo); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetPageInfo_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfPage.setPageInfo(new FDFPageInfo(p));

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(p, fdfPage.getPageInfo().getCOSObject());
  }

  /**
   * Test {@link FDFPage#setPageInfo(FDFPageInfo)}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>When {@link FDFPageInfo#FDFPageInfo()}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  @DisplayName("Test setPageInfo(FDFPageInfo); given FDFPage(); when FDFPageInfo(); then FDFPage() COSObject Values size is one")
  void testSetPageInfo_givenFDFPage_whenFDFPageInfo_thenFDFPageCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setPageInfo(new FDFPageInfo());

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFPage#setPageInfo(FDFPageInfo)}.
   * <ul>
   *   <li>Given {@link FDFPage#FDFPage()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFPage#FDFPage()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  @DisplayName("Test setPageInfo(FDFPageInfo); given FDFPage(); when 'null'; then FDFPage() COSObject size is zero")
  void testSetPageInfo_givenFDFPage_whenNull_thenFDFPageCOSObjectSizeIsZero() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    // Act
    fdfPage.setPageInfo(null);

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFPage#setPageInfo(FDFPageInfo)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFPage#setPageInfo(FDFPageInfo)}
   */
  @Test
  @DisplayName("Test setPageInfo(FDFPageInfo); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetPageInfo_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    FDFPage fdfPage = new FDFPage();

    COSDictionary p = new COSDictionary();
    p.setDirect(true);

    // Act
    fdfPage.setPageInfo(new FDFPageInfo(p));

    // Assert
    COSDictionary cOSObject = fdfPage.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(p, fdfPage.getPageInfo().getCOSObject());
  }
}
