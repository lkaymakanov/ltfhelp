/**A bfs search function for creating menu*/
function bfs(menu, rootNode, createmenuFunctionObject){
	this.queue = [];
	this.qEnd = 0;
	this.qStart = 0;
	this.rootNode = rootNode;
	this.menu = menu;
	//this.createmenuFunction = createmenuFunctionObject.createMenuFunction;
	
	this.bfs = function(){
		//loop through root children & put their indexes in queue
		//console.log('root node menuid: '+ rootNode.menuid);
		if(createmenuFunctionObject.createMenuFunction!=null) createmenuFunctionObject.createMenuFunction(rootNode.index, rootNode.children);
		for(i =0; i < rootNode.children.length; i++){  
			this.queue.push(rootNode.children[i]);
			this.qEnd+=1;
		}
		//while there are elements in queue
		while(this.qStart < this.qEnd){
			var currentEl = this.menu[this.queue[this.qStart]];   //get the first element in queue & get element from menu
			
			//console.log('current node index ' +  this.queue[this.qStart] + ' children indexes: ' + currentEl.children);
			//call create menu function
			if(createmenuFunctionObject.createMenuFunction!=null) createmenuFunctionObject.createMenuFunction(this.queue[this.qStart], currentEl.children);
			
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
};


/**Menu create class*/
function MenuCreate(){
	this.menuNodes;
	this.rootNodes;
	this.menuTable;
	
	this.createUl =function(ulid, children){
		var ul='<ul class="menu" id="' + ulid +'">';
		var i=0;
		//create main nodes
		while(i < children.length){
			var menuItem = children[i];
			ul+='<li id="menuId_' + menuItem.menuid +  '">' + highlightText(children[i].menuname, this.menuTable.filterText, this.menuTable.bHighLigh )+  '   <span style="color:aqua;">  ------> ' +  
			highlightText(children[i].href, this.menuTable.filterText, this.menuTable.bHighLigh ) + '</span></li>';
			i=i+1;
		}
		ul+='</ul>';
		return ul;
	};
	
	/**get menu item objects for menu indexes*/
    this.getMenuitemsByIndexes = function (menuindexes){
		var menuitems = [];
		var i=0;
		while(i < menuindexes.length){
			menuitems.push(menu[menuindexes[i]]);
			i=i+1;
		}
		return menuitems;
	};
	
	
	/**Creates menu for root menu index & children nodes for this menu index*/
	this.createMenuFunction = function(rootMenuIndex, children){
		if(children.length == 0) return;
		var menuItem = this.menuNodes[rootMenuIndex];
		var elid = 'menuId_' + menuItem.menuid;
		var domel = document.getElementById(elid);
		
		//create sub menu
		var submenu = this.createUl(menuItem.menuid, this.getMenuitemsByIndexes(children));
		domel.innerHTML = domel.innerHTML + submenu;
	};
	
	
	this.createMenu = function(){
		var i = 0;
		//retrieve filtered items
		var filteredItems = this.menuTable.getFiltereredContent(); //this.menu.filter(filterColumn);
		var filteredIndexes = [];
	
		//get filtered items roots indexes
		while(i < filteredItems.length){
			if(filteredIndexes.indexOf(filteredItems[i].rootind) == -1){
				filteredIndexes.push(filteredItems[i].rootind);
			}
			i=i+1;
		}
		var rootnodez = this.getMenuitemsByIndexes(filteredIndexes);
		var mainmenu = this.createUl(0, rootnodez);
		var div = document.getElementById('treeview');
		
		div.innerHTML = mainmenu;
		i=0;
		while(i < rootnodez.length){
			new bfs(this.menuNodes, rootnodez[i], this).bfs();
			i=i+1;
		}
	};
	
	this.showMenu = function(b){
		document.getElementById("treeview").innerHTML='';
		if(b){
			this.createMenu();
		}else{
			this.menuTable.createTableForCurrentTableId();
		}
	};
	
	//argument constructor
	MenuCreate.prototype.init_1 = function (menuNodes, rootNodes){
		this.menuNodes = menuNodes;    //all menu nodes
		this.rootNodes = rootNodes;    //menu root nodes
		this.menuTable = new TableCreator().init_1('treeview', menuNodes, getObjectPropertyNames(menuNodes[0])); 
	    return this;
	};

};





