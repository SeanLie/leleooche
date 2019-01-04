<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tSUserController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tSUserPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								手机号:
							</label>
						</td>
						<td class="value">
						    <input id="mobilephone" name="mobilephone" type="text" maxlength="30" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.mobilephone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								用户昵称:
							</label>
						</td>
						<td class="value">
						    <input id="nickname" name="nickname" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.nickname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户昵称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						    <input id="sex" name="sex" type="text" maxlength="2" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.sex}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								邮箱:
							</label>
						</td>
						<td class="value">
						    <input id="email" name="email" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.email}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮箱</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								办公座机:
							</label>
						</td>
						<td class="value">
						    <input id="officephone" name="officephone" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.officephone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">办公座机</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								portrait:
							</label>
						</td>
						<td class="value">
						    <input id="portrait" name="portrait" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.portrait}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">portrait</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								imsign:
							</label>
						</td>
						<td class="value">
						    <input id="imsign" name="imsign" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.imsign}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">imsign</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								用户类型:
							</label>
						</td>
						<td class="value">
						    <input id="userType" name="userType" type="text" maxlength="2" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.userType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								人员类型:
							</label>
						</td>
						<td class="value">
						    <input id="personType" name="personType" type="text" maxlength="2" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.personType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人员类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								人员级别:
							</label>
						</td>
						<td class="value">
						    <input id="personlevel" name="personlevel" type="text" maxlength="3" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.personlevel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人员级别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户车辆ID:
							</label>
						</td>
						<td class="value">
						    <input id="vehicleId" name="vehicleId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.vehicleId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户车辆ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								用户头像:
							</label>
						</td>
						<td class="value">
						    <input id="headimgurl" name="headimgurl" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.headimgurl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户头像</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户是否关注:
							</label>
						</td>
						<td class="value">
						    <input id="subscribe" name="subscribe" type="text" maxlength="10" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${tSUserPage.subscribe}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户是否关注</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								用户关注时间:
							</label>
						</td>
						<td class="value">
						    <input id="subscribeTime" name="subscribeTime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.subscribeTime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户关注时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								工号:
							</label>
						</td>
						<td class="value">
						    <input id="empNo" name="empNo" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.empNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						    <input id="citizenNo" name="citizenNo" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.citizenNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								传真:
							</label>
						</td>
						<td class="value">
						    <input id="fax" name="fax" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.fax}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">传真</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开发权限标志:
							</label>
						</td>
						<td class="value">
						    <input id="devFlag" name="devFlag" type="text" maxlength="2" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tSUserPage.devFlag}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开发权限标志</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								签名文件:
							</label>
						</td>
						<td class="value">
						    <input id="signaturefile" name="signaturefile" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.signaturefile}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签名文件</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								联系地址:
							</label>
						</td>
						<td class="value">
						    <input id="address" name="address" type="text" maxlength="1000" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.address}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								邮编:
							</label>
						</td>
						<td class="value">
						    <input id="post" name="post" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.post}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮编</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="memo" name="memo" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.memo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								微信OpenId:
							</label>
						</td>
						<td class="value">
						    <input id="openid" name="openid" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.openid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信OpenId</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								微信用户唯一标识:
							</label>
						</td>
						<td class="value">
						    <input id="unionid" name="unionid" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.unionid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信用户唯一标识</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所在城市:
							</label>
						</td>
						<td class="value">
						    <input id="city" name="city" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.city}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在城市</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								国家:
							</label>
						</td>
						<td class="value">
						    <input id="country" name="country" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.country}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国家</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所在省份:
							</label>
						</td>
						<td class="value">
						    <input id="province" name="province" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.province}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在省份</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								用户的语言:
							</label>
						</td>
						<td class="value">
						    <input id="language" name="language" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.language}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户的语言</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户标签:
							</label>
						</td>
						<td class="value">
						    <input id="tagidList" name="tagidList" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.tagidList}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户标签</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								粉丝备注:
							</label>
						</td>
						<td class="value">
						    <input id="remark" name="remark" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tSUserPage.remark}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">粉丝备注</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/tSUser.js"></script>		
