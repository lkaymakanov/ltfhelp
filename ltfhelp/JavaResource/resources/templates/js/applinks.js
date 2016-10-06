var selectedLinkId="-1";

/**used to create the links to the real applications ....*/
function AppLinks(){
	this.applinks;
	this.thisref='thisRef';
	this.highlightColor = 'brown';
	this.selectColor = 'red';
	 
	
	this.sortByName = function (a,b){
		if(a.name > b.name) return 1;
		if(a.name < b.name) return -1;
		return 0;
	};
	
	this.createHref = function(linkInfo){
		return linkInfo.protocol + '://' + linkInfo.ip + ':' + linkInfo.port + '/' + linkInfo.context;
	};
	
	this.selectLink = function(link){
		if(selectedLinkId!="-1"){
			document.getElementById(selectedLinkId).style.backgroundColor  = "";
		}
		link.style.backgroundColor  = this.selectColor;
		selectedLinkId = link.id;
		document.getElementById('seldb').innerHTML =  link.innerHTML;
	};
	
	this.showToolTip = function (link){
		var id= 'tooltip_' +this.thisref + link.dataset.link;
		var el = document.getElementById(id);
		el.style.display='block';
		if(link.id != selectedLinkId){
			link.style.backgroundColor = this.highlightColor;
		}
		
	};
	
	this.hideToolTip = function (link){
		var id= 'tooltip_'+this.thisref +  link.dataset.link;
		var el = document.getElementById(id).style.display='none';
		var bc = link.style.backgroundColor;
		if(bc == this.highlightColor){
			link.style.backgroundColor = "";
		}
	};
	
	this.createLink = function (linkInfo, index){
		var href = this.createHref(linkInfo);
		var target = "mateus";
		if(linkInfo.protocol == 'https') target="_top";
		var tooltTipCnt = 'IP:' + linkInfo.ip + '</br>Port:' + linkInfo.port;
		var tooltip = '<div id="tooltip_' +this.thisref +  index + '" style="position:absolute; font-weight:bold; z-index:1000; '+
		' border:solid 1px green; display:none; top:0; background-color:yellow; left:100%; ">'+ tooltTipCnt +'</div>';
		var tr = '<li style="position:relative; width:100px;"><a id="link_' + index + 
		'" style="text-decoration:none; color:white;" data-link="' + index +'" href="' +
		href +'"' + 'onclick="'+this.thisref+'.selectLink(this);"  onmouseover="'+this.thisref+'.showToolTip(this)" onmouseout="'+this.thisref+'.hideToolTip(this);"   target="' + target +'" >'+
		linkInfo.name + '</a>' + tooltip + '</li>';
		return tr; 
	};
	
	this.createLinkList = function(ulclass, ulid){
		var ul='<ul class="'+ ulclass + '" id="'+ ulid + '" style="display:none;">';
		for(var i =0; i < this.applinks.length; i++) ul+=(this.createLink(this.applinks[i], i));
		return ul + '</ul>';
	};
	
	this.writeLinkList = function(ulclass, ulid){
		document.write(this.createLinkList(ulclass, ulid));
	}
};

AppLinks.prototype.init_1 = function(thisref, applinks){
	this.applinks = applinks;
	this.thisref = thisref;
	this.applinks = applinks.sort(this.sortByName);
	return this;
};
