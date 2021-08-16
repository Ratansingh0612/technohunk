package com.techquiz.control.panel.service;

import com.techquiz.control.panel.controller.model.AppSettingsVO;

/**
 * 
 * @author Nagendra
 *
 */
public interface AppSettingsService {

	public AppSettingsVO findAppDefaultSettings(int isid);

}
