package com.coop.tpfinal.business;

import java.util.List;

import com.coop.tpfinal.model.Sprint;

public interface ISprintBusiness {
	public Sprint load(long id) throws BusinessException, NotFoundException;

	public Sprint add(Sprint sprint) throws BusinessException;

	public void delete(long id) throws BusinessException;

	public Sprint update(Sprint usuario) throws BusinessException;

	public List<Sprint> list() throws BusinessException;

	public Sprint load(String name) throws BusinessException, NotFoundException;
}
