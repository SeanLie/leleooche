<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>主表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,webuploader,bootstrap-form"></t:base>
<script src="${webRoot}/plug-in/lhgDialog/lhgdialog.min.js"></script>
<script src="${webRoot}/plug-in/jquery-plugs/i18n/jquery.i18n.properties.js"></script>
<script src="${webRoot}/plug-in/tools/curdtools.js"></script>
</head>
<body>
<div class="container" style="width:100%;overflow-x:hidden">
<div class="panel panel-default">
<div class="panel-heading"></div>
<div class="panel-body">
<form class="form-horizontal" role="form" id="formobj" action="jformOrderMainController.do?doUpdate" method="POST">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${jformOrderMainPage.id}"/>
	<fieldset>
		<legend>订单主信息</legend>
		<div class="main-form">
			<div class="row">
				<div class="bt-item col-md-6 col-sm-6">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							订单号：
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8 bt-content">
							<input name="orderCode" value = "${jformOrderMainPage.orderCode}" type="text" class="form-control input-sm" maxlength="50"  validType="jform_order_main,order_code,id" datatype="*" ignore="ignore"  />
		            	</div>
					</div>
				</div>
				<div class="bt-item col-md-6 col-sm-6">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							订单日期：
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8 bt-content">
		            		<div class="input-group input-group-sm">
		            			<input name="orderDate" type="text" class="form-control input-sm laydate-date" value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${jformOrderMainPage.orderDate}'/>"  ignore="ignore"  />
		            			<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
		            		</div>
		            	</div>
					</div>
				</div>
				<div class="bt-item col-md-6 col-sm-6">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							订单金额：
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8 bt-content">
							<input name="orderMoney" value = "${jformOrderMainPage.orderMoney}" type="text" class="form-control input-sm" maxlength="10"  datatype="d" ignore="ignore"  />
		            	</div>
					</div>
				</div>
				<div class="bt-item col-md-6 col-sm-6">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							备注：
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8 bt-content">
							<input name="content" value = "${jformOrderMainPage.content}" type="text" class="form-control input-sm" maxlength="500"  ignore="ignore"  />
		            	</div>
					</div>
				</div>
				<div class="bt-item col-md-6 col-sm-6">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							订单扫描件：
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8 bt-content">
				<t:webUploader name="ctype" outJs="true" auto="true" showImgDiv="filediv_ctype" pathValues="${jformOrderMainPage.ctype}" datatype="*"></t:webUploader>
				<div class="form" id="filediv_ctype"></div>
		            	</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>

	<ul class="nav nav-tabs" style="margin-bottom:0" id="subTabs">
		<li class="active"><a href="#jformOrderCustomer" data-toggle="tab">订单客户信息</a></li>  
		<li><a href="#jformOrderTicket" data-toggle="tab">订单票务信息</a></li>  
	</ul>
	<div class="tab-content" style="background-color:#fff;padding-top:10px;">
		<div class="tab-pane fade in active" id="jformOrderCustomer">  
			<div class="form-tb-toolbar">
				<button onclick="addOneRow('jformOrderCustomer_table')" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
				<button onclick="deleteSelectRows('jformOrderCustomer_table')" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-minus"></span>&nbsp;删除</button>
			</div>
	   		<div style="overflow-x:auto">
	   		<table class="table subinfo-table" id="jformOrderCustomer_table">
		   		<thead>
		   		<tr>
		   			<th align="center" style="width:25px;"></th>
					<th>客户名</th>
					<th>单价</th>
					<th>性别</th>
					<th>电话1</th>
					<th>身份证扫描件</th>
				</thead>
				<tbody>
				<c:if test="${fn:length(jformOrderMainPage.jformOrderCustomerList)  > 0 }">
				<c:forEach items="${jformOrderMainPage.jformOrderCustomerList}" var="poVal" varStatus="stuts">
				<tr>
			  		<td class="form-ck">
			  			<input style="" type="checkbox" name="ck"/>
			  			<input name = "jformOrderCustomerList[${stuts.index }].id" value= "${poVal.id}" type="hidden"/>
			  		</td>
					<td>
							<input name="jformOrderCustomerList[${stuts.index }].name" value = "${poVal.name}" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
					</td>
					<td>
							<input name="jformOrderCustomerList[${stuts.index }].money" value = "${poVal.money}" type="text" class="form-control input-sm" maxlength="10"  datatype="d" ignore="ignore"  />
					</td>
					<td>
			            	<div style="padding-top:5px">
			            	<t:dictSelect field="jformOrderCustomerList[${stuts.index }].sex" defaultVal = "${poVal.sex}" extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="性别"  typeGroupCode="sex" ></t:dictSelect>
			            	</div>
					</td>
					<td>
							<input name="jformOrderCustomerList[${stuts.index }].telphone" value = "${poVal.telphone}" type="text" class="form-control input-sm" maxlength="32"  ignore="checked"  />
					</td>
					<td>
				            		<input onclick="onetomanyUpload('jformOrderCustomerList[${stuts.index }].sfPic')" class="btn btn-default" type="button" value="上传附件" />	
									<input type="hidden" name="jformOrderCustomerList[${stuts.index }].sfPic" value = "${poVal.sfPic}"/>
										<a target="_blank" class=".btn-default"							            <c:if test="${not empty poVal.sfPic}">							              href="img/server/${poVal.sfPic}?down=true">下载							            </c:if>							            <c:if test="${empty poVal.sfPic}">></c:if>							            </a>					</td>
			  	</tr>
				</c:forEach>
				</c:if>
				<c:if test="${fn:length(jformOrderMainPage.jformOrderCustomerList) <= 0 }">
				<tr>
			  		<td class="form-ck"><input type="checkbox" name="ck"/></td>
					<td>
							<input name="jformOrderCustomerList[0].name"  type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
					</td>
					<td>
							<input name="jformOrderCustomerList[0].money"  type="text" class="form-control input-sm" maxlength="10"  datatype="d" ignore="ignore"  />
					</td>
					<td>
			            	<div style="padding-top:5px">
			            	<t:dictSelect field="jformOrderCustomerList[0].sex"  extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="性别"  typeGroupCode="sex" ></t:dictSelect>
			            	</div>
					</td>
					<td>
							<input name="jformOrderCustomerList[0].telphone"  type="text" class="form-control input-sm" maxlength="32"  ignore="checked"  />
					</td>
					<td>
				            		<input onclick="onetomanyUpload('jformOrderCustomerList[0].sfPic')" class="btn btn-default" type="button" value="上传附件" />	
									<input type="hidden" name="jformOrderCustomerList[0].sfPic" />
										<a target="_blank" class="btn btn-link"></a>
					</td>
			  	</tr>
				</c:if>
			 	</tbody>
			</table>
			</div>
		</div>
		<div class="tab-pane fade" id="jformOrderTicket">  
			<div class="form-tb-toolbar">
				<button onclick="addOneRow('jformOrderTicket_table')" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
				<button onclick="deleteSelectRows('jformOrderTicket_table')" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-minus"></span>&nbsp;删除</button>
			</div>
	   		<div style="overflow-x:auto">
	   		<table class="table subinfo-table" id="jformOrderTicket_table">
		   		<thead>
		   		<tr>
		   			<th align="center" style="width:25px;"></th>
					<th>航班号</th>
					<th>航班时间</th>
				</thead>
				<tbody>
				<c:if test="${fn:length(jformOrderMainPage.jformOrderTicketList)  > 0 }">
				<c:forEach items="${jformOrderMainPage.jformOrderTicketList}" var="poVal" varStatus="stuts">
				<tr>
			  		<td class="form-ck">
			  			<input style="" type="checkbox" name="ck"/>
			  			<input name = "jformOrderTicketList[${stuts.index }].id" value= "${poVal.id}" type="hidden"/>
			  		</td>
					<td>
							<input name="jformOrderTicketList[${stuts.index }].ticketCode" value = "${poVal.ticketCode}" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
					</td>
					<td>
			            	<input name="jformOrderTicketList[${stuts.index }].tickectDate" type="text" class="form-control input-sm laydate-datetime" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' type='both' value='${poVal.tickectDate}'/>"  datatype="*"  ignore="checked"  />
					</td>
			  	</tr>
				</c:forEach>
				</c:if>
				<c:if test="${fn:length(jformOrderMainPage.jformOrderTicketList) <= 0 }">
				<tr>
			  		<td class="form-ck"><input type="checkbox" name="ck"/></td>
					<td>
							<input name="jformOrderTicketList[0].ticketCode"  type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
					</td>
					<td>
			            	<input name="jformOrderTicketList[0].tickectDate" type="text" class="form-control input-sm laydate-datetime" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' type='both' value='${tickectDate}'/>"  datatype="*"  ignore="checked"  />
					</td>
			  	</tr>
				</c:if>
			 	</tbody>
			</table>
			</div>
		</div>
	</div>
