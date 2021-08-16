package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.StreamDao;
import com.synergisitic.it.service.StreamService;
import com.synergisitic.it.web.form.StreamForm;
import com.techquiz.programys.common.dao.entity.StreamEntity;

/**
 * 
 * @author Nagendra
 *
 */

@Service("StreamServiceImpl")
public class StreamServiceImpl implements StreamService  {
	
	@Autowired
	@Qualifier("StreamDaoImpl")
	private StreamDao streamDao;

	@Override
	public List<StreamForm> findStreams() {
		List<StreamEntity>  streamEntityList=streamDao.findStreams();
		List<StreamForm> streamForms=new ArrayList<StreamForm>();
		for(StreamEntity se:streamEntityList){
			StreamForm sf=new StreamForm();
			BeanUtils.copyProperties(se, sf);
			streamForms.add(sf);
		}
		return streamForms;
	}

}
