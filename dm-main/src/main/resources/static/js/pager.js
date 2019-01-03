function getPageShowList(currentPage, pageCount){
	var list = [];
	var start,end;

	if(pageCount<=5){
		start = 1;
		end = pageCount;
	}else{
		if(currentPage<3){//左边拿光,右边补上
			start = 1;
			end = currentPage+(5-currentPage);
		}else if(currentPage>pageCount-2){//这段不对
			start = pageCount-4;
			end = pageCount;
		}else{
			start = currentPage-2;
			end = currentPage+2;
		}
	}
	
	for(var i = start;i<=end;i++){
		list.push(i);
	}
	
	return list;
}

function initPager(currentPage, elementsCount, pageSize){
	var pageCount = Math.ceil(elementsCount/pageSize);
	
	var html = "";
	
	if(pageCount<5 || currentPage==1){
		html += "<li style='display:none'><a href='"+(currentPage-1)+"'><</a></li>";
	}else{
		html += "<li><a href='"+(currentPage-1)+"'><</a></li>";
	}
	
	if(pageCount>5){
		var pageToShow = getPageShowList(currentPage, pageCount);
		for(var i = 1;i<=pageCount;i++){
			if( $.inArray(i, pageToShow) > -1){
				var link_Url = "";
				if( i == currentPage){
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
			if( i == currentPage){
				link_Url += "<li><a class='active' href='javascript:void(0)'>"+i+"</a></li>"; 
			}else{
				link_Url += "<li><a href='"+i+"'>"+i+"</a></li>"; 
			}
			
			html += link_Url;
		}
	}
	
	
	if(pageCount<5 || currentPage==pageCount){
		html += "<li style='display:none'><a href='"+(currentPage+1)+"'>></a></li>";
	}else{
		html += "<li><a href='"+(currentPage+1)+"'>></a></li>";
	}
	
	return html;
}
