package io.oasp.gastronomy.restaurant.offermanagement.special;

import java.time.DayOfWeek;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * This is the test-case of {@link Special}
 *
 * @since dev
 */
@SpringBootTest(classes = { SpringBootApp.class })
@Transactional
public class SpecialTest extends ComponentTest {

  @Inject
  private OfferDao offerDao;

  @Inject
  private SpecialDao specialDao;

  private OfferEntity prepareOffer() {

    OfferEntity initialOE = new OfferEntity();
    initialOE.setNumber(12L);
    initialOE.setPrice(new Money(5.99));
    this.offerDao.save(initialOE);

    OfferEntity result = initialOE;
    return result;
  }

  private WeeklyPeriodEmbeddable prepareActivePeriod() {

    WeeklyPeriodEmbeddable result = new WeeklyPeriodEmbeddable();
    result.setEndingDay(DayOfWeek.MONDAY);
    result.setStartingDay(DayOfWeek.TUESDAY);
    result.setStartingHour(1);
    result.setEndingHour(1);
    return result;
  }

  private SpecialEntity prepareSpecialEntity() {

    SpecialEntity result = new SpecialEntity();
    result.setName("ddd");
    result.setActivePeriod(prepareActivePeriod());
    result.setOffer(prepareOffer());
    // result.setId(1L);

    return result;
  }

  @Test
  public void addSpecialTest() {

    // given
    // OfferEntity offerEntity = mock(OfferEntity.class);
    // OfferEto offerEto = new OfferEto();

    // when(this.offerDao.findOne(1)).thenReturn(offerEntity);
    // when(this.beanMapper.map(offerEntity, OfferEto.class)).thenReturn(offerEto);

    SpecialEntity prepareSpecialEntity = prepareSpecialEntity();

    // when
    this.specialDao.save(prepareSpecialEntity);
    // then
    assertThat(prepareSpecialEntity.getId()).isNotNull();
  }

}