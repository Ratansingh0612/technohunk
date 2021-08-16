package com.techquiz.control.panel.dao;

import com.techquiz.control.panel.dao.entity.AppSettingsEntity;

/**
 * 
 * @author Nagendra
 *
 */
public interface AppSettingsDao {

	public AppSettingsEntity findAppDefaultSettings(int isid);

}
