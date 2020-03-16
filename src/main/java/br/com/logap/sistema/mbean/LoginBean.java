/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logap.sistema.mbean;

import javax.faces.bean.ManagedBean;

import br.com.logap.sistema.dao.UsuarioDAO;
import br.com.logap.sistema.model.Usuario;
import br.com.logap.sistema.utils.AbstractController;
import br.com.logap.sistema.utils.ValidatorUtil;

/**
 *
 * @author Luan
 */
@ManagedBean
public class LoginBean extends AbstractController {

	UsuarioDAO dao = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public String login() {
		if (!validarLogin()) {
			addMsgError("Login ou senha não informados");
			return null;
		}

		try {
			Usuario u_banco = dao.findWithLoginAndPassword(usuario.getLogin(), usuario.getPassword());
			if (!ValidatorUtil.isEmpty(u_banco)) {
				getCurrentSession().setAttribute("usuario", u_banco);
				addMsgInfo("Seja Bem vindo(a) ao Sistema");
				return "/autenticado/mural";
			}
		} catch (Exception e) {
			addMsgError("Login ou senha incorretos!");
			return "/publico/login";
		}
		addMsgError("Login ou senha incorretos!");
		return "/publico/login";
	}

	public String logoff() {
		getCurrentSession().removeAttribute("usuario");
		return "/publico/login";
	}

	public boolean validarLogin() {
		if (!ValidatorUtil.isEmpty(usuario.getLogin()) && !ValidatorUtil.isEmpty(usuario.getPassword())) {
			return true;
		}
		return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