</form>
</div>
</div>
</div>
<table style="display:none">
	<tbody id="jformOrderCustomer_table_template">
		<tr>
			<td class="form-ck"><input type="checkbox" name="ck"/></td>
			<td>
							<input name="jformOrderCustomerList[#index#].name"  type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
			</td>
			<td>
							<input name="jformOrderCustomerList[#index#].money"  type="text" class="form-control input-sm" maxlength="10"  datatype="d" ignore="ignore"  />
			</td>
			<td>
			            	<div style="padding-top:5px">
			            	<t:dictSelect field="jformOrderCustomerList[#index#].sex"  extendJson="{class:'i-checks-tpl'}" type="radio" hasLabel="false"  title="性别"  typeGroupCode="sex" ></t:dictSelect>
			            	</div>
			</td>
			<td>
							<input name="jformOrderCustomerList[#index#].telphone"  type="text" class="form-control input-sm" maxlength="32"  ignore="checked"  />
			</td>
			<td>
				            		<input onclick="onetomanyUpload('jformOrderCustomerList[#index#].sfPic')" class="btn btn-default" type="button" value="上传附件" />	
									<input type="hidden" name="jformOrderCustomerList[#index#].sfPic" />
										<a target="_blank" class="btn btn-link"></a>
			</td>
		</tr>
	</tbody>
	<tbody id="jformOrderTicket_table_template">
		<tr>
			<td class="form-ck"><input type="checkbox" name="ck"/></td>
			<td>
							<input name="jformOrderTicketList[#index#].ticketCode"  type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
			</td>
			<td>
			            	<input name="jformOrderTicketList[#index#].tickectDate" type="text" class="form-control input-sm laydate-datetime" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' type='both' value='${tickectDate}'/>"  datatype="*"  ignore="checked"  />
			</td>
		</tr>
	</tbody>
