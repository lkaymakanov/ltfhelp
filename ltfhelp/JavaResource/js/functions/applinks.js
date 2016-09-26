function createHref(linkInfo){
		return linkInfo.protocol + '://' + linkInfo.ip + ':' + linkInfo.port + '/' + linkInfo.context;
	}
	
	function selectLink(link){
		console.log(link.dataset.link);
		
		if(selectedLinkId!="-1"){
			document.getElementById(selectedLinkId).style.backgroundColor  = "";
		}
		link.style.backgroundColor  = selectColor;
		selectedLinkId = link.id;
		document.getElementById('seldb').innerHTML =  link.innerHTML;
	}
	
	function showToolTip(link){
		var id= 'tooltip_'+ link.dataset.link;
		var el = document.getElementById(id);
		el.style.display='block';
		if(link.id != selectedLinkId){
			link.style.backgroundColor = highlightColor;
		}
		
	}
	
	function hideToolTip(link){
		var id= 'tooltip_'+ link.dataset.link;
		var el = document.getElementById(id).style.display='none';
		var bc = link.style.backgroundColor;
		if(bc==highlightColor){
			link.style.backgroundColor = "";
		}
	}
	
	
	function createLink(linkInfo, index){
		var href = createHref(linkInfo);
		var target = "mateus";
		if(linkInfo.protocol == 'https') target="_top";
		var tooltTipCnt = 'IP:' + linkInfo.ip + '</br>Port:' + linkInfo.port;
		var tooltip = '<div id="tooltip_' + index + '" style="position:absolute; font-weight:bold; z-index:1000; border:solid 1px green; display:none; top:0; background-color:yellow; left:100%; ">'+ tooltTipCnt +'</div>';
		var tr = '<li style="position:relative; width:100px;"><a id="link_' + index + 
		'" style="text-decoration:none; color:white;" data-link="' + index +'" href="' +
		href +'"' + 'onclick="selectLink(this)"  onmouseover="showToolTip(this)" onmouseout="hideToolTip(this)"   target="' + target +'" >'+
		linkInfo.name + '</a>' + tooltip + '</li>';
		return tr; 
	}