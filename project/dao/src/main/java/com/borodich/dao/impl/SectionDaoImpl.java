package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.SectionDao;
import com.borodich.entity.Section;

@Repository
public class SectionDaoImpl extends AbstractBaseDao<Section> implements SectionDao {

	public SectionDaoImpl() {
		super(Section.class);
	}

	@Override
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getEntityById(Integer id) {
		return entityManager.find(Section.class, id);
	}
}
