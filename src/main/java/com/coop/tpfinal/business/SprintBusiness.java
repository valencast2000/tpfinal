package com.coop.tpfinal.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coop.tpfinal.model.Sprint;
import com.coop.tpfinal.model.persistence.SprintRepository;

@Service
public class SprintBusiness implements ISprintBusiness {

	@Autowired
	private SprintRepository SprintDAO;
	
	@Override
	public Sprint load(long id) throws BusinessException, NotFoundException {
		Optional<Sprint> o;
		try{
			o = SprintDAO.findById(id);
		}catch(Exception e) {
			throw new BusinessException(e);
		}
		if (o.isPresent())
			return o.get();
		else
			throw new NotFoundException();
	}

	@Override
	public Sprint add(Sprint sprint) throws BusinessException {
		try {
			return SprintDAO.save(sprint);
		}
		catch(Exception e) {
			throw new BusinessException(e);
		}
		
	}

	@Override
	public void delete(long id) throws BusinessException {
		try {
			SprintDAO.deleteById(id);
		}
		catch(Exception e) {
			throw new BusinessException(e);
		}
		
	}

	@Override
	public Sprint update(Sprint sprint) throws BusinessException {
		try {
			return SprintDAO.save(sprint);
		} catch(Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Sprint> list() throws BusinessException {
		try {
			return SprintDAO.findAll();
		} catch(Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public Sprint load(String name) throws BusinessException, NotFoundException {
		List<Sprint> l;
		try {
			l=SprintDAO.findByName(name);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(),e);
		}
		if(l.size()==0)
			throw new NotFoundException("No se encuentra el Sprint con el nombre "+name);
		return l.get(0);
	}

}
