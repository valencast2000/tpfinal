package com.coop.tpfinal.business;

import java.util.List;

import com.coop.tpfinal.business.BusinessException;
import com.coop.tpfinal.business.NotFoundException;
import com.coop.tpfinal.model.Usuario;

public interface IUsuarioBusiness {

	public Usuario load(long id) throws BusinessException, NotFoundException;

	public Usuario add(Usuario usuario) throws BusinessException;

	public void delete(long id) throws BusinessException;

	public Usuario update(Usuario usuario) throws BusinessException;

	public List<Usuario> list() throws BusinessException;
	
	public List<Usuario> list(String parteDelNombre) throws BusinessException;

	public Usuario load(String usernameOrEmail) throws BusinessException, NotFoundException;

}