</table>
<script type="text/javascript">
$(document).ready(function() {
	formControlInit();
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				var oopanel = $(o.obj).closest(".tab-pane");
				var a = 0;
				if(oopanel.length>0){
					var panelID = oopanel.attr("id");
					if(!!panelID){
						var waitActive = $('#subTabs a[href="#'+panelID+'"]');
						if(!waitActive.hasClass("active")){
							waitActive.tab('show')
							a = 1;
						}
					}
				}
				if(a==1){
					setTimeout(function(){validationMessage(o.obj,msg);},366);
				}else{
					validationMessage(o.obj,msg);
				}
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
	  //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".form-tb-toolbar").hide();
		$("#formobj").find(":input").attr("readonly","readonly");
	}
});
function formControlInit(){
	$(".laydate-datetime").each(function(){
		if($(this).attr("name").indexOf('#index#')<=0){
			var _this = this;
			laydate.render({
			  elem: _this,
			  format: 'yyyy-MM-dd HH:mm:ss',
			  type: 'datetime',
			  ready: function(date){
			  	 $(_this).val(DateJsonFormat(date,this.format));
			  },
			  done:function(){
				  _this.focus();
			  }
			});
		}

	});
	$(".laydate-date").each(function(){
		if($(this).attr("name").indexOf('#index#')<=0){
			var _this = this;
			laydate.render({
			  elem: _this,
			  format: 'yyyy-MM-dd',
			  ready: function(date){
			  	 $(_this).val(DateJsonFormat(date,this.format));
			  },
			  done:function(){
				  _this.focus();
			  }
			});
		}
	});
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
}
//初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('tbody > tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this),validtype_str = $this.attr('validType'), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val();
			if(name!=null){
				if (name.indexOf("#index#") >= 0){
					$this.attr("name",name.replace('#index#',i));
				}else{
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s+1,e);
					$this.attr("name",name.replace("["+new_name+"]","["+i+"]"));
				}
			}
			if(id!=null){
				if (id.indexOf("#index#") >= 0){
					$this.attr("id",id.replace('#index#',i));
				}else{
					var s = id.indexOf("[");
					var e = id.indexOf("]");
					var new_id = id.substring(s+1,e);
					$this.attr("id",id.replace(new_id,i));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
				    var s = onclick_str.indexOf("[");
					var e = onclick_str.indexOf("]");
					var new_onclick_str = onclick_str.substring(s+1,e);
					$this.attr("onclick",onclick_str.replace(new_onclick_str,i));
				}
			}
			if(validtype_str!=null){
				if(validtype_str.indexOf("#index#") >= 0){
					$this.attr("validType",validtype_str.replace('#index#',i));
				}
			}
			var class_str = $this.attr("class");
			if(!!class_str && class_str.indexOf("i-checks-tpl")>=0){
				$this.attr("class",class_str.replace(/i-checks-tpl/,"i-checks"));
			}
		});
		//$(this).find('div[name=\'xh\']').html(i+1);
	});
}
//新增一行
function addOneRow(tableId){
 	var tr =  $("#"+tableId+"_template tr").clone();
 	 $("#"+tableId).append(tr);
 	 resetTrNum(tableId);
 	 formControlInit();
}
//删除所选行
function deleteSelectRows(tableId){
	$("#"+tableId).find("input[name$='ck']:checked").parent().parent().remove();
    resetTrNum(tableId); 
}
//通用弹出式文件上传
function onetomanyUpload(inputName){
    $.dialog({
           content: "url:${webRoot}/systemController.do?commonWebUpload",
           lock : true,
           title:"文件上传",
           zIndex:getzIndex(),
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
	       ok: function(){
	               var iframe = this.iframe.contentWindow;
	               var url = iframe.uploadCallback();
	               $("input[name='"+inputName+"']").val(url);
	               $("input[name='"+inputName+"']").next("a").attr("href","img/server/"+url+"?down=true").html("下载");
	               return true;
	       },
	       cancelVal: '关闭',
	       cancel: function(){
       	   } 
      });
  }
</script>
</body>
</html>