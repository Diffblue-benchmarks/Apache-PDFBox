package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDThreadDiffblueTest {
  /**
   * Test {@link PDThread#PDThread(COSDictionary)}.
   * <p>
   * Method under test: {@link PDThread#PDThread(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDThread(COSDictionary)")
  void testNewPDThread() {
    // Arrange
    COSDictionary t = new COSDictionary();

    // Act and Assert
    assertSame(t, (new PDThread(t)).getCOSObject());
  }

  /**
   * Test {@link PDThread#PDThread()}.
   * <p>
   * Method under test: {@link PDThread#PDThread()}
   */
  @Test
  @DisplayName("Test new PDThread()")
  void testNewPDThread2() {
    // Arrange and Act
    PDThread actualPdThread = new PDThread();

    // Assert
    COSDictionary cOSObject = actualPdThread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdThread.getThreadInfo());
    assertNull(actualPdThread.getFirstBead());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDThread#getCOSObject()}.
   * <p>
   * Method under test: {@link PDThread#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDThread()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDThread#getThreadInfo()}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread(COSDictionary)} with t is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); given PDThread(COSDictionary) with t is COSDictionary(); then return 'null'")
  void testGetThreadInfo_givenPDThreadWithTIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThread(new COSDictionary())).getThreadInfo());
  }

  /**
   * Test {@link PDThread#getThreadInfo()}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); given PDThread(); then return 'null'")
  void testGetThreadInfo_givenPDThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThread()).getThreadInfo());
  }

  /**
   * Test {@link PDThread#getThreadInfo()}.
   * <ul>
   *   <li>Then return Author is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); then return Author is 'null'")
  void testGetThreadInfo_thenReturnAuthorIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();
    pdThread.setThreadInfo(new PDDocumentInformation());

    // Act
    PDDocumentInformation actualThreadInfo = pdThread.getThreadInfo();

    // Assert
    assertNull(actualThreadInfo.getAuthor());
    assertNull(actualThreadInfo.getCreator());
    assertNull(actualThreadInfo.getKeywords());
    assertNull(actualThreadInfo.getProducer());
    assertNull(actualThreadInfo.getSubject());
    assertNull(actualThreadInfo.getTitle());
    assertNull(actualThreadInfo.getTrapped());
    assertNull(actualThreadInfo.getCreationDate());
    assertNull(actualThreadInfo.getModificationDate());
    COSDictionary cOSObject = actualThreadInfo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualThreadInfo.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.</li>
   *   <li>Then {@link PDThread#PDThread()} ThreadInfo Author is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setThreadInfo(PDDocumentInformation); given PDThread(); then PDThread() ThreadInfo Author is 'null'")
  void testSetThreadInfo_givenPDThread_thenPDThreadThreadInfoAuthorIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();

    // Act
    pdThread.setThreadInfo(new PDDocumentInformation());

    // Assert
    PDDocumentInformation threadInfo = pdThread.getThreadInfo();
    assertNull(threadInfo.getAuthor());
    assertNull(threadInfo.getCreator());
    assertNull(threadInfo.getKeywords());
    assertNull(threadInfo.getProducer());
    assertNull(threadInfo.getSubject());
    assertNull(threadInfo.getTitle());
    assertNull(threadInfo.getTrapped());
    assertNull(threadInfo.getCreationDate());
    assertNull(threadInfo.getModificationDate());
    COSDictionary cOSObject = pdThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(threadInfo.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThread#PDThread()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName("Test setThreadInfo(PDDocumentInformation); given PDThread(); when 'null'; then PDThread() COSObject Values size is one")
  void testSetThreadInfo_givenPDThread_whenNull_thenPDThreadCOSObjectValuesSizeIsOne() {
    // Arrange
    PDThread pdThread = new PDThread();

    // Act
    pdThread.setThreadInfo(null);

    // Assert
    COSDictionary cOSObject = pdThread.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDThread#getFirstBead()}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread(COSDictionary)} with t is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); given PDThread(COSDictionary) with t is COSDictionary(); then return 'null'")
  void testGetFirstBead_givenPDThreadWithTIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThread(new COSDictionary())).getFirstBead());
  }

  /**
   * Test {@link PDThread#getFirstBead()}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); given PDThread(); then return 'null'")
  void testGetFirstBead_givenPDThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThread()).getFirstBead());
  }

  /**
   * Test {@link PDThread#getFirstBead()}.
   * <ul>
   *   <li>Then return Thread COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); then return Thread COSObject UpdateState OriginDocumentState is 'null'")
  void testGetFirstBead_thenReturnThreadCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();
    pdThread.setFirstBead(new PDThreadBead());

    // Act
    PDThreadBead actualFirstBead = pdThread.getFirstBead();

    // Assert
    PDThread thread = actualFirstBead.getThread();
    COSDictionary cOSObject = thread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualFirstBead.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(thread.getThreadInfo());
    PDThreadBead nextBead = actualFirstBead.getNextBead();
    PDThread thread2 = nextBead.getThread();
    assertNull(thread2.getThreadInfo());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDThread thread3 = nextBead2.getThread();
    assertNull(thread3.getThreadInfo());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    PDThread thread4 = nextBead3.getThread();
    assertNull(thread4.getThreadInfo());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    PDThread thread5 = nextBead4.getThread();
    assertNull(thread5.getThreadInfo());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    PDThread thread6 = nextBead5.getThread();
    assertNull(thread6.getThreadInfo());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    PDThread thread7 = nextBead6.getThread();
    assertNull(thread7.getThreadInfo());
    PDThreadBead previousBead = actualFirstBead.getPreviousBead();
    PDThreadBead nextBead7 = previousBead.getNextBead();
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    PDThreadBead nextBead9 = nextBead8.getNextBead();
    PDThreadBead nextBead10 = nextBead9.getNextBead();
    PDThread thread8 = nextBead10.getThread();
    assertNull(thread8.getThreadInfo());
    PDThread thread9 = nextBead9.getThread();
    assertNull(thread9.getThreadInfo());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThreadBead nextBead11 = previousBead2.getNextBead();
    PDThreadBead nextBead12 = nextBead11.getNextBead();
    PDThreadBead nextBead13 = nextBead12.getNextBead();
    PDThread thread10 = nextBead13.getThread();
    assertNull(thread10.getThreadInfo());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    PDThreadBead nextBead14 = previousBead3.getNextBead();
    PDThreadBead nextBead15 = nextBead14.getNextBead();
    PDThreadBead nextBead16 = nextBead15.getNextBead();
    PDThread thread11 = nextBead16.getThread();
    assertNull(thread11.getThreadInfo());
    PDThread thread12 = nextBead8.getThread();
    assertNull(thread12.getThreadInfo());
    PDThread thread13 = nextBead12.getThread();
    assertNull(thread13.getThreadInfo());
    PDThreadBead previousBead4 = nextBead2.getPreviousBead();
    PDThreadBead nextBead17 = previousBead4.getNextBead();
    PDThreadBead nextBead18 = nextBead17.getNextBead();
    PDThread thread14 = nextBead18.getThread();
    assertNull(thread14.getThreadInfo());
    PDThreadBead previousBead5 = nextBead3.getPreviousBead();
    PDThreadBead nextBead19 = previousBead5.getNextBead();
    PDThreadBead nextBead20 = nextBead19.getNextBead();
    PDThread thread15 = nextBead20.getThread();
    assertNull(thread15.getThreadInfo());
    PDThreadBead previousBead6 = nextBead7.getPreviousBead();
    PDThreadBead nextBead21 = previousBead6.getNextBead();
    PDThreadBead nextBead22 = nextBead21.getNextBead();
    PDThread thread16 = nextBead22.getThread();
    assertNull(thread16.getThreadInfo());
    PDThread thread17 = nextBead15.getThread();
    assertNull(thread17.getThreadInfo());
    PDThreadBead previousBead7 = previousBead2.getPreviousBead();
    PDThreadBead nextBead23 = previousBead7.getNextBead();
    PDThreadBead nextBead24 = nextBead23.getNextBead();
    PDThread thread18 = nextBead24.getThread();
    assertNull(thread18.getThreadInfo());
    PDThreadBead previousBead8 = previousBead3.getPreviousBead();
    PDThreadBead nextBead25 = previousBead8.getNextBead();
    PDThreadBead nextBead26 = nextBead25.getNextBead();
    PDThread thread19 = nextBead26.getThread();
    assertNull(thread19.getThreadInfo());
    PDThread thread20 = nextBead7.getThread();
    assertNull(thread20.getThreadInfo());
    PDThread thread21 = nextBead11.getThread();
    assertNull(thread21.getThreadInfo());
    PDThread thread22 = nextBead17.getThread();
    assertNull(thread22.getThreadInfo());
    PDThread thread23 = nextBead19.getThread();
    assertNull(thread23.getThreadInfo());
    PDThreadBead previousBead9 = nextBead4.getPreviousBead();
    PDThreadBead nextBead27 = previousBead9.getNextBead();
    PDThread thread24 = nextBead27.getThread();
    assertNull(thread24.getThreadInfo());
    PDThreadBead previousBead10 = nextBead8.getPreviousBead();
    PDThreadBead nextBead28 = previousBead10.getNextBead();
    PDThread thread25 = nextBead28.getThread();
    assertNull(thread25.getThreadInfo());
    PDThread thread26 = nextBead21.getThread();
    assertNull(thread26.getThreadInfo());
    PDThreadBead previousBead11 = nextBead11.getPreviousBead();
    PDThreadBead nextBead29 = previousBead11.getNextBead();
    PDThread thread27 = nextBead29.getThread();
    assertNull(thread27.getThreadInfo());
    PDThreadBead previousBead12 = nextBead14.getPreviousBead();
    PDThreadBead nextBead30 = previousBead12.getNextBead();
    PDThread thread28 = nextBead30.getThread();
    assertNull(thread28.getThreadInfo());
    PDThread thread29 = nextBead14.getThread();
    assertNull(thread29.getThreadInfo());
    PDThread thread30 = nextBead23.getThread();
    assertNull(thread30.getThreadInfo());
    PDThreadBead previousBead13 = previousBead4.getPreviousBead();
    PDThreadBead nextBead31 = previousBead13.getNextBead();
    PDThread thread31 = nextBead31.getThread();
    assertNull(thread31.getThreadInfo());
    PDThreadBead previousBead14 = previousBead6.getPreviousBead();
    PDThreadBead nextBead32 = previousBead14.getNextBead();
    PDThread thread32 = nextBead32.getThread();
    assertNull(thread32.getThreadInfo());
    PDThread thread33 = nextBead25.getThread();
    assertNull(thread33.getThreadInfo());
    PDThreadBead previousBead15 = previousBead7.getPreviousBead();
    PDThreadBead nextBead33 = previousBead15.getNextBead();
    PDThread thread34 = nextBead33.getThread();
    assertNull(thread34.getThreadInfo());
    PDThreadBead previousBead16 = previousBead8.getPreviousBead();
    PDThreadBead nextBead34 = previousBead16.getNextBead();
    PDThread thread35 = nextBead34.getThread();
    assertNull(thread35.getThreadInfo());
    PDThread thread36 = previousBead.getThread();
    assertNull(thread36.getThreadInfo());
    PDThread thread37 = previousBead2.getThread();
    assertNull(thread37.getThreadInfo());
    PDThread thread38 = previousBead4.getThread();
    assertNull(thread38.getThreadInfo());
    PDThread thread39 = previousBead5.getThread();
    assertNull(thread39.getThreadInfo());
    PDThread thread40 = previousBead9.getThread();
    assertNull(thread40.getThreadInfo());
    PDThreadBead previousBead17 = nextBead5.getPreviousBead();
    PDThread thread41 = previousBead17.getThread();
    assertNull(thread41.getThreadInfo());
    PDThreadBead previousBead18 = nextBead9.getPreviousBead();
    PDThread thread42 = previousBead18.getThread();
    assertNull(thread42.getThreadInfo());
    PDThread thread43 = previousBead10.getThread();
    assertNull(thread43.getThreadInfo());
    PDThreadBead previousBead19 = nextBead12.getPreviousBead();
    PDThread thread44 = previousBead19.getThread();
    assertNull(thread44.getThreadInfo());
    PDThreadBead previousBead20 = nextBead15.getPreviousBead();
    PDThread thread45 = previousBead20.getThread();
    assertNull(thread45.getThreadInfo());
    PDThread thread46 = previousBead6.getThread();
    assertNull(thread46.getThreadInfo());
    PDThread thread47 = previousBead11.getThread();
    assertNull(thread47.getThreadInfo());
    PDThreadBead previousBead21 = nextBead17.getPreviousBead();
    PDThread thread48 = previousBead21.getThread();
    assertNull(thread48.getThreadInfo());
    PDThreadBead previousBead22 = nextBead19.getPreviousBead();
    PDThread thread49 = previousBead22.getThread();
    assertNull(thread49.getThreadInfo());
    PDThreadBead previousBead23 = nextBead21.getPreviousBead();
    PDThread thread50 = previousBead23.getThread();
    assertNull(thread50.getThreadInfo());
    PDThread thread51 = previousBead12.getThread();
    assertNull(thread51.getThreadInfo());
    PDThreadBead previousBead24 = nextBead23.getPreviousBead();
    PDThread thread52 = previousBead24.getThread();
    assertNull(thread52.getThreadInfo());
    PDThreadBead previousBead25 = nextBead25.getPreviousBead();
    PDThread thread53 = previousBead25.getThread();
    assertNull(thread53.getThreadInfo());
    PDThread thread54 = previousBead3.getThread();
    assertNull(thread54.getThreadInfo());
    PDThread thread55 = previousBead7.getThread();
    assertNull(thread55.getThreadInfo());
    PDThread thread56 = previousBead13.getThread();
    assertNull(thread56.getThreadInfo());
    PDThreadBead previousBead26 = previousBead5.getPreviousBead();
    PDThread thread57 = previousBead26.getThread();
    assertNull(thread57.getThreadInfo());
    PDThreadBead previousBead27 = previousBead9.getPreviousBead();
    PDThread thread58 = previousBead27.getThread();
    assertNull(thread58.getThreadInfo());
    PDThreadBead previousBead28 = previousBead10.getPreviousBead();
    PDThread thread59 = previousBead28.getThread();
    assertNull(thread59.getThreadInfo());
    PDThread thread60 = previousBead14.getThread();
    assertNull(thread60.getThreadInfo());
    PDThreadBead previousBead29 = previousBead11.getPreviousBead();
    PDThread thread61 = previousBead29.getThread();
    assertNull(thread61.getThreadInfo());
    PDThreadBead previousBead30 = previousBead12.getPreviousBead();
    PDThread thread62 = previousBead30.getThread();
    assertNull(thread62.getThreadInfo());
    PDThread thread63 = previousBead8.getThread();
    assertNull(thread63.getThreadInfo());
    PDThread thread64 = previousBead15.getThread();
    assertNull(thread64.getThreadInfo());
    PDThreadBead previousBead31 = previousBead13.getPreviousBead();
    PDThread thread65 = previousBead31.getThread();
    assertNull(thread65.getThreadInfo());
    PDThreadBead previousBead32 = previousBead14.getPreviousBead();
    PDThread thread66 = previousBead32.getThread();
    assertNull(thread66.getThreadInfo());
    PDThread thread67 = previousBead16.getThread();
    assertNull(thread67.getThreadInfo());
    PDThreadBead previousBead33 = previousBead15.getPreviousBead();
    PDThread thread68 = previousBead33.getThread();
    assertNull(thread68.getThreadInfo());
    PDThreadBead previousBead34 = previousBead16.getPreviousBead();
    PDThread thread69 = previousBead34.getThread();
    assertNull(thread69.getThreadInfo());
    assertNull(actualFirstBead.getPage());
    assertNull(nextBead.getPage());
    assertNull(nextBead2.getPage());
    assertNull(nextBead3.getPage());
    assertNull(nextBead4.getPage());
    assertNull(nextBead5.getPage());
    assertNull(nextBead6.getPage());
    PDThreadBead nextBead35 = nextBead6.getNextBead();
    assertNull(nextBead35.getPage());
    PDThreadBead nextBead36 = nextBead10.getNextBead();
    assertNull(nextBead36.getPage());
    assertNull(nextBead10.getPage());
    PDThreadBead nextBead37 = nextBead13.getNextBead();
    assertNull(nextBead37.getPage());
    PDThreadBead nextBead38 = nextBead16.getNextBead();
    assertNull(nextBead38.getPage());
    assertNull(nextBead9.getPage());
    assertNull(nextBead13.getPage());
    PDThreadBead nextBead39 = nextBead18.getNextBead();
    assertNull(nextBead39.getPage());
    PDThreadBead nextBead40 = nextBead20.getNextBead();
    assertNull(nextBead40.getPage());
    PDThreadBead nextBead41 = nextBead22.getNextBead();
    assertNull(nextBead41.getPage());
    assertNull(nextBead16.getPage());
    PDThreadBead nextBead42 = nextBead24.getNextBead();
    assertNull(nextBead42.getPage());
    PDThreadBead nextBead43 = nextBead26.getNextBead();
    assertNull(nextBead43.getPage());
    assertNull(nextBead8.getPage());
    assertNull(nextBead12.getPage());
    assertNull(nextBead18.getPage());
    assertNull(nextBead20.getPage());
    PDThreadBead nextBead44 = nextBead27.getNextBead();
    assertNull(nextBead44.getPage());
    PDThreadBead nextBead45 = nextBead28.getNextBead();
    assertNull(nextBead45.getPage());
    assertNull(nextBead22.getPage());
    PDThreadBead nextBead46 = nextBead29.getNextBead();
    assertNull(nextBead46.getPage());
    PDThreadBead nextBead47 = nextBead30.getNextBead();
    assertNull(nextBead47.getPage());
    assertNull(nextBead15.getPage());
    assertNull(nextBead24.getPage());
    PDThreadBead nextBead48 = nextBead31.getNextBead();
    assertNull(nextBead48.getPage());
    PDThreadBead nextBead49 = previousBead26.getNextBead();
    PDThreadBead nextBead50 = nextBead49.getNextBead();
    assertNull(nextBead50.getPage());
    PDThreadBead nextBead51 = nextBead32.getNextBead();
    assertNull(nextBead51.getPage());
    assertNull(nextBead26.getPage());
    PDThreadBead nextBead52 = nextBead33.getNextBead();
    assertNull(nextBead52.getPage());
    PDThreadBead nextBead53 = nextBead34.getNextBead();
    assertNull(nextBead53.getPage());
    assertNull(nextBead7.getPage());
    assertNull(nextBead11.getPage());
    assertNull(nextBead17.getPage());
    assertNull(nextBead19.getPage());
    assertNull(nextBead27.getPage());
    PDThreadBead nextBead54 = previousBead17.getNextBead();
    assertNull(nextBead54.getPage());
    PDThreadBead nextBead55 = previousBead18.getNextBead();
    assertNull(nextBead55.getPage());
    assertNull(nextBead28.getPage());
    PDThreadBead nextBead56 = previousBead19.getNextBead();
    assertNull(nextBead56.getPage());
    PDThreadBead nextBead57 = previousBead20.getNextBead();
    assertNull(nextBead57.getPage());
    assertNull(nextBead21.getPage());
    assertNull(nextBead29.getPage());
    PDThreadBead nextBead58 = previousBead21.getNextBead();
    assertNull(nextBead58.getPage());
    PDThreadBead nextBead59 = previousBead22.getNextBead();
    assertNull(nextBead59.getPage());
    PDThreadBead nextBead60 = previousBead23.getNextBead();
    assertNull(nextBead60.getPage());
    assertNull(nextBead30.getPage());
    PDThreadBead nextBead61 = previousBead24.getNextBead();
    assertNull(nextBead61.getPage());
    PDThreadBead nextBead62 = previousBead25.getNextBead();
    assertNull(nextBead62.getPage());
    assertNull(nextBead14.getPage());
    assertNull(nextBead23.getPage());
    assertNull(nextBead31.getPage());
    assertNull(nextBead49.getPage());
    PDThreadBead nextBead63 = previousBead27.getNextBead();
    assertNull(nextBead63.getPage());
    PDThreadBead nextBead64 = previousBead28.getNextBead();
    assertNull(nextBead64.getPage());
    assertNull(nextBead32.getPage());
    PDThreadBead nextBead65 = previousBead29.getNextBead();
    assertNull(nextBead65.getPage());
    PDThreadBead nextBead66 = previousBead30.getNextBead();
    assertNull(nextBead66.getPage());
    assertNull(nextBead25.getPage());
    assertNull(nextBead33.getPage());
    PDThreadBead nextBead67 = previousBead31.getNextBead();
    assertNull(nextBead67.getPage());
    PDThreadBead nextBead68 = previousBead32.getNextBead();
    assertNull(nextBead68.getPage());
    assertNull(nextBead34.getPage());
    PDThreadBead nextBead69 = previousBead33.getNextBead();
    assertNull(nextBead69.getPage());
    PDThreadBead nextBead70 = previousBead34.getNextBead();
    assertNull(nextBead70.getPage());
    assertNull(previousBead.getPage());
    assertNull(previousBead2.getPage());
    assertNull(previousBead4.getPage());
    assertNull(previousBead5.getPage());
    assertNull(previousBead9.getPage());
    assertNull(previousBead17.getPage());
    PDThreadBead previousBead35 = nextBead6.getPreviousBead();
    assertNull(previousBead35.getPage());
    PDThreadBead previousBead36 = nextBead10.getPreviousBead();
    assertNull(previousBead36.getPage());
    assertNull(previousBead18.getPage());
    PDThreadBead previousBead37 = nextBead13.getPreviousBead();
    assertNull(previousBead37.getPage());
    PDThreadBead previousBead38 = nextBead16.getPreviousBead();
    assertNull(previousBead38.getPage());
    assertNull(previousBead10.getPage());
    assertNull(previousBead19.getPage());
    PDThreadBead previousBead39 = nextBead18.getPreviousBead();
    assertNull(previousBead39.getPage());
    PDThreadBead previousBead40 = nextBead20.getPreviousBead();
    assertNull(previousBead40.getPage());
    PDThreadBead previousBead41 = nextBead22.getPreviousBead();
    assertNull(previousBead41.getPage());
    assertNull(previousBead20.getPage());
    PDThreadBead previousBead42 = nextBead24.getPreviousBead();
    assertNull(previousBead42.getPage());
    PDThreadBead previousBead43 = nextBead26.getPreviousBead();
    assertNull(previousBead43.getPage());
    assertNull(previousBead6.getPage());
    assertNull(previousBead11.getPage());
    assertNull(previousBead21.getPage());
    assertNull(previousBead22.getPage());
    PDThreadBead previousBead44 = nextBead27.getPreviousBead();
    assertNull(previousBead44.getPage());
    PDThreadBead previousBead45 = nextBead28.getPreviousBead();
    assertNull(previousBead45.getPage());
    assertNull(previousBead23.getPage());
    PDThreadBead previousBead46 = nextBead29.getPreviousBead();
    assertNull(previousBead46.getPage());
    PDThreadBead previousBead47 = nextBead30.getPreviousBead();
    assertNull(previousBead47.getPage());
    assertNull(previousBead12.getPage());
    assertNull(previousBead24.getPage());
    PDThreadBead previousBead48 = nextBead31.getPreviousBead();
    assertNull(previousBead48.getPage());
    PDThreadBead previousBead49 = nextBead32.getPreviousBead();
    assertNull(previousBead49.getPage());
    assertNull(previousBead25.getPage());
    PDThreadBead previousBead50 = nextBead33.getPreviousBead();
    assertNull(previousBead50.getPage());
    PDThreadBead previousBead51 = nextBead34.getPreviousBead();
    assertNull(previousBead51.getPage());
    assertNull(previousBead3.getPage());
    assertNull(previousBead7.getPage());
    assertNull(previousBead13.getPage());
    assertNull(previousBead26.getPage());
    assertNull(previousBead27.getPage());
    PDThreadBead previousBead52 = previousBead17.getPreviousBead();
    assertNull(previousBead52.getPage());
    PDThreadBead previousBead53 = previousBead18.getPreviousBead();
    assertNull(previousBead53.getPage());
    assertNull(previousBead28.getPage());
    PDThreadBead previousBead54 = previousBead19.getPreviousBead();
    assertNull(previousBead54.getPage());
    PDThreadBead previousBead55 = previousBead20.getPreviousBead();
    assertNull(previousBead55.getPage());
    assertNull(previousBead14.getPage());
    assertNull(previousBead29.getPage());
    PDThreadBead previousBead56 = previousBead21.getPreviousBead();
    assertNull(previousBead56.getPage());
    PDThreadBead previousBead57 = previousBead22.getPreviousBead();
    assertNull(previousBead57.getPage());
    PDThreadBead previousBead58 = previousBead23.getPreviousBead();
    assertNull(previousBead58.getPage());
    assertNull(previousBead30.getPage());
    PDThreadBead previousBead59 = previousBead24.getPreviousBead();
    assertNull(previousBead59.getPage());
    PDThreadBead previousBead60 = previousBead25.getPreviousBead();
    assertNull(previousBead60.getPage());
    assertNull(previousBead8.getPage());
    assertNull(previousBead15.getPage());
    assertNull(previousBead31.getPage());
    PDThreadBead previousBead61 = previousBead26.getPreviousBead();
    assertNull(previousBead61.getPage());
    PDThreadBead previousBead62 = previousBead27.getPreviousBead();
    assertNull(previousBead62.getPage());
    PDThreadBead previousBead63 = previousBead28.getPreviousBead();
    assertNull(previousBead63.getPage());
    assertNull(previousBead32.getPage());
    PDThreadBead previousBead64 = previousBead29.getPreviousBead();
    assertNull(previousBead64.getPage());
    PDThreadBead previousBead65 = previousBead30.getPreviousBead();
    assertNull(previousBead65.getPage());
    assertNull(previousBead16.getPage());
    assertNull(previousBead33.getPage());
    PDThreadBead previousBead66 = previousBead31.getPreviousBead();
    assertNull(previousBead66.getPage());
    PDThreadBead previousBead67 = previousBead32.getPreviousBead();
    assertNull(previousBead67.getPage());
    assertNull(previousBead34.getPage());
    PDThreadBead previousBead68 = previousBead33.getPreviousBead();
    assertNull(previousBead68.getPage());
    PDThreadBead previousBead69 = previousBead34.getPreviousBead();
    assertNull(previousBead69.getPage());
    assertNull(actualFirstBead.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(nextBead2.getRectangle());
    assertNull(nextBead3.getRectangle());
    assertNull(nextBead4.getRectangle());
    assertNull(nextBead5.getRectangle());
    assertNull(nextBead6.getRectangle());
    assertNull(nextBead35.getRectangle());
    assertNull(nextBead36.getRectangle());
    assertNull(nextBead10.getRectangle());
    assertNull(nextBead37.getRectangle());
    assertNull(nextBead38.getRectangle());
    assertNull(nextBead9.getRectangle());
    assertNull(nextBead13.getRectangle());
    assertNull(nextBead39.getRectangle());
    assertNull(nextBead40.getRectangle());
    assertNull(nextBead41.getRectangle());
    assertNull(nextBead16.getRectangle());
    assertNull(nextBead42.getRectangle());
    assertNull(nextBead43.getRectangle());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead12.getRectangle());
    assertNull(nextBead18.getRectangle());
    assertNull(nextBead20.getRectangle());
    assertNull(nextBead44.getRectangle());
    assertNull(nextBead45.getRectangle());
    assertNull(nextBead22.getRectangle());
    assertNull(nextBead46.getRectangle());
    assertNull(nextBead47.getRectangle());
    assertNull(nextBead15.getRectangle());
    assertNull(nextBead24.getRectangle());
    assertNull(nextBead48.getRectangle());
    assertNull(nextBead51.getRectangle());
    assertNull(nextBead26.getRectangle());
    assertNull(nextBead52.getRectangle());
    assertNull(nextBead53.getRectangle());
    assertNull(nextBead7.getRectangle());
    assertNull(nextBead11.getRectangle());
    assertNull(nextBead17.getRectangle());
    assertNull(nextBead19.getRectangle());
    assertNull(nextBead27.getRectangle());
    assertNull(nextBead54.getRectangle());
    assertNull(nextBead55.getRectangle());
    assertNull(nextBead28.getRectangle());
    assertNull(nextBead56.getRectangle());
    assertNull(nextBead57.getRectangle());
    assertNull(nextBead21.getRectangle());
    assertNull(nextBead29.getRectangle());
    assertNull(nextBead58.getRectangle());
    assertNull(nextBead59.getRectangle());
    assertNull(nextBead60.getRectangle());
    assertNull(nextBead30.getRectangle());
    assertNull(nextBead61.getRectangle());
    assertNull(nextBead62.getRectangle());
    assertNull(nextBead14.getRectangle());
    assertNull(nextBead23.getRectangle());
    assertNull(nextBead31.getRectangle());
    assertNull(nextBead49.getRectangle());
    assertNull(nextBead63.getRectangle());
    assertNull(nextBead64.getRectangle());
    assertNull(nextBead32.getRectangle());
    assertNull(nextBead65.getRectangle());
    assertNull(nextBead66.getRectangle());
    assertNull(nextBead25.getRectangle());
    assertNull(nextBead33.getRectangle());
    assertNull(nextBead67.getRectangle());
    assertNull(nextBead68.getRectangle());
    assertNull(nextBead34.getRectangle());
    assertNull(nextBead69.getRectangle());
    assertNull(nextBead70.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(previousBead2.getRectangle());
    assertNull(previousBead4.getRectangle());
    assertNull(previousBead5.getRectangle());
    assertNull(previousBead9.getRectangle());
    assertNull(previousBead17.getRectangle());
    assertNull(previousBead35.getRectangle());
    assertNull(previousBead36.getRectangle());
    assertNull(previousBead18.getRectangle());
    assertNull(previousBead37.getRectangle());
    assertNull(previousBead38.getRectangle());
    assertNull(previousBead10.getRectangle());
    assertNull(previousBead19.getRectangle());
    assertNull(previousBead39.getRectangle());
    assertNull(previousBead40.getRectangle());
    assertNull(previousBead41.getRectangle());
    assertNull(previousBead20.getRectangle());
    assertNull(previousBead42.getRectangle());
    assertNull(previousBead43.getRectangle());
    assertNull(previousBead6.getRectangle());
    assertNull(previousBead11.getRectangle());
    assertNull(previousBead21.getRectangle());
    assertNull(previousBead22.getRectangle());
    assertNull(previousBead44.getRectangle());
    assertNull(previousBead45.getRectangle());
    assertNull(previousBead23.getRectangle());
    assertNull(previousBead46.getRectangle());
    assertNull(previousBead47.getRectangle());
    assertNull(previousBead12.getRectangle());
    assertNull(previousBead24.getRectangle());
    assertNull(previousBead48.getRectangle());
    assertNull(previousBead49.getRectangle());
    assertNull(previousBead25.getRectangle());
    assertNull(previousBead50.getRectangle());
    assertNull(previousBead51.getRectangle());
    assertNull(previousBead3.getRectangle());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead13.getRectangle());
    assertNull(previousBead26.getRectangle());
    assertNull(previousBead27.getRectangle());
    assertNull(previousBead52.getRectangle());
    assertNull(previousBead53.getRectangle());
    assertNull(previousBead28.getRectangle());
    assertNull(previousBead54.getRectangle());
    assertNull(previousBead55.getRectangle());
    assertNull(previousBead14.getRectangle());
    assertNull(previousBead29.getRectangle());
    assertNull(previousBead56.getRectangle());
    assertNull(previousBead57.getRectangle());
    assertNull(previousBead58.getRectangle());
    assertNull(previousBead30.getRectangle());
    assertNull(previousBead59.getRectangle());
    assertNull(previousBead60.getRectangle());
    assertNull(previousBead8.getRectangle());
    assertNull(previousBead15.getRectangle());
    assertNull(previousBead31.getRectangle());
    assertNull(previousBead61.getRectangle());
    assertNull(previousBead62.getRectangle());
    assertNull(previousBead63.getRectangle());
    assertNull(previousBead32.getRectangle());
    assertNull(previousBead64.getRectangle());
    assertNull(previousBead65.getRectangle());
    assertNull(previousBead16.getRectangle());
    assertNull(previousBead33.getRectangle());
    assertNull(previousBead66.getRectangle());
    assertNull(previousBead67.getRectangle());
    assertNull(previousBead34.getRectangle());
    assertNull(previousBead68.getRectangle());
    assertNull(previousBead69.getRectangle());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertSame(cOSObject, thread2.getCOSObject());
    assertSame(cOSObject, thread3.getCOSObject());
    assertSame(cOSObject, thread4.getCOSObject());
    assertSame(cOSObject, thread5.getCOSObject());
    assertSame(cOSObject, thread6.getCOSObject());
    assertSame(cOSObject, thread7.getCOSObject());
    assertSame(cOSObject, thread8.getCOSObject());
    assertSame(cOSObject, thread9.getCOSObject());
    assertSame(cOSObject, thread10.getCOSObject());
    assertSame(cOSObject, thread11.getCOSObject());
    assertSame(cOSObject, thread12.getCOSObject());
    assertSame(cOSObject, thread13.getCOSObject());
    assertSame(cOSObject, thread14.getCOSObject());
    assertSame(cOSObject, thread15.getCOSObject());
    assertSame(cOSObject, thread16.getCOSObject());
    assertSame(cOSObject, thread17.getCOSObject());
    assertSame(cOSObject, thread18.getCOSObject());
    assertSame(cOSObject, thread19.getCOSObject());
    assertSame(cOSObject, thread20.getCOSObject());
    assertSame(cOSObject, thread21.getCOSObject());
    assertSame(cOSObject, thread22.getCOSObject());
    assertSame(cOSObject, thread23.getCOSObject());
    assertSame(cOSObject, thread24.getCOSObject());
    assertSame(cOSObject, thread25.getCOSObject());
    assertSame(cOSObject, thread26.getCOSObject());
    assertSame(cOSObject, thread27.getCOSObject());
    assertSame(cOSObject, thread28.getCOSObject());
    assertSame(cOSObject, thread29.getCOSObject());
    assertSame(cOSObject, thread30.getCOSObject());
    assertSame(cOSObject, thread31.getCOSObject());
    assertSame(cOSObject, thread32.getCOSObject());
    assertSame(cOSObject, thread33.getCOSObject());
    assertSame(cOSObject, thread34.getCOSObject());
    assertSame(cOSObject, thread35.getCOSObject());
    assertSame(cOSObject, thread36.getCOSObject());
    assertSame(cOSObject, thread37.getCOSObject());
    assertSame(cOSObject, thread38.getCOSObject());
    assertSame(cOSObject, thread39.getCOSObject());
    assertSame(cOSObject, thread40.getCOSObject());
    assertSame(cOSObject, thread41.getCOSObject());
    assertSame(cOSObject, thread42.getCOSObject());
    assertSame(cOSObject, thread43.getCOSObject());
    assertSame(cOSObject, thread44.getCOSObject());
    assertSame(cOSObject, thread45.getCOSObject());
    assertSame(cOSObject, thread46.getCOSObject());
    assertSame(cOSObject, thread47.getCOSObject());
    assertSame(cOSObject, thread48.getCOSObject());
    assertSame(cOSObject, thread49.getCOSObject());
    assertSame(cOSObject, thread50.getCOSObject());
    assertSame(cOSObject, thread51.getCOSObject());
    assertSame(cOSObject, thread52.getCOSObject());
    assertSame(cOSObject, thread53.getCOSObject());
    assertSame(cOSObject, thread54.getCOSObject());
    assertSame(cOSObject, thread55.getCOSObject());
    assertSame(cOSObject, thread56.getCOSObject());
    assertSame(cOSObject, thread57.getCOSObject());
    assertSame(cOSObject, thread58.getCOSObject());
    assertSame(cOSObject, thread59.getCOSObject());
    assertSame(cOSObject, thread60.getCOSObject());
    assertSame(cOSObject, thread61.getCOSObject());
    assertSame(cOSObject, thread62.getCOSObject());
    assertSame(cOSObject, thread63.getCOSObject());
    assertSame(cOSObject, thread64.getCOSObject());
    assertSame(cOSObject, thread65.getCOSObject());
    assertSame(cOSObject, thread66.getCOSObject());
    assertSame(cOSObject, thread67.getCOSObject());
    assertSame(cOSObject, thread68.getCOSObject());
    assertSame(cOSObject, thread69.getCOSObject());
    assertSame(cOSObject2, nextBead.getCOSObject());
    assertSame(cOSObject2, nextBead2.getCOSObject());
    assertSame(cOSObject2, nextBead3.getCOSObject());
    assertSame(cOSObject2, nextBead4.getCOSObject());
    assertSame(cOSObject2, nextBead5.getCOSObject());
    assertSame(cOSObject2, nextBead6.getCOSObject());
    assertSame(cOSObject2, nextBead35.getCOSObject());
    assertSame(cOSObject2, nextBead36.getCOSObject());
    assertSame(cOSObject2, nextBead10.getCOSObject());
    assertSame(cOSObject2, nextBead37.getCOSObject());
    assertSame(cOSObject2, nextBead38.getCOSObject());
    assertSame(cOSObject2, nextBead9.getCOSObject());
    assertSame(cOSObject2, nextBead13.getCOSObject());
    assertSame(cOSObject2, nextBead39.getCOSObject());
    assertSame(cOSObject2, nextBead40.getCOSObject());
    assertSame(cOSObject2, nextBead41.getCOSObject());
    assertSame(cOSObject2, nextBead16.getCOSObject());
    assertSame(cOSObject2, nextBead42.getCOSObject());
    assertSame(cOSObject2, nextBead43.getCOSObject());
    assertSame(cOSObject2, nextBead8.getCOSObject());
    assertSame(cOSObject2, nextBead12.getCOSObject());
    assertSame(cOSObject2, nextBead18.getCOSObject());
    assertSame(cOSObject2, nextBead20.getCOSObject());
    assertSame(cOSObject2, nextBead44.getCOSObject());
    assertSame(cOSObject2, nextBead45.getCOSObject());
    assertSame(cOSObject2, nextBead22.getCOSObject());
    assertSame(cOSObject2, nextBead46.getCOSObject());
    assertSame(cOSObject2, nextBead47.getCOSObject());
    assertSame(cOSObject2, nextBead15.getCOSObject());
    assertSame(cOSObject2, nextBead24.getCOSObject());
    assertSame(cOSObject2, nextBead48.getCOSObject());
    assertSame(cOSObject2, nextBead50.getCOSObject());
    assertSame(cOSObject2, nextBead51.getCOSObject());
    assertSame(cOSObject2, nextBead26.getCOSObject());
    assertSame(cOSObject2, nextBead52.getCOSObject());
    assertSame(cOSObject2, nextBead53.getCOSObject());
    assertSame(cOSObject2, nextBead7.getCOSObject());
    assertSame(cOSObject2, nextBead11.getCOSObject());
    assertSame(cOSObject2, nextBead17.getCOSObject());
    assertSame(cOSObject2, nextBead19.getCOSObject());
    assertSame(cOSObject2, nextBead27.getCOSObject());
    assertSame(cOSObject2, nextBead54.getCOSObject());
    assertSame(cOSObject2, nextBead55.getCOSObject());
    assertSame(cOSObject2, nextBead28.getCOSObject());
    assertSame(cOSObject2, nextBead56.getCOSObject());
    assertSame(cOSObject2, nextBead57.getCOSObject());
    assertSame(cOSObject2, nextBead21.getCOSObject());
    assertSame(cOSObject2, nextBead29.getCOSObject());
    assertSame(cOSObject2, nextBead58.getCOSObject());
    assertSame(cOSObject2, nextBead59.getCOSObject());
    assertSame(cOSObject2, nextBead60.getCOSObject());
    assertSame(cOSObject2, nextBead30.getCOSObject());
    assertSame(cOSObject2, nextBead61.getCOSObject());
    assertSame(cOSObject2, nextBead62.getCOSObject());
    assertSame(cOSObject2, nextBead14.getCOSObject());
    assertSame(cOSObject2, nextBead23.getCOSObject());
    assertSame(cOSObject2, nextBead31.getCOSObject());
    assertSame(cOSObject2, nextBead49.getCOSObject());
    assertSame(cOSObject2, nextBead63.getCOSObject());
    assertSame(cOSObject2, nextBead64.getCOSObject());
    assertSame(cOSObject2, nextBead32.getCOSObject());
    assertSame(cOSObject2, nextBead65.getCOSObject());
    assertSame(cOSObject2, nextBead66.getCOSObject());
    assertSame(cOSObject2, nextBead25.getCOSObject());
    assertSame(cOSObject2, nextBead33.getCOSObject());
    assertSame(cOSObject2, nextBead67.getCOSObject());
    assertSame(cOSObject2, nextBead68.getCOSObject());
    assertSame(cOSObject2, nextBead34.getCOSObject());
    assertSame(cOSObject2, nextBead69.getCOSObject());
    assertSame(cOSObject2, nextBead70.getCOSObject());
    assertSame(cOSObject2, previousBead.getCOSObject());
    assertSame(cOSObject2, previousBead2.getCOSObject());
    assertSame(cOSObject2, previousBead4.getCOSObject());
    assertSame(cOSObject2, previousBead5.getCOSObject());
    assertSame(cOSObject2, previousBead9.getCOSObject());
    assertSame(cOSObject2, previousBead17.getCOSObject());
    assertSame(cOSObject2, previousBead35.getCOSObject());
    assertSame(cOSObject2, previousBead36.getCOSObject());
    assertSame(cOSObject2, previousBead18.getCOSObject());
    assertSame(cOSObject2, previousBead37.getCOSObject());
    assertSame(cOSObject2, previousBead38.getCOSObject());
    assertSame(cOSObject2, previousBead10.getCOSObject());
    assertSame(cOSObject2, previousBead19.getCOSObject());
    assertSame(cOSObject2, previousBead39.getCOSObject());
    assertSame(cOSObject2, previousBead40.getCOSObject());
    assertSame(cOSObject2, previousBead41.getCOSObject());
    assertSame(cOSObject2, previousBead20.getCOSObject());
    assertSame(cOSObject2, previousBead42.getCOSObject());
    assertSame(cOSObject2, previousBead43.getCOSObject());
    assertSame(cOSObject2, previousBead6.getCOSObject());
    assertSame(cOSObject2, previousBead11.getCOSObject());
    assertSame(cOSObject2, previousBead21.getCOSObject());
    assertSame(cOSObject2, previousBead22.getCOSObject());
    assertSame(cOSObject2, previousBead44.getCOSObject());
    assertSame(cOSObject2, previousBead45.getCOSObject());
    assertSame(cOSObject2, previousBead23.getCOSObject());
    assertSame(cOSObject2, previousBead46.getCOSObject());
    assertSame(cOSObject2, previousBead47.getCOSObject());
    assertSame(cOSObject2, previousBead12.getCOSObject());
    assertSame(cOSObject2, previousBead24.getCOSObject());
    assertSame(cOSObject2, previousBead48.getCOSObject());
    assertSame(cOSObject2, previousBead49.getCOSObject());
    assertSame(cOSObject2, previousBead25.getCOSObject());
    assertSame(cOSObject2, previousBead50.getCOSObject());
    assertSame(cOSObject2, previousBead51.getCOSObject());
    assertSame(cOSObject2, previousBead3.getCOSObject());
    assertSame(cOSObject2, previousBead7.getCOSObject());
    assertSame(cOSObject2, previousBead13.getCOSObject());
    assertSame(cOSObject2, previousBead26.getCOSObject());
    assertSame(cOSObject2, previousBead27.getCOSObject());
    assertSame(cOSObject2, previousBead52.getCOSObject());
    assertSame(cOSObject2, previousBead53.getCOSObject());
    assertSame(cOSObject2, previousBead28.getCOSObject());
    assertSame(cOSObject2, previousBead54.getCOSObject());
    assertSame(cOSObject2, previousBead55.getCOSObject());
    assertSame(cOSObject2, previousBead14.getCOSObject());
    assertSame(cOSObject2, previousBead29.getCOSObject());
    assertSame(cOSObject2, previousBead56.getCOSObject());
    assertSame(cOSObject2, previousBead57.getCOSObject());
    assertSame(cOSObject2, previousBead58.getCOSObject());
    assertSame(cOSObject2, previousBead30.getCOSObject());
    assertSame(cOSObject2, previousBead59.getCOSObject());
    assertSame(cOSObject2, previousBead60.getCOSObject());
    assertSame(cOSObject2, previousBead8.getCOSObject());
    assertSame(cOSObject2, previousBead15.getCOSObject());
    assertSame(cOSObject2, previousBead31.getCOSObject());
    assertSame(cOSObject2, previousBead61.getCOSObject());
    assertSame(cOSObject2, previousBead62.getCOSObject());
    assertSame(cOSObject2, previousBead63.getCOSObject());
    assertSame(cOSObject2, previousBead32.getCOSObject());
    assertSame(cOSObject2, previousBead64.getCOSObject());
    assertSame(cOSObject2, previousBead65.getCOSObject());
    assertSame(cOSObject2, previousBead16.getCOSObject());
    assertSame(cOSObject2, previousBead33.getCOSObject());
    assertSame(cOSObject2, previousBead66.getCOSObject());
    assertSame(cOSObject2, previousBead67.getCOSObject());
    assertSame(cOSObject2, previousBead34.getCOSObject());
    assertSame(cOSObject2, previousBead68.getCOSObject());
    assertSame(cOSObject2, previousBead69.getCOSObject());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   * <p>
   * Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setFirstBead(PDThreadBead)")
  void testSetFirstBead() {
    // Arrange
    COSDictionary t = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    t.setKey(key);
    PDThread pdThread = new PDThread(t);
    PDThreadBead bead = new PDThreadBead();

    // Act
    pdThread.setFirstBead(bead);

    // Assert
    assertSame(key, bead.getThread().getCOSObject().getKey());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Thread COSObject Key is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setFirstBead(PDThreadBead); given PDThread(); then PDThreadBead() Thread COSObject Key is 'null'")
  void testSetFirstBead_givenPDThread_thenPDThreadBeadThreadCOSObjectKeyIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();
    PDThreadBead bead = new PDThreadBead();

    // Act
    pdThread.setFirstBead(bead);

    // Assert
    COSDictionary cOSObject = bead.getThread().getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertSame(cOSObject,
        bead.getNextBead().getNextBead().getPreviousBead().getNextBead().getPreviousBead().getThread().getCOSObject());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   * <ul>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Thread COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setFirstBead(PDThreadBead); then PDThreadBead() Thread COSObject is COSDictionary()")
  void testSetFirstBead_thenPDThreadBeadThreadCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary t = new COSDictionary();
    t.setDirect(true);
    PDThread pdThread = new PDThread(t);
    PDThreadBead bead = new PDThreadBead();

    // Act
    pdThread.setFirstBead(bead);

    // Assert
    PDThread thread = bead.getThread();
    assertSame(t, thread.getCOSObject());
    PDThreadBead firstBead = thread.getFirstBead();
    PDThread thread2 = firstBead.getThread();
    assertSame(t, thread2.getCOSObject());
    assertSame(t, thread2.getFirstBead().getThread().getCOSObject());
    PDThreadBead nextBead = bead.getNextBead();
    PDThread thread3 = nextBead.getThread();
    PDThreadBead firstBead2 = thread3.getFirstBead();
    assertSame(t, firstBead2.getThread().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    PDThread thread4 = nextBead2.getThread();
    assertSame(t, thread4.getFirstBead().getThread().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    PDThread thread5 = nextBead3.getThread();
    assertSame(t, thread5.getFirstBead().getThread().getCOSObject());
    PDThreadBead previousBead = bead.getPreviousBead();
    PDThreadBead nextBead4 = previousBead.getNextBead();
    PDThread thread6 = nextBead4.getThread();
    assertSame(t, thread6.getFirstBead().getThread().getCOSObject());
    PDThread thread7 = previousBead.getThread();
    PDThreadBead firstBead3 = thread7.getFirstBead();
    assertSame(t, firstBead3.getThread().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    PDThread thread8 = previousBead2.getThread();
    assertSame(t, thread8.getFirstBead().getThread().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    PDThread thread9 = previousBead3.getThread();
    assertSame(t, thread9.getFirstBead().getThread().getCOSObject());
    assertSame(t, thread3.getCOSObject());
    PDThreadBead nextBead5 = firstBead.getNextBead();
    assertSame(t, nextBead5.getThread().getCOSObject());
    assertSame(t, firstBead2.getNextBead().getThread().getCOSObject());
    assertSame(t, firstBead3.getNextBead().getThread().getCOSObject());
    assertSame(t, thread4.getCOSObject());
    assertSame(t, nextBead5.getNextBead().getThread().getCOSObject());
    assertSame(t, thread5.getCOSObject());
    PDThreadBead nextBead6 = nextBead3.getNextBead();
    assertSame(t, nextBead6.getThread().getCOSObject());
    assertSame(t, nextBead6.getNextBead().getThread().getCOSObject());
    PDThreadBead nextBead7 = nextBead4.getNextBead();
    assertSame(t, nextBead7.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead7.getThread().getCOSObject());
    PDThreadBead nextBead8 = previousBead2.getNextBead();
    assertSame(t, nextBead8.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead4 = nextBead2.getPreviousBead();
    PDThreadBead nextBead9 = previousBead4.getNextBead();
    assertSame(t, nextBead9.getNextBead().getThread().getCOSObject());
    PDThreadBead nextBead10 = previousBead3.getNextBead();
    assertSame(t, nextBead10.getNextBead().getThread().getCOSObject());
    assertSame(t, thread6.getCOSObject());
    PDThreadBead previousBead5 = firstBead.getPreviousBead();
    assertSame(t, previousBead5.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead8.getThread().getCOSObject());
    assertSame(t, nextBead9.getThread().getCOSObject());
    PDThreadBead previousBead6 = nextBead3.getPreviousBead();
    assertSame(t, previousBead6.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead7 = nextBead4.getPreviousBead();
    assertSame(t, previousBead7.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead10.getThread().getCOSObject());
    PDThreadBead previousBead8 = previousBead2.getPreviousBead();
    assertSame(t, previousBead8.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead9 = previousBead3.getPreviousBead();
    assertSame(t, previousBead9.getNextBead().getThread().getCOSObject());
    assertSame(t, thread7.getCOSObject());
    assertSame(t, previousBead5.getThread().getCOSObject());
    assertSame(t, firstBead2.getPreviousBead().getThread().getCOSObject());
    assertSame(t, firstBead3.getPreviousBead().getThread().getCOSObject());
    assertSame(t, thread8.getCOSObject());
    assertSame(t, nextBead5.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead4.getThread().getCOSObject());
    assertSame(t, previousBead6.getThread().getCOSObject());
    assertSame(t, nextBead6.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead7.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead7.getThread().getCOSObject());
    assertSame(t, nextBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead9.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead10.getPreviousBead().getThread().getCOSObject());
    assertSame(t, thread9.getCOSObject());
    assertSame(t, previousBead5.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead8.getThread().getCOSObject());
    assertSame(t, previousBead4.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead6.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead7.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getThread().getCOSObject());
    assertSame(t, previousBead8.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead9.getPreviousBead().getThread().getCOSObject());
  }
}
