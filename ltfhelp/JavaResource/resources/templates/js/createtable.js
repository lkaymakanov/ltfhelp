/**A class that will create html tables based on json array object*/
function TableCreator(){
	if(!(this instanceof arguments.callee)){
		return new TableCreator();
	}
	this.objectpropNames;     //array with object properties
	this.objects;        //the array of objects that we create table for
	this.oddrowclass = 'odd';
	this.evenrowclass = 'even';
	this.sortfunctions;     //array of sorting functions for each column!!!
	this.tableid='';       
	this.filterText='';       //text used to filter data
	this.bDirectMatch = false;   //direct match in search or not
	this.bHighLigh = true;       //hight light fount text or not
	this.tableRefName = 'tc';
	
	/***/
	this.searchForText = function(textToSearchIn, textToSearchFor){
		return  this.bDirectMatch ? (textToSearchIn == textToSearchFor) : (textToSearchIn.indexOf(textToSearchFor) > -1);
	};
	
	/**a filtering function for each row object*/
	this.filterColumn = function(object){
		var b = false;
		var textToSearchIn;
		for(var i=0; i < this.objectpropNames.length; i++){
			textToSearchIn = this.getPropertyValue(object, this.objectpropNames[i]);
			b = this.searchForText(textToSearchIn + '', this.filterText);
			if(b == true) return b;
		}
		return b;
	};
	
	/**apply the filter to the objects array of the table & returns the filtered data set*/
	this.getFiltereredContent = function(){
		return this.objects.filter(this.filterColumn, this);
	};
	
	//returns the value of the property of object  by object and property name!!!
	this.getPropertyValue = function(obj, propertyName){        
		return obj[propertyName];
	};
	
	//create sorting functions for each property
	this.createSortFunctionsForPropName = function(propName){
		var ascFun;
		var descFun;
		var obj = '{';
		ascFun = 'asc : ' + this.createSortFuction(propName, true);
		descFun = 'desc : ' + this.createSortFuction(propName, false);
		obj+=ascFun + ' , ' + descFun;
		return obj += '}';
	};
	
	//create ascending / descending sorting functions for each property
	this.createSortFunctionObject = function(){
		var funs;
		var obj = ' {';
		for(var i=0; i < this.objectpropNames.length; i++){
			funs = this.createSortFunctionsForPropName(this.objectpropNames[i]);
			obj+= this.objectpropNames[i] + ' : ' + funs;
			if(i >= 0 && i < this.objectpropNames.length-1) obj+=',';
		}
		return obj + ' }';
	};
	
	//access property of object for sorting functions!!!
	this.accessProperty = function(objname, propname){
		return objname+'.'+propname;
	};
	
	// creates a sort function for column name
	this.createSortFuction = function(columnname, ascending){
		var aaccess = this.accessProperty('a', columnname);
		var baccess = this.accessProperty('b', columnname);
		var retVal = (ascending) ? -1 : 1;
		return 'function (a,b){ if (' + aaccess + ' < ' + baccess + ')  return ' + retVal + '; if ('+  aaccess + ' > ' + baccess +' ) return ' + retVal*(-1) + '; return 0;}' ; 
	};
	
	
	//sort this objects by column index & id of the href either descending or ascending based on data-ascend attribute of the link!!!
	this.sortByColumnIndex = function(index, hrefId){
		var href = document.getElementById(hrefId);
		var  ascend = href.getAttribute("data-ascend");
		var myBool = new Boolean(ascend == 'true');
		var sortFun = (myBool == true) ?  this.sortfunctions[this.objectpropNames[index]].asc :  this.sortfunctions[this.objectpropNames[index]].desc;
		//console.log(sortFun);
		this.objects = this.objects.sort(sortFun);
		this.createTableForCurrentTableId();
		href = document.getElementById(hrefId);
		if(myBool == true){
			href.dataset.ascend = 'false';
		}else{
			href.dataset.ascend = 'true';
		}
	};

	//creates table header!!!
	this.createHeader = function(){
		var cells = '';
		var sortLink;
		var singlequote ='\'';
		var hrefId;
		for(i=0; i < this.objectpropNames.length; i++){
			hrefId = singlequote + this.tableid + '_col' + i + singlequote;
			sortLink = '<a id="'+ this.tableid + '_col' + i + '" href="#" data-ascend="true" onclick="'+ this.tableRefName+ '.sortByColumnIndex(' + i+  ', ' + hrefId + ');">'+ this.objectpropNames[i].toUpperCase()+' </a>';
			cells+= this.createTableCell(sortLink, false);
		}
		return '<tr class="header">' + cells + '</tr>';
	};
	
	//creates a single table cell by value!!!
	this.createTableCell = function(value, highlight){
		return '<td>' + highlightText(value+'', this.filterText, highlight) + '</td>';
	};
	
	//creates html table
	this.createTable = function(){
		var tbl = '<table class="register">' + this.createHeader();
		var fobjects = this.getFiltereredContent();
		for(pp=0; pp < fobjects.length; pp++ ){
			tbl+=this.createTableRow(fobjects[pp], pp);
		}
		return tbl+='</table>';
	};
	
	//creates table in the div id for the current table!!!
	this.createTableForCurrentTableId = function(){
		this.createTableByElementId(this.tableid);
	};
	
	//creates  a table inside the element id
	this.createTableByElementId = function(elementId){
		var d = document.getElementById(elementId);
		var tblcontent = this.createTable();
		d.innerHTML = tblcontent;
	}
	
	//create single table row
	this.createTableRow = function(obj, rowindex){
		var cls = ( rowindex%2 == 0) ? this.evenrowclass: this.oddrowclass;
		var cells = '';
		for(i=0; i < this.objectpropNames.length; i++){
			cells+= this.createTableCell(this.getPropertyValue(obj, this.objectpropNames[i]), this.bHighLigh);
		}
		return  '<tr class="' + cls +'">' + cells + '</tr>';
	};
	
	//argument constructor
	TableCreator.prototype.init_1 = function (tableid, objects, objectpropNames){
		this.tableid = tableid;
		this.objectpropNames = objectpropNames;    //array with object properties
		this.objects =  objects;                   //the array of objects that we create table for
		eval('var sfun = '+ this.createSortFunctionObject()+';');
		this.sortfunctions = sfun;
	    return this;
	};

};



