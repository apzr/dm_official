function getPageShowList(currentNumber, pageCount){
	var list = [];
	var start,end;

	if(pageCount<=5){
		start = 1;
		end = pageCount;
	}else{
		if(currentNumber<3){//左边拿光,右边补上
			start = 1;
			end = currentNumber+(5-currentNumber);
		}else if(currentNumber>pageCount-2){//这段不对
			start = pageCount-4;
			end = pageCount;
		}else{
			start = currentNumber-2;
			end = currentNumber+2;
		}
	}
	
	for(var i = start;i<=end;i++){
		list.push(i);
	}
	
	return list;
}

function initPager(currentNumber, totalNumber, pageSize){
	var pageCount = Math.ceil(totalNumber/pageSize);
	
	var html = "";
	
	if(pageCount<5 || currentNumber==1){
		html += "<li style='display:none'><a href='"+(currentNumber-1)+"'><</a></li>";
	}else{
		html += "<li><a href='"+(currentNumber-1)+"'><</a></li>";
	}
	
	if(pageCount>5){
		var pageToShow = getPageShowList(currentNumber, pageCount);
		for(var i = 1;i<=pageCount;i++){
			if( $.inArray(i, pageToShow) > -1){
				var link_Url = "";
				if( i == currentNumber){
					link_Url += "<li><a class='active' href='javascript:void(0)'>"+i+"</a></li>"; 
				}else{
					link_Url += "<li><a href='"+i+"'>"+i+"</a></li>"; 
				}
				
				html += link_Url;
			}
		}
	}else{
		for(var i = 1;i<=pageCount;i++){
			var link_Url = "";
			if( i == currentNumber){
				link_Url += "<li><a class='active' href='javascript:void(0)'>"+i+"</a></li>"; 
			}else{
				link_Url += "<li><a href='"+i+"'>"+i+"</a></li>"; 
			}
			
			html += link_Url;
		}
	}
	
	
	if(pageCount<5 || currentNumber==pageCount){
		html += "<li style='display:none'><a href='"+(currentNumber+1)+"'>></a></li>";
	}else{
		html += "<li><a href='"+(currentNumber+1)+"'>></a></li>";
	}
	
	return html;
}
