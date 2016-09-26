function escapeRegExp(str) {
    return str.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
}

function replaceAll(str, find, replace) {
  return str.replace(new RegExp(escapeRegExp(find), 'g'), replace);
}



function highlightText(text){
	var bh = document.getElementById("highlight").checked;
	if(!bh) return text;
	var highlighetdText = '<span class="highlight">' + document.getElementById("searchtext").value + '</span>';
	var textTohiglight = document.getElementById("searchtext").value;
	return replaceAll(text, textTohiglight, highlighetdText);
}


function createTableRow(menuitem, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + (menuitem.menuid) + '</td>' + 
	'<td>' + highlightText(menuitem.menuname) + '</td>' + 
	'<td>' + highlightText(menuitem.href) + '</td>' + 
	'<td>' + menuitem.parentid + '</td>' + 
	'</tr>'; 
}

/**a filtering function for each row*/
function filterColumn(menuitem){
	var inputSearch = document.getElementById("searchtext").value;
	
	if(inputSearch.length < 0) return true;
	var bSearchCols = true;//;document.getElementById("ckSearchInColumns").checked;
	var bSearchTables = true;//document.getElementById("ckSearchInTables").checked;
	var bDirectMatch = document.getElementById("ckDirectMatch").checked;

	inputSearch = inputSearch.toLowerCase();
	
	if(bSearchCols) bSearchCols =  bDirectMatch ? menuitem.menuname == inputSearch  : menuitem.menuname.indexOf(inputSearch) > -1;
	if(bSearchTables ) bSearchTables = bDirectMatch  ? menuitem.href == inputSearch  : menuitem.href.indexOf(inputSearch) > -1
	
	return bSearchCols || bSearchTables;
};

//show filtered content
function showFiltered(filtered){
	var d = document.getElementById('filtered');
	var tableStr='<table class="register">';
	var headr = '<tr class="header">' +
	'<td>menuId</td>' + 
	'<td>menuName</td>' + 
	'<td>hRref</td>' + 
	'<td>menuParentId</td>' + 
	'</tr>'; 
	tableStr+=headr;
	if(filtered.length == 0) {d.innerHTML = ''; return;}
	for(i=0; i < filtered.length; i++){tableStr+=(createTableRow(filtered[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
};

/**A bfs search function for creating menu*/
function bfs(menu, rootNode, createmenuFunction){
	this.queue = [];
	this.qEnd = 0;
	this.qStart = 0;
	this.rootNode = rootNode;
	this.menu = menu;
	this.createmenuFunction = createMenuFunction;
	
	this.bfs = function(){
		//loop through root children & put their indexes in queue
		//console.log('root node menuid: '+ rootNode.menuid);
		if(createMenuFunction!=null) createMenuFunction(rootNode.index, rootNode.children);
		for(i =0; i < rootNode.children.length; i++){  
			this.queue.push(rootNode.children[i]);
			this.qEnd+=1;
		}
		//while there are elements in queue
		while(this.qStart < this.qEnd){
			var currentEl = menu[this.queue[this.qStart]];   //get the first element in queue & get element from menu
			
			//console.log('current node index ' +  this.queue[this.qStart] + ' children indexes: ' + currentEl.children);
			//call create menu function
			if(createMenuFunction!=null) createMenuFunction(this.queue[this.qStart], currentEl.children);
			
			//get children indexes for element & put them in queue
			for(i =0; i < currentEl.children.length; i++){  
				this.queue.push(currentEl.children[i]);
				this.qEnd+=1;  
			}
			this.qStart+=1;   //go to next level
		}
		
		//print the queue
		//console.log(this.queue);
	}
		
}




/**Creates a ul with menu items*/
function createUl(ulid, children){
	var ul='<ul class="menu" id="' + ulid +'">';
	var i=0;
	
	//create main nodes
	while(i < children.length){
		var menuItem = children[i];
		ul+='<li id="menuId_' + menuItem.menuid +  '">' + highlightText(children[i].menuname)+  '   <span style="color:aqua;">  ------> ' +   highlightText(children[i].href) + '</span></li>';
		i=i+1;
	}
	ul+='</ul>';
	return ul;
}


/**get menu item objects for menu indexes*/
function getMenuitemsByIndexes(menuindexes){
	var menuitems = [];
	var i=0;
	while(i < menuindexes.length){
		menuitems.push(menu[menuindexes[i]]);
		i=i+1;
	}
	return menuitems;
}


/**Creates menu for root menu index & children nodes for this menu index*/
function createMenuFunction(rootMenuIndex, children){
	if(children.length == 0) return;
	var menuItem = menu[rootMenuIndex];
	var elid = 'menuId_' + menuItem.menuid;
	var domel = document.getElementById(elid);
	
	//create sub menu
	var submenu = createUl(menuItem.menuid, getMenuitemsByIndexes(children));
	domel.innerHTML = domel.innerHTML + submenu;
}






function createMenuNodes(){
    var i = 0;
	
	//retrieve filtered items
	var filteredItems = menu.filter(filterColumn);
	var filteredIndexes = [];
	
	//get filtered items roots indexes
	while(i < filteredItems.length){
		if(filteredIndexes.indexOf(filteredItems[i].rootind) == -1){
			filteredIndexes.push(filteredItems[i].rootind);
		}
		i=i+1;
	}
	
	var rootnodez = getMenuitemsByIndexes(filteredIndexes);
	var mainmenu = createUl(0, rootnodez);
	var div = document.getElementById('filtered');
	
	div.innerHTML = mainmenu;
	i=0;
	while(i < rootnodez.length){
		new bfs(menu, rootnodez[i], createMenuFunction).bfs();
		i=i+1;
	}
}
	
	
function showMenu(){
	var treeVeiw = document.getElementById("treeview").checked;
	if(treeVeiw){
		createMenuNodes();
	}else{
		showFiltered(menu.filter(filterColumn));
	}
}
	
	


