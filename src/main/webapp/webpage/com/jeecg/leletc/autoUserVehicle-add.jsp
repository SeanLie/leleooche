<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户车辆信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="autoUserVehicleController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${autoUserVehiclePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="userId" name="userId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车牌号:
						</label>
					</td>
					<td class="value">
					     	 <input id="carNum" name="carNum" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车牌号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车型号:
						</label>
					</td>
					<td class="value">
					     	 <input id="carModel" name="carModel" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车型号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							购车日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="carBuyDate" name="carBuyDate" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">购车日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车辆描述:
						</label>
					</td>
					<td class="value">
					     	 <input id="carDesc" name="carDesc" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆描述</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/autoUserVehicle.js"></script>		
