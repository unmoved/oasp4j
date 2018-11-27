package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;

/**
 * @author KKAPLON
 *
 */
@Named
public class SpecialDaoImpl extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialDao {

  @Override
  protected Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

}
