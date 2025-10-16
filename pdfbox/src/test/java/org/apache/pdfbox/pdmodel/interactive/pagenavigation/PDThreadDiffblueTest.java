package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDThreadDiffblueTest {
  /**
   * Test {@link PDThread#PDThread(COSDictionary)}.
   *
   * <p>Method under test: {@link PDThread#PDThread(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDThread(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.<init>(COSDictionary)"})
  void testNewPDThread() {
    // Arrange
    COSDictionary t = new COSDictionary();

    // Act and Assert
    assertSame(t, new PDThread(t).getCOSObject());
  }

  /**
   * Test {@link PDThread#PDThread()}.
   *
   * <p>Method under test: {@link PDThread#PDThread()}
   */
  @Test
  @DisplayName("Test new PDThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.<init>()"})
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
   *
   * <p>Method under test: {@link PDThread#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDThread.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDThread().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); given PDThread(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentInformation PDThread.getThreadInfo()"})
  void testGetThreadInfo_givenPDThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDThread().getThreadInfo());
  }

  /**
   * Test {@link PDThread#getThreadInfo()}.
   *
   * <ul>
   *   <li>Then return Author is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); then return Author is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentInformation PDThread.getThreadInfo()"})
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
    assertTrue(actualThreadInfo.getMetadataKeys().isEmpty());
  }

  /**
   * Test {@link PDThread#getThreadInfo()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getThreadInfo()}
   */
  @Test
  @DisplayName("Test getThreadInfo(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocumentInformation PDThread.getThreadInfo()"})
  void testGetThreadInfo_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentInformation info = new PDDocumentInformation(dic);

    PDThread pdThread = new PDThread();
    pdThread.setThreadInfo(info);

    // Act and Assert
    assertSame(dic, pdThread.getThreadInfo().getCOSObject());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setThreadInfo(PDDocumentInformation); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setThreadInfo(PDDocumentInformation)"})
  void testSetThreadInfo_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDThread pdThread = new PDThread();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));

    // Act
    pdThread.setThreadInfo(new PDDocumentInformation(dic));

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
    assertSame(dic, threadInfo.getCOSObject());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDThread#PDThread()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setThreadInfo(PDDocumentInformation); given PDThread(); when 'null'; then PDThread() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setThreadInfo(PDDocumentInformation)"})
  void testSetThreadInfo_givenPDThread_whenNull_thenPDThreadCOSObjectValuesSizeIsOne() {
    // Arrange
    PDThread pdThread = new PDThread();

    // Act
    pdThread.setThreadInfo(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdThread.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setThreadInfo(PDDocumentInformation); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setThreadInfo(PDDocumentInformation)"})
  void testSetThreadInfo_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDThread pdThread = new PDThread();

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);

    // Act
    pdThread.setThreadInfo(new PDDocumentInformation(dic));

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
    assertSame(dic, threadInfo.getCOSObject());
  }

  /**
   * Test {@link PDThread#setThreadInfo(PDDocumentInformation)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentInformation#PDDocumentInformation()}.
   *   <li>Then {@link PDThread#PDThread()} ThreadInfo Author is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setThreadInfo(PDDocumentInformation)}
   */
  @Test
  @DisplayName(
      "Test setThreadInfo(PDDocumentInformation); when PDDocumentInformation(); then PDThread() ThreadInfo Author is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setThreadInfo(PDDocumentInformation)"})
  void testSetThreadInfo_whenPDDocumentInformation_thenPDThreadThreadInfoAuthorIsNull() {
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
   * Test {@link PDThread#getFirstBead()}.
   *
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); given PDThread(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDThreadBead PDThread.getFirstBead()"})
  void testGetFirstBead_givenPDThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDThread().getFirstBead());
  }

  /**
   * Test {@link PDThread#getFirstBead()}.
   *
   * <ul>
   *   <li>Then return PreviousBead Thread is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); then return PreviousBead Thread is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDThreadBead PDThread.getFirstBead()"})
  void testGetFirstBead_thenReturnPreviousBeadThreadIsNull() {
    // Arrange
    PDThreadBead bead = new PDThreadBead();
    bead.setPreviousBead(new PDThreadBead());

    PDThread pdThread = new PDThread();
    pdThread.setThreadInfo(new PDDocumentInformation());
    pdThread.setFirstBead(bead);

    // Act and Assert
    assertNull(pdThread.getFirstBead().getPreviousBead().getThread());
  }

  /**
   * Test {@link PDThread#getFirstBead()}.
   *
   * <ul>
   *   <li>Then return Thread ThreadInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#getFirstBead()}
   */
  @Test
  @DisplayName("Test getFirstBead(); then return Thread ThreadInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDThreadBead PDThread.getFirstBead()"})
  void testGetFirstBead_thenReturnThreadThreadInfoIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();
    pdThread.setFirstBead(new PDThreadBead());

    // Act
    PDThreadBead actualFirstBead = pdThread.getFirstBead();

    // Assert
    PDThread thread = actualFirstBead.getThread();
    assertNull(thread.getThreadInfo());
    assertNull(actualFirstBead.getNextBead().getThread().getThreadInfo());
    PDThread thread2 = actualFirstBead.getPreviousBead().getThread();
    assertNull(thread2.getThreadInfo());
    COSDictionary cOSObject = thread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(cOSObject, thread2.getCOSObject());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   *
   * <p>Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setFirstBead(PDThreadBead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setFirstBead(PDThreadBead)"})
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
   *
   * <ul>
   *   <li>Given {@link PDThread#PDThread()}.
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Thread COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName(
      "Test setFirstBead(PDThreadBead); given PDThread(); then PDThreadBead() Thread COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setFirstBead(PDThreadBead)"})
  void testSetFirstBead_givenPDThread_thenPDThreadBeadThreadCOSObjectKeyIsNull() {
    // Arrange
    PDThread pdThread = new PDThread();
    PDThreadBead bead = new PDThreadBead();

    // Act
    pdThread.setFirstBead(bead);

    // Assert
    PDThread thread = bead.getThread();
    COSDictionary cOSObject = thread.getCOSObject();
    assertNull(cOSObject.getKey());
    PDThreadBead firstBead = thread.getFirstBead();
    assertNull(firstBead.getPage());
    assertNull(bead.getNextBead().getThread().getFirstBead().getPage());
    assertNull(bead.getPreviousBead().getThread().getFirstBead().getPage());
    assertNull(firstBead.getNextBead().getPage());
    assertNull(firstBead.getPreviousBead().getPage());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = bead.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   *
   * <ul>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is five.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setFirstBead(PDThreadBead); then PDThreadBead() COSObject Values size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setFirstBead(PDThreadBead)"})
  void testSetFirstBead_thenPDThreadBeadCOSObjectValuesSizeIsFive() {
    // Arrange
    PDThread pdThread = new PDThread();

    PDPage page = new PDPage();
    page.setRotation(1);

    PDThreadBead bead = new PDThreadBead();
    bead.setPage(page);

    // Act
    pdThread.setFirstBead(bead);

    // Assert
    COSDictionary cOSObject = bead.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(page, bead.getThread().getFirstBead().getPage());
  }

  /**
   * Test {@link PDThread#setFirstBead(PDThreadBead)}.
   *
   * <ul>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Thread COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDThread#setFirstBead(PDThreadBead)}
   */
  @Test
  @DisplayName(
      "Test setFirstBead(PDThreadBead); then PDThreadBead() Thread COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDThread.setFirstBead(PDThreadBead)"})
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
    assertSame(t, thread.getFirstBead().getThread().getCOSObject());
    PDThreadBead nextBead = bead.getNextBead();
    assertSame(t, nextBead.getThread().getCOSObject());
    assertSame(t, nextBead.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead = bead.getPreviousBead();
    assertSame(t, previousBead.getNextBead().getThread().getCOSObject());
    assertSame(t, previousBead.getThread().getCOSObject());
    assertSame(t, nextBead.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead.getPreviousBead().getThread().getCOSObject());
  }
}
