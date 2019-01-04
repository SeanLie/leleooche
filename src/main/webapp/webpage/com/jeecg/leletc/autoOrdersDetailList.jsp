<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addAutoOrdersDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delAutoOrdersDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addAutoOrdersDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_autoOrdersDetail_table_template tr").clone();
	 	 $("#add_autoOrdersDetail_table").append(tr);
	 	 resetTrNum('add_autoOrdersDetail_table');
	 	 return false;
    });  
	$('#delAutoOrdersDetailBtn').bind('click', function(){   
		$("#add_autoOrdersDetail_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_autoOrdersDetail_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addAutoOrdersDetailBtn" href="#">添加</a> <a id="delAutoOrdersDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="autoOrdersDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						服务产品
				  </td>
	</tr>
	<tbody id="add_autoOrdersDetail_table">
	<c:if test="${fn:length(autoOrdersDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="autoOrdersDetailList[0].id" type="hidden"/>
					<input name="autoOrdersDetailList[0].createName" type="hidden"/>
					<input name="autoOrdersDetailList[0].createBy" type="hidden"/>
					<input name="autoOrdersDetailList[0].createDate" type="hidden"/>
					<input name="autoOrdersDetailList[0].updateName" type="hidden"/>
					<input name="autoOrdersDetailList[0].updateBy" type="hidden"/>
					<input name="autoOrdersDetailList[0].updateDate" type="hidden"/>
					<input name="autoOrdersDetailList[0].sysOrgCode" type="hidden"/>
					<input name="autoOrdersDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="autoOrdersDetailList[0].bpmStatus" type="hidden"/>
					<input name="autoOrdersDetailList[0].orderId" type="hidden"/>
				  <td align="left">
					  	<input name="autoOrdersDetailList[0].product" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">服务产品</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(autoOrdersDetailList)  > 0 }">
		<c:forEach items="${autoOrdersDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="autoOrdersDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="autoOrdersDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="autoOrdersDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="autoOrdersDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="autoOrdersDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="autoOrdersDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="autoOrdersDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="autoOrdersDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="autoOrdersDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="autoOrdersDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="autoOrdersDetailList[${stuts.index }].orderId" type="hidden" value="${poVal.orderId }"/>
				   <td align="left">
					  	<input name="autoOrdersDetailList[${stuts.index }].product" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.product }"/>
					  <label class="Validform_label" style="display: none;">服务产品</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
