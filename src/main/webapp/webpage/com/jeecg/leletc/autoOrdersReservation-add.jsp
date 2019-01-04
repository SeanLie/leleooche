<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预约订单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="autoOrdersReservationController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${autoOrdersReservationPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderCode" name="orderCode" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							订单状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderStatus" name="orderStatus" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="statusName" name="statusName" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							状态备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="statusRemark" name="statusRemark" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态备注</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单日期:
						</label>
					</td>
					<td class="value">
							   <input id="orderTime" name="orderTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							预约排序:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderLevel" name="orderLevel" type="text" maxlength="10" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预约排序</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户停车地点:
						</label>
					</td>
					<td class="value">
					     	 <input id="parkSpace" name="parkSpace" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户停车地点</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							用户停车位:
						</label>
					</td>
					<td class="value">
					     	 <input id="parkNo" name="parkNo" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户停车位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车牌号:
						</label>
					</td>
					<td class="value">
					     	 <input id="plateNumber" name="plateNumber" type="text" maxlength="255" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车牌号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							用户停车照片:
						</label>
					</td>
					<td class="value">
					     	 <input id="parkPhoto" name="parkPhoto" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户停车照片</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							服务商停车位:
						</label>
					</td>
					<td class="value">
					     	 <input id="providerParkNo" name="providerParkNo" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服务商停车位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							服务商停车照片:
						</label>
					</td>
					<td class="value">
					     	 <input id="providerParkPhoto" name="providerParkPhoto" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服务商停车照片</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单描述:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderDesc" name="orderDesc" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单描述</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人名称:
						</label>
					</td>
					<td class="value">
							<input id="createName" name="createName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'id,realname','orderUsers,createName','base_user')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createBy" name="createBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateName" name="updateName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateBy" name="updateBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新日期:
						</label>
					</td>
					<td class="value">
							   <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/autoOrdersReservation.js"></script>		
