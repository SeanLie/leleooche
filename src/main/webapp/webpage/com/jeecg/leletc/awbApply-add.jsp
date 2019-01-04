<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>申请运单_MiniDao</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="awbApplyController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${awbApplyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					<td class="value">
					     	 <input id="appPerson" name="appPerson" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="appTime" name="appTime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="appRemarks" name="appRemarks" type="text" maxlength="1000" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							票证类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="ticketType" name="ticketType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">票证类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运单类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="awbType" name="awbType" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运单类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申请数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="appNumber" name="appNumber" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审批人:
						</label>
					</td>
					<td class="value">
					     	 <input id="audPerson" name="audPerson" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审批人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							审批时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="audTime" name="audTime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审批时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审批人备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="audRemarks" name="audRemarks" type="text" maxlength="1000" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审批人备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="appStatus" name="appStatus" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审批数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="audNumbers" name="audNumbers" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审批数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发放人:
						</label>
					</td>
					<td class="value">
					     	 <input id="pPerson" name="pPerson" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发放人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发放时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="paidTime" name="paidTime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发放时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							电子单标识:
						</label>
					</td>
					<td class="value">
					     	 <input id="eawb" name="eawb" type="text" maxlength="1" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电子单标识</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/awbApply.js"></script>		
