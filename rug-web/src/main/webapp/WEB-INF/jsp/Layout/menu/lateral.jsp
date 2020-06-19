<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Iterator"%>
<%@page import="mx.gob.se.rug.seguridad.to.MenuTO"%>
<%@page import="mx.gob.se.rug.to.UsuarioTO"%>
<%@page import="mx.gob.se.rug.seguridad.serviceimpl.MenusServiceImpl"%>
<%@include file="/WEB-INF/jsp/Layout/menu/applicationCtx.jsp"%>
<ul id="slide-out" class="side-nav indigo lighten-5 collapsible">
	<li>
		<div class="user-view">
			<div class="background">
				<div style="width: 100%; height: 100%; background-color: #1c3144c7;"></div>
			</div>
			<a href="#"><img class="circle" src="<%=request.getContextPath()%>/resources/imgs/msn-user-profile.png" style="background-color: #e2e5ef;"></a>
			<a href="#">
				<span class="white-text name">
					<s:property value="#session.User.profile.nombre" />
			        <s:property  value="#session.User.profile.apellidoPaterno" />
			        <s:property value="#session.User.profile.apellidoMaterno" />
				</span>
			</a>
			<a href="#"><span class="white-text email"><s:property value="#session.User.profile.email" /></span></a>
		</div>
	</li>
	<%
		MenuTO menuTO = new MenuTO(1, request.getContextPath());
		MenusServiceImpl menuService = (MenusServiceImpl) ctx .getBean("menusServiceImpl");
		menuTO = menuService.cargaMenuPrincipal(menuTO, (UsuarioTO) session.getAttribute("usuario"));
		Iterator<String> iterator = menuTO.getHtml().iterator();
		while (iterator.hasNext()) {
			String menuItem = iterator.next();
	%><%=menuItem%>
	<%
		}
	%>
</ul>
<!-- <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a> -->
