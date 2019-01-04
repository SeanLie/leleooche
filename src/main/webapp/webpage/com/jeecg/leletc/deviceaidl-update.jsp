<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能柜接口_测试Minidao</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="deviceaidlController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${deviceaidlPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属部门:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sysOrgCode" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.sysOrgCode}" hasLabel="false"  title="所属部门" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属部门</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所属公司:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sysCompanyCode" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.sysCompanyCode}" hasLabel="false"  title="所属公司" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属公司</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开门板ip:
							</label>
						</td>
						<td class="value">
						    <input id="ip" name="ip" type="text" maxlength="36" style="width: 150px" class="inputxt"  datatype="ipv4" ignore="checked"  value='${deviceaidlPage.ip}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开门板ip</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开门板端口号:
							</label>
						</td>
						<td class="value">
						    <input id="port" name="port" type="text" maxlength="10" style="width: 150px" class="inputxt"  datatype="s" ignore="checked"  value='${deviceaidlPage.port}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开门板端口号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="boxNum" name="boxNum" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="s" ignore="checked"  value='${deviceaidlPage.boxNum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								列号:
							</label>
						</td>
						<td class="value">
						    <input id="columnNum" name="columnNum" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="s" ignore="checked"  value='${deviceaidlPage.columnNum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">列号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								等待休眠时间:
							</label>
						</td>
						<td class="value">
						    <input id="sleeptime" name="sleeptime" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n" ignore="checked"  value='${deviceaidlPage.sleeptime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">等待休眠时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								箱门总数:
							</label>
						</td>
						<td class="value">
						    <input id="boxTotal" name="boxTotal" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${deviceaidlPage.boxTotal}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱门总数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								智能柜类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="boxType" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.boxType}" hasLabel="false"  title="智能柜类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">智能柜类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								维护用户:
							</label>
						</td>
						<td class="value">
						    <input id="boxPerson" name="boxPerson" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${deviceaidlPage.boxPerson}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">维护用户</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所在省:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="prov" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.prov}" hasLabel="false"  title="所在省" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在省</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所在市:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="city" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.city}" hasLabel="false"  title="所在市" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在市</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所在区:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="section" type="list"  typeGroupCode=""   defaultVal="${deviceaidlPage.section}" hasLabel="false"  title="所在区" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在区</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								运单号:
							</label>
						</td>
						<td class="value">
						    <input id="awb" name="awb" type="text" maxlength="8" style="width: 150px" class="inputxt"  datatype="awb" ignore="ignore"  value='${deviceaidlPage.awb}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否租用:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isrend" type="radio"  datatype="n"  typeGroupCode="isrend"   defaultVal="${deviceaidlPage.isrend}" hasLabel="false"  title="是否租用" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否租用</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								客户类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="custyoe" type="checkbox"  datatype="n"  typeGroupCode="paytype"   defaultVal="${deviceaidlPage.custyoe}" hasLabel="false"  title="客户类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								上线时间:
							</label>
						</td>
						<td class="value">
									   <input id="onlinetime" name="onlinetime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${deviceaidlPage.onlinetime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
						      	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上线时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								弹出框:
							</label>
						</td>
						<td class="value">
							<input id="popup" name="popup" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  value='${deviceaidlPage.popup}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">弹出框</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								描述信息:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="desr" style="height:auto;width:95%;" class="inputxt" rows="6" name="desr"  ignore="ignore" >${deviceaidlPage.desr}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述信息</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/deviceaidl.js"></script>		
