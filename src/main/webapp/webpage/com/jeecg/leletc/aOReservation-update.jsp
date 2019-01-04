<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预约订单</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="orderReservationController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${aOReservationPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">服务产品ID:</label>
			</td>
			<td class="value">
		     	 <input id="productId" name="productId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.productId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务产品ID</label>
			</td>
			<td align="right">
				<label class="Validform_label">订单编号:</label>
			</td>
			<td class="value">
		     	 <input id="orderCode" name="orderCode" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.orderCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">预订用户:</label>
			</td>
			<td class="value">
		     	 <input id="orderUsers" name="orderUsers" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.orderUsers}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预订用户</label>
			</td>
			<td align="right">
				<label class="Validform_label">订单状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="orderStatus" type="list"   typeGroupCode="ord_status"  defaultVal="${aOReservationPage.orderStatus}" hasLabel="false"  title="订单状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">订单日期:</label>
			</td>
			<td class="value">
					  <input id="orderTime" name="orderTime" type="text" style="width: 150px"   datatype="*"  ignore="checked"  value='<fmt:formatDate value='${aOReservationPage.orderTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">预约排序:</label>
			</td>
			<td class="value">
		     	 <input id="orderSort" name="orderSort" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${aOReservationPage.orderSort}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预约排序</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">用户停车地点:</label>
			</td>
			<td class="value">
		     	 <input id="parkSpace" name="parkSpace" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.parkSpace}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用户停车地点</label>
			</td>
			<td align="right">
				<label class="Validform_label">用户停车位:</label>
			</td>
			<td class="value">
		     	 <input id="parkNo" name="parkNo" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.parkNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用户停车位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">用户停车照片:</label>
			</td>
			<td class="value">
		<table id="park_photo_fileTable"></table>
		<div class="form jeecgDetail">
			<t:upload name="parkPhoto" id="parkPhoto" queueID="filediv_parkPhoto" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="pic" buttonText='添加图片'  onUploadStart="parkPhotoOnUploadStart"> </t:upload>
			<div class="form" id="filediv_parkPhoto"></div>
			<script type="text/javascript">
				function parkPhotoOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#parkPhoto').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'auto_orders_reservation',
						'cgFormField':'PARK_PHOTO'
					});
				}
			</script>
		</div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用户停车照片</label>
			</td>
			<td align="right">
				<label class="Validform_label">服务商停车位:</label>
			</td>
			<td class="value">
		     	 <input id="providerParkNo" name="providerParkNo" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOReservationPage.providerParkNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务商停车位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">服务商停车照片:</label>
			</td>
			<td class="value">
		<table id="provider_park_photo_fileTable"></table>
		<div class="form jeecgDetail">
			<t:upload name="providerParkPhoto" id="providerParkPhoto" queueID="filediv_providerParkPhoto" outhtml="false" uploader="cgUploadController.do?saveFiles"  extend="pic" buttonText='添加图片'  onUploadStart="providerParkPhotoOnUploadStart"> </t:upload>
			<div class="form" id="filediv_providerParkPhoto"></div>
			<script type="text/javascript">
				function providerParkPhotoOnUploadStart(file){
					var cgFormId=$("input[name='id']").val();
					$('#providerParkPhoto').uploadify("settings", "formData", {
						'cgFormId':cgFormId,
						'cgFormName':'auto_orders_reservation',
						'cgFormField':'PROVIDER_PARK_PHOTO'
					});
				}
			</script>
		</div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务商停车照片</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">订单描述:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="orderDesc" style="width:600px;height:60px;" class="inputxt" rows="6" name="orderDesc"  ignore="ignore" >${aOReservationPage.orderDesc}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单描述</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="orderReservationController.do?autoOrdersDetailList&id=${aOReservationPage.id}" icon="icon-search" title="预约订单明细" id="autoOrdersDetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_autoOrdersDetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="autoOrdersDetailList[#index#].product" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">服务产品</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/leletc/aOReservation.js"></script>	
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "orderReservationController.do?getFiles&id=" +  cgFormId,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  			$.each(arrayFileObj,function(n,file){
	  				var fieldName = file.field.toLowerCase();
	  				var table = $("#"+fieldName+"_fileTable");
	  				var tr = $("<tr style=\"height:34px;\"></tr>");
	  				var title = file.title;
	  				if(title.length > 15){
	  					title = title.substring(0,12) + "...";
	  				}
	  				var td_title = $("<td>" + title + "</td>");
	  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
	  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
	  		  		tr.appendTo(table);
	  		  		td_title.appendTo(tr);
	  		  		td_download.appendTo(tr);
	  		  		td_view.appendTo(tr);
		  		  		if(location.href.indexOf("load=detail")==-1){
			  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
			  		  		td_del.appendTo(tr);
		  		  		}
	  		  		
	  			 });
	  		   }
	  		});
	  	})
	  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
		  		});
		  	}
	  	
  		function jeecgFormFileCallBack(data){
  			if (data.success == true) {
				uploadFile(data);
			} else {
				if (data.responseText == '' || data.responseText == undefined) {
					$.messager.alert('错误', data.msg);
					$.Hidemsg();
				} else {
					try {
						var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
						$.messager.alert('错误', emsg);
						$.Hidemsg();
					} catch(ex) {
						$.messager.alert('错误', data.responseText + '');
					}
				}
				return false;
			}
			if (!neibuClickFlag) {
				var win = frameElement.api.opener;
				win.reloadTable();
			}
  		}
  		function upload() {
					$('#parkPhoto').uploadify('upload', '*');
					$('#providerParkPhoto').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
					$('#parkPhoto').uploadify('cancel', '*');
					$('#providerParkPhoto').uploadify('cancel', '*');
		}
		function uploadFile(data){
			if(!$("input[name='id']").val()){
				if(data.obj!=null && data.obj!='undefined'){
					$("input[name='id']").val(data.obj.id);
				}
			}
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				if (neibuClickFlag){
					alert(data.msg);
					neibuClickFlag = false;
				}else {
					var win = frameElement.api.opener;
					win.reloadTable();
					win.tip(data.msg);
					frameElement.api.close();
				}
			}
		}
  	</script>
