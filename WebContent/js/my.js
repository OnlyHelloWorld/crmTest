//加载数据字典
    //数据字典类型;将数据放入标签的id;生成下拉选时select标签的name属性值;回显时选中哪个option
	function loadSelect(typecode,positionId,selectname,selectedId){
		
    	//创建select对象,指定name属性
    	var $select = $("<select name="+selectname+"></select>")
    	//添加提示选项
    	
    	$select.append($("<option value=''>--请选择--</option>"));
    	//使用jquery的ajax方法,访问后台Action
    	$.post("${pageContext.request.contextPath}/BaseDictAction",{dict_type_code:typecode},
    			function(data){
    		//遍历json数组
    		$.each(data,function(i,json){
    			var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>")
    			//判断是否需要回显
    			if(json['dict_id'] == selectedId){
    				$option.attr("selected","selected");
    			}
    			//添加到selected对象
    			$select.append($option);
    		});
    	},"json");
    	//对返回的json数组进行遍历
    	
    	//每次遍历创建一个option对象,判断是否需要回显并添加到selected对象
    	//将组装好的select对象放入页面指定对象
    	
    	$("#"+positionId).append($select);
	}