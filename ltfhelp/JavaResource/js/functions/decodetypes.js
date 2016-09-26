

function createOptions(opts){
	var opt='';	
	for(pp=0; pp < opts.length; pp++){	
	    opt+='<option>' + opts[pp] + '</option>';
	}
	return '<select>' + opt + '</select>';
}


function createTableRow(dtype, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	var redirectcontent='-----';
	var rowCnt;
	rowCnt = '<tr class="' + cls +'">' +
	'<td>' + dtype.type + '</td>' +  
	'<td>' + createOptions(dtype.options) + '</td>' +  '</tr>'; 
	return rowCnt;
}


function filterColumn(dtype){
	var inputSearch = document.getElementById("searchtext").value;
	if(inputSearch.length < 1) return true;
	inputSearch = inputSearch.toLowerCase();
	return dtype.type.toLowerCase().indexOf(inputSearch) > -1;
};

function recreateTable(){
	var d = document.getElementById('tableDiv');
	var searchTxt = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + 
	'<td>' + 'DecodeType' +  '</td>' + 
	'<td>' + 'Options' +  '</td>' + 
	
	'</tr>';
	tableStr+=header;
	var row = '';
	var filtered = decodetypes.filter(filterColumn);
	for(i=0; i < filtered.length; i++){
		row = createTableRow(filtered[i], i);
		tableStr+=row;
	}
	//for(i=0; i < decodetypes.length; i++){tableStr+=(createTableRow(decodetypes[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}